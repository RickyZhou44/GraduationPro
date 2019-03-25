import Mock from 'mockjs'
import { start, insurancePolicy } from './api'

// https://github.com/nuysoft/Mock/issues/300
Mock.XHR.prototype.proxy_send = Mock.XHR.prototype.send
Mock.XHR.prototype.send = function () {
  if (this.custom.xhr) {
    this.custom.xhr.withCredentials = this.withCredentials || false
  }
  this.proxy_send(...arguments)
}

// sign in
Mock.mock(/\/api\/signin/, 'post', start.signInByUsername)
Mock.mock(/\/api\/signout/, 'post', start.logout)
Mock.mock(/\/user\/info\.*/, 'get', start.getUserInfo)

// sign up
Mock.mock(/\/api\/getcode/, 'get', start.getValidateCode())

// insurancePolicy
Mock.mock(/\/insurance\/list/, 'get', insurancePolicy.getList)
Mock.mock(/\/insurance\/filters/, 'get', insurancePolicy.getFilters)
Mock.mock(/\/insurance\/queryemployee/, 'get', insurancePolicy.employeeQuery)

export default Mock
