package main

import "fmt"

// 泛型求和
func Sum[T int | float64](nums []T) T {
	var total T
	for _, num := range nums {
		total += num
	}
	return total
}

func main() {
	fmt.Println(Sum([]int{1, 2, 3}))
	fmt.Println(Sum([]float64{1.1, 2.2}))
}