package main

import (
	"fmt"
	"reflect"
)

type User struct {
	Name string
	Age  int
}

func (u User) SayHello() {
	fmt.Println("Hello, ", u.Name)
}

func main() {
	u := User{Name: "Alice", Age: 25}

	v := reflect.ValueOf(u)
	// 获取类型
	t := reflect.TypeOf(u)

	// 获取字段信息 t.Numfield() 获取结构体字段数量
	for i := 0; i < t.NumField(); i++ {
		// 获取字段
		field := t.Field(i)
		value := v.Field(i)
		fmt.Printf("字段: %s = %v\n", field.Name, value)
	}

	// 调用方法
	method := v.MethodByName("SayHello")
	method.Call(nil)
}
