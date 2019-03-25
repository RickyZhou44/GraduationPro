<template>
  <div class="container">
    <el-row>
      <el-card shadow="always">
        <el-row class="opening">
          <div>{{$t('settlement.VIStandardSettlement.opening')}}</div>
        </el-row>
        <el-form label-position="right" label-width="80px">
          <el-row :gutter="20">
            <el-collapse v-model="activeNames" class="collapse">
              <el-collapse-item :title="$t('settlement.VIStandardSettlement.settlementObject')" name='settlementObject'>
                <el-form-item :label="$t('settlement.VIStandardSettlement.branch')">
                  <el-select v-model="branch">
                    <el-option :label="$t('settlement.VIStandardSettlement.anHui')" value="anHui"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.enShi')" value="enShi"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.fuJian')" value="fuJian"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.guangXi')" value="guangXi"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.haiNan')" value="haiNan"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.heNan')" value="heNan"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.heiLongJiang')" value="heiLongJiang"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.huNan')" value="huNan"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.jiangSu')" value="jiangSu"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.jingMen')" value="jingMen"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.liaoNing')" value="liaoNing"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.ningXia')" value="ningXia"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.shanXi')" value="shanXi"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.shiYan')" value="shiYan"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.tianJin')" value="tianJin"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.wuChang')" value="wuChang"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.wuHan')" value="wuHan"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.xianTao')" value="xianTao"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.xianNing')" value="xianNing"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.xiangYang')" value="xiangYang"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.xinJiang')" value="xinJiang"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.yiChang')" value="yiChang"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.yunNan')" value="yunNan"></el-option>
                    <el-option :label="$t('settlement.VIStandardSettlement.headquarters')" value="headquarters"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item :label="$t('settlement.VIStandardSettlement.span')">
                  <el-date-picker
                    v-model="span"
                    type="daterange"
                    range-separator="-"
                    format="yyyy / MM / dd"
                    value-format="yyyy-MM-dd"
                    :clearable=false
                    :editable=false>
                  </el-date-picker>
                </el-form-item>
                <el-form-item>
                  <el-button size="medium" @click="onCommissionCalculation">{{$t('settlement.VIStandardSettlement.commissionCalculation')}}</el-button>
                </el-form-item>
              </el-collapse-item>
            </el-collapse>
          </el-row>
          <el-row>
            <el-form-item>
              <el-button type="primary" @click="onSubmit">{{$t('settlement.VIStandardSettlement.lookUp')}}</el-button>
            </el-form-item>
          </el-row>
        </el-form>
        <el-row :gutter="20" v-if="listShown" class="listResult">
          <el-col :span="7">
            <el-tabs type="card">
              <el-tab-pane :label="$t('settlement.VIStandardSettlement.commissionList')">
                <el-table
                  :data="commissionList"
                  :header-cell-style="{ backgroundColor: '#f8f8f9', color: '#2c2c2c' }"
                  max-height="750"
                  fit
                  border>
                  <el-table-column type="index" width="50" align="center"></el-table-column>
                  <el-table-column prop="branch" width="140px" align="center" :label="$t('settlement.VIStandardSettlement.branch')"></el-table-column>
                  <el-table-column prop="commissionStart" width="140px" align="center" :label="$t('settlement.VIStandardSettlement.commissionStart')"></el-table-column>
                  <el-table-column prop="commissionEnd" width="141px" align="center" :label="$t('settlement.VIStandardSettlement.commissionEnd')"></el-table-column>
                </el-table>
              </el-tab-pane>
            </el-tabs>
          </el-col>
          <el-col :span="17">
            <el-tabs v-model="tabActiveName" type="card">
              <el-tab-pane :label="$t('settlement.VIStandardSettlement.salaryDetails')" name="salary">
                <el-table
                  :data="salaryList"
                  :header-cell-style="{ backgroundColor: '#f8f8f9', color: '#2c2c2c' }"
                  max-height="750"
                  fit
                  border>
                  <el-table-column type="index" width="50" align="center"></el-table-column>
                  <el-table-column prop="agency" width="230px" align="center" :label="$t('settlement.VIStandardSettlement.agency')"></el-table-column>
                  <el-table-column prop="branch" width="250px" align="center" :label="$t('settlement.VIStandardSettlement.branch')"></el-table-column>
                  <el-table-column prop="commissionStart" width="200px" align="center" :label="$t('settlement.VIStandardSettlement.commissionStart')"></el-table-column>
                  <el-table-column prop="commissionEnd" width="200px" align="center" :label="$t('settlement.VIStandardSettlement.commissionEnd')"></el-table-column>
                  <el-table-column prop="branchCommission" width="245px" align="center" :label="$t('settlement.VIStandardSettlement.branchCommission')"></el-table-column>
                </el-table>
              </el-tab-pane>
              <el-tab-pane :label="$t('settlement.VIStandardSettlement.insurancePolicyDetails')" name="insurancePolicy">
                <el-table
                  :data="insurancePolicyList"
                  :header-cell-style="{ backgroundColor: '#f8f8f9', color: '#2c2c2c' }"
                  max-height="750"
                  fit
                  border>
                  <el-table-column type="index" width="50" align="center"></el-table-column>
                  <el-table-column prop="company" width="175px" align="center" :label="$t('settlement.VIStandardSettlement.company')"></el-table-column>
                  <el-table-column prop="IPNo" width="125px" align="center" :label="$t('settlement.VIStandardSettlement.IPNo')"></el-table-column>
                  <el-table-column prop="acceptDate" width="125px" align="center" :label="$t('settlement.VIStandardSettlement.acceptDate')"></el-table-column>
                  <el-table-column prop="compulsoryPremium" width="175px" align="center" :label="$t('settlement.VIStandardSettlement.compulsoryPremium')"></el-table-column>
                  <el-table-column prop="branchCompulsory" width="175px" align="center" :label="$t('settlement.VIStandardSettlement.branchCompulsory')"></el-table-column>
                  <el-table-column prop="businessPremium" width="175px" align="center" :label="$t('settlement.VIStandardSettlement.businessPremium')"></el-table-column>
                  <el-table-column prop="branchBusiness" width="175px" align="center" :label="$t('settlement.VIStandardSettlement.branchBusiness')"></el-table-column>
                </el-table>
              </el-tab-pane>
            </el-tabs>
          </el-col>
        </el-row>
        <el-row v-if="listShown">
          <el-button plain size="medium" @click="deleteResult">{{$t('settlement.VIStandardSettlement.deleteResult')}}</el-button>
          <el-button plain size="medium" type="primary" @click="salaryExport">
            {{$t('settlement.VIStandardSettlement.salaryExport')}}
            <i class="el-icon-download el-icon--right"></i>
          </el-button>
          <el-button plain size="medium" type="primary" @@click="IPExport">
            {{$t('settlement.VIStandardSettlement.IPExport')}}
            <i class="el-icon-download el-icon--right"></i>
          </el-button>
        </el-row>
      </el-card>
    </el-row>
  </div>
</template>

<script>
  import ElTabPane from 'element-ui/packages/tabs/src/tab-pane'
  export default {
    name: 'VIStandardSettlement',
    components: { ElTabPane },
    data () {
      return {
        activeNames: ['settlementObject'],
        branch: '',
        span: '',
        commissionList: [],
        tabActiveName: 'salary',
        salaryList: [],
        insurancePolicyList: [],
        listShown: false
      }
    },
    created () {
      this.setDefaultValue()
    },
    methods: {
      onCommissionCalculation () {
        // TODO
        console.log('Commission Calculation Submitted!')
      },
      onSubmit () {
        // TODO
        this.listShown = true
      },
      deleteResult () {
        // TODO
        console.log('Delete Result Submitted!')
      },
      salaryExport () {
        // TODO
        console.log('Salary Exported!')
      },
      IPExport () {
        // TODO
        console.log('IP Exported!')
      },
      setDefaultValue () {
        this.branch = 'anHui'
        let date = new Date()
        let currentYear = date.getFullYear()
        let currentMonth = date.getMonth() + 1
        let currentDate = date.getDate()
        let currentYMD = currentYear + ' / ' + currentMonth + ' / ' + currentDate
        this.span = [currentYMD, currentYMD]
      }
    }
  }
</script>

<style lang="scss">
  .container {
    padding: 15px;
  }

  .opening {
    margin-top: 20px;
    margin-left: 20px;
  }

  .collapse {
    margin: 20px;
  }

  .listResult {
    margin: 40px 20px 20px 20px;
  }
</style>
