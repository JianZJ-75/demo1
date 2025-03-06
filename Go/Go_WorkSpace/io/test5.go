package io

import (
	"fmt"
	"os"
)

/*
	删除文件
*/
func Test5() {
	err := os.Remove("resource/hello.txt")
	if err != nil {
		fmt.Println("Error: ", err)
	} 
}