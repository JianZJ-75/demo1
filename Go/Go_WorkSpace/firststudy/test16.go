package firststudy

import "fmt"

/*
	接口
		多态：不同类型实现同一接口，实现多态行为。
		解耦：通过接口定义依赖关系，降低模块之间的耦合。
		泛化：使用空接口 interface{} 表示任意类型。
		接口定义
			// 定义接口
			type interface_name interface {
				method_name1 [return_type]
				method_name2 [return_type]
				method_name3 [return_type]
				...
				method_namen [return_type]
			}

			// 定义结构体
			type struct_name struct {
				// variables
			}

			// 实现接口方法
			func (struct_name_variable struct_name) method_name1() [return_type] {
				// 方法实现
			}
			...
			func (struct_name_variable struct_name) method_namen() [return_type] {
				// 方法实现
			}

		空接口 interface{} 是 Go 的特殊接口，表示所有类型的超集。
			任意类型都实现了空接口。
			常用于需要存储任意类型数据的场景，如泛型容器、通用参数等。

		接口组合
			接口可以通过嵌套组合，实现更复杂的行为描述。
*/
func Test16() {
	r := Rectangle{width: 10, height: 5}
	var s Shape = r
	fmt.Println("Area: ", s.Area())
	fmt.Println("Perimeter: ", s.Perimeter())

	printType(42)
	printType("hello")
	printType(3.14)
	printType([]int{1, 2, 3})
}

type Shape interface {
    Area() float64
    Perimeter() float64
}

type Rectangle struct {
	width, height float64
}

func (r Rectangle) Area() float64 {
	return r.width * r.height
}

func (r Rectangle) Perimeter() float64 {
	return 2 * (r.width + r.height)
}

// 类型选择
func printType(val interface{}) {
	switch v := val.(type) {
	case int:
		fmt.Println("Integer:", v)
	case string:
		fmt.Println("String:", v)
	case float64:
		fmt.Println("Float:", v)
	default:
		fmt.Println("Unknown type")
	}
}