package concurrency

import (
	"fmt"
	"sync"
	"time"
)

/*
	Channel：
		Go 中用于在 Goroutine 之间通信的机制。
		支持同步和数据共享，避免了显式的锁机制。
		使用 chan 关键字创建，通过 <- 操作符发送和接收数据。

		使用 make 函数创建一个 channel，使用 <- 操作符发送和接收数据。如果未指定方向，则为双向通道。
			ch := make(chan int)

		注意：默认情况下，通道是不带缓冲区的。发送端发送数据，同时必须有接收端相应的接收数据。

		注意：如果通道不带缓冲，发送方会阻塞直到接收方从通道中接收了值。如果通道带缓冲，发送方则会阻塞直到发送的值被拷贝到缓冲区内；如果缓冲区已满，则意味着需要等待直到某个接收方获取到一个值。接收方在有值可以接收之前会一直阻塞。
*/

func sum(s []int, ch chan int) {
	sum := 0
	for _, v := range s {
		sum += v
	}
	ch <- sum
}

func fibonacci(n int, c chan int) {
	x, y := 0, 1
	for i := 0; i < n; i++ {
		c <- x
		x, y = y, x+y
	}
	close(c)
}

func f1(c, quit chan int) {
	x, y := 0, 1
	for {
		select {
		case c <- x:
			x, y = y, x+y
		case <-quit:
			fmt.Println("quit")
			return
		}
	}
}

func worker(id int, wg *sync.WaitGroup) {
	defer wg.Done()
	fmt.Printf("Worker %d starting\n", id)
	time.Sleep(time.Second)
	fmt.Printf("Worker %d done\n", id)
}

func Test2() {

	s := []int{7, 2, 8, -9, 4, 0}

	ch := make(chan int)

	go sum(s[:len(s)/2], ch)
	go sum(s[len(s)/2:], ch)
	x, y := <-ch, <-ch

	fmt.Println(x, y, x+y)

	// 通道可以设置缓冲区，通过 make 的第二个参数指定缓冲区大小：
	ch = make(chan int, 2)

	ch <- 1
	ch <- 2

	fmt.Println(<-ch)
	fmt.Println(<-ch)

	// 通道的遍历与关闭
	// 遍历 v, ok := <-ch
	// 如果通道接收不到数据后 ok 就为 false，这时通道就可以使用 close() 函数来关闭。
	c := make(chan int, 10)
	go fibonacci(cap(c), c)
	for i := range c {
		fmt.Println(i)
	}

	// select
	// select 语句使得一个 goroutine 可以等待多个通信操作。select 会阻塞，直到其中的某个 case 可以继续执行：
	c = make(chan int)
	quit := make(chan int)
	go func() {
		for i := 0; i < 10; i++ {
			fmt.Println(<-c)
		}
		quit <- 0
	}()
	f1(c, quit)

	// WaitGroup
	// WaitGroup 用于等待一组 goroutine 结束。主 goroutine 调用 Add 方法设置等待的 goroutine 的数量。每个 goroutine 在结束时调用 Done 方法。同时，Wait 可以阻塞至所有 goroutine 结束。
	var wg sync.WaitGroup
	for i := 1; i <= 3; i++ {
		wg.Add(1)
		go worker(i, &wg)
	}

	wg.Wait()
	fmt.Println("All workers done")

}