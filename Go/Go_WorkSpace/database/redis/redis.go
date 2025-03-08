package main

import (
	"context"
	"fmt"
	"github.com/redis/go-redis/v9"
)

var ctx = context.Background()

func main() {
	/* 
		创建 Redis 客户端
		rdb := redis.NewClient(&redis.Options{
			Addr:     "192.168.86.129:6379",
			Password: "", // 如果 Redis 有密码，填写相应的密码
			DB:       0,  // 使用默认数据库
		})
	*/
	rdb := redis.NewClient(&redis.Options{
		Addr: 		"192.168.86.129:6379",
		Password: 	"redis-1q2w3e4R",
		DB: 		0,
	})

	// 测试与 Redis 服务器的连接
	pong, err := rdb.Ping(ctx).Result()
	if err != nil {
		fmt.Printf("无法连接到 Redis 服务器: %v\n", err)
		return
	}
	fmt.Printf("成功连接到 Redis 服务器，Ping 响应: %s\n", pong)

	// 设置键值对
    err = rdb.Set(ctx, "Hello Go", "Hello redis", 0).Err()
    if err != nil {
        fmt.Printf("设置键值对时出错: %v\n", err)
        return
    }

	// 获取键的值
    val, err := rdb.Get(ctx, "Hello Go").Result()
    if err != nil {
        if err == redis.Nil {
            fmt.Println("键不存在")
        } else {
            fmt.Printf("获取键值时出错: %v\n", err)
        }
        return
    }
	fmt.Println(val)
}