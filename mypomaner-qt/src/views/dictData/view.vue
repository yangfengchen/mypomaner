<template>
    <div class="container">
        <lay-layer v-model="visibleView" title="查看详细信息" :shade="false" :area="['500px', '450px']">
            <div style="padding: 20px;">
                <lay-form :model="dictDataViewDto" ref="layFormRef11">
                    <lalbelItem labelName="标签名称">
                        {{ dictDataViewDto.dictName }}
                    </lalbelItem>
                    <lalbelItem labelName="标签">
                        {{ dictDataViewDto.dictLabel }}
                    </lalbelItem>
                    <lalbelItem labelName="标签值">
                        {{ dictDataViewDto.dictValue }}
                    </lalbelItem>
                    <lalbelItem labelName="排序">
                        {{ dictDataViewDto.dictSort }}
                    </lalbelItem>
                </lay-form>
            </div>
        </lay-layer>
    </div>
</template>
<script setup>
import { reactive, onBeforeMount, onMounted, ref, watch } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { viewData } from '@/api/dictData/dictDataApi'
import { layerSuccess, layerError } from '@/api/messageBuilder'
import lalbelItem from '@/components/labelItem/index.vue'

onBeforeMount( () =>
{
    //console.log('2.组件挂载页面之前执行----onBeforeMount')
} )
onMounted( () =>
{
    //console.log('3.-组件挂载到页面之后执行-------onMounted')
} )
let visibleView = ref( false )

let dictDataViewDto = reactive( {} );

const ajaxViewData = ( id ) =>
{
    viewData( id ).then( data =>
    {
        Object.assign( dictDataViewDto, data )
        visibleView.value = true
    } )
}
defineExpose( { ajaxViewData } )

// 测试子组件监听父组件值
// let props = defineProps( {
//     testParentVal: {
//         type: String,
//         default: ''
//     }
// } )
// let testVal = ref(props.testParentVal)
// watch(()=>props.testParentVal,(nVal,oVal)=>{
//     console.log(nVal,oVal)
//     testVal.value = nVal
// })
</script>

<style scoped lang="scss">
.labelContext {
    padding-top: 10px;
}</style>
