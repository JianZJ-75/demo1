package network

import (
	"fmt"
	"io"
	"net/http"
)

/*
	HTTP客户端请求
*/
func Test2() {
	resp, err := http.Get("http://localhost:8080/hello")
	if err != nil {
		fmt.Println("Error: ", err)
		return
	}
	defer resp.Body.Close()

	body, err := io.ReadAll(resp.Body)
	if err != nil {
		fmt.Println("Error reading response body:", err)
        return
	}
	fmt.Println(string(body))
}