package io

import (
	"fmt"
	"os"
)

/*
	读取整个文件
*/
func Test2() {
	data, err := os.ReadFile("resource/hello.txt")
	if err != nil {
		fmt.Println("Error: ", err)
		return
	}
	fmt.Println(string(data))
}