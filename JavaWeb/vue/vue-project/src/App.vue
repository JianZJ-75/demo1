<!-- 模板部分, 由它生成HTML代码 -->
<template>
  <div>
    <!-- <h1>{{ message }}</h1> -->
    <!-- <ElementView></ElementView> -->

    <!-- 员工管理 -->
    <!-- <emp-view></emp-view> -->

    <router-view></router-view>

  </div>
</template>

<!-- 控制模板的数据来源和行为 -->
<script>
/* import ElementView from './views/element/ElementView.vue' */
/* import EmpView from './views/tlias/EmpView.vue' */
export default {
  components: {/* EmpView */ /* ElementView */ },
  data() {
    return {
      message: "Hello Vue"
    }
  },
  methods: {

  }
}
</script>

<!-- css样式部分 -->
<style></style>
