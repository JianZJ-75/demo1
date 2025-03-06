package io

import (
	"fmt"
	"os"
)

/*
	续写
*/
func Test4() {
	/* 
		指定打开文件的模式。使用按位或操作符 | 组合多个模式。
			os.O_APPEND：以追加模式打开文件。如果文件存在，数据将被写入文件末尾。
			os.O_WRONLY：以只写模式打开文件。
	*/
	file, err := os.OpenFile("resource/hello.txt", os.O_APPEND | os.O_WRONLY, 0644)
	if err != nil {
		fmt.Println("Error: ", err)
		return
	}
	defer file.Close()
	file.WriteString("\n你好")
}