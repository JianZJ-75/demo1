package firststudy

import (
	"fmt"
	"sync"
)

/*
	mutex互斥锁
*/

var mu sync.Mutex
var count int = 0

func increment(wg *sync.WaitGroup) {
	defer wg.Done()
	mu.Lock()
	count++
	mu.Unlock()
}

func Test22() {
	var wg sync.WaitGroup
	wg.Add(100000)
	for i := 0; i < 100000; i++ {
		go increment(&wg)
	}
	wg.Wait()
	fmt.Println("count:", count)
}