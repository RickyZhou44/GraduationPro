<template>
  <el-popover
    :placement="placement"
    :width="width"
    :trigger="mode"
    v-model="visible">
    <p>{{ message }}</p>
    <div style="text-align: right; margin: 10px 0 0;">
      <el-button size="mini" type="text" @click="visible = false">{{ cancelText }}</el-button>
      <el-button type="primary" size="mini" @click="confirm">{{ confirmText }}</el-button>
    </div>
    <slot slot="reference"></slot>
  </el-popover>
</template>

<script>
  export default {
    name: 'PopoverTip',

    props: {
      mode: {
        type: String,
        default () {
          return 'click'
        }
      },

      placement: {
        type: String,
        required: false,
        default () {
          return 'top'
        }
      },

      width: {
        type: String,
        required: false,
        default () {
          return '160'
        }
      },

      message: {
        type: String,
        required: true
      },

      confirmText: {
        type: String,
        required: true
      },

      cancelText: {
        type: String,
        required: true
      }
    },

    data () {
      return {
        visible: false
      }
    },

    methods: {
      confirm () {
        this.visible = false
        this.$emit('popover-tip-confirm')
      },

      show () {
        this.visible = true
      }
    }
  }
</script>
