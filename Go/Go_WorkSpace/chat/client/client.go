package main

import (
	"bufio"
	"fmt"
	"os"

	"github.com/gorilla/websocket"
)

func main() {
	conn, _, err := websocket.DefaultDialer.Dial("ws://localhost:8080/ws", nil)
	if err != nil {
		fmt.Println("Error: ", err)
		return
	}
	defer conn.Close()

	// 接收服务端信息
	go func() {
		for {
			_, message, err := conn.ReadMessage()
			if err != nil {
				fmt.Println("Error: ", err)
				return
			}
			fmt.Println(string(message))
		}
	}()

	// 发送信息
	scanner := bufio.NewScanner(os.Stdin)
	for scanner.Scan() {
		msg := scanner.Text()
		if msg == "exit" {
			break
		}
		msg = conn.LocalAddr().String() + ": " + msg
		conn.WriteMessage(websocket.TextMessage, []byte(msg))
	}
}