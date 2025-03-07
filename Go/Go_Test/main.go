package main

import (
	"fmt"
	"net/http"
	"github.com/gorilla/websocket"
)

// 定义一个 WebSocket 升级器
var upgrader = websocket.Upgrader{}

func handler2(w http.ResponseWriter, r *http.Request) {
	// 将 HTTP 连接升级为 WebSocket 连接
	conn, err := upgrader.Upgrade(w, r, nil)
	if err != nil {
		fmt.Println("Error upgrading connection:", err)
		return
	}
	defer conn.Close()

	for {
		// 读取消息
		_, msg, err := conn.ReadMessage()
		if err != nil {
			fmt.Println("Error reading message:", err)
			break
		}
		fmt.Println("收到消息:", string(msg))

		// 发送消息
		err = conn.WriteMessage(websocket.TextMessage, msg)
		if err != nil {
			fmt.Println("Error writing message:", err)
			break
		}
	}
}

func Test4() {
	http.HandleFunc("/ws", handler2)
	fmt.Println("WebSocket 服务器运行在端口8080")
	err := http.ListenAndServe(":8080", nil)
	if err != nil {
		fmt.Println("Error starting server:", err)
	}
}

func main() {
	Test4()
}