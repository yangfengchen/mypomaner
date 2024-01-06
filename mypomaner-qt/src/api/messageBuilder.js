import { layer } from '@layui/layui-vue'

const layerSuccess = function(msg, opts){
    layer.msg(msg, Object.assign({},{ icon: 1, time: 1000 }, opts))
}

const layerError = function(msg, opts){
    layer.msg(msg, Object.assign({},{ icon: 2, time: 1000 }, opts))
}

export {
    layerSuccess,
    layerError
}