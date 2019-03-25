<template>
  <div @click="click">
    <svg-icon :icon-class="isFullscreen?'minimize':'maximize'"></svg-icon>
  </div>
</template>

<script>
  import screenfull from 'screenfull'

  export default {
    name: 'Screenfull',
    props: {
      width: {
        type: Number,
        default: 22
      },
      height: {
        type: Number,
        default: 22
      },
      fill: {
        type: String,
        default: '#48576a'
      }
    },
    data () {
      return {
        isFullscreen: false
      }
    },
    methods: {
      click (): void {
        if (!screenfull.enabled) {
          this.$message({
            message: 'you browser can not work',
            type: 'warning'
          })
          return false
        }
        this.isFullscreen = !this.isFullscreen
        this.$emit('mode-change', this.isFullscreen)
        screenfull.toggle()
      }
    }
  }
</script>
