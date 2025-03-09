package main

import (
	"fmt"
	"reflect"
)

type User struct {
	Name string
	Age  int
}

func main() {

	u := User{
		Name: "Alice",
		Age:  15,
	}
	// 需要传递指针
	// Elem() 方法用于解引用指针，返回指针指向的值的反射表示。最终 v 是 u 的反射值对象，可用于操作 u 的字段。
	v := reflect.ValueOf(&u).Elem()
	// 获取指定字段的反射值
	nameFeild := v.FieldByName("Name")

	// CanSet 方法用于检查该反射值是否可设置。只有当反射值代表的是可寻址的值（如指针指向的值）时，才可以设置其值。这里检查 Name 字段是否可设置。
	if nameFeild.CanSet() {
		nameFeild.SetString("Bob")
	}

	fmt.Println(u.Name)
}