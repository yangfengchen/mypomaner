<template>
    <div class="container">
        <div style="padding: 10px 15px" :style="defaultWrapStyle">
            <lay-row space="10">
                <lay-col md="6" class="defaultLabelCss" :style="defaultLabelStyle">
                    <template v-if="defaultLabelName && defaultLabelName.length > 0">
                        {{ defaultLabelName }}:
                    </template>
                    <slot name="label"></slot>
                </lay-col>
                <lay-col md="18" :style="defaultContextStyle">
                    <slot></slot>
                </lay-col>
            </lay-row>
        </div>
    </div>
</template>
<script setup>
import { reactive, onBeforeMount, onMounted, ref, computed } from 'vue'
import { useRouter, useRoute } from 'vue-router'
onBeforeMount( () =>
{
    //console.log('2.组件挂载页面之前执行----onBeforeMount')
} )
onMounted( () =>
{
    //console.log('3.-组件挂载到页面之后执行-------onMounted')
} )
let props = defineProps( {
    labelName: {
        type: String,
        default: ''
    },
    labelStyle: {
        type: Object,
        default: () => { }
    },
    contextStyle: {
        type: Object,
        default: () => { }
    },
    wrapStyle: {
        type: Object,
        default: () => { }
    }
} )

const defaultLabelName = ref( props.labelName )
const defaultLabelStyle = Object.assign( {}, props.labelStyle )
const defaultContextStyle = Object.assign( {}, props.contextStyle )
const defaultWrapStyle = Object.assign( {}, props.wrapStyle )

// const defaultLabelStyle = computed( () =>
// {

//     return Object.assign( {}, props.labelStyle )
// } )
</script>

<style scoped lang="scss">
.defaultLabelCss {
    text-align: right;
}
</style>
