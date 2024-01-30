<template>
  <div class="All">
  <div class="border"
        :style = "{
          borderRadius:'--el-border-radius-base',
          boxShadow:`--el-box-shadow`
        }" >
    <div class="SignUp">
      <h2>注册</h2>
    <el-form :model="form" label-width="120px" :rules = "rules" ref = "SignForm">
      <el-form-item label="昵称" prop="name">
        <el-input v-model="form.name"/>
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input v-model="form.phone" placeholder="登陆使用"/>
<!--        <el-select v-model="form.region" placeholder="please select your zone">-->
<!--          <el-option label="Zone one" value="shanghai"/>-->
<!--          <el-option label="Zone two" value="beijing"/>-->
<!--        </el-select>-->
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model = "form.email" placeholder="发送相关资源使用"/>
      </el-form-item>
      <el-form-item label="密码" prop="pwd1">
        <el-input v-model = "form.pwd1" property="required"/>
      </el-form-item>
      <el-form-item label="重复输入密码" prop="pwd2">
        <el-input v-model = "form.pwd2"/>
      </el-form-item>

<!--      <el-form-item label="Activity time">-->
<!--        <el-col :span="11">-->
<!--          <el-date-picker-->
<!--              v-model="form.date1"-->
<!--              type="date"-->
<!--              placeholder="Pick a date"-->
<!--              style="width: 100%"-->
<!--          />-->
<!--        </el-col>-->
<!--        <el-col :span="2" class="text-center">-->
<!--          <span class="text-gray-500">-</span>-->
<!--        </el-col>-->
<!--        <el-col :span="11">-->
<!--          <el-time-picker-->
<!--              v-model="form.date2"-->
<!--              placeholder="Pick a time"-->
<!--              style="width: 100%"-->
<!--          />-->
<!--        </el-col>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="Instant delivery">-->
<!--        <el-switch v-model="form.delivery"/>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="Activity type">-->
<!--        <el-checkbox-group v-model="form.type">-->
<!--          <el-checkbox label="Online activities" name="type"/>-->
<!--          <el-checkbox label="Promotion activities" name="type"/>-->
<!--          <el-checkbox label="Offline activities" name="type"/>-->
<!--          <el-checkbox label="Simple brand exposure" name="type"/>-->
<!--        </el-checkbox-group>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="Resources">-->
<!--        <el-radio-group v-model="form.resource">-->
<!--          <el-radio label="Sponsor"/>-->
<!--          <el-radio label="Venue"/>-->
<!--        </el-radio-group>-->
<!--      </el-form-item>-->
      <el-form-item label="签名">
        <el-input v-model="form.slogan" type="textarea"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit()">创建用户</el-button>
        <el-button @click = "clear()">清空</el-button>
      </el-form-item>
    </el-form>
    </div>
  </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Sign UP",
  data() {
    var pwdPass = (rule, value, callback) =>{
      if (value !== this.form.pwd1){
        callback(new Error('两次输入的密码不同'))
      }
    }
    return {
      form: {
        name: '',
        phone:'',
        email:'',
        pwd1: '',
        pwd2: '',
        slogan:''
      },
      rules:{
        name:[
          { required: true, message: '请输入昵称', trigger: 'blur' },
          { min: 3, max: 5, message: 'Length should be 3 to 5', trigger: 'blur' },
        ],
        phone:[
          { required: true, message: '请输入手机号', trigger: 'blur' },
          { pattern:/^((0\d{2,3}-\d{7,8})|(1[34578]\d{9}))$/, message: '手机号格式出错', trigger: 'blur' },
        ],
        email:[
          { required: true, message: '请输入邮箱', trigger: 'blur' },
          { pattern:/^([a-zA-Z0-9]+[-_\.]?)+@[a-zA-Z0-9]+\.[a-z]+$/, message: '邮箱格式出错', trigger: 'blur' },
        ],
        pwd1: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],
        pwd2: [
          { required: true, message: '请再输入一次', trigger: 'blur' },
          {validator:pwdPass,trigger: 'blur'}
        ]
      }
    }
  },
  methods:{
    onSubmit(){
      this.$refs.SignForm.validate((valid)=>{
        if (!valid){
          this.$message.error('请检查输入项')
        }else {
          axios({
            url:'',
            method:'POST',
            data:{
            }
          }).then(result =>{
            console.log(result)
          })
        }
      })
    },
    clear(){
      let clearForm = {
        name: '',
        phone:'',
        email:'',
        pwd1: '',
        pwd2: '',
        slogan:''
      }
      this.form = clearForm
    },
    pwdPass(){

    }
  }
}
</script>

<style scoped>
.All{
  min-height: 800px;
  display: flex;
  justify-content: center;
  align-items: center;

}
.SignUp {
  margin: 90px;
}
.border{
  width: 800px;
  border: 1px solid var(--el-border-color);
  border-radius: 0;
}
</style>