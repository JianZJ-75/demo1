package concurrency

import (
	"fmt"
	"sync"
	"time"
)

/*
	条件变量

	Wait 方法的行为：
		当 Wait 方法被调用时，它会自动释放关联的互斥锁，并将当前 goroutine 放入等待队列。
		当 Wait 方法返回时，它会重新获取关联的互斥锁。
	Signal 方法的行为：
		当 Signal 方法被调用时，它会唤醒等待队列中的一个 goroutine。
		被唤醒的 goroutine 会尝试重新获取互斥锁，并继续执行 Wait 方法之后的代码。
*/

// 定义条件变量和共享变量
var condition = sync.NewCond(&sync.Mutex{})
var ready bool

func wait() {
	condition.L.Lock()
	for !ready {
		condition.Wait()
	}
	fmt.Println("收到信号 开始执行")
	condition.L.Unlock()
}

func signal() {
	// 首先休眠 1 秒钟，模拟一些准备工作
	time.Sleep(time.Second)
	condition.L.Lock()
	ready = true
	condition.Signal()
	condition.L.Unlock()
}

func Test8() {
	go wait()
	go signal()
	time.Sleep(2 * time.Second)
}