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
        <template #fileCode="{ row }">
          <lay-input v-model="row.fileCode" />
        </template>
        <template #fileName="{ row }">
          <lay-input v-model="row.fileName" />
        </template>
        <template #filePrimary="{ row }">
          <lay-switch v-model="row.filePrimary"></lay-switch>
        </template>
        <template #fileNull="{ row }">
          <lay-switch v-model="row.fileNull"></lay-switch>
        </template>
        <template #fileAuto="{ row }">
          <lay-switch v-model="row.fileAuto"></lay-switch>
        </template>
        <template #fileDataType="{ row }">
          <lay-select v-model="row.fileDataType">
            <template v-for="item in fieldDbTypeList">
              <lay-select-option :value="item.value" :label="item.label" />
            </template>
          </lay-select>
        </template>
        <template #fileLen="{ row }">
          <lay-input v-model="row.fileLen" />
        </template>
        <template #fileDecimal="{ row }">
          <lay-input v-model="row.fileDecimal" />
        </template>
        <template #fileDec="{ row }">
          <lay-input v-model="row.fileDec" />
        </template>
        <template #fileDefaultVal="{ row }">
          <lay-input v-model="row.fileDefaultVal" />
        </template>
        <template #fileDtoStatus="{ row }">
          <lay-switch v-model="row.fileDtoStatus"></lay-switch>
        </template>
        <template #fileVoStatus="{ row }">
          <lay-switch v-model="row.fileVoStatus"></lay-switch>
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
import { getinitsearch, getListData, saveListData } from '@/api/fileTemplate/fileTemplateApi'
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
    key: "fileCode",
    customSlot: "fileCode"
  },
  {
    title: "字段名称",
    width: "200px",
    key: "fileName",
    customSlot: "fileName"
  },
  {
    title: "字段是否主键",
    width: "200px",
    key: "filePrimary",
    customSlot: "filePrimary"
  },
  {
    title: "字段是否空",
    width: "200px",
    key: "fileNull",
    customSlot: "fileNull"
  },
  {
    title: "字段是否自增",
    width: "200px",
    key: "fileAuto",
    customSlot: "fileAuto"
  },
  {
    title: "字段数据类型",
    width: "200px",
    key: "fileDataType",
    customSlot: "fileDataType"
  },
  {
    title: "字段长度",
    width: "200px",
    key: "fileLen",
    customSlot: "fileLen"
  },
  {
    title: "字段小数位",
    width: "200px",
    key: "fileDecimal",
    customSlot: "fileDecimal"
  },
  {
    title: "字段说明",
    width: "200px",
    key: "fileDec",
    customSlot: "fileDec"
  },
  {
    title: "字段默认值",
    width: "200px",
    key: "fileDefaultVal",
    customSlot: "fileDefaultVal"
  },
  {
    title: "字段dto",
    width: "200px",
    key: "fileDtoStatus",
    customSlot: "fileDtoStatus"
  },
  {
    title: "字段vo",
    width: "200px",
    key: "fileVoStatus",
    customSlot: "fileVoStatus"
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
  getIdByType( 'fileTemplate' ).then( data =>
  {
    let _obj = {
      id: data,
      fileCode: '',
      fileName: '',
      filePrimary: false,
      fileNull: true,
      fileAuto: false,
      fileType: '',
      fileDataType: '',
      fileLen: '',
      fileDecimal: '',
      fileDec: '',
      fileDefaultVal: '',
      fileHtmlType: '',
      tableId: selectTableTemplateCode,
      enabled: true,
      fileDtoStatus: false,
      fileVoStatus: false
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
