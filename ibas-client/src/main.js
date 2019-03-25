import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import i18n from './lang'
import { mixin } from './config'
import './errorLog'
import './permission'

new Vue({
  router,
  store,
  i18n,
  render: h => h(App),
  mixins: [mixin]
}).$mount('#app')
