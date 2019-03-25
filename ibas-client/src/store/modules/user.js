import { getUserInfo, logout, signInByUsername } from '../../api'
import { getToken, clearCookies, setToken } from '@/shared'

const user = {
  state: {
    user: '',
    status: '',
    code: '',
    token: getToken(),
    name: '',
    avatar: '',
    introduction: '',
    roles: [],
    setting: {
      articlePlatform: []
    }
  },

  mutations: {
    SET_CODE: (state: Object, code: string): void => {
      state.code = code
    },
    SET_TOKEN: (state: Object, token: string): void => {
      state.token = token
    },
    SET_INTRODUCTION: (state: Object, introduction: string): void => {
      state.introduction = introduction
    },
    SET_SETTING: (state: Object, setting: Object): void => {
      state.setting = setting
    },
    SET_STATUS: (state: Object, status: string): void => {
      state.status = status
    },
    SET_NAME: (state: Object, name: string): void => {
      state.name = name
    },
    SET_AVATAR: (state: Object, avatar: string): void => {
      state.avatar = avatar
    },
    SET_ROLES: (state: Object, roles: Array<string>) => {
      state.roles = roles
    }
  },

  actions: {

    SignInByUsername ({ commit }: Object, userInfo: Object): Object {
      const userIdentifier = userInfo.userIdentifier.trim()
      return new Promise((resolve, reject) => {
        signInByUsername(userIdentifier, userInfo.userPassword).then(response => {
          const data = response
          commit('SET_TOKEN', data.token)
          setToken(data.token)
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    GetUserInfo ({ commit, state }: Object): Object {
      return new Promise((resolve, reject) => {
        getUserInfo(state.token).then(response => {
          if (!response) {
            reject(new Error('Verification failed, please login again.'))
          }
          const data = response

          if (data.roles && data.roles.length > 0) { // 验证返回的roles是否是一个非空数组
            commit('SET_ROLES', data.roles)
          } else {
            reject(new Error('getInfo: roles must be a non-null array!'))
          }

          commit('SET_NAME', data.name)
          commit('SET_AVATAR', data.avatar)
          commit('SET_INTRODUCTION', data.introduction)
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 第三方验证登录
    // LoginByThirdparty({ commit, state }, code) {
    //   return new Promise((resolve, reject) => {
    //     commit('SET_CODE', code)
    //     loginByThirdparty(state.status, state.email, state.code).then(response => {
    //       commit('SET_TOKEN', response.data.token)
    //       setToken(response.data.token)
    //       resolve()
    //     }).catch(error => {
    //       reject(error)
    //     })
    //   })
    // },

    LogOut ({ commit, state }: Object): Object {
      return new Promise((resolve, reject) => {
        logout(state.token).then(() => {
          commit('SET_TOKEN', '')
          commit('SET_ROLES', [])
          clearCookies()
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 前端 登出
    FedLogOut ({ commit }: Object): Object {
      return new Promise(resolve => {
        commit('SET_TOKEN', '')
        clearCookies()
        resolve()
      })
    },

    // 动态修改权限
    ChangeRoles ({ commit, dispatch }: Object, role: string): Object {
      return new Promise(resolve => {
        commit('SET_TOKEN', role)
        setToken(role)
        getUserInfo(role).then(response => {
          const data = response.data
          commit('SET_ROLES', data.roles)
          commit('SET_NAME', data.name)
          commit('SET_AVATAR', data.avatar)
          commit('SET_INTRODUCTION', data.introduction)
          dispatch('GenerateRoutes', data) // 动态修改权限后 重绘侧边菜单
          resolve()
        })
      })
    }
  }
}

export default user
