<template>
  <span class="input-tag">
    <el-input
      v-if="inputVisible"
      v-model="value"
      v-focus
      :size="size"
      @keyup.enter.native="handleConfirm"
      @blur="handleConfirm"
      :placeholder="tagName">
    </el-input>
    <el-button v-else class="button-tag" :type="value?'primary':''" :size="size" @click="showTagInput" plain>
      <svg-icon v-if="icon" :icon-class="icon"></svg-icon>
      <span>{{ tagName }}</span>
    </el-button>
  </span>

</template>

<script>
  export default {
    name: 'InputTag',

    props: {
      showOperation: {
        type: Boolean,
        default () {
          return false
        }
      },

      icon: {
        type: String
      },

      size: {
        type: String,
        default () {
          return 'medium'
        }
      },

      tagName: {
        type: String
      },

      initValue: {
        type: String
      }
    },

    created () {
      if (this.initValue) this.value = this.initValue
    },

    data () {
      return {
        inputVisible: false,
        value: ''
      }
    },

    directives: {
      focus: {
        inserted: el => {
          el.children[0].focus()
        }
      }
    },

    methods: {
      handleConfirm (): void {
        this.inputVisible = false
        this.$emit('confirm', this.value.trim())
      },

      showTagInput (): void {
        this.inputVisible = true
      }
    }
  }
</script>
