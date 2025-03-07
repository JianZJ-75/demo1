package concurrency

import (
	"fmt"
	"sync"
)

/*
	单次执行
*/

var once sync.Once

func initialize() {
	fmt.Println("只执行一次...")
}

func Test6() {
	for i := 0; i < 10; i++ {
		go once.Do(initialize)
	}
}