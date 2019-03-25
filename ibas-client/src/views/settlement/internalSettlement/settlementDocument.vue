<template>
  <div class="container">
    <el-row>
      <el-card shadow="always">
        <el-row class="opening">
          <div>{{$t('settlement.settlementDocument.opening')}}</div>
        </el-row>
        <el-row>
          <el-form label-position="right" label-width="80px" class="form">
            <el-form-item :label="$t('settlement.settlementDocument.backupMonth')">
              <el-date-picker
                v-model="backupMonth"
                type="month"
                format="yyyy / MM"
                value-format="yyyy-MM"
                :picker-options="pickerOptions"
                :clearable=false
                :editable=false>
              </el-date-picker>
            </el-form-item>
            <el-form-item :label="$t('settlement.settlementDocument.branch')">
              <el-select v-model="branch" multiple @change="branchChange">
                <el-option :label="$t('settlement.settlementDocument.all')" value="all"></el-option>
                <el-option :label="$t('settlement.settlementDocument.enShi')" value="enShi"></el-option>
                <el-option :label="$t('settlement.settlementDocument.guangXi')" value="guangXi"></el-option>
                <el-option :label="$t('settlement.settlementDocument.huNan')" value="huNan"></el-option>
                <el-option :label="$t('settlement.settlementDocument.jiangSu')" value="jiangSu"></el-option>
                <el-option :label="$t('settlement.settlementDocument.jingMen')" value="jingMen"></el-option>
                <el-option :label="$t('settlement.settlementDocument.liaoNing')" value="liaoNing"></el-option>
                <el-option :label="$t('settlement.settlementDocument.shiYan')" value="shiYan"></el-option>
                <el-option :label="$t('settlement.settlementDocument.wuChang')" value="wuChang"></el-option>
                <el-option :label="$t('settlement.settlementDocument.wuHan')" value="wuHan"></el-option>
                <el-option :label="$t('settlement.settlementDocument.xianTao')" value="xianTao"></el-option>
                <el-option :label="$t('settlement.settlementDocument.xianNing')" value="xianNing"></el-option>
                <el-option :label="$t('settlement.settlementDocument.xiangYang')" value="xiangYang"></el-option>
                <el-option :label="$t('settlement.settlementDocument.yiChang')" value="yiChang"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="counterBackup">{{$t('settlement.settlementDocument.counterBackup')}}</el-button>
              <el-button type="primary" @click="backup">{{$t('settlement.settlementDocument.backUp')}}</el-button>
            </el-form-item>
          </el-form>
        </el-row>
      </el-card>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: 'settlementDocument',
    data () {
      return {
        backupMonth: '',
        branch: '',
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
      counterBackup () {
        // TODO
        return 'Counter Backup Finished!'
      },
      backup () {
        // TODO
        return 'Backup Finished!'
      },
      setDefaultValue () {
        let currentDate = new Date()
        let currentYear = currentDate.getFullYear()
        let currentMonth = currentDate.getMonth() + 1
        this.backupMonth = currentYear + '-' + currentMonth
        this.branch = ['all']
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

  .form {
    margin-top: 20px;
  }
</style>
