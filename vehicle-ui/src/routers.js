
import Vehicles from "@/components/Vehicles.vue";
import Polygons from "@/components/Polygons.vue";
import {createRouter, createWebHistory} from "vue-router";

const routes=[
    {
        name:'Vehicles',
        component:Vehicles,
        path:'/'
    },
    {
        name:'Polygons',
        component:Polygons,
        path:'/polygons'
    }
]

const routers = createRouter({
    history: createWebHistory(),
    routes,
});

export default routers;
