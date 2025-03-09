package main

import (
	"fmt"
	"reflect"
)

type Calculator struct{}

func (c *Calculator) Add(a, b int) int {
	return a + b
}

func main() {

	c := Calculator{}
	method := reflect.ValueOf(&c).MethodByName("Add")
	if !method.IsValid() {
		fmt.Println("方法不存在")
		return
	}
	args := []reflect.Value{reflect.ValueOf(3), reflect.ValueOf(5)}
	res := method.Call(args)

	fmt.Println("res = ", res[0].Int())
}
