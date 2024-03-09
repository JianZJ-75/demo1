<!-- 模板部分, 由它生成HTML代码 -->
<template>
  <div>
    <!-- <h1>{{ message }}</h1> -->
    <ElementView></ElementView>
  </div>
</template>

<!-- 控制模板的数据来源和行为 -->
<script>
import ElementView from './views/element/ElementView.vue'
export default {
  components: { ElementView },
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
<style>

</style>
