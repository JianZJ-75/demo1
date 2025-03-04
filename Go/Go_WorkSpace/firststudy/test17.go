package firststudy

import "fmt"

/*
	接口组合
	动态值和动态类型
	接口的零值是 nil
*/
func Test17() {
	// 接口组合
	var rw ReadWriter = File{}
	fmt.Println(rw.Read())
	rw.Write("Hello, Go!")

	// 动态值和动态类型
	var i interface{} = 42
	fmt.Printf("Dynamic type: %T, Dynamic value: %v\n", i, i)
}

type Reader interface {
	Read() string
}

type Writer interface {
	Write(data string)
}

type ReadWriter interface {
	Reader
	Writer
}

type File struct{}

func (f File) Read() string {
	return "Reading data"
}

func (f File) Write(data string) {
	fmt.Println("Writing data:", data)
}