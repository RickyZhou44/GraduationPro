<template>
    <div class="c-container"
         :style="{ backgroundColor: activeColor,
                   transitionDelay: transitionDelay,
                   transitionDuration: transitionDuration,
                   transitionTimingFunction: transitionTimingFunction }">
      <slot></slot>
    </div>
</template>

<script>
  export default {

    props: {
      colorSet: {
        type: Array,
        required: true,
        default () {
          return [ '#fff' ]
        }
      },
      changeDelay: {
        type: Number,
        default () {
          return 3000
        }
      },
      transitionDelay: {
        type: String,
        default () {
          return '.5s'
        }
      },
      transitionDuration: {
        type: String,
        default () {
          return '1s'
        }
      },
      transitionTimingFunction: {
        type: String,
        default () {
          return 'linear'
        }
      }
    },

    data () {
      return {
        activeColor: '#fff'
      }
    },

    mounted () {
      if (this.colorSet.length === 1) {
        this.activeColor = this.colorSet[0]
      } else if (this.colorSet.length > 1) {
        let post = false
        let colorArr = this.colorSet.slice(0)
        const change = () => {
          post = !post
          const v = colorArr.shift()
          this.activeColor = v
          this.$emit('oncolorchange')
          colorArr.push(v)
          if (post) {
            setTimeout(change, this.changeDelay)
          } else {
            setTimeout(change, 2 * this.changeDelay)
          }
        }
        change()
      }
    }
  }
</script>

<style lang="scss" scoped>
  .c-container{
    display: flex;
    flex-direction: column;
    flex: auto;
  }
</style>
