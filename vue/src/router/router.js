import {createRouter, createWebHashHistory} from 'vue-router'
import HomePage from "@/pages/HomePage.vue";
import HomePageContent from "@/pages/HomePageContent.vue";
import Login from "@/pages/Login.vue";
import SignUp from "@/pages/SignUp.vue";

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
        },
        {
            path:'/login',
            component:Login
        },
        {
            path:'/SignUp',
            component:SignUp
        }
    ]
})
export default router