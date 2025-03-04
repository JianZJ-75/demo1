package firststudy

import "fmt"

/*
	指针
	格式
		var var_name *var-type

	指针数组
	格式
		var var_name []*var-type

	指向指针的指针
	格式
		var var_name **var-type
*/
func Test10() {
	a := 10
	var ip *int
	ip = &a
	fmt.Println("a 变量的地址是: ", &a)
	fmt.Println("ip 变量存储的指针地址: ", ip)
	fmt.Println("ip 变量的值: ", *ip)

	// 空指针
	var ptr *int
	if (ptr == nil) {
		fmt.Println("空指针")
	} else {
		fmt.Println("非空指针")
	}

	var arr []*int
	fmt.Println("arr 变量存储的指针地址: ", arr)

	var a1 int
	var a2 *int
	var a3 **int

	a1 = 3000

	/* 指针 ptr 地址 */
	a2 = &a1

	/* 指向指针 ptr 地址 */
	a3 = &a2

	/* 获取 pptr 的值 */
	fmt.Printf("变量 a = %d\n", a1)
	fmt.Printf("指针变量 *ptr = %d\n", *a2)
	fmt.Printf("指向指针的指针变量 **pptr = %d\n", **a3)

	s1 := 10
	s2 := 20
	var t1 *int = &s1
	var t2 *int = &s2
	swap(t1, t2)
	fmt.Println("交换后的值:", s1, s2)
}

func swap(x, y *int) {
	*x, *y = *y, *x
}