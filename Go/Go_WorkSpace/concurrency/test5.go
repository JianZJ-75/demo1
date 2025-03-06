package concurrency

import (
	"fmt"
	"sync"
	"time"
)

/*
	读写锁
		多个goroutine读取数据时 如果没有修改 多个读操作可以并发执行 提高性能
		写操作时 需要阻塞其他的读写操作 保证数据一致性
*/

type SharedData struct {
	data int
	lock sync.RWMutex
}

func (s *SharedData) ReadData() {
	// 读锁
	s.lock.RLock()
	defer s.lock.RUnlock()
	fmt.Println("Reading: ", s.data)
	time.Sleep(500 * time.Millisecond)
}

func (s *SharedData) WriteData(value int) {
	// 写锁
	s.lock.Lock()
	defer s.lock.Unlock()
	s.data = value
	fmt.Println("Writing: ", value)
	time.Sleep(500 * time.Millisecond)
}

func Test5() {
	shared := SharedData{}

	for i := 0; i < 3; i++ {
		go shared.ReadData()
	}

	go shared.WriteData(42)

	time.Sleep(2 * time.Second)

}