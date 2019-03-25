<template>
  <div class="navbar">
    <hamburger :toggle-click="toggleSideBar" :is-active="sidebar.opened" class="hamburger-container"></hamburger>

    <breadcrumb class="breadcrumb-container"></breadcrumb>

    <div class="right-menu">
      <template v-if="device!=='mobile'">
        <error-log class="errLog-container right-menu-item"></error-log>

        <lang-select class="international right-menu-item" :class="{ 'right-menu-item-active':langVisible }" @visible-change="visible => langVisible = visible"></lang-select>

        <screenfull class="international right-menu-item"></screenfull>

      </template>

      <el-dropdown class="avatar-container right-menu-item" :class="{ 'right-menu-item-active':avatarVisible }" trigger="hover" @visible-change="visible => avatarVisible = visible">
        <div class="avatar-wrapper">
          <a class="avatar-tab">
            <img alt="" :src="avatar+'?imageView2/1/w/80/h/80'" class="user-avatar"/>
            <span class="user-name">{{ $store.getters.name }}</span>
          </a>
        </div>
        <el-dropdown-menu slot="dropdown">
          <router-link to="/">
            <el-dropdown-item>
              {{ $t('navbar.home') }}
            </el-dropdown-item>
          </router-link>
          <el-dropdown-item divided>
            <span style="display:block;" @click="logout">{{ $t('navbar.logOut') }}</span>
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<style rel="stylesheet/scss" lang="scss" scoped>
  *,*:focus{
    outline: none;
  }
  .navbar {
    height: 50px;
    line-height: 50px;
    border-radius: 0 !important;
    .hamburger-container {
      line-height: 58px;
      height: 50px;
      float: left;
      padding: 0 10px;
    }
    .breadcrumb-container{
      float: left;
    }
    .errLog-container {
      display: inline-block;
      vertical-align: top;
    }
    .right-menu {
      float: right;
      height: 100%;
      .right-menu-item-active {
        transition: .3s;
        background-color: $--color-light-black-bg;
      }
      .right-menu-item {
        transition: .3s;
        display: inline-block;
        padding: 0 8px;
        cursor: pointer;
        &:hover,&:active{
          background-color: $--color-light-black-bg;
        }
        &:hover,&:active,&:focus{
          outline: none;
        }
      }
      .international{
        vertical-align: top;
      }
      .theme-switch {
        vertical-align: 15px;
      }
      .avatar-container {
        height: 50px;
        .avatar-wrapper {
          position: relative;
          .avatar-tab{
            padding: 0 10px;
            .user-name{
              padding-left: 10px;
            }
            .user-avatar {
              margin-top: -3px;
              vertical-align: middle;
              width: 25px;
              height: 25px;
              border-radius: 50%;
            }
          }
        }
      }
    }
  }
</style>

<script>

  import { mapGetters } from 'vuex'
  import {
    Breadcrumb,
    Hamburger,
    ErrorLog,
    Screenfull,
    LangSelect
  } from '@/components'

  export default {
    data () {
      return {
        langVisible: false,
        avatarVisible: false
      }
    },
    components: {
      Breadcrumb,
      Hamburger,
      ErrorLog,
      Screenfull,
      LangSelect
    },
    computed: {
      ...mapGetters([
        'sidebar',
        'name',
        'avatar',
        'device'
      ])
    },
    methods: {
      toggleSideBar (): void {
        this.$store.dispatch('toggleSideBar')
      },
      logout (): void {
        this.$store.dispatch('LogOut').then(() => {
          location.reload()// In order to re-instantiate the vue-router object to avoid bugs
        })
      }
    }
  }

</script>
