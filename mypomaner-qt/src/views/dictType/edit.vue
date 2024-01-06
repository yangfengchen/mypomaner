<template>
 <div class="container">

 </div>
</template>
<script setup>
import { reactive, onBeforeMount, onMounted, ref } from 'vue'
import { useRouter, useRoute } from 'vue-router'
onBeforeMount(() => {
    //console.log('2.组件挂载页面之前执行----onBeforeMount')
})
onMounted(() => {
    //console.log('3.-组件挂载到页面之后执行-------onMounted')
})
</script>

<style scoped lang="scss">

</style>
