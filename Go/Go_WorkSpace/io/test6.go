package io

import (
	"fmt"
	"os"
)

/*
	创建文件
*/
func Test6() {
	file, err := os.Create("resource/hello.txt")
	if err != nil {
		fmt.Println("Error: ", err)
		return
	}
	defer file.Close()
	file.WriteString("hello\n")
}