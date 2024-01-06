import request from '@/api/mypomanerRequest'

export function getinitsearch() {
    return request({
        method: 'get',
        url: "/api/dictType/initsearch"
    });
}

export function getListData(data) {
    return request({
        method: 'post',
        url: "/api/dictType/rest",
        data: data
    })
}

export function addViewData(){
    return request({
        method: 'get',
        url: "/api/dictType/add",
    })
}

export function editViewData(id){
    return request({
        method: 'get',
        url: "/api/dictType/edit/" + id,
    })
}

export function saveData(data){
    return request({
        method: 'post',
        url: "/api/dictType/save",
        data:data
    })
}

export function deleteById(id){
    return request({
        method: 'get',
        url: "/api/dictType/deleteById/" + id
    })
}