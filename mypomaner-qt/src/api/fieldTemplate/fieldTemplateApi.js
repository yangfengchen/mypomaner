import request from '@/api/mypomanerRequest'

export function getinitsearch() {
    return request({
        method: 'get',
        url: "/api/fieldTemplate/initsearch"
    });
}

export function getListData(data) {
    return request({
        method: 'post',
        url: "/api/fieldTemplate/restList",
        data: data
    })
}

export function saveListData(data) {
    return request({
        method: 'post',
        url: "/api/fieldTemplate/saveList",
        data: data
    });
}
