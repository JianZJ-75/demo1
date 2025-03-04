package firststudy

import "fmt"

/*
	循环语句
		控制语句 break continue goto
*/
func Test7() {
	// for循环
	// for 初始化;条件;修饰 {}
	for i := 0; i < 10; i++ {
		fmt.Println(i)
	}
	// for循环的初始化和修饰是可以省略的
	i := 0
	for i < 10 {
		fmt.Println(i)
		i++
	}
	// 无限循环
	for {
		fmt.Println("无限循环")
	}
}