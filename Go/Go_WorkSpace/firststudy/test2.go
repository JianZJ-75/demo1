package firststudy

import "fmt"

/* 
    数据类型
*/
func Test2() {
    // 布尔类型
    var isTrue bool = true
    fmt.Println("布尔类型:", isTrue)

    // 整数类型
    var a int = 10
    var b int8 = 127
    var c int16 = 32767
    var d int32 = 2147483647
    var e int64 = 9223372036854775807
    fmt.Println("整数类型:", a, b, c, d, e)

    // 无符号整数类型
    var ua uint = 10
    var ub uint8 = 255
    var uc uint16 = 65535
    var ud uint32 = 4294967295
    var ue uint64 = 18446744073709551615
    fmt.Println("无符号整数类型:", ua, ub, uc, ud, ue)

    // 浮点类型
    var fa float32 = 3.14
    var fb float64 = 3.141592653589793
    fmt.Println("浮点类型:", fa, fb)

    // 复数类型
    var ca complex64 = 1 + 2i
    var cb complex128 = 1 + 2i
    fmt.Println("复数类型:", ca, cb)

    // 字符串类型
    var s string = "Hello, Go!"
    fmt.Println("字符串类型:", s)

    // 字符类型
    var byteChar byte = 'a'
    var runeChar rune = '你'
    fmt.Println("字符类型:", byteChar, runeChar)
}