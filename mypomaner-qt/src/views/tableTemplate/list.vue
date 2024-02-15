<template>
    <div class="container">
        <lay-row space="12">
            <lay-col md="12">
                <lay-form-item label="模板名称">
                    <lay-input v-model="searchDto.name" @change="loadData" />
                </lay-form-item>
                <lay-form-item label="模板编码">
                    <lay-input v-model="searchDto.code" @change="loadData" />
                </lay-form-item>
            </lay-col>
            <lay-col md="10">
                <lay-button @click="addOpenView">添加数据</lay-button>
                <lay-button @click="toHome" type="normal">返回主页</lay-button>
            </lay-col>
        </lay-row>
        <lay-row>
            <lay-table :columns="tableThead" :data-source="tableTbody" :page="page" @change="changePage" :loading="loading">
                <template #enabled="{ row }">
                    {{ row.enabled == true ? '是':'否' }}
                </template>
                <template v-slot:operator="{ row }">
                    <lay-button @click="editViewOp($event, row)">编辑</lay-button>
                    <lay-button @click="removeOp($event, row)">删除</lay-button>
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
import { getinitsearch, getData, deleteById } from '@/api/tableTemplate/tableTemplateApi'
import addView from '@/views/tableTemplate/add.vue'
import editView from '@/views/tableTemplate/edit.vue'
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
        title: "类型",
        width: "200px",
        key: "name"
    },
    {
        title: "编码",
        width: "200px",
        key: "code"
    },
    {
        title: "是否启用",
        width: "80px",
        key: "enabled",
        customSlot: "enabled"
    }, {
        title: "操作", width: "150px", customSlot: "operator", ignoreExport: true
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

</script>

<style scoped lang="scss"></style>
