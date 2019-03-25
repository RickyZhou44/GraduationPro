/* @flow */
import qs from 'qs'

/**
 * debounce
 * delay: 500ms
 * immediate: true
 * @return {Function}
 * @param fun
 * @param delay
 * @param immediate
 */
export function debounce (fun: function, delay?: number, immediate?: boolean): function {
  let timer = null
  let delayTime = delay || 500
  let immediateFun = immediate || true

  return function (...args) {
    let self = this

    timer && clearTimeout(timer)

    if (immediateFun && !timer) {
      timer = setTimeout(() => {
        timer = null
      }, delayTime)
      fun.apply(self, args)
    } else {
      timer = setTimeout(() => {
        fun.apply(self, args)
      }, delayTime)
    }
  }
}

/**
 * throttle
 * @return {Function}
 * @param fun
 * @param delay
 */
export function throttle (fun: function, delay: number): Function {
  let timer = null

  return function () {
    let args = arguments
    let self = this

    if (!timer) {
      timer = setTimeout(() => {
        fun.apply(self, args)
        timer = null
      }, delay)
    }
  }
}

/**
 * parse time
 * @param time
 * @param cFormat
 * @return {*}
 */
export function parseTime (time: Object | string, cFormat?: string): Function {
  if (arguments.length === 0) {
    return null
  }
  const format = cFormat || '{y}-{m}-{d} {h}:{i}:{s}'
  let date
  if (typeof time === 'object') {
    date = time
  } else {
    if (('' + time).length === 10) time = parseInt(time) * 1000
    date = new Date(time)
  }
  const formatObj = {
    y: date.getFullYear(),
    m: date.getMonth() + 1,
    d: date.getDate(),
    h: date.getHours(),
    i: date.getMinutes(),
    s: date.getSeconds(),
    a: date.getDay()
  }
  return format.replace(/{([ymdhisa])+}/g, (result, key) => {
    let value = formatObj[key]
    // Note: getDay() returns 0 on Sunday
    if (key === 'a') {
      return ['日', '一', '二', '三', '四', '五', '六'][value]
    }
    if (result.length > 0 && value < 10) {
      value = '0' + value
    }
    return value || 0
  })
}

/**
 * format time to object or string-zh
 * @param time
 * @param option
 * @return {*}
 */
export function formatTime (time: number, option?): string {
  time = +time * 1000
  const d = new Date(time)
  const now = Date.now()

  const diff = (now - d) / 1000

  if (diff < 30) {
    return '刚刚'
  } else if (diff < 3600) {
    // less 1 hour
    return Math.ceil(diff / 60) + '分钟前'
  } else if (diff < 3600 * 24) {
    return Math.ceil(diff / 3600) + '小时前'
  } else if (diff < 3600 * 24 * 2) {
    return '1天前'
  }
  if (option) {
    return parseTime(time, option)
  } else {
    return (
      d.getMonth() +
      1 +
      '月' +
      d.getDate() +
      '日' +
      d.getHours() +
      '时' +
      d.getMinutes() +
      '分'
    )
  }
}

/**
 * parse url
 * @param url
 */
export function getQueryObject (url: string): Object {
  url = url == null ? window.location.href : url
  const search = url.substring(url.lastIndexOf('?') + 1)
  const obj = {}
  const reg = /([^?&=]+)=([^?&=]*)/g
  search.replace(reg, (rs, $1, $2) => {
    const name = decodeURIComponent($1)
    let val = decodeURIComponent($2)
    val = String(val)
    obj[name] = val
    return rs
  })
  return obj
}

/**
 * get byte len
 * @param val
 * @return {number}
 */
export function getByteLen (val: string): Number {
  let len = 0
  for (let i = 0; i < val.length; i++) {
    if (val[i].match(/[^\x00-\xff]/gi) != null) {
      len += 1
    } else {
      len += 0.5
    }
  }
  return Math.floor(len)
}

/**
 * cleanArray
 * @param actual
 * @return {Array}
 */
export function cleanArray (actual: Array<any>): Array<any> {
  const newArray = []
  for (let i = 0; i < actual.length; i++) {
    if (actual[i]) {
      newArray.push(actual[i])
    }
  }
  return newArray
}

/**
 * param json to url
 * @param json
 * @return {string}
 */
export function param2url (json: Object): string {
  if (!json) return ''
  return cleanArray(
    Object.keys(json).map(key => {
      if (json[key] === undefined) return ''
      return encodeURIComponent(key) + '=' + encodeURIComponent(json[key])
    })
  ).join('&')
}

/**
 * param url to obj
 * @param url
 * @return {*}
 */
export function param2Obj (url: string): Object {
  const search = url.split('?')[1]
  if (!search) {
    return {}
  }
  return qs.parse(
    decodeURIComponent(search)
      .replace(/"/g, '\\"')
  )
}

/**
 * convert html to text
 * @param val
 * @return {*|string}
 */
export function html2Text (val: string): string {
  const div = document.createElement('div')
  div.innerHTML = val
  return div.textContent || div.innerText
}

/**
 * Merges two  objects,
 * giving the last one precedence
 * tips: Object.assign can make one level attributes deep copy but other attributes
 * @param target
 * @param source
 * @return {*}
 */
export function objectMerge (target: Object, source: Object): Object {
  if (typeof target !== 'object') {
    target = {}
  }
  if (Array.isArray(source)) {
    return source.slice()
  }
  Object.keys(source).forEach(property => {
    const sourceProperty = source[property]
    if (typeof sourceProperty === 'object') {
      target[property] = objectMerge(target[property], sourceProperty)
    } else {
      target[property] = sourceProperty
    }
  })
  return target
}

export const pickerOptions = [
  {
    text: '今天',
    onClick (picker: Object): void {
      const end = new Date()
      const start = new Date(new Date().toDateString())
      end.setTime(start.getTime())
      picker.$emit('pick', [start, end])
    }
  },
  {
    text: '最近一周',
    onClick (picker: Object): void {
      const end = new Date(new Date().toDateString())
      const start = new Date()
      start.setTime(end.getTime() - 3600 * 1000 * 24 * 7)
      picker.$emit('pick', [start, end])
    }
  },
  {
    text: '最近一个月',
    onClick (picker: Object): void {
      const end = new Date(new Date().toDateString())
      const start = new Date()
      start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
      picker.$emit('pick', [start, end])
    }
  },
  {
    text: '最近三个月',
    onClick (picker: Object): void {
      const end = new Date(new Date().toDateString())
      const start = new Date()
      start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
      picker.$emit('pick', [start, end])
    }
  }
]

/**
 * get now time
 * @param type
 * @return {*}
 */
export function getTime (type: 'start' | any): Object {
  if (type === 'start') {
    return new Date().getTime() - 3600 * 1000 * 24 * 90
  } else {
    return new Date(new Date().toDateString())
  }
}

/**
 * This is just a simple version of deep copy
 * Has a lot of edge cases bug
 * If you want to use a perfect deep copy, use lodash's _.cloneDeep
 */
export function deepClone (source: Object): Object {
  if (!source && typeof source !== 'object') {
    throw new Error('error arguments', 'shallowClone')
  }
  const targetObj = source.constructor === Array ? [] : {}
  Object.keys(source).forEach(keys => {
    if (source[keys] && typeof source[keys] === 'object') {
      targetObj[keys] = deepClone(source[keys])
    } else {
      targetObj[keys] = source[keys]
    }
  })
  return targetObj
}

/**
 * Duplicate removal
 * @param arr
 * @return {Array<*>|Array<void>}
 */
export function uniqueArr (arr: Array<any>): Array<any> {
  return Array.from(new Set(arr))
}

/**
 * url test
 * @param path
 * @return {boolean}
 */
export function isExternal (path: string): boolean {
  return /^(https?:|mailto:|tel:)/.test(path)
}

/**
 * date in range
 * @param item
 * @param range
 */
export function dateInRange (item: string, range: Array<string>): boolean {
  let index = new Date(item)
  let start = new Date(range[0])
  let end = new Date(range[1])
  return index >= start && index <= end
}

/**
 * Check if value is primitive
 */
export function isPrimitive (value: any): boolean {
  return (
    typeof value === 'string' ||
    typeof value === 'number' ||
    // $flow-disable-line
    typeof value === 'symbol' ||
    typeof value === 'boolean'
  )
}

export function initObject (value: Object): void {
  for (let key in value) {
    if (value.hasOwnProperty(key)) {
      if (isPrimitive(value[key])) {
        value[key] = ''
      } else if (value[key] instanceof Object) {
        if (value[key] instanceof Array) {
          value[key] = []
        } else {
          initObject(value[key])
        }
      }
    }
  }
}
