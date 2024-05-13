<template>
  <div class="container">
    <lay-row space="12">
      <lay-col md="12">
        <lay-form-item label="数据库类型">
          <lay-select class="selectCustomCss" v-model="selectDbType" :show-search="true" @change="changeDbType"
            :allow-clear="true">
            <template v-for="item in dbTypeList">
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
        <template #fieldDbType="{ row }">
          <lay-select v-model="row.fieldDbType">
            <template v-for="item in fieldDbList">
              <lay-select-option :value="item.value" :label="item.label" />
            </template>
          </lay-select>
        </template>
        <template #fieldCodeType="{ row }">
          <lay-input v-model="row.fieldCodeType" />
        </template>
        <template #fieldBaseType="{ row }">
          <lay-input v-model="row.fieldBaseType" />
        </template>
        <template #fieldDefLen="{ row }">
          <lay-input v-model="row.fieldDefLen" />
        </template>
        <template #fieldDefDecimal="{ row }">
          <lay-input v-model="row.fieldDefDecimal" />
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
import { getinitsearch, getListData, saveListData } from '@/api/fieldConfig/fieldCOnfigApi'
import { getIdByType } from '@/api/idgenerate/idgenerateApi'
import { layerSuccess, layerError } from '@/api/messageBuilder'
import { layer } from '@layui/layui-vue'

const router = useRouter()

let dbTypeList = ref( [] )
let fieldDbList = ref( [] )

let selectDbType = ref( '' )
let selectFieldDb = ref( '' )
let searchDto = reactive( {} )

onBeforeMount( () =>
{
  //console.log('2.组件挂载页面之前执行----onBeforeMount')
} )
onMounted( () =>
{
  //console.log('3.-组件挂载到页面之后执行-------onMounted')
  getinitsearch().then( data =>
  {
    dbTypeList.value = data.dbList;
    fieldDbList.value = data.fieldDbTypeList;
    if ( data.dbList && data.dbList.length > 0 )
    {
      selectDbType.value = data.dbList[ 0 ].value
    }

    loadData();
  } )
} )


let loading = ref( false )

function changeDbType ()
{
  loadData();
}

const loadData = () =>
{
  loading.value = true;
  searchDto.databaseType = selectDbType.value;
  getListData( searchDto ).then( data =>
  {
    tableTbody.value = data
    loading.value = false;
  } )
}

let tableThead = [
  {
    title: "数据库字段类型",
    width: "200px",
    key: "fieldDbType",
    customSlot: "fieldDbType"
  },
  {
    title: "字段代码类型",
    width: "200px",
    key: "fieldCodeType",
    customSlot: "fieldCodeType"
  },
  {
    title: "字段数据库类型",
    width: "200px",
    key: "fieldBaseType",
    customSlot: "fieldBaseType"
  },
  {
    title: "数据库字段长度",
    width: "200px",
    key: "fieldDefLen",
    customSlot: "fieldDefLen"
  },
  {
    title: "数据库字段默认小数位",
    width: "200px",
    key: "fieldDefDecimal",
    customSlot: "fieldDefDecimal"
  }, {
    title: "操作", width: "150px", customSlot: "operator", ignoreExport: true
  }
]
let tableTbody = ref( [] )

function addData ()
{
  getIdByType( 'fieldConfig' ).then( data =>
  {
    console.log( data )
    let _obj = {
      id: data,
      databaseType: selectDbType.value,
      fieldDbType: '',
      fieldCodeType: '',
      fieldBaseType: '',
      fieldDefLen: '',
      fieldDefDecimal: ''
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
const toHome = () =>{
    router.push({path: '/'})
}
</script>

<style scoped lang="scss"></style>
