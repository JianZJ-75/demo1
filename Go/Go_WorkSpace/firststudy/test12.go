package firststudy

/* 
	切片 Slice
		Go 语言切片是对数组的抽象。
		Go 数组的长度不可改变，在特定场景中这样的集合就不太适用，Go 中提供了一种灵活，功能强悍的内置类型切片("动态数组")，与数组相比切片的长度是不固定的，可以追加元素，在追加时可能使切片的容量增大。
*/
func Test12() {
	// 切片的声明
	var slice1 []int
	var slice2 = []int{1, 2, 3}
	// []int 表示切片的类型，3 表示长度，5 表示容量
	var slice3 = make([]int, 3, 5)
	// 切片的使用
	slice1 = append(slice1, 1)
	slice1 = append(slice1, 2)
	slice1 = append(slice1, 3)
	slice1 = append(slice1, 4)
	slice1 = append(slice1, 5)
	slice1 = append(slice1, 6)
	slice1 = append(slice1, 7)
	slice1 = append(slice1, 8)
	slice1 = append(slice1, 9)
	slice1 = append(slice1, 10)
	// 切片的长度和容量
	println(len(slice1))
	println(cap(slice1))
	// 切片的遍历
	for i := 0; i < len(slice1); i++ {
		println(slice1[i])
	}
	for i, v := range slice2 {
		println(i, v)
	}
	for i, v := range slice3 {
		println(i, v)
	}
	// 切片的截取
	// 1 <= slice1 < 3
	var slice4 = slice1[1:3]
	var slice5 = slice1[1:]
	var slice6 = slice1[:3]
	var slice7 = slice1[:]
	println(slice4)
	println(slice5)
	println(slice6)
	println(slice7)
	// 切片的复制
	var slice8 = make([]int, 3)
	copy(slice8, slice1)
	for i, v := range slice8 {
		println(i, v)
	}
	// 切片的删除
	slice1 = append(slice1[:1], slice1[2:]...)
	for i, v := range slice1 {
		println(i, v)
	}
	// 切片的扩容
	slice1 = append(slice1, 11)
	println(len(slice1))
	println(cap(slice1))
}