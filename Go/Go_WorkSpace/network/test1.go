package network

import (
	"fmt"
	"net/http"
)

/*
	启动http服务器
*/

func handler1(w http.ResponseWriter, r *http.Request) {
	fmt.Println(w, "Hello, Go HTTP Server!")
}

func Test1() {
	http.HandleFunc("/hello", handler1)
	http.HandleFunc("/ws", handler2)
	fmt.Println("Go Http 服务器运行在端口8080")
	// 使用 http.ListenAndServe 启动 HTTP 服务器，监听 8080 端口。第二个参数为 nil，表示使用默认的多路复用器（DefaultServeMux）。
	err := http.ListenAndServe(":8080", nil)
	if err != nil {
		fmt.Println("Error starting server:", err)
	}
}
