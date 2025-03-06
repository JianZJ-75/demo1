package json

import (
	"encoding/json"
	"fmt"
)

/*
	json转换
		解析json时 结构体字段首字母必须大写
*/

type Person struct {
	// `json:"name"`指定json解析格式
	Name string `json:"name"`
	Age int		`json:"age"`
}

func NewPerson(name string, age int) *Person {
	return &Person {
		Name:	name,
		Age:	age,
	}
}

func Test1() {
	// 结构体转json
	p := NewPerson("Alice", 25)
	jsonData, _ := json.Marshal(p)
	fmt.Println(string(jsonData))

	// json转结构体
	var p2 Person
	json.Unmarshal(jsonData, &p2)
	fmt.Println(p2)
}