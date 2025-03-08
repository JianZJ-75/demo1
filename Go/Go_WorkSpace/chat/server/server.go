package main

import (
	"fmt"
	"net/http"
	"sync"

	"github.com/gorilla/websocket"
)

var upgrader = websocket.Upgrader{}
var clients = make(map[*websocket.Conn]bool)
var lock = sync.Mutex{}

func handler(w http.ResponseWriter, r *http.Request) {
	conn, err := upgrader.Upgrade(w, r, nil)
	if err != nil {
		fmt.Println("Error: ", err)
		return
	}
	defer conn.Close()

	lock.Lock()
	clients[conn] = true
	lock.Unlock()

	fmt.Println("新用户加入聊天室")

	for {
		_, message, err := conn.ReadMessage()
		if err != nil {
			lock.Lock()
			delete(clients, conn)
			lock.Unlock()
			fmt.Println("用户断开连接")
			return
		}

		// 发送消息给所有人
		broadcast(message)
	}
}

func broadcast(message []byte) {
	lock.Lock()
	defer lock.Unlock()
	for conn := range clients {
		conn.WriteMessage(websocket.TextMessage, message)
	}
}

func main() {
	http.HandleFunc("/ws", handler)
	fmt.Println("聊天服务器运行中...")
	http.ListenAndServe(":8080", nil)
}