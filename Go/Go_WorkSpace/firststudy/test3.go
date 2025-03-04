package firststudy

import "fmt"

/*
	声明
		声明之后必须要被使用 否则会报错
	空白标识符 _ 是一个只写变量 不能读取它的值
		用于抛弃数据 不占用内存
		_ = 10
		假设你有一个函数返回多个值，但你只需要其中的一部分。你可以使用空白标识符 _ 来抛弃不需要的值。
*/
func Test3() {
	var a int = 10;
	var b = 20;
	// 短变量声明 这种只能写在函数体内
	c := 30;
	e, f, g := "z", "j", "zj"
	// 交换写法
	a, b = b, a
	// 抛弃第一个返回值
	_, c = calc()
	fmt.Println("声明:", a, b, c, e, f, g)
}

func calc() (int, int) {
	return 10, 20
}