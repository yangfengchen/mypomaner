import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import dictDataList from '@/views/dictData/list.vue'
import dictTypeList from '@/views/dictType/list.vue'
import fieldConfigList from '@/views/fieldConfig/list.vue'
import fieldTemplateList from '@/views/fieldTemplate/list.vue'
import tableTemplateList from '@/views/tableTemplate/list.vue'
import projectInfoList from '@/views/projectInfo/list.vue'
import projectTableList from '@/views/projectTable/list.vue'
import projectTableAdd from '@/views/projectTable/add.vue'
import projectTableEdit from '@/views/projectTable/edit.vue'


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
      path: '/fieldTemplateList',
      name: 'fieldTemplateList',
      component: fieldTemplateList
    },
    {
      path: '/tableTemplateList',
      name: 'tableTemplateList',
      component: tableTemplateList
    },
    {
      path: '/projectInfoList',
      name: 'projectInfoList',
      component: projectInfoList
    },
    {
      path: '/projectTableList',
      name: 'projectTableList',
      component: projectTableList
    },
    {
      path: '/projectTableAdd',
      name: 'projectTableAdd',
      component: projectTableAdd
    },
    {
      path: '/projectTableEdit',
      name: 'projectTableEdit',
      component: projectTableEdit
    }
    
  ]
})

export default router
