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
    logOut: 'Log Out',
    home: 'Home'
  },
  tagsView: {
    refresh: 'Refresh',
    close: 'Close',
    closeOthers: 'Close Others',
    closeAll: 'Close All'
  },
  home: {
    title: 'Home'
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
