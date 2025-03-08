package main

import (
	"database/sql"
	"fmt"
	_ "github.com/go-sql-driver/mysql"
)

type Dish struct {
	Id int
	Name string
}

func main() {
	// db, err := sql.Open("mysql", "user:password@tcp(127.0.0.1:3306)/dbname")
	dsn := "root:mysql-1q2w3e4R@tcp(192.168.86.129:3306)/sky_take_out"
	db, err := sql.Open("mysql", dsn)
	if err != nil {
		panic(err)
	}
	defer db.Close()

	rows, err := db.Query("select id, name from dish where id = 46")
	if err != nil {
		panic(err)
	}
	defer rows.Close()

	for rows.Next() {
		var info Dish
		rows.Scan(&info.Id, &info.Name)
		fmt.Println(info)
	}
}