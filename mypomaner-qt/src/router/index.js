import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import dictDataList from '@/views/dictData/list.vue'
import dictTypeList from '@/views/dictType/list.vue'
import fieldConfigList from '@/views/fieldConfig/list.vue'
import fileTemplateList from '@/views/fileTemplate/list.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/dictDataList',
      name: 'disctDataList',
      component: dictDataList
    },
    {
      path: '/dictTypeList',
      name: 'disctTypeList',
      component: dictTypeList
    },
    {
      path: '/dictTypeList',
      name: 'disctTypeList',
      component: dictTypeList
    },
    {
      path: '/fieldConfigList',
      name: 'fieldConfigList',
      component: fieldConfigList
    },
    {
      path: '/fileTemplateList',
      name: 'fileTemplateList',
      component: fileTemplateList
    }
  ]
})

export default router
