package main

import (
	"database/sql"
	_ "github.com/go-sql-driver/mysql"
)

func main() {
	dsn := "root:mysql-1q2w3e4R@tcp(192.168.86.129:3306)/sky_take_out"
	db, err := sql.Open("mysql", dsn)
	if err != nil {
		panic(err)
	}
	defer db.Close()

	// 开启事务
	tx, err := db.Begin()
	if err != nil {
		panic(err)
	}

	_, err = tx.Exec("update dish set name = '王老吉1' where id = 46")
	if err != nil {
		// 回滚
		tx.Rollback()
		return
	}

	_, err = tx.Exec("update dish set name = '王老吉' where id = 46")
	if err != nil {
		tx.Rollback()
		return
	}

	// 提交事务
	tx.Commit()
}