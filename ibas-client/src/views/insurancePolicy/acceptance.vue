<template>
  <div class="container">
    <el-row>
      <el-card shadow="always">
        <div slot="header">
          <el-row :gutter="20" type="flex" align="middle">
            <el-col :span="21">
              <div class="search-bar">
                <el-select
                  multiple
                  collapse-tags
                  v-model="search.select"
                  slot="prepend"
                  @change="handleSearchSelect"
                  @remove-tag="tag => this.search.conditions[tag] = ''"
                  :placeholder="$t('insurancePolicy.acceptance.selectCondition')"
                  style="width: 200px">
                  <el-option
                    v-for="option in Object.keys(search.conditions)"
                    :key="option"
                    :disabled="search.select.includes('policyNo')&&option!=='policyNo'"
                    :label="$t(`insurancePolicy.acceptance.${option}`)"
                    :value="option">
                  </el-option>
                </el-select>
                <div class="search-input-tags">
                  <transition-group name="list-complete">
                    <input-tag
                      v-for="item in search.select"
                      :key="item"
                      :init-value="search.conditions[item]"
                      :tag-name="$t(`insurancePolicy.acceptance.${item}`)"
                      @confirm="data=>search.conditions[item]=data">
                    </input-tag>
                  </transition-group>
                </div>
              </div>
            </el-col>
            <el-col :span="3">
              <el-tooltip effect="dark" :content="$t('insurancePolicy.acceptance.addNew')" placement="top">
                <el-button type="primary" @click="addNew" style="float: right; padding: 10px" plain>
                  <svg-icon icon-class="plus"></svg-icon>
                </el-button>
              </el-tooltip>
              <el-tooltip effect="dark" :content="$t('insurancePolicy.acceptance.exportExcel')" placement="top">
                <el-button type="primary" @click="exportExcel" style="float: right; margin-right:10px;padding: 10px" plain>
                  <svg-icon icon-class="upload"></svg-icon>
                </el-button>
              </el-tooltip>
            </el-col>
          </el-row>
        </div>
        <el-row>
          <el-table
            v-loading="listLoading"
            :key="tableKey"
            :data="list"
            :header-cell-style="{ backgroundColor: '#f8f8f9', color: '#2c2c2c' }"
            max-height="650"
            fit
            border>
            <el-table-column type="index" width="50" align="center"></el-table-column>
            <el-table-column prop="relateNo" width="120px" :label="$t('insurancePolicy.acceptance.relateNo')" ></el-table-column>
            <el-table-column prop="policyNo" width="120px" :label="$t('insurancePolicy.acceptance.policyNo')" ></el-table-column>
            <!--insurer filter-->
            <el-table-column
              width="100px"
              align="center"
              :label="$t('insurancePolicy.acceptance.insurer')">
              <!--eslint-disable-next-line-->
              <template slot="header" slot-scope="scope">
                <table-filter
                  mode="list"
                  :filter="filters.insurers"
                  :reference="$t('insurancePolicy.acceptance.insurer')"
                  :filterText="$t('common.filter')"
                  :resetText="$t('common.reset')"
                  @confirm-filter="filter($event,'insurer')">
                </table-filter>
              </template>
              <template slot-scope="scope">{{ scope.row.insurer }}</template>
            </el-table-column>
            <!--status filter-->
            <el-table-column
              prop="policyStatus"
              width="100px"
              align="center"
              :label="$t('insurancePolicy.acceptance.status')">
              <!--eslint-disable-next-line-->
              <template slot="header" slot-scope="scope">
                <table-filter
                  mode="list"
                  :filter="filters.statuses"
                  :reference="$t('insurancePolicy.acceptance.status')"
                  :filterText="$t('common.filter')"
                  :resetText="$t('common.reset')"
                  @confirm-filter="filter($event,'status')">
                </table-filter>
              </template>
              <template slot-scope="scope">{{ scope.row.status }}</template>
            </el-table-column>
            <el-table-column prop="holder" width="100px" align="center" :label="$t('insurancePolicy.acceptance.holder')" ></el-table-column>
            <el-table-column prop="agent" width="100px" align="center" :label="$t('insurancePolicy.acceptance.agent')" ></el-table-column>
            <el-table-column prop="employee" width="100px" align="center" :label="$t('insurancePolicy.acceptance.employee')" ></el-table-column>
            <!--check in date filter-->
            <el-table-column width="120px" align="center">
              <!--eslint-disable-next-line-->
              <template slot="header" slot-scope="scope">
                <TableFilter
                  mode="date"
                  :reference="$t('insurancePolicy.acceptance.checkInDate')"
                  :startDateText="$t('insurancePolicy.acceptance.startDate')"
                  :endDateText="$t('insurancePolicy.acceptance.endDate')"
                  :filterText="$t('common.filter')"
                  :resetText="$t('common.reset')"
                  @confirm-filter="filter($event,'checkInDate')">
                </TableFilter>
              </template>
              <template slot-scope="scope">{{ scope.row.checkInDate }}</template>
            </el-table-column>
            <!--valid date filter-->
            <el-table-column width="120px" align="center" >
              <!--eslint-disable-next-line-->
              <template slot="header" slot-scope="scope">
                <TableFilter
                  mode="date"
                  :reference="$t('insurancePolicy.acceptance.validDate')"
                  :startDateText="$t('insurancePolicy.acceptance.startDate')"
                  :endDateText="$t('insurancePolicy.acceptance.endDate')"
                  :filterText="$t('common.filter')"
                  :resetText="$t('common.reset')"
                  @confirm-filter="filter($event,'validDate')">
                </TableFilter>
              </template>
              <template slot-scope="scope">{{ scope.row.validDate }}</template>
            </el-table-column>
            <!--period filter-->
            <el-table-column width="100px" align="center" >
              <!--eslint-disable-next-line-->
              <template slot="header" slot-scope="scope">
                <TableFilter
                  mode="range"
                  :reference="$t('insurancePolicy.acceptance.period')"
                  :filterText="$t('common.filter')"
                  :resetText="$t('common.reset')"
                  @confirm-filter="filter($event,'period')">
                </TableFilter>
              </template>
              <template slot-scope="scope">{{ scope.row.period }}</template>
            </el-table-column>
            <el-table-column prop="policyCode" width="100px" align="center" :label="$t('insurancePolicy.acceptance.policyCode')" ></el-table-column>
            <!--insurance filter-->
            <el-table-column
              prop="insurance"
              width="120px"
              align="center"
              :label="$t('insurancePolicy.acceptance.insurance')">
              <!--eslint-disable-next-line-->
              <template slot="header" slot-scope="scope">
                <table-filter
                  mode="list"
                  :filter="filters.insurances"
                  :reference="$t('insurancePolicy.acceptance.insurance')"
                  :filterText="$t('common.filter')"
                  :resetText="$t('common.reset')"
                  @confirm-filter="filter($event,'insurance')">
                </table-filter>
              </template>
              <template slot-scope="scope">{{ scope.row.insurance }}</template>
            </el-table-column>
            <el-table-column prop="insured" width="100px" align="center" :label="$t('insurancePolicy.acceptance.insured')" ></el-table-column>
            <el-table-column prop="account" width="100px" align="center" :label="$t('insurancePolicy.acceptance.account')" ></el-table-column>
            <el-table-column prop="unit" width="100px" align="center" :label="$t('insurancePolicy.acceptance.unit')" ></el-table-column>
            <el-table-column prop="premium" width="100px" align="center" :label="$t('insurancePolicy.acceptance.premium')" ></el-table-column>
            <el-table-column prop="agentType" width="100px" align="center" :label="$t('insurancePolicy.acceptance.agentType')" ></el-table-column>
            <el-table-column
              fixed="right"
              :label="$t('insurancePolicy.acceptance.operation')"
              align="center"
              width="100">
              <template slot-scope="scope">
                <el-button @click="rowEdit(scope.row, scope.$index)" type="text" size="mini">{{ $t('common.edit') }}</el-button>
                <popover-tip
                  :message="$t('common.delConfirm')"
                  :confirm-text="$t('common.confirm')"
                  :cancel-text="$t('common.cancel')"
                  @popover-tip-confirm="rowDel(scope.$index)">
                  <el-button type="text" size="mini" style="color: #f56c6c;margin-left: 5px;">{{ $t('common.delete') }}</el-button>
                </popover-tip>
              </template>
            </el-table-column>
          </el-table>
        </el-row>
        <el-row>
          <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" :background="false" @pagination="getList" />
        </el-row>
      </el-card>
    </el-row>

    <el-dialog
      :title="$t('insurancePolicy.acceptance.policyInfo')"
      width="55%"
      @close="dialogClose"
      :visible.sync="editorVisible">
      <el-form
        label-position="top"
        size="mini"
        ref="policyInfo"
        :model="policyInfo"
        label-width="150"
        :inline="true">
        <el-row>
          <el-form-item :label="$t('insurancePolicy.acceptance.insurer')">
            <el-autocomplete
              v-model="policyInfo.insurer"
              :fetch-suggestions="insurerNameQuerySearch"
              @select="handleInsurerSelect"
              :placeholder="$t('common.pleaseInput')">
              <template slot-scope="{ item }">
                <div>{{ item }}</div>
              </template>
            </el-autocomplete>
          </el-form-item>
          <el-form-item :label="$t('insurancePolicy.acceptance.checkInDate')">
            <el-date-picker :placeholder="$t('common.pleaseSelect')" type="date" v-model="policyInfo.checkInDate"></el-date-picker>
          </el-form-item>
          <el-form-item :label="$t('insurancePolicy.acceptance.status')">
            <el-select v-model="policyInfo.status" :placeholder="$t('common.pleaseSelect')">
              <el-option
                v-for="item in filters.statuses"
                :key="item"
                :label="item"
                :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :label="$t('insurancePolicy.acceptance.receipt')">
            <el-select v-model="policyInfo.receipt" :placeholder="$t('common.pleaseSelect')">
              <el-option
                v-for="item in filters.receipts"
                :key="item"
                :label="item"
                :value="item">
              </el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item :label="$t('insurancePolicy.acceptance.paymentCategories')">
            <el-select v-model="policyInfo.paymentCategory" :placeholder="$t('common.pleaseSelect')">
              <el-option
                v-for="item in filters.paymentCategories"
                :key="item"
                :label="item"
                :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :label="$t('insurancePolicy.acceptance.paymentMethods')">
            <el-select v-model="policyInfo.paymentMethod" :placeholder="$t('common.pleaseSelect')">
              <el-option
                v-for="item in filters.paymentMethods"
                :key="item"
                :label="item"
                :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :label="$t('insurancePolicy.acceptance.validDate')">
            <el-date-picker :placeholder="$t('common.pleaseSelect')" type="date" v-model="policyInfo.validDate"></el-date-picker>
          </el-form-item>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item :label="$t('insurancePolicy.acceptance.holder')">
              <popover-tip
                v-if="policyInfo.holder.name"
                ref="holder"
                :message="$t('common.delConfirm')"
                :confirm-text="$t('common.confirm')"
                :cancel-text="$t('common.cancel')"
                mode="manual"
                @popover-tip-confirm="policyholderDel()">
                <el-tag
                  closable
                  @close="$refs.holder.show()">
                  <svg-icon icon-class="user"></svg-icon>
                  {{ policyInfo.holder.name }}
                </el-tag>
              </popover-tip>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item :label="$t('insurancePolicy.acceptance.insured')">
              <popover-tip
                v-if="policyInfo.insured.name"
                ref="insured"
                :message="$t('common.delConfirm')"
                :confirm-text="$t('common.confirm')"
                :cancel-text="$t('common.cancel')"
                mode="manual"
                @popover-tip-confirm="insuredDel()">
                <el-tag
                  closable
                  @close="$refs.insured.show()"
                  type="success">
                  <svg-icon icon-class="user"></svg-icon>
                  {{ policyInfo.insured.name }}
                </el-tag>
              </popover-tip>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item :label="$t('insurancePolicy.acceptance.agentType')">
              <el-select v-model="policyInfo.agentType" :placeholder="$t('common.pleaseSelect')">
                <el-option
                  v-for="item in filters.agentTypes"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="16">
            <el-form-item :label="$t('insurancePolicy.acceptance.employees')" class="employee-tags">
              <popover-tip
                v-for="employee in policyInfo.employees"
                :key="employee.id"
                :ref="`employee_${employee.id}`"
                :message="$t('common.delConfirm')"
                :confirm-text="$t('common.confirm')"
                :cancel-text="$t('common.cancel')"
                mode="manual"
                @popover-tip-confirm="employeeDel(employee.id)">
                <el-tag
                  type="info"
                  closable
                  @close="$refs[`employee_${employee.id}`][0].show()">
                  <svg-icon icon-class="user"></svg-icon>
                  {{ employee.name }} - {{ employee.type  }}
                </el-tag>
              </popover-tip>
              <template v-if="policyInfo.tagInputVisible">
                <el-autocomplete
                  class="input-new-tag"
                  popper-class="employee-popper"
                  v-model="policyInfo._employee.name"
                  ref="saveTagInput"
                  size="small"
                  @keyup.enter.native="handleInputConfirm"
                  @select="handleEmployeeSelect"
                  :fetch-suggestions="employeeQuery"
                  @clear="inputFocus"
                  clearable>
                  <template slot-scope="{ item }">
                    <div class="name">{{ item.name }}</div>
                    <div class="type">{{ item.type }}</div>
                  </template>
                </el-autocomplete>
                <el-button-group>
                  <el-button @click="handleInputConfirm" type="success" icon="el-icon-check"></el-button>
                  <el-button @click="employeeAddCancel" type="danger" icon="el-icon-close"></el-button>
                </el-button-group>
              </template>
              <el-button v-else class="button-new-tag" size="small" @click="showTagInput">
                <svg-icon icon-class="user-plus"></svg-icon>
              </el-button>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="danger" @click="editorVisible = false" plain>{{ $t('common.cancel') }}</el-button>
        <el-button type="primary" @click="dialogConfirm" plain>{{ $t('common.confirm') }}</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<style lang="scss">
.container {

  .search-bar {

    .search-input-tags{
      padding:0 10px;
      height: 34px;
      line-height: 34px;
      left: 200px;
      position: absolute;
      z-index: 1;
      top: 0;
      right: 56px;
    }
  }

  .el-tag {
    cursor: pointer;
  }

  .button-new-tag {
    margin-left: 10px;
    height: 28px;
    line-height: 26px;
    padding-top: 0;
    padding-bottom: 0;
  }
  .input-new-tag {
    width: 90px;
    margin-left: 10px;
    vertical-align: bottom;

    input {
      height: 28px !important;
    }
  }

  .input-with-select .el-input-group__prepend {
    background-color: #fff;
  }

  .popover-button {
    background: transparent;
    border: none;
    color: #606266;
    cursor: pointer;
    font-size: 13px;
    padding: 0 3px;

    &:hover{
      color: $--color-primary;
    }
  }

  .employee-tags {
    span+span{
      margin-left: 10px;
    }
  }
}

  .employee-popper {

    li {
      line-height: normal;
      padding: 7px;

      .name {
        text-overflow: ellipsis;
        overflow: hidden;
      }
      .type {
        font-size: 12px;
        color: #b4b4b4;
      }

      .highlighted .type {
        color: #ddd;
      }
    }
  }
</style>

<script>
  import { Pagination, PopoverTip, TableFilter, InputTag } from '@/components'
  import { fetchList, fetchFilters, queryEmployee } from '@/api'
  import { initObject } from '@/shared'

  export default {
    name: 'acceptance',
    components: { Pagination, PopoverTip, TableFilter, InputTag },
    data () {
      return {
        tableKey: 0,
        list: [],
        total: 0,
        listLoading: true,
        delTipVisible: false,
        editorVisible: false,
        listQuery: {
          page: 1,
          limit: 10
        },
        search: {
          conditions: {
            policyNo: '',
            relateNo: '',
            holder: '',
            holderCode: '',
            insured: '',
            agent: '',
            employee: ''
          },
          select: []
        },
        filters: {
          insurers: [],
          statuses: [],
          insurances: [],
          paymentCategories: [],
          paymentMethods: [],
          receipts: [],
          agentTypes: [],
          conditions: {
            insurer: [],
            status: [],
            insurance: [],
            checkInDate: [],
            validDate: [],
            period: []
          }
        },
        operation: {
          batch: false
        },
        policyInfo: {
          status: '',
          insurer: '',
          checkInDate: '',
          paymentCategory: '',
          paymentMethod: '',
          receipt: '',
          validDate: '',
          holder: {
            id: 1,
            name: '佐助'
          },
          insured: {
            id: 1,
            name: '佐助'
          },
          agentType: '',
          employees: [
            {
              id: 1,
              name: '艾',
              type: '承揽人'
            },
            {
              id: 2,
              name: '纲手',
              type: '收费员'
            }
          ],
          tagInputVisible: false,
          _employee: {
            name: '',
            value: {}
          }
        }
      }
    },
    created () {
      this.getList()
      this.getFilters()
    },
    watch: {
      'search.conditions': {
        handler () {
          this.getList()
        },
        deep: true
      },
      'filters.conditions': {
        handler () {
          this.getList()
        },
        deep: true
      }
    },
    methods: {
      getList (): void {
        this.listLoading = true
        fetchList(this.listQuery, this.search.conditions, this.filters.conditions).then(data => {
          this.list = data.items
          this.total = data.total

          // Just to simulate the time of the request
          setTimeout(() => {
            this.listLoading = false
          }, 200)
        }, error => {
          // error
          console.log(error)
        })
      },
      insurerNameQuerySearch (queryString?: string, callback: Function): void {
        callback(queryString ? this.filters.insurers.filter(item => item.toLowerCase().includes(queryString.toLowerCase())) : this.filters.insurers)
      },
      getFilters (): void {
        fetchFilters().then(data => {
          for (let key in data) {
            if (data.hasOwnProperty(key)) {
              if (this.filters.hasOwnProperty(key)) {
                this.filters[key] = data[key]
              }
            }
          }
        })
      },
      filter (condition: string|Array, type: string): void {
        this.filters.conditions[type] = condition
      },
      rowEdit (row: Object, index: Number): void {
        // mock
        this.policyInfo.$index = index
        for (let key in row) {
          if (row.hasOwnProperty(key)) {
            if (this.policyInfo.hasOwnProperty(key)) {
              this.policyInfo[key] = row[key]
            }
          }
        }
        this.editorVisible = true
      },
      rowDel (index: Number): void {
        this.delTipVisible = false
        this.list.splice(index, 1)
        // ...api
      },
      handleInputConfirm (): void {
        let value = this.policyInfo._employee.value
        if (value) {
          this.policyInfo.employees.push(value)
        }
        this.policyInfo.tagInputVisible = false
        this.policyInfo._employee = {
          name: '',
          value: {}
        }
      },
      showTagInput (): void {
        this.policyInfo.tagInputVisible = true
        this.inputFocus()
      },
      inputFocus () {
        this.$nextTick(() => {
          this.$refs.saveTagInput.$refs.input.focus()
        })
      },
      policyholderDel (): void {
        this.policyInfo.holder = {}
        // api...
      },
      insuredDel () :void {
        this.policyInfo.insured = {}
      },
      handleInsurerSelect (item: Object): void {
        this.policyInfo.insurer = item
      },
      handleEmployeeSelect (item: Object): void {
        this.policyInfo._employee.value = item
        this.policyInfo._employee.name = item.name
      },
      employeeDel (employeeId: string): void {
        const index = this.policyInfo.employees.findIndex(item => item.id === employeeId)
        if (index > -1) {
          this.policyInfo.employees.splice(index, 1)
          // api...
        }
      },
      employeeQuery (queryString: string, callback: Function): void {
        queryEmployee(queryString)
          .then(data => {
            callback(data)
          })
      },
      employeeAddCancel (): void {
        this.policyInfo.tagInputVisible = false
        this.policyInfo._employee = {
          name: '',
          value: {}
        }
      },
      handleSearchSelect ():void {
        if (this.search.select.includes('policyNo')) {
          for (let item of this.search.select) {
            if (item !== 'policyNo') this.search.conditions[item] = ''
          }
          this.search.select = ['policyNo']
        }
      },
      dialogConfirm (): void {
        if (this.policyInfo.$index) {
          let item = this.list[this.policyInfo.$index]
          for (let key in item) {
            if (item.hasOwnProperty(key)) {
              if (this.policyInfo.hasOwnProperty(key)) {
                item[key] = this.policyInfo[key]
              }
            }
          }
        }
        this.editorVisible = false
      },
      dialogClose (): void {
        if (this.policyInfo.$index > -1) {
          delete this.policyInfo.$index
        }
      },
      addNew (): void {
        initObject(this.policyInfo)
        this.editorVisible = true
      },
      exportExcel ():void {}
    }
  }
</script>
