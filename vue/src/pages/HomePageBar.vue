<template>
  <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
      :ellipsis="false"
  >
    <el-menu-item index="0">
      <img
          style="width: 200px"
          src="../img/Title.png"
          alt="Element logo"
      />
    </el-menu-item >
    <el-menu-item v-for = "(button,index) in buttons"
                  :index = "index"
    >{{button.section}}</el-menu-item>
    <div class="flex-grow" />
    <el-menu-item>
      <el-input v-model = "input1">
        <template #prepend>
          <el-button :icon = "Search"/>
        </template>
      </el-input>
    </el-menu-item>
    <el-menu-item v-if = "username === null" @click = "toLogin()">登陆</el-menu-item>
    <el-sub-menu v-else>
      <template #title>
        <el-avatar :size = "30"
                   src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"
                   style = "margin-left: 20px"
                   @click = "user()"
        ></el-avatar>
      </template>
      <el-menu-item index="2-1">个人中心</el-menu-item>
      <el-menu-item index="2-2">退出</el-menu-item>
    </el-sub-menu>
  </el-menu>
  <router-view></router-view>


</template>

<script>
import {Search} from "@element-plus/icons-vue";
import axios from "axios";

export default {
  name: "HomePageBar",
  data(){
    return{
      buttons:[],
      activeIndex:'1',
      username : ''
    }
  },
  computed: {
    Search() {
      return Search
    }
  },
  methods:{
    user(){
      this.$message.success('hao')
    },
    getSection(){
      axios({
        url:'http://localhost:8080/mainpage/getSection',
        method:'GET'
      }).then(result =>{
        console.log(result)
        this.buttons = result.data
      })
    },
    toLogin(){
      this.$router.push({
        path:`/login`
      })
    }
  },
  mounted() {
    this.getSection()
    this.username = localStorage.getItem('username')
    console.log(this.username)
  }
}
</script>

<style scoped>
.flex-grow{
  flex-grow: 1;
}
</style>