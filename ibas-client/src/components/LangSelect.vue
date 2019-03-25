<template>
  <el-dropdown trigger='hover' class='international' @command="handleSetLanguage" @visible-change="visible => { $emit('visible-change',visible) }">
    <div>
      <span>{{ language.toUpperCase() }}</span>
    </div>
    <el-dropdown-menu slot="dropdown">
      <el-dropdown-item :disabled="language==='zh'" command='zh'>中文</el-dropdown-item>
      <el-dropdown-item :disabled="language==='en'" command='en'>English</el-dropdown-item>
    </el-dropdown-menu>
  </el-dropdown>
</template>

<script>
  export default {
    props: {
      alert: {
        type: Boolean,
        required: false,
        default () {
          return false
        }
      }
    },
    computed: {
      language () {
        return this.$store.getters.language
      }
    },
    methods: {
      handleSetLanguage (lang: string): void {
        this.$i18n.locale = lang
        this.$store.dispatch('setLanguage', lang)
        this.alert && this.$message({
          message: 'Switch Language Success',
          type: 'success'
        })
      }
    }
  }
</script>

<style scoped>
  *,*:focus{
    outline: none;
  }
</style>
