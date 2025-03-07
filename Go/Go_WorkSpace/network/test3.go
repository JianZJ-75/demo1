package network

import (
	"bytes"
	"fmt"
	"io"
	"net/http"
)

/*
	发送Post请求
*/
func Test3() {
	data := bytes.NewBuffer([]byte("data=Hello"))
	resp, err := http.Post("http://localhost:8080/hello", "application/x-www-form-urlencoded", data)
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