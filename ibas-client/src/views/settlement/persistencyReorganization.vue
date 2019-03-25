<template>
  <div class="container">
    <el-row>
      <el-card shadow="always">
        <el-tabs type="card">
          <el-tab-pane :label="$t('settlement.persistencyReorganization.persistencyReorg')">
            <el-row :gutter="20">
              <el-form label-position="right" label-width="90px" :inline=true class="form">
                <el-col :span="5">
                  <div>
                    <el-form-item :label="$t('settlement.persistencyReorganization.month')">
                      <el-date-picker
                        v-model="persistencyReorg.persistencyMonth"
                        type="month"
                        format="yyyy / MM"
                        value-format="yyyy-MM"
                        :picker-options="pickerOptions"
                        :clearable=false
                        :editable=false>
                      </el-date-picker>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col :span="19">
                  <el-form-item>
                    <el-button type="primary" @click="reCalculate">{{$t('common.reCalculate')}}</el-button>
                  </el-form-item>
                </el-col>
              </el-form>
            </el-row>
          </el-tab-pane>
          <el-tab-pane :label="$t('settlement.persistencyReorganization.persistencyQuery')">
            <el-row :gutter="20">
              <el-form label-position="right" label-width="90px" class="form" :inline=true>
                <el-col :span="19">
                  <el-form-item :label="$t('settlement.persistencyReorganization.month')">
                    <el-date-picker
                      v-model="persistencyQuery.persistencyMonth"
                      type="month"
                      format="yyyy / MM"
                      value-format="yyyy-MM"
                      :picker-options="pickerOptions"
                      :clearable=false
                      :editable=false>
                    </el-date-picker>
                  </el-form-item>
                  <el-form-item :label="$t('settlement.persistencyReorganization.calSpan')">
                    <el-select v-model="persistencyQuery.span">
                      <el-option :label="$t('settlement.persistencyReorganization.annual')" value="annual"></el-option>
                      <el-option :label="$t('settlement.persistencyReorganization.monthly')" value="monthly"></el-option>
                      <el-option :label="$t('settlement.persistencyReorganization.quarterly')" value="quarterly"></el-option>
                      <el-option :label="$t('settlement.persistencyReorganization.semiAnnual')" value="semiAnnual"></el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item :label="$t('settlement.persistencyReorganization.persistencyType')">
                    <el-select v-model="persistencyQuery.type">
                      <el-option label="R13" value="R13"></el-option>
                      <el-option label="R25" value="R25"></el-option>
                      <el-option label="R37" value="R37"></el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item :label="$t('settlement.persistencyReorganization.queryDimension')">
                    <el-select v-model="persistencyQuery.dimension">
                      <el-option :label="$t('settlement.persistencyReorganization.individual')" value="individual"></el-option>
                      <el-option :label="$t('settlement.persistencyReorganization.branch')" value="branch"></el-option>
                      <el-option :label="$t('settlement.persistencyReorganization.all')" value="all"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="5">
                  <el-form-item>
                    <el-button type="primary" @click="query">{{$t('common.search')}}</el-button>
                  </el-form-item>
                </el-col>
              </el-form>
            </el-row>
            <el-row v-if="listShown">
              <el-table
              :data="list"
              :header-cell-style="{ backgroundColor: '#f8f8f9', color: '#2c2c2c' }"
              max-height="750"
              fit
              border
              highlight-current-row
              @current-change="handleHighlightRowChange">
                <el-table-column type="index" width="50" align="center"></el-table-column>
                <el-table-column prop="persistencyMonth" width="200px" align="center" :label="$t('settlement.persistencyReorganization.persistencyMonth')"></el-table-column>
                <el-table-column prop="branch" width="200px" align="center" :label="$t('settlement.persistencyReorganization.apartment')"></el-table-column>
                <el-table-column prop="rank" width="200px" align="center" :label="$t('settlement.persistencyReorganization.rank')"></el-table-column>
                <el-table-column prop="employeeNo" width="250px" align="center" :label="$t('settlement.persistencyReorganization.employeeNo')"></el-table-column>
                <el-table-column prop="name" width="200px" align="center" :label="$t('settlement.persistencyReorganization.name')"></el-table-column>
                <el-table-column prop="persistencyReceivable" width="200px" align="center" :label="$t('settlement.persistencyReorganization.persistencyReceivable')"></el-table-column>
                <el-table-column prop="persistencyReceived" width="200px" align="center" :label="$t('settlement.persistencyReorganization.persistencyReceived')"></el-table-column>
                <el-table-column prop="R13" width="167px" align="center" label="R13"></el-table-column>
              </el-table>
            </el-row>
            <el-row v-if="listShown">
              <el-col>
                <el-pagination
                  :page-sizes="[10, 20, 30, 50]"
                  :page-size="10"
                  layout="total, sizes, prev, pager, next, jumper"
                  :total="total">
                </el-pagination>
              </el-col>
            </el-row>
            <el-row v-if="listShown">
              <el-col :span="6" :offset="18">
                <el-button plain size="medium" type="primary" @click="excelExport">{{$t('settlement.persistencyReorganization.excelExport')}}</el-button>
                <el-button plain size="medium" @click="detailExport">{{$t('settlement.persistencyReorganization.detailExport')}}</el-button>
                <el-button plain size="medium" @click="IPDetail">{{$t('settlement.persistencyReorganization.IPDetail')}}</el-button>
              </el-col>
            </el-row>
          </el-tab-pane>
        </el-tabs>
      </el-card>
    </el-row>

    <el-dialog :title="$t('settlement.persistencyReorganization.exportField')" :visible.sync="dialogTableVisible" width="18%">
      <el-table
        :data="fieldData"
        tooltip-effect="dark"
        @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="name" width="200px" align="center" :label="$t('settlement.persistencyReorganization.fieldName')"></el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogTableVisible = false">{{$t('common.cancel')}}</el-button>
        <el-button type="primary" @click="excelExportConfirm">{{$t('common.confirm')}}</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import ElCard from 'element-ui/packages/card/src/main'
  import ElTabPane from 'element-ui/packages/tabs/src/tab-pane'
  export default {
    name: 'persistencyReorganization',
    components: { ElTabPane, ElCard },
    data () {
      return {
        list: [],
        total: 0,
        listShown: false,
        currentRow: null,
        dialogTableVisible: false,
        selectedFields: [],
        fieldData: [],
        persistencyReorg: {
          persistencyMonth: ''
        },
        persistencyQuery: {
          persistencyMonth: '',
          span: '',
          type: '',
          dimension: ''
        },
        pickerOptions: {
          disabledDate: (time) => {
            return time.getTime() > Date.now()
          }
        }
      }
    },
    created () {
      this.createFieldData()
      this.setDefaultValue()
    },
    methods: {
      reCalculate () {
        // TODO: reCalculate Method
        console.log('ReCalculate submitted!')
      },
      query () {
        // TODO: query method
        this.list = [{
          persistencyMonth: '2010-01',
          branch: '黑龙江分公司',
          rank: '业务经理-标准',
          employeeNo: '6101101000001',
          name: '戴俊成',
          persistencyReceivable: '',
          persistencyReceived: '',
          R13: ''
        }, {
          persistencyMonth: '2010-01',
          branch: '恩施分公司',
          rank: '部门经理',
          employeeNo: '0501101000001',
          name: '金亮',
          persistencyReceivable: '',
          persistencyReceived: '',
          R13: ''
        }, {
          persistencyMonth: '2010-01',
          branch: '恩施分公司',
          rank: '内勤人员',
          employeeNo: '431103000002',
          name: '杜鑫',
          persistencyReceivable: '',
          persistencyReceived: '',
          R13: ''
        }, {
          persistencyMonth: '2010-01',
          branch: '湖南分公司',
          rank: '车险出单员',
          employeeNo: '4101103000003',
          name: '张杜娟',
          persistencyReceivable: '',
          persistencyReceived: '',
          R13: ''
        }, {
          persistencyMonth: '2010-01',
          branch: '湖南分公司',
          rank: '部门经理',
          employeeNo: '4102000002',
          name: '黄亚青',
          persistencyReceivable: '',
          persistencyReceived: '',
          R13: ''
        }]
        this.total = this.list.length
        this.listShown = true
        console.log('Query submitted!')
      },
      excelExport () {
        // TODO
        this.dialogTableVisible = true
        console.log('excelExport completed!')
      },
      detailExport () {
        // TODO
        console.log('detailExport completed!')
      },
      IPDetail () {
        // TODO
        console.log('IPDetail completed!')
      },
      handleHighlightRowChange (val) {
        this.currentRow = val
      },
      handleSelectionChange (val) {
        // TODO: 防止用户一个选项都没选
        this.selectedFields = val
      },
      createFieldData () {
        // TODO: 英文版本
        this.fieldData = [{
          name: '序号'
        }, {
          name: '继续率发生月份'
        }, {
          name: '单位'
        }, {
          name: '职级'
        }, {
          name: '员工编号'
        }, {
          name: '姓名'
        }, {
          name: '应收继续保费'
        }, {
          name: '实收继续保费'
        }, {
          name: 'R13'
        }]
      },
      excelExportConfirm () {
        // TODO
        this.dialogTableVisible = false
        console.log('Start Exporting Excel!')
      },
      setDefaultValue () {
        let currentDate = new Date()
        let currentYear = currentDate.getFullYear()
        let currentMonth = currentDate.getMonth() + 1
        this.persistencyQuery.persistencyMonth = this.persistencyReorg.persistencyMonth = currentYear + '-' + currentMonth
        this.persistencyQuery.dimension = 'individual'
        this.persistencyQuery.span = 'annual'
        this.persistencyQuery.type = 'R13'
        // TODO: fieldData default value
      }
    }
  }
</script>

<style lang="scss">
  .container {
    padding: 15px;
  }

  .el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }

  .form {
    margin-top: 20px;
  }
</style>
