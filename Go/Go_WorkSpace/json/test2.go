package json

import (
	"encoding/json"
	"fmt"
)

/*
	动态解析JSON
*/
func Test2() {
	jsonStr := `{"name":"Alice","age":25,"extra":{"city":"New York}}`
	var data map[string]interface{}
	json.Unmarshal([]byte(jsonStr), &data)
	fmt.Println(data["name"], data["age"])
	fmt.Println(data["extra"].(map[string]interface{})["city"])
}
