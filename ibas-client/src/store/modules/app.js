import Cookies from 'js-cookie'

const app = {
  state: {
    sidebar: {
      opened: Cookies.get('sidebarStatus') ? !!+Cookies.get('sidebarStatus') : true,
      withoutAnimation: false
    },
    device: 'desktop',
    language: Cookies.get('language') || 'zh'
  },
  mutations: {
    TOGGLE_SIDEBAR: (state: Object): void => {
      state.sidebar.opened = !state.sidebar.opened
      state.sidebar.withoutAnimation = false
      if (state.sidebar.opened) {
        Cookies.set('sidebarStatus', 1)
      } else {
        Cookies.set('sidebarStatus', 0)
      }
    },
    CLOSE_SIDEBAR: (state: Object, withoutAnimation: boolean): void => {
      Cookies.set('sidebarStatus', 0)
      state.sidebar.opened = false
      state.sidebar.withoutAnimation = withoutAnimation
    },
    TOGGLE_DEVICE: (state: Object, device: 'desktop' | 'mobile'): void => {
      state.device = device
    },
    SET_LANGUAGE: (state: Object, language: 'en' | 'zh'): void => {
      state.language = language
      Cookies.set('language', language, { expires: 7 })
    }
  },
  actions: {
    toggleSideBar ({ commit }: Object): void {
      commit('TOGGLE_SIDEBAR')
    },
    closeSideBar ({ commit }: Object, { withoutAnimation }: Object): void {
      commit('CLOSE_SIDEBAR', withoutAnimation)
    },
    toggleDevice ({ commit }: Object, device: 'desktop' | 'mobile'): void {
      commit('TOGGLE_DEVICE', device)
    },
    setLanguage ({ commit }: Object, language: 'en' | 'zh'): void {
      commit('SET_LANGUAGE', language)
    }
  }
}

export default app
