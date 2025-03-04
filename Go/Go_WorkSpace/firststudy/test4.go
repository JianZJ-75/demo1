package firststudy

import (
	"fmt"
	"unsafe"
)

// 枚举
const (
	Unknown = 0
	Female = 1
	Male = 2
)

// 常量可以用len(), cap(), unsafe.Sizeof()函数计算表达式的值。常量表达式中，函数必须是内置函数，否则编译不过
const (
    a = "abc"
    b = len(a)
    c = unsafe.Sizeof(a)
)

const (
	hh = iota
	ii
)

const (
	i=1<<iota 	// i = 1 << 0 = 1
    j=3<<iota	// j = 3 << 1 = 6
    k			// k = 3 << 2 = 12
    l			// l = 3 << 3 = 24
)

/*
	常量
		只能是布尔型、数字型（整数型、浮点型和复数）和字符串型
		格式为 const identifier [type] = value
		如果常量没有显式赋值，它将继承上一行的表达式如果常量没有显式赋值，它将继承上一行的表达式
	iota 是常量计数器，从0开始，组中每定义一个常量自动递增1
		const关键字出现时将被重置为 0
*/
func Test4() {
	const LENGTH int = 10
	const WIDTH int = 5  
	var area int = LENGTH * WIDTH
	fmt.Printf("面积为 : %d", area)
	println(a, b, c)  

	println(Unknown)

	println(hh, ii)

	println(i, j, k, l)
}