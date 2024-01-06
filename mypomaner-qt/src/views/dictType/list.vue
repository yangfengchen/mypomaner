<template>
 <div class="container">
    <lay-row>
        <lay-row space="10">
            <lay-button @click="addOpenView">添加数据</lay-button>
            <lay-button @click="toHome" type="normal">返回主页</lay-button>
        </lay-row>
    </lay-row>
    <lay-row>
            <lay-table :columns="tableThead" :data-source="tableTbody" :page="page" 
             @change="changePage" :loading="loading">
                <template v-slot:operator="{ row }">
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
import { getinitsearch, getListData, deleteById } from '@/api/dictType/dictTypeApi'
import { layerSuccess, layerError } from '@/api/messageBuilder'
import addView from '@/views/dictType/add.vue'
import editView from '@/views/dictType/edit.vue'


onBeforeMount(() => {
    //console.log('2.组件挂载页面之前执行----onBeforeMount')
})
onMounted(() => {
    //console.log('3.-组件挂载到页面之后执行-------onMounted')
    getinitsearch().then( data =>
    {
        loadData();
    } )
})

const router = useRouter()
const route = useRoute()

const toHome = () =>{
    router.push({path: '/'})
}

let searchDto = reactive({})
let loading = ref(false)

const loadData = () =>
{
    loading.value = true;

    getListData( searchDto ).then( data =>
    {
        tableTbody.value = data.results
        Object.assign(page,{current: data.current, total: data.totalCount})
        loading.value = false;
    } )
}

let tableThead = [
    {
        title: "类型",
        width: "80px",
        key: "dictName"
    },
    {
        title: "类型值",
        width: "200px",
        key: "dictType"
    },  {
        title: "操作", width: "150px", customSlot: "operator", ignoreExport: true
    }
]
let tableTbody = ref( [] )

const page = reactive({ current: 1, limit: 10 });

const changePage = (page) =>{
   searchDto.current = page.current
   loadData()
}

const addViewRef = ref( null )

const addOpenView =  () => {
    addViewRef.value.ajaxViewData()
}

const editOpenView = (e, row) =>{
    addViewRef.value.ajaxViewData(row.id)
}

const removeOp = (e, row) =>{
    deleteById(row.id).then(data => {
        layerSuccess(data)
        loadData()
    })
}


</script>

<style scoped lang="scss">

</style>
