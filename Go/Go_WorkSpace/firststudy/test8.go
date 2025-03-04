package firststudy

import (
	"fmt"
	"math"
)

/*
	函数
	格式
		func function_name( [parameter list] ) [return_types] {
			函数体
		}
	Go 语言可以很灵活的创建函数，并作为另外一个函数的实参

	Go 语言中同时有函数和方法。一个方法就是一个包含了接受者的函数，接受者可以是命名类型或者
	结构体类型的一个值或者是一个指针。
	格式
		func (variable_name variable_data_type) function_name() [return_type]{
			// 函数体
		}
*/
func Test8() {
	/* 定义局部变量 */
	var a int = 100
	var b int = 200
	var ret int = max(a, b)
 
	fmt.Printf( "最大值是 : %d\n", ret )

	x := 9.0
	/* 声明函数变量 */
	getSquareRoot := func() float64 {
		return math.Sqrt(x)
	}
  
	/* 使用函数 */
	fmt.Println(getSquareRoot())

	var c1 Circle
	c1.radius = 10.00
	fmt.Println("圆的面积 = ", c1.getArea())

}

/* 函数返回两个数的最大值 */
func max(num1, num2 int) int {
	/* 定义局部变量 */
	var result int
 
	if (num1 > num2) {
		result = num1
	} else {
	   	result = num2
	}
	return result
}

/* 定义结构体 */
type Circle struct {
	radius float64
}

func (c Circle) getArea() float64 {
	return 3.14 * c.radius * c.radius
}