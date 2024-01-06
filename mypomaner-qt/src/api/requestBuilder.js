import axios from 'axios'

axios.defaults.withCredentials = false

const builder = function (opts) {
    let service = axios.create(Object.assign({
        timeout: 600000
    }, opts));

    service.interceptors.request.use(
        config => {
            if (config.vue) {
                config.vue.loading = true
                config.vue.loadfailed = false;
            }

            config.params = {
                t: new Date().getTime(),
                ...config.params
            }
            //config.headers['token'] = token;
            return config
        },
        error => {
            return Promise.reject(error)
        }
    )

    // response interceptor
    service.interceptors.response.use(
        response => {
            if (response && response.config && response.config.vue) {
                response.config.vue.loading = false;
                response.config.vue.loadfailed = false;
            }
            const res = response.data
            return res
        },
        err => {
            if (err && err.response) {
                switch (err.response.status) {
                    case 400:
                        err.message = '错误请求'
                        break
                    default:
                        break
                }
            }
            if (err && err.config && err.config.vue) {
                err.config.vue.loading = false;
                err.config.vue.loadfailed = true;
            }
            return Promise.reject(err)
        }
    )

    return service;
};

export default builder;