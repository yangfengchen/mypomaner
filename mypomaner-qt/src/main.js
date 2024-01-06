import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import Layui from '@layui/layui-vue'
import '@layui/layui-vue/lib/index.css'


import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(Layui)

app.mount('#app')
