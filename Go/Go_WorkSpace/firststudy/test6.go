package firststudy

import (
	"fmt"
	"time"
)

/*
	条件语句
*/
func Test6() {
	/* 
		基本语法
		格式
			if condition {
				// 当 condition 为 true 时执行的代码
			} else if anotherCondition {
				// 当 anotherCondition 为 true 时执行的代码
			} else {
				// 当上述条件都不满足时执行的代码
			}
	*/
	a := 10

    if a > 5 {
        fmt.Println("a is greater than 5")
    } else if a == 5 {
        fmt.Println("a is equal to 5")
    } else {
        fmt.Println("a is less than 5")
    }

	// 带初始化的条件语句
	if b := 20; b > 15 {
        fmt.Println("b is greater than 15")
    } else {
        fmt.Println("b is less than or equal to 15")
    }

	/* 
		switch语句
		格式
			switch expression {
			case value1:
				// 当 expression == value1 时执行的代码
			case value2:
				// 当 expression == value2 时执行的代码
			default:
				// 当上述条件都不满足时执行的代码
			}
	*/
	day := "Monday"

    switch day {
    case "Monday":
        fmt.Println("Today is Monday")
    case "Tuesday":
        fmt.Println("Today is Tuesday")
    default:
        fmt.Println("Today is not Monday or Tuesday")
    }

	// 带初始化的switch语句
	switch day := "Monday"; day {
    case "Monday":
        fmt.Println("Today is Monday")
    case "Tuesday":
        fmt.Println("Today is Tuesday")
    default:
        fmt.Println("Today is not Monday or Tuesday")
    }

	/* 
		select语句
		在 Go 语言中，select 语句用于处理多个通道（channel）的通信操作。它类似于 switch 语句，但专门用于通道的读写操作。select 语句会阻塞，直到其中的某个通道操作可以进行。
		格式
			select {
			case <-ch1:
				// 当 ch1 通道有数据可读时执行的代码
			case ch2 <- value:
				// 当 ch2 通道可以写入数据时执行的代码
			default:
				// 当上述通道操作都不可进行时执行的代码
			}
	*/
	ch1 := make(chan string)
    ch2 := make(chan string)

    go func() {
        time.Sleep(1 * time.Second)
        ch1 <- "one"
    }()

    go func() {
        time.Sleep(2 * time.Second)
        ch2 <- "two"
    }()

    for i := 0; i < 2; i++ {
        select {
        case msg1 := <-ch1:
            fmt.Println("Received", msg1)
        case msg2 := <-ch2:
            fmt.Println("Received", msg2)
        }
    }

	// 带超时的select语句
	ch := make(chan string)

    go func() {
        time.Sleep(2 * time.Second)
        ch <- "result"
    }()

    select {
    case res := <-ch:
        fmt.Println("Received", res)
    case <-time.After(1 * time.Second):
        fmt.Println("Timeout")
    }

}