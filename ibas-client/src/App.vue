<template>
  <div id="app">
    <transition
      enter-active-class="animated fadeIn"
      leave-to-class="animated fadeOut"
      mode="out-in">
      <router-view></router-view>
    </transition>
  </div>
</template>

<script>
  export default {
    name: 'app'
  }
</script>

<style lang="scss">
  /**
   * global style
   */
  *{
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
    margin: 0;
    padding: 0;
  }

  a{
    text-decoration:none;
    outline: none;

    &:link{
      color: $--color-primary !important;
    }
  }

</style>
