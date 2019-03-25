<template>
  <div class="container">
    <el-row>
      <el-card shadow="always">
        <el-row :gutter="20">
          <el-form label-position="right" label-width="80px" :inline="true">
            <el-col :span="5">
              <div>
                <el-form-item :label="$t('common.branch')">
                  <el-select v-model="branch" multiple :placeholder="$t('common.pleaseSelect')" @change="branchChange">
                    <el-option :label="$t('settlement.performanceReorganization.all')" value="all"></el-option>
                    <el-option :label="$t('settlement.performanceReorganization.enShi')" value="enShi"></el-option>
                    <el-option :label="$t('settlement.performanceReorganization.guangXi')" value="guangXi"></el-option>
                    <el-option :label="$t('settlement.performanceReorganization.huNan')" value="huNan"></el-option>
                    <el-option :label="$t('settlement.performanceReorganization.jiangSu')" value="jiangSu"></el-option>
                    <el-option :label="$t('settlement.performanceReorganization.jingMen')" value="jingMen"></el-option>
                    <el-option :label="$t('settlement.performanceReorganization.liaoNing')" value="liaoNing"></el-option>
                    <el-option :label="$t('settlement.performanceReorganization.shiYan')" value="shiYan"></el-option>
                    <el-option :label="$t('settlement.performanceReorganization.wuChang')" value="wuChang"></el-option>
                    <el-option :label="$t('settlement.performanceReorganization.wuHan')" value="wuHan"></el-option>
                    <el-option :label="$t('settlement.performanceReorganization.xianTao')" value="xianTao"></el-option>
                    <el-option :label="$t('settlement.performanceReorganization.xianNing')" value="xianNing"></el-option>
                    <el-option :label="$t('settlement.performanceReorganization.xiangYang')" value="xiangYang"></el-option>
                    <el-option :label="$t('settlement.performanceReorganization.yiChang')" value="yiChang"></el-option>
                  </el-select>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <el-form-item :label="$t('settlement.performanceReorganization.performanceSpan')">
                <!--TODO: monthrange doesn't work-->
                <el-date-picker
                  v-model="span"
                  type="monthrange"
                  range-separator="-"
                  :start-placeholder="$t('common.startMonth')"
                  :end-placeholder="$t('common.endMonth')">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="13">
              <el-form-item>
                <el-button type="primary" @click="onSubmit">{{$t('common.reCalculate')}}</el-button>
              </el-form-item>
            </el-col>
          </el-form>
        </el-row>
      </el-card>
    </el-row>
  </div>
</template>

<script>
  import ElCard from 'element-ui/packages/card/src/main'
  export default {
    name: 'performanceReorganization',
    components: { ElCard },
    data () {
      return {
        branch: ['all'],
        span: '',
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
    created () {
      this.setDefaultValue()
    },
    methods: {
      onSubmit () {
        // TODO: submit method
        console.log('submit!')
      },
      branchChange () {
        // 用户只能选择“不区分”或其他多个选项，当用户删除所有选项时，默认选择不区分
        let branch = this.branch
        if (branch.length === 0) {
          this.branch = ['all']
        } else {
          let selectedLastBranch = branch[branch.length - 1]
          if (selectedLastBranch === 'all') {
            this.branch = ['all']
          } else {
            for (let i = 0; i < branch.length; i++) {
              if (branch[i] === 'all') branch.splice(i, 1)
            }
          }
        }
      },
      setDefaultValue () {
        // TODO: set default span time
      }
    }
  }
</script>

<style lang="scss">
  .container {
    padding: 15px;
  }

  .to {
    padding: 0 10px;
  }
</style>
