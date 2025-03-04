package firststudy

import "fmt"

/*
	测试Sprintf Printf
*/
func Test1() {
	var url = "name=%s&age=%d"
	var name = "zhangsan"
	var age = 20
	var ans = fmt.Sprintf(url, name, age)
	fmt.Println(ans)
	fmt.Printf(url, name, age)
}