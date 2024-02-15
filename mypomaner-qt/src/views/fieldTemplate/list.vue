<template>
  <div class="container">
    <lay-row space="12">
      <lay-col md="12">
        <lay-form-item label="标签类型">
          <lay-select class="selectCustomCss" v-model="selectTableTemplateCode" :show-search="true"
            @change="changeTableTemplateCode" :allow-clear="true">
            <template v-for="item in tableTemplateList">
              <lay-select-option :value="item.value" :label="item.label" />
            </template>
          </lay-select>
        </lay-form-item>
      </lay-col>
      <lay-col md="10">
        <lay-button @click="addData">添加数据</lay-button>
        <lay-button @click="saveOpData">保存数据</lay-button>
        <lay-button @click="toHome" type="normal">返回主页</lay-button>
      </lay-col>
    </lay-row>
    <lay-row>
      <lay-table :columns="tableThead" :data-source="tableTbody">
        <template #fieldCode="{ row }">
          <lay-input v-model="row.fieldCode" />
        </template>
        <template #fieldName="{ row }">
          <lay-input v-model="row.fieldName" />
        </template>
        <template #fieldPrimary="{ row }">
          <lay-switch v-model="row.fieldPrimary"></lay-switch>
        </template>
        <template #fieldNull="{ row }">
          <lay-switch v-model="row.fieldNull"></lay-switch>
        </template>
        <template #fieldAuto="{ row }">
          <lay-switch v-model="row.fieldAuto"></lay-switch>
        </template>
        <template #fieldDataType="{ row }">
          <lay-select v-model="row.fieldDataType">
            <template v-for="item in fieldDbTypeList">
              <lay-select-option :value="item.value" :label="item.label" />
            </template>
          </lay-select>
        </template>
        <template #fieldLen="{ row }">
          <lay-input v-model="row.fieldLen" />
        </template>
        <template #fieldDecimal="{ row }">
          <lay-input v-model="row.fieldDecimal" />
        </template>
        <template #fieldDec="{ row }">
          <lay-input v-model="row.fieldDec" />
        </template>
        <template #fieldDefaultVal="{ row }">
          <lay-input v-model="row.fieldDefaultVal" />
        </template>
        <template #fieldDtoStatus="{ row }">
          <lay-switch v-model="row.fieldDtoStatus"></lay-switch>
        </template>
        <template #fieldVoStatus="{ row }">
          <lay-switch v-model="row.fieldVoStatus"></lay-switch>
        </template>
        <template #enabled="{ row }">
          <lay-switch v-model="row.enabled"></lay-switch>
        </template>

        <template v-slot:operator="{ row }">
          <lay-button @click="removeOp($event, row)">删除</lay-button>
        </template>
      </lay-table>
    </lay-row>
  </div>
</template>
<script setup>
import { reactive, onBeforeMount, onMounted, ref, watch } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { getinitsearch, getListData, saveListData } from '@/api/fieldTemplate/fieldTemplateApi'
import { getIdByType } from '@/api/idgenerate/idgenerateApi'
import { layerSuccess, layerError } from '@/api/messageBuilder'
import { layer } from '@layui/layui-vue'


const router = useRouter()
let fieldDbTypeList = ref( [] )
let tableTemplateList = ref( [] )
let selectTableTemplateCode = ref('')
let searchDto = reactive({})

onBeforeMount( () =>
{
  //console.log('2.组件挂载页面之前执行----onBeforeMount')
} )
onMounted( () =>
{
  //console.log('3.-组件挂载到页面之后执行-------onMounted')
  getinitsearch().then( data =>
  {
    fieldDbTypeList.value = data.fieldDbTypeList;
    tableTemplateList.value = data.tableTemplateList;
    if(data.tableTemplateList && data.tableTemplateList.length > 0){
      selectTableTemplateCode.value = data.tableTemplateList[0].value;
    }
    loadData();
  } )
} )

let tableTbody = ref( [] )

const loadData = () =>
{
  searchDto.tableId = selectTableTemplateCode;
  getListData(searchDto).then( data =>
  {
    tableTbody.value = data
  } )
}

let tableThead = [
  {
    title: "字段代码",
    width: "200px",
    key: "fieldCode",
    customSlot: "fieldCode"
  },
  {
    title: "字段名称",
    width: "200px",
    key: "fieldName",
    customSlot: "fieldName"
  },
  {
    title: "字段是否主键",
    width: "200px",
    key: "fieldPrimary",
    customSlot: "fieldPrimary"
  },
  {
    title: "字段是否空",
    width: "200px",
    key: "fieldNull",
    customSlot: "fieldNull"
  },
  {
    title: "字段是否自增",
    width: "200px",
    key: "fieldAuto",
    customSlot: "fieldAuto"
  },
  {
    title: "字段数据类型",
    width: "200px",
    key: "fieldDataType",
    customSlot: "fieldDataType"
  },
  {
    title: "字段长度",
    width: "200px",
    key: "fieldLen",
    customSlot: "fieldLen"
  },
  {
    title: "字段小数位",
    width: "200px",
    key: "fieldDecimal",
    customSlot: "fieldDecimal"
  },
  {
    title: "字段说明",
    width: "200px",
    key: "fieldDec",
    customSlot: "fieldDec"
  },
  {
    title: "字段默认值",
    width: "200px",
    key: "fieldDefaultVal",
    customSlot: "fieldDefaultVal"
  },
  {
    title: "字段dto",
    width: "200px",
    key: "fieldDtoStatus",
    customSlot: "fieldDtoStatus"
  },
  {
    title: "字段vo",
    width: "200px",
    key: "fieldVoStatus",
    customSlot: "fieldVoStatus"
  },
  {
    title: "是否启用",
    width: "200px",
    key: "enabled",
    customSlot: "enabled"
  }, {
    title: "操作", width: "150px", customSlot: "operator", ignoreExport: true
  }
];

function addData ()
{
  getIdByType( 'fieldTemplate' ).then( data =>
  {
    let _obj = {
      id: data,
      fieldCode: '',
      fieldName: '',
      fieldPrimary: false,
      fieldNull: true,
      fieldAuto: false,
      fieldType: '',
      fieldDataType: '',
      fieldLen: '',
      fieldDecimal: '',
      fieldDec: '',
      fieldDefaultVal: '',
      fieldHtmlType: '',
      tableId: selectTableTemplateCode,
      enabled: true,
      fieldDtoStatus: false,
      fieldVoStatus: false
    }
    tableTbody.value.push( _obj )
  } )

}

const removeOp = ( e, row ) =>
{
  tableTbody.value = tableTbody.value.filter( item => item.id !== row.id )
}


function saveOpData ()
{
  saveListData( tableTbody.value ).then( data =>
  {
    layerSuccess( data )
  } )
}
const toHome = () =>
{
  router.push( { path: '/' } )
}

const changeTableTemplateCode = () =>
{
loadData();
}


</script>

<style scoped lang="scss"></style>
