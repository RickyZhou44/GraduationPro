import Vue from 'vue'
import Element from 'element-ui'
import i18n from '@/lang'
import * as filters from '@/filters'
import '@/icons'
import '@/mock'
import '@/assets/style/index.scss'
import 'normalize.css/normalize.css'
import 'animate.css/animate.min.css'
import { clearCookies, isRememberToken } from './shared'
import VueParticles from 'vue-particles'

Vue.use(VueParticles)

Vue.use(Element, {
  size: 'medium', // set element-ui default size
  i18n: (key, value) => i18n.t(key, value)
})

// register global utility filters.
Object.keys(filters).forEach(key => {
  Vue.filter(key, filters[key])
})

Vue.config.productionTip = false

export const mixin = {
  mounted () {
    window.onbeforeunload = (): void => {
      if (isRememberToken() !== 'true') {
        clearCookies()
      }
    }
  }
}
