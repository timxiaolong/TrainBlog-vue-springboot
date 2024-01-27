import {createRouter, createWebHashHistory} from 'vue-router'
import HomePage from "@/pages/HomePage.vue";
import HomePageContent from "@/pages/HomePageContent.vue";

const router = createRouter({
    history:createWebHashHistory(),
    routes:[
        {
            path:'/',
            component:HomePage,
            redirect:'/Content',
            children:[
                {
                    path:'Content',
                    component:HomePageContent
                }
            ]
        }
    ]
})
export default router