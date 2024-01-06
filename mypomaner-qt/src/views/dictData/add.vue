<template>
    <div class="container">
        <lay-layer v-model="visibleView" title="编辑内容" :shade="false" :area="['500px', '450px']">
            <div style="padding: 20px;">
                <lay-form :model="dictDataSaveDto" ref="layFormRef11" :rules="rules5">
                    <lay-form-item label="标签名称">
                        <div class="labelContext">{{ selectProjectCodeName }}</div>
                    </lay-form-item>
                    <lay-form-item label="标签" prop="dictLabel">
                        <lay-input v-model="dictDataSaveDto.dictLabel"></lay-input>
                    </lay-form-item>
                    <lay-form-item label="标签值" prop="dictValue">
                        <lay-input v-model="dictDataSaveDto.dictValue"></lay-input>
                    </lay-form-item>
                    <lay-form-item label="排序" prop="dictSort">
                        <lay-input v-model="dictDataSaveDto.dictSort"></lay-input>
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

import { reactive, onBeforeMount, onMounted, ref, defineProps, defineEmits, defineExpose } from 'vue'
import { addViewData, saveData } from '@/api/dictData/dictDataApi'
import { layerSuccess, layerError } from '@/api/messageBuilder'
import { useRouter, useRoute } from 'vue-router'
onBeforeMount( () =>
{
    // console.log( '2.组件挂载页面之前执行----onBeforeMount' )
} )

onMounted( () =>
{
    // console.log( '3.-组件挂载到页面之后执行-------onMounted' )
} )

let props = defineProps( {
    // visible11: {
    //     type: Boolean,
    //     default: false
    // }
} )
const $emit = defineEmits( [ "callbackData" ] )

let visibleView = ref( false )

let layFormRef11 = ref();
let validateSort = ( rule, value, callback, source, options ) =>
{
    if ( typeof value == "number" )
    {
        return true;
    } else
    {
        callback( new Error( `${ rule.field }必须为数值` ) );
    }
}

let rules5 = ref( {
    dictLabel: {
        required: true, message: '必填项'
    },
    dictValue: {
        required: true, message: '必填项'
    },
    dictSort: [
        {
            required: true, message: '必填项'
        },
        {
            validateSort: validateSort
        }
    ]
} )

const submit5 = function ()
{
    layFormRef11.value.validate( ( isValidate, model, errors ) =>
    {
        if ( isValidate )
        {
            saveData( dictDataSaveDto ).then( data =>
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
let dictDataSaveDto = reactive( {
    dictLabel: '',
    dictValue: '',
    dictSort: ''
} )
let selectProjectCodeName = ref( '' )

const ajaxViewData = ( selectProjectCode, visible11 ) =>
{
    addViewData( selectProjectCode ).then( data =>
    {
        let _dictTypeList = data.dictTypeList;
        if ( _dictTypeList )
        {
            _dictTypeList.forEach( element =>
            {
                if ( selectProjectCode == element.value )
                {
                    selectProjectCodeName.value = element.label
                    return true
                }
            } );
        }
        Object.assign( dictDataSaveDto, data.dictDataSaveVo )
        visibleView.value = true
    } )
}
defineExpose( { ajaxViewData } )
</script>

<style scoped lang="scss">
.labelContext {
    padding-top: 10px;
}
</style>
