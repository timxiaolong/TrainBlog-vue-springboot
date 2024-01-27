<script>
export default {
  name: "Login",
  data() {
    return {
      user: {
        account: '',
        password: '',
        verifyCode: '',
      }
    }
  }
}

</script>

<template>
  <div class="login">
    <div class="loginPart">
      <h2>用户登录</h2>
      <el-form
          ref="ruleFormRef"
          :model="user"
          status-icon
          :rules="rules"
          label-width="100px"
          class="demo-ruleForm"
          style="transform:translate(-30px);"
      >
        <el-form-item label="账号：" prop="account">
          <el-input v-model="user.account" placeholder="请输入账号" maxlength="20" clearable />
        </el-form-item>
        <el-form-item label="密码：" prop="password">
          <el-input v-model="user.password" type="password" placeholder="请输入密码" maxlength="20" show-password clearable />
        </el-form-item>
        <el-form-item label="验证码：" prop="verifyCode">
          <el-input style="width: 150px;" v-model="user.verifyCode" placeholder="请输入验证码" maxlength="4" clearable />
<!--          <img class="verifyCodeImg" :src="" @click="">-->
        </el-form-item>
        <el-button class="btn" type="primary"  @click="">登录</el-button>
        <div style="text-align: right;transform:translate(0,30px);">
          <el-link type="warning" @click="">没有账号？去注册</el-link>
        </div>
      </el-form>
    </div>
  </div>
</template>

<style scoped>
.login {
  height: 100%;
  width: 100%;
  overflow: hidden;
}
.login__particles {
  height: 100%;
  width: 100%;
  background-size: cover;
  background-repeat: no-repeat;
  //background-image: url('@/assets/0001.jpg');
  opacity:0.9;
  position:fixed;
  pointer-events: none;
}
.loginPart{
  position:absolute;
  /*定位方式绝对定位absolute*/
  top:50%;
  left:80%;
  /*顶和高同时设置50%实现的是同时水平垂直居中效果*/
  transform:translate(-50%,-50%);
  /*实现块元素百分比下居中*/
  width:450px;
  padding:50px;
  background: rgba(255,184,81,0.44);
  /*背景颜色为黑色，透明度为0.8*/
  box-sizing:border-box;
  /*box-sizing设置盒子模型的解析模式为怪异盒模型，
  将border和padding划归到width范围内*/
  box-shadow: 0px 15px 25px rgba(0,0,0,.5);
  /*边框阴影  水平阴影0 垂直阴影15px 模糊25px 颜色黑色透明度0.5*/
  border-radius:15px;
  /*边框圆角，四个角均为15px*/
}
h2{
  margin:0 0 30px;
  padding:0;
  color: #fff;
  text-align:center;
  /*文字居中*/
}
.btn{
  transform:translate(170px);
  width:80px;
  height:40px;
  font-size:15px;
}
</style>