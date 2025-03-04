package firststudy

import "fmt"

// 声明一个包含 2 的幂次方的切片
var pow = []int{1, 2, 4, 8, 16, 32, 64, 128}

/* 
	范围
*/
func Test13() {
	/* 数组和切片 */
	// 遍历 pow 切片，i 是索引，v 是值
	for i, v := range pow {
		// 打印 2 的 i 次方等于 v
		fmt.Printf("2**%d = %d\n", i, v)
	}

	/* 字符串 */
	for i, c := range "hello" {
    	fmt.Printf("index: %d, char: %c\n", i, c)
    }

	/* 映射 */
	// 创建一个空的 map，key 是 int 类型，value 是 float32 类型
    map1 := make(map[int]float32)
   
    // 向 map1 中添加 key-value 对
    map1[1] = 1.0
    map1[2] = 2.0
    map1[3] = 3.0
    map1[4] = 4.0
   
    // 遍历 map1，读取 key 和 value
    for key, value := range map1 {
        // 打印 key 和 value
        fmt.Printf("key is: %d - value is: %f\n", key, value)
    }

    // 遍历 map1，只读取 key
    for key := range map1 {
        // 打印 key
        fmt.Printf("key is: %d\n", key)
    }

    // 遍历 map1，只读取 value
    for _, value := range map1 {
        // 打印 value
        fmt.Printf("value is: %f\n", value)
    }

	/* 通道 */
	ch := make(chan int, 2)
    ch <- 1
    ch <- 2
    close(ch)
   
    for v := range ch {
        fmt.Println(v)
    }

}