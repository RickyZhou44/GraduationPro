
<template>
  <!-- eslint-disable vue/require-component-is-->
  <component v-bind="linkProps(to)">
    <slot/>
  </component>
</template>

<script>
  import { isExternal } from '@/shared'

  export default {
    props: {
      to: {
        type: String,
        required: true
      }
    },
    methods: {
      isExternalLink (routePath: string) {
        return isExternal(routePath)
      },
      linkProps (url: string): Object {
        if (this.isExternalLink(url)) {
          return {
            is: 'a',
            href: url,
            target: '_blank',
            rel: 'noopener'
          }
        }
        return {
          is: 'router-link',
          to: url
        }
      }
    }
  }
</script>
