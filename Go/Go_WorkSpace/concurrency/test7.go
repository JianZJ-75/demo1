package concurrency

import (
	"fmt"
	"sync"
)

/*
	sync.Map 并发安全的映射
*/

func Test7() {

	var m sync.Map

    // 存储键值对
    m.Store("key1", "value1")
    m.Store("key2", "value2")

    // 读取键值对
    if value, ok := m.Load("key1"); ok {
        fmt.Println("key1:", value)
    }

    // 使用 LoadOrStore 方法
	// 如果键存在，返回对应的值和 true；否则，存储键值对并返回新存储的值和 false。
    if value, loaded := m.LoadOrStore("key3", "value3"); loaded {
        fmt.Println("key3 已存在:", value)
    } else {
        fmt.Println("key3 不存在，已存储:", value)
    }

    // 删除键值对
    m.Delete("key2")

    // 遍历所有键值对
	// 使用 Range 方法遍历所有键值对。Range 方法接收一个函数作为参数，该函数对每个键值对进行操作。如果函数返回 false，遍历停止。
    m.Range(func(key, value interface{}) bool {
        fmt.Println(key, value)
        return true
    })

}
