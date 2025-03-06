package io

import (
	"fmt"
	"os"
)

/*
	写入文件（非续写）
*/
func Test3() {
	str := "Hello, Go!"
	/* 
		文件权限
			0644 文件所有者可以读写，其他用户和组可以读取。
			0755 文件所有者可以读写执行，其他用户和组可以读取和执行。
			0700 文件所有者可以读写执行，其他用户和组没有任何权限。

			4：读权限（r）
			2：写权限（w）
			1：执行权限（x）
	*/
	err := os.WriteFile("resource/hello.txt", []byte(str), 0644)
	if err != nil {
		fmt.Println("Error: ", err)
	}
}