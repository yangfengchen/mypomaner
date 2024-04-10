<template>
    <div class="container">
        <lay-row space="10">
            <lay-col md="14">
                <lay-form-item label="表名称">
                    <lay-input v-model="searchDto.name" @change="loadData" />
                </lay-form-item>
                <lay-form-item label="项目编码">
                    <lay-input v-model="searchDto.projectCode" @change="loadData" />
                </lay-form-item>
                <lay-form-item label="表中文名">
                    <lay-input v-model="searchDto.znName" @change="loadData" />
                </lay-form-item>
                <lay-form-item label="类名称">
                    <lay-input v-model="searchDto.codeName" @change="loadData" />
                </lay-form-item>
            </lay-col>
            <lay-col md="10">
                <lay-button @click="addOpenView">添加数据</lay-button>
                <lay-button @click="toHome" type="normal">返回项目页面</lay-button>
            </lay-col>
        </lay-row>
        <lay-row>
            <lay-table :columns="tableThead" :data-source="tableTbody" :page="page" @change="changePage" :loading="loading">
                <template #enabled="{ row }">
                    {{ row.enabled == true ? '是' : '否' }}
                </template>
                <template v-slot:operator="{ row }">
                    <lay-button @click="editViewOp($event, row)">编辑</lay-button>
                    <lay-button @click="removeOp($event, row)">删除</lay-button>
                </template>
            </lay-table>
        </lay-row>
    </div>
</template>
<script setup>
import { reactive, onBeforeMount, onMounted, ref } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { getinitsearch, getData, deleteById } from '@/api/projectTable/projectTableApi'
import { layerSuccess, layerError } from '@/api/messageBuilder'

let searchDto = reactive( {} )
let tableTbody = ref( [] )
let loading = ref( false )
const router = useRouter()
const route = useRoute()
const projectCode = ref( '' )

onBeforeMount( () =>
{
    //console.log('2.组件挂载页面之前执行----onBeforeMount')
} )
onMounted( () =>
{
    //console.log('3.-组件挂载到页面之后执行-------onMounted')
    projectCode.value = route.query.projectCode
    getinitsearch().then( data =>
    {
        loadData()
    } )
} )

let tableThead = [
    {
        title: "表名称",
        width: "200px",
        key: "name"
    },
    {
        title: "项目编码",
        width: "120px",
        key: "projectCode"
    },
    {
        title: "表中文名",
        width: "200px",
        key: "znName"
    },
    {
        title: "类名称",
        width: "200px",
        key: "codeName"
    },
    {
        title: "包名",
        width: "200px",
        key: "packageName"
    },
    {
        title: "是否启用",
        width: "120px",
        key: "enabled",
        customSlot: "enabled"
    },
    {
        title: "操作", width: "300px", customSlot: "operator", ignoreExport: true
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
    searchDto.projectCode = projectCode.value
    getData( searchDto ).then( data =>
    {
        tableTbody.value = data.results
        Object.assign( page, { current: data.current, total: data.totalCount } )
        loading.value = false;
    } )
}

const toHome = () =>
{
    router.push( { path: '/projectInfoList' } )
}

const addOpenView = () =>
{
    // const {href} = router.resolve({path: '/projectTableAdd',
    //     query:{
    //         projectCode: projectCode.value
    //     }
    // });
    // window.open(href, '_blank');
    router.push( {
        path: '/projectTableAdd',
        query: {
            projectCode: projectCode.value
        }
    } )
}

const removeOp = ( e, row ) =>
{
    deleteById( row.id ).then( data =>
    {
        layerSuccess( data )
        loadData()
    } )
}

const editViewOp = ( e, row ) =>
{
    // const {href} = router.resolve({path: '/projectTableAdd',
    //     query:{
    //         projectCode: projectCode.value
    //     }
    // });
    // window.open(href, '_blank');
    router.push( {
        path: '/projectTableEdit',
        query: {
            projectCode: projectCode.value,
            id: row.id
        }
    } )
}



</script>

<style scoped lang="scss"></style>
