import request from '@/api/mypomanerRequest'

export function getIdByType(type) {
    return request({
        method: 'get',
        url: "/api/idGenerate/getIdByType/" + type
    });
}