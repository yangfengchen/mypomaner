import request from '@/api/mypomanerRequest'

export function getinitsearch() {
    return request({
        method: 'get',
        url: "/api/fileTemplate/initsearch"
    });
}

export function getListData(data) {
    return request({
        method: 'post',
        url: "/api/fileTemplate/restList",
        data: data
    })
}

export function saveListData(data) {
    return request({
        method: 'post',
        url: "/api/fileTemplate/saveList",
        data: data
    });
}
