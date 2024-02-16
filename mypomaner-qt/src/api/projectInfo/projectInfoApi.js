import request from '@/api/mypomanerRequest'

export function getinitsearch() {
    return request({
        method: 'get',
        url: "/api/projectInfo/initsearch"
    });
}

export function getData(data) {
    return request({
        method: 'post',
        url: "/api/projectInfo/rest",
        data: data
    })
}

export function addViewData(){
    return request({
        method: 'get',
        url: "/api/projectInfo/add",
    })
}

export function editViewData(id){
    return request({
        method: 'get',
        url: "/api/projectInfo/edit/" + id,
    })
}

export function saveData(data){
    return request({
        method: 'post',
        url: "/api/projectInfo/save",
        data:data
    })
}

export function deleteById(id){
    return request({
        method: 'get',
        url: "/api/projectInfo/deleteById/" + id
    })
}

export function viewData(id){
    return request({
        method: 'get',
        url: "/api/projectInfo/view/" + id
    })
}

export function getCodeByProjectFile(projectCode){
    return request({
        method: 'get',
        url: "/api/buildCode/getCodeByProject/" + projectCode
    })
}

