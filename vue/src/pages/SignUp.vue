<template>
  <div class="All">
  <div class="border"
        :style = "{
          borderRadius:'--el-border-radius-base',
          boxShadow:`--el-box-shadow`
        }" >
    <div class="SignUp">
      <h2>注册</h2>
    <el-form :model="form" label-width="120px" :rules = "rules" ref = "SignForm" >
      <el-form-item label="头像" class="center-label">
        <el-avatar :size="100" src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png" @click = "updateAvatar()"/>
      </el-form-item>
      <el-form-item>
        <el-upload
            v-model:file-list="fileList"
            class="upload-demo"
            action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
            :on-preview="handlePreview"
            :on-remove="handleRemove"
            :before-remove="beforeRemove"
            :limit="3"
            :on-exceed="handleExceed">
          <el-button>点击上传</el-button>
        </el-upload>
      </el-form-item>
      <el-form-item label="昵称" prop="username">
        <el-input v-model="form.username"/>
      </el-form-item>
      <el-form-item label="手机号" prop="phonenumber">
        <el-input v-model="form.phonenumber" placeholder="登陆使用"/>
<!--        <el-select v-model="form.region" placeholder="please select your zone">-->
<!--          <el-option label="Zone one" value="shanghai"/>-->
<!--          <el-option label="Zone two" value="beijing"/>-->
<!--        </el-select>-->
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model = "form.email" placeholder="发送相关资源使用"/>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model = "form.password" type="password"/>
      </el-form-item>
      <el-form-item label="重复输入密码" prop="pwd2">
        <el-input v-model = "form.pwd2" type="password"/>
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
        <el-button type="primary" @click="onSign('SignForm')">创建用户</el-button>
        <el-button @click = "clear()">清空</el-button>
      </el-form-item>
    </el-form>
    </div>
  </div>
  </div>
</template>

<script>
import axios from "axios";
import {getCurrentInstance, ref, toRaw} from "vue";
import login from "@/pages/Login.vue";
export default {
  name: "Sign UP",
  setup(){
    const {proxy,ctx} = getCurrentInstance()
    const _this = ctx

    console.log(_this)
    console.log(proxy)
  },
  data() {
    var pwdPass = (rule, value, callback) =>{
      if (value !== this.form.password){
        callback(new Error('两次输入的密码不同'))
      }
    }
    return {
      form: {
        id:null,
        username: '你好',
        phonenumber:'17614025077',
        email:'530216378@qq.com',
        password: '12345678',
        pwd2: '12345678',
        slogan:''
      },
      rules:{
        username:[
          { required: true, message: '请输入昵称', trigger: 'blur' },
        ],
        phonenumber:[
          { required: true, message: '请输入手机号', trigger: 'blur' },
          { pattern:/^((0\d{2,3}-\d{7,8})|(1[34578]\d{9}))$/, message: '手机号格式出错', trigger: 'blur' },

        ],
        email:[
          { required: true, message: '请输入邮箱', trigger: 'blur' },
          { pattern:/^([a-zA-Z0-9]+[-_\.]?)+@[a-zA-Z0-9]+\.[a-z]+$/, message: '邮箱格式出错', trigger: 'blur' },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          {min: 8,max: 16, message: '密码长度应在8-16个字符', trigger: 'blur'}
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
      console.log('开始校验')
      _this.SignForm.value.validate(valid=>{
        console.log('校验成功',valid)
      })
    },
    sendSubmit(){
      let list = toRaw(this.form)
      axios({
        url:'http://localhost:8080/user/signUp',
        method:'POST',
        data:list
      }).then(result =>{
        if (result){
          console.log(result)
          this.$message.success(result.message)
          setTimeout(()=>{
            this.$router.push({
              url:`/home/login`
            })
          },3000)
        }else {
          this.$message.error(result.message)
          this.clear()
        }
      })
    },
    updateAvatar(){

    },
    clear(){
      let clearForm = {
        username: '',
        phonenmber:'',
        email:'',
        password: '',
        pwd2: '',
        slogan:''
      }
      this.form = clearForm
    },
    pwdPass(){
      if (this.form.pwd1 !== this.form.pwd2){
        return false;
      }else {
        return true;
      }
    },
    handlePreview(){

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
.center-label .el-form-item_label{
  width: 50%;
  line-height: 38px;
}
</style>