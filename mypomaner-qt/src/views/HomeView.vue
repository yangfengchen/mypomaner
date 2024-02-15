<script setup>
import { ref, onMounted } from 'vue'
import { useRouter, useRoute } from 'vue-router'
const router = useRouter()
const route = useRoute()
const selectProjectCode = ref( '' )
const projectList = []
function seachProject ( item )
{

}
const toDictDataView = () =>
{
  router.push( { path: '/dictDataList' } )
}

const toDictTypeView = () =>
{
  router.push( { path: '/dictTypeList' } )
}

const toFieldConfigView = () =>
{
  router.push({path: '/fieldConfigList'})
}

const toTableTemplateView = () =>
{
  router.push({path: '/tableTemplateList'})
}

const toFieldTemplateView = () =>
{
  router.push({path: '/fieldTemplateList'})
}

const toProjectInfoView = () =>
{
  router.push({path: '/projectInfoList'})
}


</script>

<template>
  <lay-row space="10">
    <lay-col md="8">
      <lay-button type="default" radius @click="toProjectInfoView">项目维护</lay-button>
    </lay-col>
    <lay-col md="8">
      <lay-dropdown trigger="hover" updateAtScroll radius>
        <lay-button>标签维护</lay-button>
        <template #content>
          <lay-dropdown-menu>
            <lay-dropdown-menu-item @click="toDictTypeView">标签类型</lay-dropdown-menu-item>
            <lay-dropdown-menu-item @click="toDictDataView">标签</lay-dropdown-menu-item>
          </lay-dropdown-menu>
        </template>
      </lay-dropdown>
    </lay-col>
    <lay-col md="8">
      <lay-dropdown trigger="hover" updateAtScroll radius>
        <lay-button type="default" radius>默认表字段设置</lay-button>
        <template #content>
          <lay-dropdown-menu>
            <lay-dropdown-menu-item @click="toFieldConfigView">基础字段配置</lay-dropdown-menu-item>
            <lay-dropdown-menu-item @click="toTableTemplateView">基础表配置</lay-dropdown-menu-item>
            <lay-dropdown-menu-item @click="toFieldTemplateView">默认字段配置</lay-dropdown-menu-item>
          </lay-dropdown-menu>
        </template>
      </lay-dropdown>
    </lay-col>
  </lay-row>
  <!-- <lay-row space="10">
    <lay-select v-model="selectProjectCode" :show-search="true" @search="seachProject">
      <template v-for="item in projectList">
        <lay-select-option :value="item.value"> 选项 - {{ item.label }}</lay-select-option>
      </template>
    </lay-select>
  </lay-row> -->
</template>
<style scoped>
.col-item {
  text-align: center;
}

.col-item-btn {
  width: 80%;
}
</style>
