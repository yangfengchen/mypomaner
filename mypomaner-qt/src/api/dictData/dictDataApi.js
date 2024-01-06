import request from '@/api/mypomanerRequest'

export function getinitsearch() {
    return request({
        method: 'get',
        url: "/api/dictData/initsearch"
    });
}

export function getListData(data) {
    return request({
        method: 'post',
        url: "/api/dictData/rest",
        data: data
    })
}

export function addViewData(data){
    return request({
        method: 'get',
        url: "/api/dictData/add?dictCode=" + data,
    })
}

export function editViewData(id){
    return request({
        method: 'get',
        url: "/api/dictData/edit/" + id,
    })
}

export function saveData(data){
    return request({
        method: 'post',
        url: "/api/dictData/save",
        data:data
    })
}

export function viewData(id){
    return request({
        method: 'get',
        url: "/api/dictData/view/" + id
    })
}

export function deleteById(id){
    return request({
        method: 'get',
        url: "/api/dictData/deleteById/" + id
    })
}