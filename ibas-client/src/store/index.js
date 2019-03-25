import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'
import app from './modules/app'
import tagsView from './modules/tagsViews'
import errorLog from './modules/errorLog'
import permission from './modules/permission'
import user from './modules/user'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    app,
    user,
    tagsView,
    errorLog,
    permission
  },
  getters
})

export default store
