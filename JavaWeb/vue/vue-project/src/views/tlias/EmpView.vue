<template>
    <div>
        <el-container style="height: 700px; border: 1px solid #eee">

            <el-header style="font-size: 40px; background-color: rgb(238, 241, 246)">tlias 智能学习辅助系统</el-header>

            <el-container>
                <el-aside width="230px" style="border: 1px solid #eee">
                    <el-menu :default-openeds="['1', '3']">
                        <el-submenu index="1">
                            <template slot="title"><i class="el-icon-message"></i>系统信息管理</template>
                            <el-menu-item index="1-1">
                                <router-link to="/dept" class="cls">部分管理</router-link>
                            </el-menu-item>
                            <el-menu-item index="1-2">
                                <router-link to="/emp" class="cls">员工管理</router-link>
                            </el-menu-item>
                        </el-submenu>
                    </el-menu>
                </el-aside>

                <el-main>
                    <!-- 表单 -->
                    <el-form :inline="true" :model="searchForm" class="demo-form-inline">
                        <el-form-item label="姓名">
                            <el-input v-model="searchForm.name" placeholder="请输入员工姓名"></el-input>
                        </el-form-item>

                        <el-form-item label="性别">
                            <el-select v-model="searchForm.gender" placeholder="请选择">
                                <el-option label="男" value="1"></el-option>
                                <el-option label="女" value="2"></el-option>
                            </el-select>
                        </el-form-item>

                        <el-form-item label="入职日期">
                            <!-- 日期选择器 -->
                            <el-date-picker v-model="searchForm.entrydate" type="datetimerange" range-separator="至"
                                start-placeholder="开始日期" end-placeholder="结束日期">
                            </el-date-picker>
                        </el-form-item>

                        <el-form-item>
                            <el-button type="primary" @click="onSubmit">查询</el-button>
                        </el-form-item>
                    </el-form>
                    
                    <!-- 表格 -->
                    <el-table :data="tableData" border>
                        <el-table-column prop="name" label="姓名" width="180">
                        </el-table-column>
                        <el-table-column label="图像" width="180">
                            <template slot-scope="scope">
                                <img :src="scope.row.image" width="100px" height="70px">
                            </template>
                        </el-table-column>
                        <el-table-column label="性别" width="140">
                            <!-- 插槽, 将父组件属性传给子组件 -->
                            <template slot-scope="scope">
                                <!-- <div v-if="scope.row.gender == 1">男</div>
                                <div v-else>女</div> -->
                                {{ scope.row.gender == 1 ? "男" : "女" }}
                            </template>
                        </el-table-column>
                        <el-table-column prop="job" label="职位" width="140">
                        </el-table-column>
                        <el-table-column prop="entrydate" label="入职日期" width="180">
                        </el-table-column>
                        <el-table-column prop="updatetime" label="最后操作时间" width="230">
                        </el-table-column>
                        <el-table-column label="操作">
                            <el-button type="primary" size="mini">编辑</el-button>
                            <el-button type="danger" size="mini">删除</el-button>
                        </el-table-column>
                    </el-table>

                    <br>

                    <!-- Pagination 分页 -->
                    <el-pagination background layout="total, ->, sizes, prev, pager, next, jumper"
                        @size-change="handleSizeChange" @current-change="handleCurrentChange" :total="1000">
                    </el-pagination>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            tableData: [],
            searchForm: {
                name: '',
                gender: '',
                entrydate: []
            },
        }
    },
    methods: {
        onSubmit() {
            alert("查询数据");
        },
        handleSizeChange(val) {
            alert("每页记录数变化" + val);
        },
        handleCurrentChange(val) {
            alert("页码发生变化" + val);
        },
    },
    mounted() {
        // 发送异步请求, 获取数据
        axios.get("https://mock.apifox.cn/m1/3128855-0-default/emp/list").then((result) => {
            this.tableData = result.data.data;
        });
    }
}
</script>

<style>
    .cls {
        text-decoration: none;
        color: #888888;
    }
</style>