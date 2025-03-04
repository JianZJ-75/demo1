package firststudy

import (
	"fmt"
	"strconv"
)

/*
	类型转换
	格式
		type_name(expression)
*/
func Test15() {
	var sum int = 17
	var count int = 5
	var mean float32
	
	mean = float32(sum) / float32(count)
	fmt.Printf("mean 的值为: %f\n",mean)

	// string -> int
	str := "123"
	// strconv.Atoi 函数返回两个值，第一个是转换后的整型值，第二个是可能发生的错误
    num, err := strconv.Atoi(str)
    if err != nil {
        fmt.Println("转换错误:", err)
    } else {
        fmt.Printf("字符串 '%s' 转换为整数为：%d\n", str, num)
    }
	
	// int -> string
	num = 456
	str = strconv.Itoa(num)
	fmt.Printf("整数 %d  转换为字符串为：'%s'\n", num, str)

	// string -> float
	str = "3.14"
	// 64 表示转换为 float64
    fnum, err := strconv.ParseFloat(str, 64)
    if err != nil {
        fmt.Println("转换错误:", err)
    } else {
        fmt.Printf("字符串 '%s' 转为浮点型为：%f\n", str, fnum)
    }

	// float -> string
	fnum = 3.1415926
	// fnum 为要转换的浮点数，'f' 表示格式，2 表示小数点保留的位数，64 表示 float64
	str = strconv.FormatFloat(fnum, 'f', 2, 64)
	fmt.Printf("浮点数 %f 转为字符串为：'%s'\n", fnum, str)

	/* 
		接口类型转换
			分为: 类型断言和类型转换
				类型断言
					类型断言用于将接口类型转换为指定类型，其语法为：
						value.(type) 
						或者 
						value.(T)
				类型转换
					类型转换用于将一个接口类型的值转换为另一个接口类型，其语法为：
						T(value)
	*/
	var i interface{} = "Hello, World"
    str, ok := i.(string)
    if ok {
        fmt.Printf("'%s' is a string\n", str)
    } else {
        fmt.Println("conversion failed")
    }

	// 创建一个 StringWriter 实例并赋值给 Writer 接口变量
    var w Writer = &StringWriter{}
   
    // 将 Writer 接口类型转换为 StringWriter 类型
    sw := w.(*StringWriter)
   
    // 修改 StringWriter 的字段
    sw.str = "Hello, World"
   
    // 打印 StringWriter 的字段值
    fmt.Println(sw.str)
}

// 定义一个接口 Writer
type Writer interface {
    Write([]byte) (int, error)
}

// 实现 Writer 接口的结构体 StringWriter
type StringWriter struct {
    str string
}

// 实现 Write 方法
func (sw *StringWriter) Write(data []byte) (int, error) {
    sw.str += string(data)
    return len(data), nil
}