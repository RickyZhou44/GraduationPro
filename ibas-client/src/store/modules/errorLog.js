const errorLog = {
  state: {
    logs: []
  },
  mutations: {
    ADD_ERROR_LOG: (state: Object, log: string): void => {
      state.logs.push(log)
    }
  },
  actions: {
    addErrorLog ({ commit }: Object, log: string): void {
      commit('ADD_ERROR_LOG', log)
    }
  }
}

export default errorLog
