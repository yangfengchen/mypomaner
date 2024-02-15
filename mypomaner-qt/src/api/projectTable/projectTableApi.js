import request from '@/api/mypomanerRequest'

export function getinitsearch() {
    return request({
        method: 'get',
        url: "/api/projectTable/initsearch"
    });
}

export function getData(data) {
    return request({
        method: 'post',
        url: "/api/projectTable/rest",
        data: data
    })
}

export function addViewData(projectCode){
    return request({
        method: 'get',
        url: "/api/projectTable/add/" + projectCode,
    })
}

export function editViewData(id){
    return request({
        method: 'get',
        url: "/api/projectTable/edit/" + id,
    })
}

export function saveData(data){
    return request({
        method: 'post',
        url: "/api/projectTable/save",
        data:data
    })
}

export function deleteById(id){
    return request({
        method: 'get',
        url: "/api/projectTable/deleteById/" + id
    })
}

export function viewData(id){
    return request({
        method: 'get',
        url: "/api/projectTable/view/" + id
    })
}

