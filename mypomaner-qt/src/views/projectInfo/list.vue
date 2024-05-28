<template>
    <div class="container">
        <lay-row space="10">
            <lay-col md="14">
                <lay-form-item label="项目名称">
                    <lay-input v-model="searchDto.projectName" @change="loadData" />
                </lay-form-item>
                <lay-form-item label="项目编码">
                    <lay-input v-model="searchDto.projectCode" @change="loadData" />
                </lay-form-item>
                <lay-form-item label="项目中文名">
                    <lay-input v-model="searchDto.projectZnName" @change="loadData" />
                </lay-form-item>
            </lay-col>
            <lay-col md="10">
                <lay-button @click="addOpenView">添加数据</lay-button>
                <lay-button @click="toHome" type="normal">返回主页</lay-button>
            </lay-col>
        </lay-row>
        <lay-row>
            <lay-table :columns="tableThead" :data-source="tableTbody" :page="page" @change="changePage"
             :loading="loading" :ellipsisTooltip="true">
                <template v-slot:operator="{ row }">
                    <lay-button @click="designViewOp($event, row)">设计表</lay-button>
                    <lay-button @click="editViewOp($event, row)">编辑</lay-button>
                    <lay-button @click="removeOp($event, row)">删除</lay-button>
                    <lay-button @click="buildCodeOp($event, row)">生成代码</lay-button>
                </template>
            </lay-table>
        </lay-row>

        <addView ref="addViewRef" @callbackData="loadData"></addView>
        <editView ref="editViewRef" @callbackData="loadData"></editView>
    </div>
</template>
<script setup>
import { reactive, onBeforeMount, onMounted, ref } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { getinitsearch, getData, deleteById, getCodeByProjectFile } from '@/api/projectInfo/projectInfoApi'
import addView from '@/views/projectInfo/add.vue'
import editView from '@/views/projectInfo/edit.vue'
import { layerSuccess, layerError } from '@/api/messageBuilder'

let searchDto = reactive( {} )
let tableTbody = ref( [] )
let loading = ref( false )
const router = useRouter()

onBeforeMount( () =>
{
    //console.log('2.组件挂载页面之前执行----onBeforeMount')
} )
onMounted( () =>
{
    //console.log('3.-组件挂载到页面之后执行-------onMounted')
    getinitsearch().then( data =>
    {
        console.log( data );
        loadData();
    } )
} )


const toHome = () =>
{
    router.push( { path: '/' } )
}

let tableThead = [
    {
        title: "项目名称",
        width: "200px",
        key: "projectName",
        fixed: "left",
    },
    {
        title: "项目编码",
        width: "120px",
        key: "projectCode"
    },
    {
        title: "项目中文名称",
        width: "200px",
        key: "projectZnName"
    }, 
    {
        title: "项目包",
        width: "200px",
        key: "packageName"
    },
    {
        title: "表模板",
        width: "120px",
        key: "tableTemplateCodeName"
    },
    {
        title: "数据库类型",
        width: "100px",
        key: "databaseTypeName"
    },
    {
        title: "编码类型",
        width: "120px",
        key: "codeTypeName"
    },{
        title: "操作", width: "350px", customSlot: "operator", ignoreExport: true
    }
]

const page = reactive( { current: 1, limit: 10 } );

const changePage = ( page ) =>
{
    searchDto.current = page.current
    loadData()
}

const loadData = () =>
{
    loading.value = true;

    getData( searchDto ).then( data =>
    {
        tableTbody.value = data.results
        Object.assign( page, { current: data.current, total: data.totalCount } )
        loading.value = false;
    } )
}

const addViewRef = ref( null )

const addOpenView = () =>
{
    addViewRef.value.ajaxViewData()
}

const removeOp = ( e, row ) =>
{
    deleteById( row.id ).then( data =>
    {
        layerSuccess( data )
        loadData()
    } )
}

const editViewRef = ref( null )

const editViewOp = (e, row) => {
    editViewRef.value.ajaxViewData( row.id )
}

const designViewOp = (e, row) =>{
  const {href} = router.resolve({path: '/projectTableList',
        query:{
            projectCode: row.projectCode
        }
    });
    window.open(href, '_blank');
}

const buildCodeOp = (e, row) =>
{
    getCodeByProjectFile(row.projectCode).then(data => {
      if(data == true){
            layerSuccess("生成代码成功")
        }
    })
}

</script>

<style scoped lang="scss"></style>
