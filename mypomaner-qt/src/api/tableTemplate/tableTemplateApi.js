import request from '@/api/mypomanerRequest'

export function getinitsearch() {
    return request({
        method: 'get',
        url: "/api/tableTemplate/initsearch"
    });
}

export function getData(data) {
    return request({
        method: 'post',
        url: "/api/tableTemplate/rest",
        data: data
    })
}

export function addViewData(){
    return request({
        method: 'get',
        url: "/api/tableTemplate/add",
    })
}

export function editViewData(id){
    return request({
        method: 'get',
        url: "/api/tableTemplate/edit/" + id,
    })
}

export function saveData(data){
    return request({
        method: 'post',
        url: "/api/tableTemplate/save",
        data:data
    })
}

export function deleteById(id){
    return request({
        method: 'get',
        url: "/api/tableTemplate/deleteById/" + id
    })
}