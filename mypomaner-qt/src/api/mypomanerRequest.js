import builder from '@/api/requestBuilder'
import { ref } from 'vue';

const ajaxRequest = builder({ baseURL: import.meta.env.VITE_APP_API_URL })

const request = function (opts){
    return new Promise((resolve, reject) => {
        ajaxRequest(opts)
            .then(response => {
                let {status, data} = response;
                if(status == "200"){
                    resolve(data)
                }else{
                    reject(response)
                }
            }, err => {
                loading.value = false
                reject(err)
            })
            .catch((error) => {
                loading.value = false
                reject(error)
            })
    })
}

export default request