package io

import (
	"bufio"
	"fmt"
	"os"
)

/*
	读取文件
*/
func Test1() {
	// 相对路径是相对于项目根目录
	file, err := os.Open("resource/hello.txt")
	if err != nil {
		fmt.Println("Error: ", err)
		return
	}
	defer file.Close()
	scanner := bufio.NewScanner(file)
	// 逐行读取
	for scanner.Scan() {
		fmt.Println(scanner.Text())
	}
}
