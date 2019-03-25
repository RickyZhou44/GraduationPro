<template>
  <div class="container">
    <el-row>
      <el-card>
        <el-row class="opening">
          <div>{{$t('settlement.automaticStandardSettlement.opening')}}</div>
        </el-row>
        <el-form label-position="right" label-width="100px" class="form">
          <el-row :gutter="20">
            <el-form-item :label="$t('settlement.automaticStandardSettlement.performanceMonth')">
              <el-col :span="3.5">
                <el-date-picker
                  v-model="performanceMonth"
                  type="month"
                  format="yyyy / MM"
                  value-format="yyyy-MM"
                  :picker-options="pickerOptions"
                  :clearable=false
                  :editable=false>
                </el-date-picker>
              </el-col>
              <el-col :span="1.5">
                <el-button size="medium" @click="onCounterCommission">{{$t('settlement.automaticStandardSettlement.counterCommission')}}</el-button>
              </el-col>
              <el-col :span="18">
                <el-checkbox v-model="allBranches">{{$t('settlement.automaticStandardSettlement.allBranches')}}</el-checkbox>
              </el-col>
            </el-form-item>
          </el-row>
          <el-row :gutter="20">
            <el-collapse v-model="activeNames" class="collapse">
              <el-collapse-item :title="$t('settlement.automaticStandardSettlement.settlementObject')" name='settlementObject'>
                <el-form-item :label="$t('settlement.automaticStandardSettlement.branch')">
                  <el-select v-model="branch">
                    <el-option :label="$t('settlement.automaticStandardSettlement.anHui')" value="anHui"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.enShi')" value="enShi"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.fuJian')" value="fuJian"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.guangXi')" value="guangXi"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.haiNan')" value="haiNan"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.heNan')" value="heNan"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.heiLongJiang')" value="heiLongJiang"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.huNan')" value="huNan"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.jiangSu')" value="jiangSu"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.jingMen')" value="jingMen"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.liaoNing')" value="liaoNing"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.ningXia')" value="ningXia"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.shanXi')" value="shanXi"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.shiYan')" value="shiYan"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.tianJin')" value="tianJin"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.wuChang')" value="wuChang"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.wuHan')" value="wuHan"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.xianTao')" value="xianTao"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.xianNing')" value="xianNing"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.xiangYang')" value="xiangYang"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.xinJiang')" value="xinJiang"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.yiChang')" value="yiChang"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.yunNan')" value="yunNan"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.headquarters')" value="headquarters"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item :label="$t('settlement.automaticStandardSettlement.policy')">
                  <el-select v-model="policy">
                    <el-option :label="$t('settlement.automaticStandardSettlement.standard')" value="standard"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.management')" value="management"></el-option>
                    <el-option :label="$t('settlement.automaticStandardSettlement.basicA')" value="basicA"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item>
                  <el-button size="medium" @click="onCommissionCalculation">{{$t('settlement.automaticStandardSettlement.commissionCalculation')}}</el-button>
                </el-form-item>
              </el-collapse-item>
            </el-collapse>
          </el-row>
          <el-row>
            <el-form-item>
              <el-button type="primary" @click="onSubmit">{{$t('settlement.automaticStandardSettlement.lookUp')}}</el-button>
            </el-form-item>
          </el-row>
        </el-form>
      </el-card>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: 'automaticStandardSettlement',
    data () {
      return {
        performanceMonth: '',
        allBranches: true,
        activeNames: ['settlementObject'],
        branch: '',
        policy: '',
        pickerOptions: {
          disabledDate: (time) => {
            return time.getTime() > Date.now()
          }
        }
      }
    },
    created () {
      this.setDefaultValue()
    },
    methods: {
      setDefaultValue () {
        let currentDate = new Date()
        let currentYear = currentDate.getFullYear()
        let currentMonth = currentDate.getMonth() + 1
        this.performanceMonth = currentYear + '-' + currentMonth
        this.branch = 'anHui'
        this.policy = 'standard'
      },
      onCounterCommission () {
        // TODO
        console.log('Counter Commission Submitted!')
      },
      onCommissionCalculation () {
        // TODO
        console.log('Commission Calculation Submitted!')
      },
      onSubmit () {
        // TODO
        console.log('Look up Submitted!')
      }
    }
  }
</script>

<style lang="scss">
  .container {
    padding: 15px;
  }

  .form {
    margin-top: 20px;
  }

  .collapse {
    margin: 20px;
  }

  .opening {
    margin-top: 20px;
    margin-left: 20px;
  }
</style>
