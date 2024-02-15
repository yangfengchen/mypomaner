import request from '@/api/mypomanerRequest'

export function getinitsearch() {
    return request({
        method: 'get',
        url: "/api/fieldConfig/initsearch"
    });
}

export function getListData(data) {
    return request({
        method: 'post',
        url: "/api/fieldConfig/restList",
        data: data
    })
}

export function saveListData(data) {
    return request({
        method: 'post',
        url: "/api/fieldConfig/saveList",
        data: data
    });
}

