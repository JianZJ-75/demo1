package main

import "fmt"

// 泛型函数
// T any代表任意类型
func Print[T any](value T) {
	fmt.Println(value)
}

// 泛型结构体
type Box[T any] struct {
	value T
}

func (b *Box[T]) Set(value T) {
	b.value = value
}

func (b *Box[T]) Get() T {
	return b.value
}

func main() {
	Print(123)
	Print("Hello")

	intBox := Box[int]{value: 42}
	fmt.Println(intBox.Get())
}