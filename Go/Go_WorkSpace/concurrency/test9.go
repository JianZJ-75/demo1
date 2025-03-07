package concurrency

import (
	"fmt"
	"sync/atomic"
)

/*
	原子操作
		sync/atomic
*/

var counter int32

func Test9() {
	atomic.AddInt32(&counter, 1)
	fmt.Println(atomic.LoadInt32(&counter))
}