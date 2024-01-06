<template>
    <div class="container">
        <lay-layer v-model="visibleView" title="编辑内容" :shade="false" :area="['500px', '450px']">
            <div style="padding: 20px;">
                <lay-form :model="dictTypeEditDto" ref="layFormRef11" :rules="rules5" required>
                    <lay-form-item label="标签" prop="dictName">
                        <lay-input v-model="dictTypeEditDto.dictName"></lay-input>
                    </lay-form-item>
                    <lay-form-item label="标签值" prop="dictType">
                        <lay-input v-model="dictTypeEditDto.dictType"></lay-input>
                    </lay-form-item>
                    <lay-form-item style="text-align: center">
                        <lay-button @click="submit5" type="primary">提交</lay-button>
                    </lay-form-item>
                </lay-form>
            </div>
        </lay-layer>
    </div>
</template>
<script setup>
import { reactive, onBeforeMount, onMounted, ref } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { addViewData, saveData } from '@/api/dictType/dictTypeApi'
import { layerSuccess, layerError } from '@/api/messageBuilder'

onBeforeMount( () =>
{
    //console.log('2.组件挂载页面之前执行----onBeforeMount')
} )
onMounted( () =>
{
    //console.log('3.-组件挂载到页面之后执行-------onMounted')
} )

let visibleView = ref( false )
let dictTypeEditDto = reactive( {} )

const ajaxViewData = () =>
{
    addViewData().then( data =>
    {
        Object.assign( dictTypeEditDto, data )
        visibleView.value = true
    } )
}
defineExpose( { ajaxViewData } )

let rules5 = ref( {})
const $emit = defineEmits( [ "callbackData" ] )

let layFormRef11 = ref(null);
const submit5 = function ()
{
    layFormRef11.value.validate( ( isValidate, model, errors ) =>
    {
        if ( isValidate )
        {
            saveData( dictTypeEditDto ).then( data =>
            {
                layerSuccess( "保存成功" )
                visibleView.value = false
                $emit( "callbackData" )
            } )
        } else
        {
            layerError( "校验失败" )
        }

    } );
}
</script>

<style scoped lang="scss"></style>
