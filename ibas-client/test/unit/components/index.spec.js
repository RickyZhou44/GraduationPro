import * as Components from '@/components'
import { mount } from '@vue/test-utils'

describe('Component', () => {
  test('是一个 Vue 实例', () => {
    const wrapper = mount(Components.SvgIcon)
    expect(wrapper.isVueInstance()).toBeTruthy()
  })
})
