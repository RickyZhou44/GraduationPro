<template>
  <div class="container">
    <el-row>
      <el-card shadow="always">
        <el-row :gutter="20">
          <el-form label-width="80px" :inline="true">
            <el-col :span="5">
              <div>
                <el-form-item :label="$t('humanCapital.rePerformanceData.branch')">
                  <el-select v-model="branch" multiple :placeholder="$t('common.select')" collapse-tags>
                    <el-option :label="$t('humanCapital.rePerformanceData.all')" value="all"></el-option>
                    <el-option :label="$t('humanCapital.rePerformanceData.enShi')" value="enShi"></el-option>
                    <el-option :label="$t('humanCapital.rePerformanceData.guangXi')" value="guangXi"></el-option>
                    <el-option :label="$t('humanCapital.rePerformanceData.huNan')" value="huNan"></el-option>
                    <el-option :label="$t('humanCapital.rePerformanceData.jiangSu')" value="jiangSu"></el-option>
                    <el-option :label="$t('humanCapital.rePerformanceData.jingMen')" value="jingMen"></el-option>
                    <el-option :label="$t('humanCapital.rePerformanceData.liaoNing')" value="liaoNing"></el-option>
                    <el-option :label="$t('humanCapital.rePerformanceData.shiYan')" value="shiYan"></el-option>
                    <el-option :label="$t('humanCapital.rePerformanceData.wuChang')" value="wuChang"></el-option>
                    <el-option :label="$t('humanCapital.rePerformanceData.wuHan')" value="wuHan"></el-option>
                    <el-option :label="$t('humanCapital.rePerformanceData.xianTao')" value="xianTao"></el-option>
                    <el-option :label="$t('humanCapital.rePerformanceData.xianNing')" value="xianNing"></el-option>
                    <el-option :label="$t('humanCapital.rePerformanceData.xiangYang')" value="xiangYang"></el-option>
                    <el-option :label="$t('humanCapital.rePerformanceData.yiChang')" value="yiChang"></el-option>
                  </el-select>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="9">
              <el-form-item :label="$t('humanCapital.rePerformanceData.performanceSpan')">
                <el-date-picker
                  v-model="selectedStartMonth"
                  type="month"
                  format="yyyy / MM"
                  :placeholder="$t('humanCapital.rePerformanceData.selectStartTime')"
                  :picker-options="pickerStartOptions">
                </el-date-picker>
                <span class="to">{{$t('humanCapital.rePerformanceData.to')}}</span>
                <el-date-picker
                  v-model="selectedEndMonth"
                  type="month"
                  format="yyyy / MM"
                  :placeholder="$t('humanCapital.rePerformanceData.selectEndTime')"
                  :picker-options="pickerEndOptions">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="10">
              <el-form-item>
                <el-button type="primary" @click="onSubmit">{{$t('humanCapital.rePerformanceData.reCalculate')}}</el-button>
              </el-form-item>
            </el-col>
          </el-form>
        </el-row>
      </el-card>
    </el-row>
  </div>
</template>

<script>
  import { reCalculate } from '@/api/humanCapital/rePerformanceData'
  export default {
    name: 'rePerformanceData',
    data () {
      return {
        branch: [],
        selectedStartMonth: '',
        selectedEndMonth: '',
        pickerStartOptions: {
          disabledDate: (time) => {
            if (this.selectedEndMonth !== '') {
              return time.getTime() > Date.now() || time.getTime() > this.selectedEndMonth
            } else {
              return time.getTime() > Date.now()
            }
          }
        },
        pickerEndOptions: {
          disabledDate: (time) => {
            return time.getTime() < this.selectedStartMonth || time.getTime() > Date.now()
          }
        }
      }
    },
    methods: {
      onSubmit () {
        let searchJson = {
          branch: this.branch,
          startMonth: this.selectedStartMonth,
          endMonth: this.selectedEndMonth
        }
        console.log('submit!')
        reCalculate(searchJson).then(data => {
          //
        })
      }
    }
  }
</script>

<style scoped>

</style>
