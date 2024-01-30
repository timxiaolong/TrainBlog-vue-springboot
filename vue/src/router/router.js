import {createRouter, createWebHashHistory} from 'vue-router'
import HomePage from "@/pages/HomePage.vue";
import Login from "@/pages/Login.vue";
import SignUp from "@/pages/SignUp.vue";
import HomePageBar from "@/pages/HomePageBar.vue";

const router = createRouter({
    history:createWebHashHistory(),
    routes:[
        {
            path:'/',
            redirect:'/home'
        },
        {
            path:'/home',
            name:'HomePageBar',
            component:HomePageBar,
            redirect:'/home/HomePage',
            children:[
                {
                    path:'HomePage',
                    name:'HomePage',
                    component:HomePage
                }
            ]
        },
        {
            path:'/login',
            component:Login,
        },
        {
            path:'/SignUp',
            component:SignUp
        }
    ]
})
export default router