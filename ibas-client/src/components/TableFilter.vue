<template>
  <el-popover
    placement="bottom"
    v-model="visible"
    trigger="click"
    popper-class="filter-popper"
    transition="el-zoom-in-top">
    <template v-if="mode==='list'">
      <el-scrollbar>
        <el-checkbox-group v-model="selected" class="el-table-filter__checkbox-group">
          <el-checkbox v-for="item in filter" :key="item" :label="item">{{ item }}</el-checkbox>
        </el-checkbox-group>
      </el-scrollbar>
      <div class="el-table-filter__bottom">
        <button @click="handleConfirm"
                :class="{ 'is-disabled': selected.length=== 0 }"
                :disabled="selected.length === 0">{{ filterText }}</button>
        <button @click="handleReset">{{ resetText }}</button>
      </div>
    </template>
    <template v-if="mode==='date'">
      <div style="padding: 10px">
        <el-date-picker
          size="mini"
          format="yyyy-MM-dd"
          value-format="yyyy/MM/dd"
          v-model="dateRange"
          type="daterange"
          align="left"
          range-separator="-"
          :start-placeholder="startDateText"
          :end-placeholder="endDateText">
          :end-placeholder="endDateText">
        </el-date-picker>
      </div>
      <div class="el-table-filter__bottom">
        <button @click="handleConfirm"
                :class="{ 'is-disabled': !dateRange }"
                :disabled="!dateRange">{{ filterText }}</button>
        <button @click="handleReset">{{ resetText }}</button>
      </div>
    </template>
    <template v-if="mode==='range'">
      <div style="padding: 10px">
        <el-row>
          <el-input-number type="number" size="mini" :min="0" v-model="range.min"></el-input-number>
        </el-row>
        <el-row style="text-align: center">
          <i class="el-icon-minus" style="transform: rotate(90deg); transform-origin: center center"></i>
        </el-row>
        <el-row>
          <el-input-number type="number" size="mini" :min="range.min" v-model="range.max"></el-input-number>
        </el-row>
      </div>
      <div class="el-table-filter__bottom">
        <button @click="handleConfirm"
                :class="{ 'is-disabled': range.max===0 }"
                :disabled="range.max===0">{{ filterText }}</button>
        <button @click="handleReset">{{ resetText }}</button>
      </div>
    </template>
    <span slot="reference">
      {{ reference }}
      <span class="el-table__column-filter-trigger">
        <i class="el-icon-arrow-down"></i>
      </span>
    </span>
  </el-popover>
</template>

<script>
  export default {
    name: 'TableFilter',

    props: {
      filter: {
        type: Array
      },
      reference: {
        type: String,
        required: true
      },
      filterText: {
        type: String,
        required: true
      },
      resetText: {
        type: String,
        required: true
      },
      startDateText: {
        type: String
      },
      endDateText: {
        type: String
      },
      mode: {
        type: String,
        default () {
          return 'list'
        }
      }
    },

    data () {
      return {
        selected: [],
        dateRange: '',
        range: {
          min: 0,
          max: 0
        },
        visible: false
      }
    },

    methods: {

      handleConfirm (): void {
        this.confirmFilter()
      },

      handleReset (): void {
        if (this.mode === 'list') this.selected = []
        if (this.mode === 'date') this.dateRange = ''
        if (this.mode === 'range') this.range = { min: 0, max: 0 }
        this.confirmFilter()
      },

      confirmFilter (): void {
        if (this.mode === 'list') this.$emit('confirm-filter', this.selected)
        if (this.mode === 'date') this.$emit('confirm-filter', this.dateRange)
        if (this.mode === 'range') this.$emit('confirm-filter', [this.range.min, this.range.max])
        let timer = setTimeout(() => {
          this.visible = false
          clearTimeout(timer)
          timer = null
        }, 16)
      }
    }
  }
</script>

<style lang="scss" scoped>
  .el-row +.el-row{
    margin-top: 5px;
  }
</style>
