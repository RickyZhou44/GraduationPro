<template>
  <div id="start">
    <div class="s-container">
      <el-container>
        <el-header>
          <el-row type="flex" align="middle">
            <el-col :span="12">
              <div class="header-title">IBAS</div>
            </el-col>
            <el-col :span="12">
              <div class="right-menu">
                <el-button size="small" type="text"  @click="signInForm.show = true">{{ $t('start.signIn' ) }}</el-button>
                <el-button size="small" type="primary" round @click="signUpForm.show = true">{{ $t('start.signUpQuick') }}</el-button>
              </div>
            </el-col>
          </el-row>
        </el-header>
        <el-main>
          <div class="start-container">
            <div class="start-title">
              <div class="logo-container">
                <svg-icon class-name="logo" icon-class="logo"></svg-icon>
              </div>
              <div class="main">{{ $t('start.mainTitle') }}</div>
            </div>
          </div>
        </el-main>
        <el-footer>
          <p>Copyright © 2019 IBAS</p>
          <div class="lang-select" :class="{ 'lang-select-active': langVisible }">
            <lang-select :alert="false" @visible-change="visible => langVisible = visible"></lang-select>
          </div>
        </el-footer>
      </el-container>

      <el-dialog :title="$t('start.signIn')"
                 :visible.sync="signInForm.show"
                 width="345px"
                 id="signInForm">
        <el-form size="medium" :model="signInForm" ref="signInForm" :rules="rules">
          <el-form-item prop="userIdentifier">
            <el-input type="text" :placeholder="$t('start.userIdentifier')" v-model="signInForm.userIdentifier" maxlength="24" clearable>
              <svg-icon slot="prefix" class-name="prefix-icon" icon-class="user"></svg-icon>
            </el-input>
          </el-form-item>
          <el-form-item prop="userPassword">
            <el-input type="password" :placeholder="$t('start.userPassword')" v-model="signInForm.userPassword" maxlength="16" clearable>
              <svg-icon slot="prefix" class-name="prefix-icon" icon-class="lock"></svg-icon>
            </el-input>
          </el-form-item>
          <el-form-item>
            <el-checkbox v-model="signInForm.rememberMe">{{$t('start.rememberMe')}}</el-checkbox>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" :loading="signInForm.loading" @click="signIn">{{ $t('start.signIn') }}</el-button>
          </el-form-item>
          <el-form-item>
            <a href="#">{{ $t('start.forgotPassword') }}</a>
          </el-form-item>
        </el-form>
      </el-dialog>

      <el-dialog :title="$t('start.signUp')"
                 :visible.sync="signUpForm.show"
                 width="345px"
                 id="signUpForm">
        <el-form size="medium" :model="signUpForm" ref="signUpForm" :rules="rules">
          <el-form-item prop="userName">
            <el-input type="text" :placeholder="$t('start.userName')" v-model="signUpForm.userName" maxlength="8" clearable>
              <svg-icon slot="prefix" class-name="prefix-icon" icon-class="user"></svg-icon>
            </el-input>
          </el-form-item>
          <el-form-item prop="userEmail">
            <el-input type="email" :placeholder="$t('start.userEmail')" v-model="signUpForm.userEmail" maxlength="24" clearable>
              <svg-icon slot="prefix" class="prefix-icon" icon-class="at-sign"></svg-icon>
            </el-input>
          </el-form-item>
          <el-form-item prop="userPassword">
            <el-input type="password" :placeholder="$t('start.userPassword')" v-model="signUpForm.userPassword" maxlength="16" clearable>
              <svg-icon slot="prefix" class="prefix-icon" icon-class="lock"></svg-icon>
            </el-input>
          </el-form-item>
          <el-form-item prop="validateCode">
            <el-input type="text" :placeholder="$t('start.validateCode')" v-model.number="signUpForm.validate.code" maxlength="6" :disabled="!signUpForm.validate.isConfirmed">
              <svg-icon slot="prefix" class="prefix-icon" icon-class="code"></svg-icon>
              <span slot="suffix">
              <el-button v-if="!signUpForm.validate.confirm" @click.stop="getValidateCode" type="text" :disabled="signUpForm.validate.confirm">{{ $t('start.getValidateCode')}}</el-button>
              <span v-else>{{signUpForm.validate.loadTime}}s</span>
            </span>
            </el-input>
          </el-form-item>
          <el-form-item prop="agree">
            <el-checkbox v-model="signUpForm.agree">{{ $t('start.agree') }}<a href="#">《{{ $t('start.userRegistrationProtocol') }}》</a></el-checkbox>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" :loading="signUpForm.loading" @click="signUp">{{ $t('start.signUp') }}</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </div>

    <div id="particles">
      <vue-particles
        color="#dedede"
        :particleOpacity="0.7"
        :particlesNumber="80"
        shapeType="circle"
        :particleSize="4"
        linesColor="#dedede"
        :linesWidth="1"
        :lineLinked="true"
        :lineOpacity="0.4"
        :linesDistance="150"
        :moveSpeed="3"
        :hoverEffect="true"
        hoverMode="grab"
        :clickEffect="true"
        clickMode="push"
      >
      </vue-particles>
    </div>
  </div>
</template>

<style lang="scss" scoped>

  .s-container{
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    z-index: auto;
  }

  #particles{
    position: absolute;
    overflow: hidden;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    z-index: -1;

    #particles-js{
      height: 100%;
      width: 100%;
      background-size: cover;
    }
  }

  .prefix-icon{
    font-size: 16px;
    cursor: pointer;
    vertical-align: -3px!important;
    margin-left: 4px;
  }

  .el-container:first-child{
    height: 100%;

    .el-header{
      line-height: 60px;

      .header-title{
        float: left;
        color: $--color-primary-black;
        font-size: 20px;
        font-weight: bolder;
        padding: 0 10px;
      }

      .right-menu{
        float: right;

        .el-button + .el-button {
          margin-left: 20px;
        }
      }
    }

    .el-main{
      padding: 0;
      display: flex;
      flex-direction: column;
      color: white;

      .start-container{
        display: flex;
        flex-direction: column;
        flex: auto;
      }

      .start-title{
        padding-bottom: 80px;
        display: flex;
        flex-direction: column;
        flex: auto;
        align-items: center;
        justify-content: center;

        .main{
          margin-top: 40px;
          color: $--color-primary-black;
          font-size: 24px;
        }

        .logo-container{
          padding: 20px;
          background-color: $--color-primary;
          border-radius: 50%;
          margin-top: 50px;
          cursor: pointer;
          transition: .8s;
          box-shadow: 0 1px 50px $--color-primary-light;
          &:hover{
            animation: bounce 1.5s ease-in-out;
          }
          .logo{
            font-size: 60px;
          }
        }
      }
    }

    .el-footer{
      line-height: 60px;
      text-align: center;
      font-size: 14px;
      color: $--color-light-black;
      position: relative;

      &:before {
        content: '';
        position: absolute;
        background-color: $--color-primary-black;
        height: 4px;
        width: 40px;
        border-radius: 1px;
        top: 0;
        left: 0;
        right: 0;
        margin: 0 auto;
      }

      .lang-select-active {
        background-color: $--color-light-black-bg;
      }
      .lang-select {
        padding:0 20px;
        position: absolute;
        top: 0;
        left: 0;
        cursor: pointer;
        margin-right: 20px;
        &:hover, &:active{
          background-color: $--color-light-black-bg;
        }
      }
    }
  }

  .el-dialog{

    .el-button{
      width: 100%;
    }

    .el-form-item{

      &:nth-last-child(2), &:nth-last-child(3){
        margin-bottom: 10px;
      }

      &:last-child{
        margin-bottom: 0;
      }
    }
  }

  #signInForm{

    .el-form-item:nth-child(2){
      margin-bottom: 10px;
    }
  }

  #signUpForm{

    .el-form-item:nth-last-child(2){
      margin-bottom: 22px;
    }
  }
</style>

<script>
  import { LangSelect } from '@/components'
  import { rememberToken } from '@/shared'
  import { getCode, validateCode, validateUserName } from '@/api'

  export default {

    name: 'start',

    components: {
      LangSelect
    },

    data () {
      // eslint-disable-next-line
      const agreeValidator = (rule: Array<validateRule>, value: number, callback: Function) => {
        if (!this.signUpForm.agree) {
          callback(new Error(this.$t('start.agreeProtocol')))
        }
      }

      // eslint-disable-next-line
      const codeValidator = (rule: Array<validateRule>, value: number, callback: Function) => {
        let code = this.signUpForm.validate.code
        if (code === '') {
          callback(new Error(this.$t('start.validateCodeNull')))
        } else {
          validateCode(this.signUpForm.userEmail, code)
            .then(() => {
              callback()
            }, reject => {
              callback(new Error(reject))
            })
            .catch(error => {
              this.$message({
                message: error.message,
                type: 'error',
                duration: 5 * 1000
              })
              callback(new Error('error'))
            })
        }
      }

      // eslint-disable-next-line
      const userNameValidator = (rule: Array<validateRule>, value: number, callback: Function) => {
        let name = this.signUpForm.userName
        if (name === '') {
          callback(new Error(this.$t('start.userNameRequired')))
        } else if (!/^([_a-zA-Z\d]|[-]){1,8}$/.test(name)) {
          callback(new Error('start.userNamePattern'))
        } else {
          validateUserName(name)
            .then(() => {
              callback()
            }, reject => {
              callback(new Error(reject))
            })
            .catch(error => {
              this.$message({
                message: error.message,
                type: 'error',
                duration: 5 * 1000
              })
              callback(new Error('error'))
            })
        }
      }

      return {
        signInForm: {
          userIdentifier: '',
          userPassword: '',
          rememberMe: false,
          loading: false,
          show: false
        },
        signUpForm: {
          userName: '',
          userEmail: '',
          userPassword: '',
          validate: {
            code: '',
            confirm: false,
            isConfirmed: false,
            loadTime: 30
          },
          agree: false,
          loading: false,
          show: false
        },
        rules: {
          userIdentifier: [
            { required: true, message: this.$t('start.userIdentifierRequired'), trigger: 'blur' }
          ],
          userPassword: [
            { required: true, message: this.$t('start.userPasswordRequired'), trigger: 'blur' },
            { min: 6, max: 16, message: this.$t('start.userPasswordLength'), trigger: 'blur' },
            {
              pattern: /^(?=.*[A-Z])(?=.*[A-Z])(?=.*\d)[_A-Za-z\d]{6,16}$/,
              message: this.$t('start.userPasswordPattern'),
              trigger: 'blur'
            }
          ],
          userName: [
            { userNameValidator, trigger: 'blur' }
          ],
          userEmail: [
            { required: true, message: this.$t('start.userEmailRequired'), trigger: 'blur' },
            { type: 'email', message: this.$t('start.userEmailPattern'), trigger: 'blur' }
          ],
          validateCode: [
            { codeValidator, trigger: 'blur' }
          ],
          agree: [
            { agreeValidator, trigger: 'blur' }
          ]
        },
        redirect: undefined,
        langVisible: false
      }
    },

    methods: {

      getValidateCode () {
        let that = this
        that.signUpForm.validate.confirm = true
        that.signUpForm.validate.isConfirmed = true
        getCode(this.signUpForm.userEmail)
          .catch(error => {
            this.$message({
              message: error.message,
              type: 'error',
              duration: 5 * 1000
            })
          })
        let interval = setInterval(() => {
          if (that.signUpForm.validate.loadTime > 0) {
            that.signUpForm.validate.loadTime--
          } else {
            that.signUpForm.validate.confirm = false
            that.signUpForm.validate.loadTime = 30
            clearInterval(interval)
            interval = null
          }
        }, 1000)
      },
      signIn () {
        this.$refs.signInForm.validate((valid) => {
          if (valid) {
            this.signInForm.loading = true
            let that = this
            this.$store.dispatch('SignInByUsername', this.signInForm).then(() => {
              that.signInForm.loading = false
              that.signInForm.show = false
              that.signInForm.rememberMe && rememberToken()
              that.$router.push({ path: that.redirect || '/' })
            }).catch(() => {
              that.signInForm.loading = false
            })
          } else {
            console.log('error submit!!')
            return false
          }
        })
      },
      signUp () {
        this.$refs.signUpForm.validate((valid) => {
          if (!valid) {
            return false
          }
        })
      }
    }
  }

</script>
