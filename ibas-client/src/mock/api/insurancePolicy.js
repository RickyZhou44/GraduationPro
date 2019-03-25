import { insurancePolicy, employee } from '../templates'
import { param2Obj, dateInRange } from '@/shared'

export default {

  getList: config => {
    let params = param2Obj(config.url)
    let result = insurancePolicy.data
    const {
      page = 1, limit = 20,
      relateNo, policyNo, holder, holderCode, insured, agent, employee,
      insurer, status, insurance, checkInDate, validDate, period
    } = params

    // search
    if (policyNo) {
      let item = result.find(item => item.policyNo === policyNo)
      if (item) result = [item]
    } else {
      let conditionParams = { relateNo, policyNo, holder, holderCode, insured, agent, employee }
      let condition = {}
      for (let key in conditionParams) {
        if (conditionParams.hasOwnProperty(key)) {
          if (conditionParams[key]) condition[key] = conditionParams[key]
        }
      }
      if (Object.keys(condition).length > 0) {
        result = result.filter(item => {
          for (let key in condition) {
            if (condition.hasOwnProperty(key)) {
              if (item[key] !== condition[key]) return false
            }
          }
          return true
        })
      }
    }

    // filter
    let filterListParams = { insurer, status, insurance }
    let filterList = {}
    let filterRangeParams = { checkInDate, validDate }
    let filterRange = []
    for (let key in filterListParams) {
      if (filterListParams[key]) filterList[key] = filterListParams[key]
    }
    for (let key in filterRangeParams) {
      if (filterRangeParams[key]) filterRange[key] = filterRangeParams[key]
    }
    if (Object.keys(filterList).length > 0) {
      result = result.filter(item => {
        for (let key in filterList) {
          if (filterList.hasOwnProperty(key)) {
            if (!filterList[key].includes(item[key])) return false
          }
        }
        return true
      })
    }
    if (Object.keys(filterRange).length > 0) {
      result = result.filter(item => {
        for (let key in filterRange) {
          if (filterRange.hasOwnProperty(key)) {
            if (!dateInRange(item[key], filterRange[key])) return false
          }
        }
        return true
      })
    }
    if (period) {
      result = result.filter(item => {
        return item['period'] >= period[0] && item['period'] <= period[1]
      })
    }

    // page split
    const pageResult = result.filter((item, index) => index < limit * page && index >= limit * (page - 1))

    return {
      total: result.length,
      items: pageResult
    }
  },

  getFilters: () => {
    return {
      insurers: ['中国人寿', '百年人寿', '地表最强', '木叶第一'],
      statuses: ['预收件', '承保件 ', '失效件'],
      insurances: ['意外险', '医疗险', '生命险', '养老险', '失业险'],
      paymentCategories: ['银行划账', '信用卡', '支票', '现金', '交费方式'],
      paymentMethods: ['年付', '半年付', '季付', '月付'],
      receipts: ['已交', '未交'],
      agentTypes: ['个人件']
    }
  },

  employeeQuery: (config: string): Array => {
    const { query } = param2Obj(config.url)
    return query ? employee.data.filter(item => item.name.toLowerCase().indexOf(query.toLowerCase()) > -1) : employee.data
  }
}
