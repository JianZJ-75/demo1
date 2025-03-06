package concurrency

import (
	"context"
	"fmt"
	"time"
)

/*
	channel 高级特性
		Buffered Channel
			创建有缓冲的 Channel。
			ch := make(chan int, 2)
		Context
			用于控制 Goroutine 的生命周期。
			context.WithCancel context.WithTimeout
		Mutex 和 RWMutex
			互斥锁和读写锁
			var mu sync.Mutex
			mu.Lock()
			mu.Unlock()
*/

// 模拟一个需要上下文的操作
func doWork(ctx context.Context) {
    for {
        select {
		// 如果接收到取消信号（<-ctx.Done()），打印取消原因并返回。
        case <-ctx.Done():
            fmt.Println("操作取消:", ctx.Err())
            return
        default:
            fmt.Println("工作中...")
            time.Sleep(500 * time.Millisecond)
        }
    }
}

func Test3() {
	// 创建一个带取消功能的上下文
	// 使用 context.WithCancel 从根上下文 context.Background() 派生出一个带取消功能的上下文 ctx，并返回一个取消函数 cancel。
    ctx, cancel := context.WithCancel(context.Background())

    // 启动一个 goroutine 执行操作
    go doWork(ctx)

    // 让操作执行一段时间
    time.Sleep(2 * time.Second)

    // 取消操作
    cancel()

    // 等待一段时间以便观察取消效果
    time.Sleep(1 * time.Second)
    fmt.Println("主函数结束")
}