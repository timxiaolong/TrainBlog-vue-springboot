<script>
import {Search} from "@element-plus/icons-vue";
import axios from "axios"

export default {
  name: "HomePage",
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

<template>
<!--  <div class="main">-->
<!--    <div class="main-layout">-->
<!--      <el-header class="header">-->
<!--        <div class="left-position">-->
<!--          <div class="image">-->
<!--            <img src="../img/Title.png">-->
<!--          </div>-->
<!--          <div >-->
<!--            <el-button-->
<!--                v-for = "(item,index) in buttons"-->
<!--                class="button"-->
<!--                :key = "item.section"-->
<!--                :type="item.type"-->
<!--                link>{{item.section}}-->
<!--            </el-button>-->
<!--          </div>-->
<!--        </div>-->
<!--        <div class="right-position">-->
<!--          <div>-->
<!--        <el-input style="width: 250px;">-->
<!--          <template #prepend>-->
<!--            <el-button :icon = "Search"></el-button>-->
<!--          </template>-->
<!--        </el-input>-->
<!--          </div>-->
<!--          <div>-->
<!--            <el-avatar :size = "30"-->
<!--                       src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"-->
<!--                       style = "margin-left: 20px"-->
<!--                       @click = "user()"-->
<!--                       ></el-avatar>-->
<!--            <el-avatar-->
<!--                :size = "30"-->
<!--                src = ""-->
<!--                style = "margin-top: 20px";-->
<!--                v-else-->
<!--            ></el-avatar>-->
<!--          </div>-->
<!--        </div>-->
<!--      </el-header>-->
<!--    </div>-->
<!--  </div>-->

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
</template>

<style scoped>
.main {
  background-color: #f3f4f7;
}

.main-layout {
  .header {
    width: 100%;
    background-color: white;
    height: 45px;
    user-select: none;
    z-index: 10000;
    position: absolute;
    //color: #fff171;
    left: 0;
    top: 0;
    display: flex;
    .image {
      height: 45px;
      width: 200px;
      position: relative;
      img {
        max-width: 100%;
      }
    }
    .button {
      margin-top: 15px;
    }
    .right-position{
      display: flex;
      width: 30%;
      align-self: flex-end;
    }
    .left-position{
      width: 70%;
      display: flex;
    }
  }
}
.flex-grow{
  flex-grow: 1;
}
</style>