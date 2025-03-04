package firststudy

import "fmt"

/*
	数组
	格式
		var arrayName [size]dataType
		var arrayName = [size]dataType{ele1, ele2, ele3}
		var arrayName = [...]dataType{ele1, ele2, ele3}
		var arrayName = [size]dataType{index1:ele1, index2:ele2}
	多维数组
		var variable_name [SIZE1][SIZE2]...[SIZEN] variable_type

*/
func Test9() {
	// Step 1: 创建数组
    values := [][]int{}

    // Step 2: 使用 append() 函数向空的二维数组添加两行一维数组
    row1 := []int{1, 2, 3}
    row2 := []int{4, 5, 6}
    values = append(values, row1)
    values = append(values, row2)

    // Step 3: 显示两行数据
    fmt.Println("Row 1")
    fmt.Println(values[0])
    fmt.Println("Row 2")
    fmt.Println(values[1])

    // Step 4: 访问第一个元素
    fmt.Println("第一个元素为：")
    fmt.Println(values[0][0])
	bb(&values)
	ppv(values)

	// 初始化二维数组
	a := [3][4]int{  
		{0, 1, 2, 3} ,   /*  第一行索引为 0 */
		{4, 5, 6, 7} ,   /*  第二行索引为 1 */
		{8, 9, 10, 11},   /* 第三行索引为 2 */
	}
	fmt.Println("二维数组为：", a)
	pp(a)
	   
}

func pp(a [3][4]int) {
	fmt.Println(a)
}

func ppv(a [][]int) {
	fmt.Println(a)
}

func bb(a *[][]int) {
	(*a)[0][0] = 100
}