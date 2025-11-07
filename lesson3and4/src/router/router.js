import { createRouter, createWebHistory } from 'vue-router'
// import Home from "@/home.vue";
import MyLayout from "@/MyLayout.vue";

const routes = [
    {
        path: '/',
        name: '',
        component: MyLayout
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router