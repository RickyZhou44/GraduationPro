<template>
  <div class="container">
    <el-row>
      <el-card shadow="always">
        <el-row :gutter="20">
          <el-col :span="22">
            <div class="search-bar">
              <el-input
                :placeholder="$t('customer.relationship.conditionalSearch')"
                v-model="search.content"
                class="input-with-select"
                clearable>
                <el-select
                  v-model="search.select"
                  slot="prepend"
                  style="width: 200px"
                  multiple
                  collapse-tags
                  :placeholder="$t('common.pleaseSelect')"
                  @remove-tag="tag => this.search.conditions[tag] = ''">
                  <!--@change="handleSearchSelect"-->
                  <el-option :label="$t('customer.relationship.clientName')" value="clientName"></el-option>
                  <el-option :label="$t('customer.relationship.relationTelList.idCard')" value="idCard"></el-option>
                  <el-option :label="$t('customer.relationship.homeTelList.address')" value="address"></el-option>
                  <el-option :label="$t('customer.relationship.homeTelList.tel')" value="tel"></el-option>
                  <el-option :label="$t('customer.relationship.homeTelList.email')" value="email"></el-option>
                </el-select>
                <el-button slot="append" icon="el-icon-search" @click="getList"></el-button>
              </el-input>
              <div class="search-input-tags">
                <input-tag
                  v-for="item in search.select"
                  :key="item"
                  :init-value="search.conditions[item]"
                  :tag-name="$t(`customer.relationship.${item}`)"
                  @confirm="data=>search.conditions[item]=data">
                </input-tag>
              </div>
            </div>
          </el-col>
          <el-col :span="2">
            <el-tooltip effect="dark" :content="$t('customer.relationship.addNew')" placement="top">
              <el-button type="primary" icon="el-icon-plus" circle @click="addNew"></el-button>
            </el-tooltip>
          </el-col>
        </el-row>
        <el-row>
          <el-table
            v-loading="listLoading"
            :key="tableKey"
            :data="list"
            :header-cell-style="{ backgroundColor: '#f8f8f9', color: '#2c2c2c' }"
            max-height="750"
            fit
            border>
            <el-table-column type="index" width="50" align="center"></el-table-column>
            <el-table-column prop="clientName" width="140px" :label="$t('customer.relationship.clientName')" ></el-table-column>
            <el-table-column
              prop="idCard"
              width="140px"
              align="center"
              :label="$t('customer.relationship.relationTelList.idCard')">
            </el-table-column>
            <el-table-column
              prop="sex"
              width="140px"
              align="center"
              :label="$t('customer.relationship.sex')"
              :filters="filters.sex"
              :filter-method="sexFilters"
              filter-placement="bottom-end" >
            </el-table-column>
            <el-table-column prop="address" width="120px" :label="$t('customer.relationship.homeTelList.address')" ></el-table-column>
            <el-table-column prop="tel" width="120px" :label="$t('customer.relationship.homeTelList.tel')" ></el-table-column>
            <el-table-column prop="email" width="120px" :label="$t('customer.relationship.homeTelList.email')" ></el-table-column>
            <el-table-column prop="birthday" width="120px" :label="$t('customer.relationship.birthday')" ></el-table-column>
            <el-table-column
              prop="clientType"
              width="140px"
              align="center"
              :label="$t('customer.relationship.clientType')"
              :filters="filters.clientType"
              :filter-method="clientTypeFilters"
              filter-placement="bottom-end" >
            </el-table-column>
            <el-table-column
              fixed="right"
              :label="$t('customer.relationship.operation')"
              align="center"
              width="120">
              <template slot-scope="scope">
                <el-button @click="rowEdit(scope.row)" type="text" size="mini">{{ $t('common.edit') }}</el-button>
                <popover-tip
                  :message="$t('common.delConfirm')"
                  :confirm-text="$t('common.confirm')"
                  :cancel-text="$t('common.cancel')"
                  @popover-tip-confirm="rowDel(scope.row)">
                  <el-button type="text" size="mini" style="color: #f56c6c;margin-left: 5px;">{{ $t('common.delete') }}</el-button>
                </popover-tip>
              </template>
            </el-table-column>
          </el-table>
        </el-row>
        <el-row>
          <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />
        </el-row>
      </el-card>
    </el-row>
    <el-dialog
      :title="$t('customer.relationship.dialog.title')"
      width="70%"
      :visible.sync="editorVisible">
      <el-row>
        <el-card shadow="always">
          <el-tabs type="card">
            <el-tab-pane :label="$t('customer.relationship.dialog.baseInfo')">
              <el-form
                label-position="top"
                size="mini"
                ref="baseInfo"
                :model="baseInfo"
                label-width="150"
                :rules="baseInfoRules"
                :inline="true">
                <el-row>
                  <el-form-item prop="name">
                    <el-input v-model="baseInfo.name" style="width: 250px">
                      <template slot="prepend">{{$t('customer.relationship.baseInfo.name')}}</template>
                    </el-input>
                  </el-form-item>
                  <el-form-item prop="identity">
                    <el-select
                        style="width: 250px"
                        v-model="baseInfo.identity"
                        :placeholder="$t('customer.relationship.baseInfo.identity')">
                        <el-option
                          v-for="item in filters.identities"
                          :key="item"
                          :label="item"
                          :value="item">
                        </el-option>
                      </el-select>
                  </el-form-item>
                  <el-form-item prop="type">
                    <el-select
                      style="width: 250px"
                      v-model="baseInfo.type"
                      :placeholder="$t('customer.relationship.baseInfo.type')">
                      <el-option
                        v-for="item in filters.types"
                        :key="item"
                        :label="item"
                        :value="item">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-row>
                <el-row>
                  <el-form-item prop="nation">
                      <el-select
                        style="width: 185px"
                        v-model="baseInfo.nation"
                        :placeholder="$t('customer.relationship.baseInfo.nation')">
                        <el-option
                          v-for="item in filters.nations"
                          :key="item"
                          :label="item"
                          :value="item">
                        </el-option>
                      </el-select>
                  </el-form-item>
                  <el-form-item prop="certfType">
                      <el-select
                        style="width: 185px"
                        v-model="baseInfo.certfType"
                        :placeholder="$t('customer.relationship.baseInfo.certfType')">
                        <el-option
                          v-for="item in filters.certfTypes"
                          :key="item"
                          :label="item"
                          :value="item">
                        </el-option>
                      </el-select>
                  </el-form-item>
                  <el-form-item prop="certfId">
                      <el-input style="width: 185px" v-model="baseInfo.certfId" :placeholder="$t('customer.relationship.baseInfo.certfId')">
                      </el-input>
                  </el-form-item>
                  <el-form-item>
                      <el-date-picker
                        style="width: 185px"
                        v-model="baseInfo.birthday"
                        :placeholder="$t('customer.relationship.baseInfo.birthday')">
                      </el-date-picker>
                  </el-form-item>
                </el-row>
                <el-row>
                  <el-form-item prop="sex">
                    <el-select
                      style="width: 250px"
                      v-model="baseInfo.sex"
                      :placeholder="$t('customer.relationship.baseInfo.sex')">
                      <el-option
                        v-for="item in filters.sexs"
                        :key="item"
                        :label="item"
                        :value="item">
                      </el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item>
                    <el-select
                      style="width: 250px"
                      v-model="baseInfo.married"
                      :placeholder="$t('customer.relationship.baseInfo.married')">
                      <el-option
                        v-for="item in filters.marrieds"
                        :key="item"
                        :label="item"
                        :value="item">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-row>
                <el-row>
                  <el-form-item>
                      <el-input v-model="baseInfo.telephone" style="width: 250px">
                        <template slot="prepend">{{$t('customer.relationship.baseInfo.telephone')}}</template>
                      </el-input>
                  </el-form-item>
                  <el-form-item>
                      <el-input v-model="baseInfo.email" style="width: 250px">
                        <template slot="prepend">{{$t('customer.relationship.baseInfo.email')}}</template>
                      </el-input>
                  </el-form-item>
                  <el-form-item>
                      <el-input v-model="baseInfo.phone" style="width: 250px;">
                        <template slot="prepend">{{$t('customer.relationship.baseInfo.phone')}}</template>
                      </el-input>
                  </el-form-item>
                </el-row>
                <el-row>
                  <el-form-item>
                      <el-input type="text" v-model="baseInfo.backup" style="width: 770px">
                        <template slot="prepend">{{$t('customer.relationship.baseInfo.backup')}}</template>
                      </el-input>
                  </el-form-item>
                </el-row>
                <el-row>
                  <el-form-item>
                      <el-input v-model="baseInfo.homeAddress" style="width: 250px">
                        <template slot="prepend">{{$t('customer.relationship.baseInfo.homeAddress')}}</template>
                      </el-input>
                  </el-form-item>
                  <el-form-item>
                      <el-input v-model="baseInfo.homeCode" style="width: 250px">
                        <template slot="prepend">{{$t('customer.relationship.baseInfo.homeCode')}}</template>
                      </el-input>
                  </el-form-item>
                  <el-form-item prop="firstContactWay">
                      <el-select
                        style="width: 250px"
                        v-model="baseInfo.firstContactWay"
                        :placeholder="$t('customer.relationship.baseInfo.firstContactWay')">
                        <el-option
                          v-for="item in filters.contacts"
                          :key="item"
                          :label="item"
                          :value="item">
                        </el-option>
                      </el-select>
                  </el-form-item>
                </el-row>
                <el-row>
                  <el-form-item>
                      <el-input v-model="baseInfo.other" type="text" style="width: 770px">
                        <template slot="prepend">{{$t('customer.relationship.baseInfo.other')}}</template>
                      </el-input>
                  </el-form-item>
                </el-row>
              </el-form>
            </el-tab-pane>
            <el-tab-pane :label="$t('customer.relationship.dialog.unitInfo')">
              <el-form
                label-position="top"
                size="mini"
                ref="unitInfo"
                :model="unitInfo"
                label-width="150"
                :inline="true">
                <el-row>
                  <el-form-item>
                    <el-input v-model="unitInfo.comName">
                      <template slot="prepend">{{$t('customer.relationship.unitInfo.comName')}}</template>
                    </el-input>
                  </el-form-item>
                </el-row>
                <el-row>
                  <el-form-item>
                    <el-col :span="12">
                      <el-input v-model="unitInfo.comPhone">
                        <template slot="prepend">{{$t('customer.relationship.unitInfo.comPhone')}}</template>
                      </el-input>
                    </el-col>
                    <el-col :span="12">
                      <el-input v-model="unitInfo.faxNo">
                        <template slot="prepend">{{$t('customer.relationship.unitInfo.faxNo')}}</template>
                      </el-input>
                    </el-col>
                  </el-form-item>
                </el-row>
                <el-row>
                  <el-form-item>
                    <el-col :span="12">
                      <el-input v-model="unitInfo.representative">
                        <template slot="prepend">{{$t('customer.relationship.unitInfo.representative')}}</template>
                      </el-input>
                    </el-col>
                    <el-col :span="12">
                      <el-input v-model="unitInfo.taxNo">
                        <template slot="prepend">{{$t('customer.relationship.unitInfo.taxNo')}}</template>
                      </el-input>
                    </el-col>
                  </el-form-item>
                </el-row>
                <el-row>
                  <el-form-item>
                    <el-input v-model="unitInfo.comAddress">
                      <template slot="prepend">{{$t('customer.relationship.unitInfo.comAddress')}}</template>
                    </el-input>
                  </el-form-item>
                </el-row>
                <el-row>
                  <el-form-item>
                    <el-input v-model="unitInfo.jobName">
                      <template slot="prepend">{{$t('customer.relationship.unitInfo.jobName')}}</template>
                    </el-input>
                  </el-form-item>
                </el-row>
                <el-row>
                  <el-form-item>
                    <el-input v-model="unitInfo.jobContent">
                      <template slot="prepend">{{$t('customer.relationship.unitInfo.jobContent')}}</template>
                    </el-input>
                  </el-form-item>
                </el-row>
                <el-row>
                  <el-form-item>
                    <el-select
                      style="width: 100%"
                      v-model="unitInfo.jobType"
                      :placeholder="$t('customer.relationship.unitInfo.jobType')">
                      <el-option
                        v-for="item in filters.jobTypes"
                        :key="item"
                        :label="item"
                        :value="item">
                      </el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item>
                    <el-select
                      style="width: 100%"
                      v-model="unitInfo.income"
                      :placeholder="$t('customer.relationship.unitInfo.income')">
                      <el-option
                        v-for="item in filters.incomes"
                        :key="item"
                        :label="item"
                        :value="item">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-row>
              </el-form>
            </el-tab-pane>
          </el-tabs>
        </el-card>
      </el-row>
      <span slot="footer" class="dialog-footer">
        <el-button @click="editorVisible = false">{{ $t('common.cancel') }}</el-button>
        <el-button type="primary" @click="submitForm">{{ $t('common.confirm') }}</el-button>
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
        top: 1px;
        right: 56px;

        .input-tag {

          &+.input-tag {
            margin-left: 10px;
          }

          .el-button {
            max-width: 90px;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
          }

          .el-input {
            min-width: 90px;
            max-width: 120px;
          }
        }
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
  import { Pagination, PopoverTip, InputTag } from '@/components'
  import customer from '@/mock/templates/customer'
  import { getCustomer, addCustomer } from '@/api/customer/index'

  export default {
    name: 'customer',
    components: { Pagination, PopoverTip, InputTag },
    methods: {
      validateForm (): boolean {
        this.$refs['baseInfo'].validate((valid) => {
          if (valid) {
            alert()
            return true
          } else {
            alert(valid)
            return false
          }
        })
      },
      submitForm (): void {
        this.$refs['baseInfo'].validate((valid) => {
          if (valid) {
            let searchJson = {
              baseInfo: this.baseInfo,
              unitInfo: this.unitInfo
            }
            console.log(searchJson)
            addCustomer(searchJson).then(data => {
              console.log(data)
            })
            alert()
          }
        })
      },
      addNew (): void {
        this.editorVisible = true
      },
      getList (): void {
        console.log(this.search.conditions)
        this.listLoading = true
        getCustomer(this.search.conditions).then(data => {
          //
          // eslint-disable-next-line
        }, error => {
          this.listLoading = false
          this.list = customer.data
          this.total = customer.data.length
          console.log(customer)
        })
        setTimeout(() => {
          this.listLoading = false
        }, 300)
      },
      // telFilters (value: string, row: Object): boolean {
      //   return row.relationTel === value
      // },
      sexFilters (value: string, row: Object): boolean {
        return row.sex === value
      },
      clientTypeFilters (value: string, row: Object): boolean {
        return row.clientType === value
      },
      rowEdit (row: Object): void {

      },
      rowDel (row: Object): void {
        this.delTipVisible = false
        this.list.splice(row.$index, 1)
        // ...api
      }
    },
    created () {
      this.getList()
      // this.filters.telType = ['身份证号', '保单号码', '相关号码'].map(x => { return { text: x, value: x } })
      this.filters.sex = ['男', '女'].map(x => { return { text: x, value: x } })
      this.filters.clientType = ['已投保客户', '潜在客户', '团险客户'].map(x => { return { text: x, value: x } })
    },
    data () {
      return {
        baseInfoRules: {
          name: [
            { required: true, message: '请输入姓名', trigger: 'blur' },
            { min: 1, max: 20, message: '长度在1-20个字符', trigger: 'blur' }
          ],
          identity: [
            { required: true, message: '请选择法律身份', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '请选择客户类型', trigger: 'blur' }
          ],
          nation: [
            { required: true, message: '请选择国籍', trigger: 'blur' }
          ],
          certfType: [
            { required: true, message: '请选择证件类型', trigger: 'blur' }
          ],
          certfId: [
            { required: true, message: '请输入证件号', trigger: 'blur' },
            { max: 50, message: '长度在0-50字符', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '请选择性别', trigger: 'blur' }
          ],
          firstContactWay: [
            { required: true, message: '请选择首选联系方式', trigger: 'blur' }
          ]
        },
        editorVisible: false,
        total: 0,
        tableKey: 0,
        list: [],
        listLoading: true,
        listQuery: {
          page: 1,
          limit: 10,
          importance: undefined,
          title: undefined,
          type: undefined
        },
        baseInfo: {
          name: '',
          identity: '',
          type: '',
          nation: '',
          certfType: '',
          certfId: '',
          birthday: '',
          sex: '',
          married: '',
          telephone: '',
          phone: '',
          email: '',
          backup: '',
          homeAddress: '',
          homeCode: '',
          firstContactWay: '',
          other: ''
        },
        unitInfo: {
          comName: '',
          comPhone: '',
          faxNo: '',
          representative: '',
          taxNo: '',
          comAddress: '',
          jobName: '',
          jobType: '',
          jobContent: '',
          income: ''
        },
        search: {
          conditions: {
            clientName: '',
            idCard: '',
            address: '',
            tel: '',
            email: ''
          },
          select: []
        },
        filters: {
          telType: [],
          sex: [],
          clientType: [],
          identities: ['自然人', '法人'],
          types: ['已投保客户', '潜在客户', '团险客户'],
          nations: ['中国', '外籍', '港澳台'],
          certfTypes: ['身份证', '军官证', '出生证', '台胞证', '护照', '港澳通行证'],
          contacts: ['手机', '家庭电话', '公司电话'],
          sexs: ['男', '女'],
          marrieds: ['已婚', '未婚', '离异', '丧偶'],
          jobTypes: ['在校研究生', '应届毕业生', '公职人员', '军人', '科技人员', '教师', '企事业职员', '务工人员',
                     '其他'],
          incomes: ['15万以内', '13-30万', '30-50万', '50-80万', '80-100万', '100-200万', '200-500万', '500万以上']
        }
      }
    }
  }
</script>
