<template>
  <div class="container">
    <lay-row space="12">
      <lay-col md="16">
        <lay-form-item label="数据表名称" >
          <lay-input v-model="projectTableSaveDto.name"/>
        </lay-form-item>
        <lay-form-item label="代码类名称" mode="inline">
          <lay-input v-model="projectTableSaveDto.codeName"/>
        </lay-form-item>
        <lay-form-item label="代码包名" mode="inline">
          <lay-input v-model="projectTableSaveDto.packageName"/>
        </lay-form-item>
        <lay-form-item label="表中文名" mode="inline">
          <lay-input v-model="projectTableSaveDto.znName"/>
        </lay-form-item>
        <lay-form-item label="是否启用" mode="inline">
          <lay-switch v-model="projectTableSaveDto.enabled"/>
        </lay-form-item>
        <lay-form-item label="数据库和代码字段是否转换" mode="inline">
          <lay-switch v-model="projectTableSaveDto.fileNameConvert" />
        </lay-form-item>
      </lay-col>
      <lay-col md="8">
        <lay-button @click="addData">添加数据</lay-button>
        <lay-button @click="saveOpData">保存数据</lay-button>
        <lay-button @click="toHome" type="normal">返回主页</lay-button>
      </lay-col>
    </lay-row>
    <lay-row>
      <lay-table :columns="tableThead" :data-source="tableTbody"
                 height="450px">
        <template #fieldCode="{ row }">
          <lay-input v-model="row.fieldCode"/>
        </template>
        <template #fieldName="{ row }">
          <lay-input v-model="row.fieldName"/>
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
              <lay-select-option :value="item.value" :label="item.label"/>
            </template>
          </lay-select>
        </template>
        <template #fieldLen="{ row }">
          <lay-input v-model="row.fieldLen"/>
        </template>
        <template #fieldDecimal="{ row }">
          <lay-input v-model="row.fieldDecimal"/>
        </template>
        <template #fieldDec="{ row }">
          <lay-input v-model="row.fieldDec"/>
        </template>
        <template #fieldDefaultVal="{ row }">
          <lay-input v-model="row.fieldDefaultVal"/>
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
import {reactive, onBeforeMount, onMounted, ref} from 'vue'
import {useRouter, useRoute} from 'vue-router'
import {editViewData, saveData} from '@/api/projectTable/projectTableApi'
import {getIdByType} from '@/api/idgenerate/idgenerateApi'
import {layerSuccess, layerError} from '@/api/messageBuilder'

const router = useRouter()
const route = useRoute()
let fieldDbTypeList = ref([])
let projectCode = ref('')
let id = ref('')
let projectTableSaveDto = reactive({
  fielddSaveDtoList: []
})
let tableTbody = ref([])

onBeforeMount(() => {
  //console.log('2.组件挂载页面之前执行----onBeforeMount')
})
onMounted(() => {
  //console.log('3.-组件挂载到页面之后执行-------onMounted')
  projectCode.value = route.query.projectCode
  id.value = route.query.id
  editViewData(id.value).then(data => {
    fieldDbTypeList.value = data.fieldDbTypeList
    Object.assign(projectTableSaveDto, data.saveDto)
    tableTbody.value = projectTableSaveDto.fieldSaveDtoList;
  })
})

let tableThead = [
  {
    title: "字段代码",
    width: "200px",
    key: "fieldCode",
    customSlot: "fieldCode",
    fixed: "left",
  },
  {
    title: "字段名称",
    width: "200px",
    key: "fieldName",
    customSlot: "fieldName",
    fixed: "left",
  },
  {
    title: "字段数据类型",
    width: "170px",
    key: "fieldDataType",
    customSlot: "fieldDataType"
  },
  {
    title: "字段长度",
    width: "70px",
    key: "fieldLen",
    customSlot: "fieldLen"
  },
  {
    title: "字段小数位",
    width: "50px",
    key: "fieldDecimal",
    customSlot: "fieldDecimal"
  },
  {
    title: "字段是否主键",
    width: "60px",
    key: "fieldPrimary",
    customSlot: "fieldPrimary"
  },
  {
    title: "字段是否空",
    width: "60px",
    key: "fieldNull",
    customSlot: "fieldNull"
  },
  {
    title: "字段是否自增",
    width: "60px",
    key: "fieldAuto",
    customSlot: "fieldAuto"
  },

  {
    title: "字段默认值",
    width: "80px",
    key: "fieldDefaultVal",
    customSlot: "fieldDefaultVal"
  },
  {
    title: "字段dto",
    width: "60px",
    key: "fieldDtoStatus",
    customSlot: "fieldDtoStatus"
  },
  {
    title: "字段vo",
    width: "60px",
    key: "fieldVoStatus",
    customSlot: "fieldVoStatus"
  },
  {
    title: "是否启用",
    width: "60px",
    key: "enabled",
    customSlot: "enabled"
  }, {
    title: "操作", width: "150px", customSlot: "operator", ignoreExport: true
  }
];

function addData() {
  getIdByType('projectTable').then(data => {
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
      tableId: projectTableSaveDto.id,
      projectCode: projectCode.value,
      enabled: true,
      fieldDtoStatus: false,
      fieldVoStatus: false
    }
    tableTbody.value.push(_obj)
  })
}

const removeOp = (e, row) => {
  tableTbody.value = tableTbody.value.filter(item => item.id !== row.id)
}

const toHome = () => {
  router.push({
    path: '/projectTableList',
    query: {
      projectCode: projectCode.value
    }
  })
}

function saveOpData() {
  let saveDto = reactive({
    fieldSaveDtoList: []
  });
  Object.assign(saveDto, projectTableSaveDto)
  saveDto.fieldSaveDtoList = tableTbody.value
  saveData(saveDto).then(data => {
    layerSuccess(data)
  })
}

</script>

<style scoped lang="scss">
.container{
  padding: 10px 5px;
}
</style>
   