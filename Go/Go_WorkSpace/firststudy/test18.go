package firststudy

import (
	"errors"
	"fmt"
)

/*
	错误处理
		Go 语言通过内置的错误接口提供了非常简单的错误处理机制
		Go 语言的错误处理采用显式返回错误的方式，而非传统的异常处理机制。这种设计使代码逻辑更清晰，便于开发者在编译时或运行时明确处理错误

		Go 的错误处理主要围绕以下机制展开：
			error 接口：标准的错误表示。
			显式返回值：通过函数的返回值返回错误。
			自定义错误：可以通过标准库或自定义的方式创建错误。
			panic 和 recover：处理不可恢复的严重错误。

		fmt 包提供了对错误的格式化输出支持：
			%v：默认格式。
			%+v：如果支持，显示详细的错误信息。
			%s：作为字符串输出。

		从 Go 1.13 开始，errors 包引入了 errors.Is 和 errors.As 用于处理错误链：
		
		panic 和 recover
		Go 的 panic 用于处理不可恢复的错误，recover 用于从 panic 中恢复。
			panic:
				导致程序崩溃并输出堆栈信息。
				常用于程序无法继续运行的情况。
			recover:
				捕获 panic，避免程序崩溃。
*/
func Test18() {
	// 使用 errors 包创建错误
	err := errors.New("this is an error")
    fmt.Println(err) // 输出：this is an error

	// 自定义错误
	_, err = divide(10, 0)
	if err != nil {
		fmt.Println(err) // 输出：cannot divide 10 by 0
	}

	// errors.Is
	// 检查某个错误是否是特定错误或由该错误包装而成。
	err = findItem(1)
	if errors.Is(err, ErrNotFound) {
		fmt.Println("Item not found")
	} else {
		fmt.Println("Other error:", err)
	}
	// errors.As
	// 将错误转换为特定类型以便进一步处理。
	err = getError()
	var myErr *MyError
	if errors.As(err, &myErr) {
		fmt.Printf("Custom error - Code: %d, Msg: %s\n", myErr.Code, myErr.Msg)
	}

	fmt.Println("Starting program...")
	safeFunction()
	fmt.Println("Program continued after panic")
}

// 实现 error 接口：任何实现了 Error() 方法的类型都可以作为错误。
// Error() 方法返回一个描述错误的字符串。
type error interface {
    Error() string
}

type DivideError struct {
	Dividend int
	Divisor  int
}

func (e *DivideError) Error() string {
	return fmt.Sprintf("cannot divide %d by %d", e.Dividend, e.Divisor)
}

func divide(a, b int) (int, error) {
	if b == 0 {
		return 0, &DivideError{Dividend: a, Divisor: b}
	}
	return a / b, nil
}

var ErrNotFound = errors.New("not found")

func findItem(id int) error {
    return fmt.Errorf("database error: %w", ErrNotFound)
}

type MyError struct {
	Code int
	Msg  string
}

func (e *MyError) Error() string {
	return fmt.Sprintf("Code: %d, Msg: %s", e.Code, e.Msg)
}

func getError() error {
	return &MyError{Code: 404, Msg: "Not Found"}
}

func safeFunction() {
	defer func() {
		if r := recover(); r != nil {
			fmt.Println("Recovered from panic:", r)
		}
	}()
	panic("something went wrong")
}
