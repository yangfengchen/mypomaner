<template>
    <div class="container">
        <lay-row space="10">
            <lay-col md="14">
                <lay-form-item label="标签类型">
                    <lay-select class="selectCustomCss" v-model="selectProjectCode" :show-search="true"
                        @change="changeProject" :allow-clear="true">
                        <template v-for="item in projectList">
                            <lay-select-option :value="item.value" :label="item.label" />
                        </template>
                    </lay-select>
                </lay-form-item>
            </lay-col>
            <lay-col md="10">
                <!-- <lay-button>查询</lay-button> -->
                <lay-button @click="addOpenView">添加数据</lay-button>
                <lay-button @click="toHome" type="normal">返回主页</lay-button>
            </lay-col>
        </lay-row>
        <lay-row>
            <lay-table :columns="tableThead" :data-source="tableTbody" :page="page" 
             @change="changePage" :loading="loading">
                <template v-slot:operator="{ row }">
                    <lay-button @click="openView($event, row)">查看</lay-button>
                    <lay-button @click="editViewOp($event, row)">编辑</lay-button>
                    <lay-button @click="removeOp($event, row)">删除</lay-button>
                </template>
            </lay-table>
        </lay-row>

        <addView ref="addViewRef" @callbackData="loadData"></addView>

        <editView ref="editViewRef" @callbackData="loadData"></editView>
       
        <infoView ref="infoViewRef" :testParentVal="selectProjectCode"></infoView>
    </div>
</template>

<script setup>
import { reactive, onBeforeMount, onMounted, ref } from 'vue'
import { layer } from '@layui/layui-vue'
import { useRouter, useRoute } from 'vue-router'
import { getinitsearch, getListData, deleteById } from '@/api/dictData/dictDataApi'
import { layerSuccess, layerError } from '@/api/messageBuilder'
import addView from '@/views/dictData/add.vue'
import editView from '@/views/dictData/edit.vue'
import infoView from '@/views/dictData/view.vue'

const router = useRouter()
const route = useRoute()

const toHome = () =>{
    router.push({path: '/'})
}

let selectProjectCode = ref( '' )
let projectList = ref( [] )

onBeforeMount( () =>
{
    getinitsearch().then( data =>
    {
        projectList.value = data.dictTypeList;
        loadData();
    } )
} )

function changeProject ()
{
    loadData();
}

let tableThead = [
    {
        title: "标签",
        width: "80px",
        key: "dictLabel"
    },
    {
        title: "标签值",
        width: "200px",
        key: "dictValue"
    }, {
        title: "标签类型名称",
        width: "180px",
        key: "dictName"
    }, {
        title: "操作", width: "150px", customSlot: "operator", ignoreExport: true
    }
]
let tableTbody = ref( [] )

let searchDto = reactive( {} )
const page = reactive({ current: 1, limit: 10 });
let loading = ref(false)
function loadData ()
{
    searchDto.dictCode = selectProjectCode.value;
    loading.value = true;
    getListData( searchDto ).then( data =>
    {
        tableTbody.value = data.results
        Object.assign(page,{current: data.current, total: data.totalCount})
        loading.value = false;
    } )
}

const changePage = (page) =>{
    searchDto.current = page.current
    loadData()
}

const addViewRef = ref( null )

function addOpenView ()
{
    if ( selectProjectCode.value.length <= 0 )
    {
        layer.msg( "先选择标签类型", { icon: 2, time: 1000 } )
        return
    }
    addViewRef.value.ajaxViewData( selectProjectCode.value, true )
    
}

const editViewRef = ref( null )

const editViewOp = (e, row) => {
    if ( selectProjectCode.value.length <= 0 )
    {
        selectProjectCode.value = row.dictCode;
    }
    editViewRef.value.ajaxViewData( selectProjectCode.value, row.id )
}

const infoViewRef = ref(null)
const openView = ( e, row ) =>
{

    infoViewRef.value.ajaxViewData(row.id)
    
}

const removeOp = ( e, row ) =>
{
    deleteById(row.id).then(data=>{
        layerSuccess(data)
        loadData()
    })
}

</script>

<style scoped lang="scss">

</style>
