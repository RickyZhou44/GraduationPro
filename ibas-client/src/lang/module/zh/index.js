import { common } from './common'
import { route } from './route'
import { start } from './start'
import { insurancePolicy } from './insurancePolicy'
import { customer } from './customer'
import { rate } from './rate'
import { settlement } from './settlement'
import { claimSettlement } from './claimSettlement'
import { humanCapital } from './humanCapital'

export default {
  navbar: {
    logOut: '退出登录',
    home: '首页'
  },
  tagsView: {
    refresh: '刷新',
    close: '关闭',
    closeOthers: '关闭其它',
    closeAll: '关闭所有'
  },
  home: {
    title: '首页'
  },
  common,
  route,
  start,
  insurancePolicy,
  customer,
  rate,
  settlement,
  claimSettlement,
  humanCapital
}
