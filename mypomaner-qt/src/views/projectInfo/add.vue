<template>
    <div class="container">
        <lay-layer v-model="visibleView" title="编辑内容" :shade="false" :area="['500px', '450px']">
            <div style="padding: 20px;">
                <lay-form :model="projectInfoSaveDto" ref="layFormRef11" :rules="rules5">
                    <lay-form-item label="项目名称" prop="projectName">
                        <lay-input v-model="projectInfoSaveDto.projectName"></lay-input>
                    </lay-form-item>
                    <lay-form-item label="项目编码" prop="projectCode">
                        <lay-input v-model="projectInfoSaveDto.projectCode"></lay-input>
                    </lay-form-item>
                    <lay-form-item label="项目中文名称" prop="projectZnName">
                        <lay-input v-model="projectInfoSaveDto.projectZnName"></lay-input>
                    </lay-form-item>
                    <lay-form-item label="项目包" prop="packageName">
                        <lay-input v-model="projectInfoSaveDto.packageName"></lay-input>
                    </lay-form-item>
                    <lay-form-item label="表模型编码" prop="tableTemplateCode">
                        <lay-select v-model="projectInfoSaveDto.tableTemplateCode">
                            <template v-for="item in tableTemplateList">
                            <lay-select-option :value="item.value" :label="item.label" />
                            </template>
                        </lay-select>
                    </lay-form-item>
                    <lay-form-item label="数据库类型" prop="databaseType">
                        <lay-select v-model="projectInfoSaveDto.databaseType">
                            <template v-for="item in dbTypeList">
                            <lay-select-option :value="item.value" :label="item.label" />
                            </template>
                        </lay-select>
                    </lay-form-item>
                    <lay-form-item label="编码类型" prop="codeType">
                        <lay-select v-model="projectInfoSaveDto.codeType">
                            <template v-for="item in codeTypeList">
                            <lay-select-option :value="item.value" :label="item.label" />
                            </template>
                        </lay-select>
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
import { addViewData, saveData } from '@/api/projectInfo/projectInfoApi'
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

let rules5 = ref( {
    projectName: {
        required: true, message: '必填项'
    },
    projectCode: {
        required: true, message: '必填项'
    },
    projectZnName: [
        {
            required: true, message: '必填项'
        }
    ],
    tableTemplateCode: {
        required: true, message: '必填项'
    },
    databaseType: {
        required: true, message: '必填项'
    },
    codeType: {
        required: true, message: '必填项'
    }
} )

const submit5 = function ()
{
    layFormRef11.value.validate( ( isValidate, model, errors ) =>
    {
        if ( isValidate )
        {
            saveData( projectInfoSaveDto ).then( data =>
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
let projectInfoSaveDto = reactive( {
    projectName: '',
    projectCode: '',
    projectZnName: '',
    tableTemplateCode: '',
    databaseType:'',
    codeType:''
} )

let dbTypeList = ref( [] )
let codeTypeList = ref( [] )
let tableTemplateList = ref( [] )


const ajaxViewData = ( id, visible11 ) =>
{
    addViewData( id ).then( data =>
    {
        dbTypeList.value = data.dbTypeList
        codeTypeList.value = data.codeTypeList
        tableTemplateList.value = data.tableTemplateList
        Object.assign( projectInfoSaveDto, data.ProjectInfoSaveDto )
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
