<template>
  <div class="container">
    <el-row>
      <el-card shadow="always">
        <el-form>
          <el-row>
            <el-form-item>
              <el-input
                style="width: 90%; margin-left: 5px"
                v-model="root"
                disabled
                clearable
                :placeholder="$t('humanCapital.personnelOrganization.root')">
                <el-button type="primary" slot="prepend" @click="dialog1Visible=true">
                  {{$t('humanCapital.personnelOrganization.root')}}
                </el-button>
              </el-input>
            </el-form-item>
          </el-row>
          <el-row>
            <el-form-item>
              {{$t('humanCapital.personnelOrganization.type')}}
              &nbsp;&nbsp;
              <el-select v-model="type">
                <el-option
                  v-for="item in filters.types"
                  :key="item"
                  :label="item"
                  :value="item">
                </el-option>
              </el-select>
              <el-checkbox v-model="showLeave" style="margin-left: 5px">
                {{$t('humanCapital.personnelOrganization.showLeave')}}
              </el-checkbox>
            </el-form-item>
          </el-row>
          <el-row>
            <el-form-item>
              {{$t('humanCapital.personnelOrganization.checkPoint')}}
              <el-date-picker
                v-model="baseMonth"
                format="yyyy / MM"
                :placeholder="$t('common.startDate')"
                :picker-options="pickerStartOptions">
              </el-date-picker>
              &nbsp;&nbsp;
              {{$t('humanCapital.personnelOrganization.level')}}
              <el-input-number v-model="level" controls-position="right" :min="1">
              </el-input-number>
            </el-form-item>
          </el-row>
          <el-row>
            <el-form-item>
              {{$t('humanCapital.personnelOrganization.fields')}}
              <el-checkbox v-model="name" style="margin-left: 2px">
                {{$t('humanCapital.personnelOrganization.name')}}
              </el-checkbox>
              <el-checkbox v-model="number">
                {{$t('humanCapital.personnelOrganization.number')}}
              </el-checkbox>
              <el-checkbox v-model="dept">
                {{$t('humanCapital.personnelOrganization.dept')}}
              </el-checkbox>
              <el-radio v-model="rank" label="name" style="margin-left: 10px">
                {{$t('humanCapital.personnelOrganization.rankName')}}
              </el-radio>
              <el-radio v-model="rank" label="code">
                {{$t('humanCapital.personnelOrganization.rankCode')}}
              </el-radio>
              <el-checkbox v-model="joinDate" style="margin-left: 10px">
                {{$t('humanCapital.personnelOrganization.joinDate')}}
              </el-checkbox>
              <el-checkbox v-model="rankState">
                {{$t('humanCapital.personnelOrganization.rankState')}}
              </el-checkbox>
            </el-form-item>
          </el-row>
          <el-row>
            <el-form-item>
              <el-button type="primary" @click="search">
                {{$t('humanCapital.personnelOrganization.search')}}
              </el-button>
              <el-button style="margin-left: 10px" type="info">
                {{$t('humanCapital.personnelOrganization.preview')}}
              </el-button>
              <el-button style="margin-left: 10px" type="success">
                {{$t('humanCapital.personnelOrganization.print')}}
              </el-button>
            </el-form-item>
          </el-row>
        </el-form>
      </el-card>
    </el-row>
    <el-dialog
      :title="$t('humanCapital.personnelOrganization.root')"
      width="55%"
      :visible.sync="dialog1Visible">
      <el-form
        label-position="top"
        size="mini"
        ref="rootInfo"
        :model="rootInfo"
        label-width="150"
        :inline="true">
        <el-row>
          <el-form-item>
            {{$t('humanCapital.personnelOrganization.dialogTitle1')}}
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item>
            {{$t('humanCapital.personnelOrganization.branch')}}
            <el-select v-model="rootInfo.branch" :placeholder="$t('humanCapital.viPerformance.branch')" multiple collapse-tags>
              <el-option
                v-for="item in filters.branchs"
                :key="item"
                :label="item"
                :value="item">
              </el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item>
            {{$t('humanCapital.personnelOrganization.dept')}}
            <el-select v-model="rootInfo.dept" :placeholder="$t('humanCapital.viPerformance.dept')" multiple collapse-tags>
              <el-option
                v-for="item in filters.depts"
                :key="item"
                :label="item"
                :value="item">
              </el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item>
            {{$t('humanCapital.personnelOrganization.people')}}
            <el-input
              style="width: auto"
              v-model="conditionValue"
              disabled
              clearable>
            </el-input>
            &nbsp;&nbsp;
            <el-tooltip effect="dark" :content="$t('humanCapital.personnelOrganization.searchPeople')">
              <el-button type="primary" icon="el-icon-more" @click="innerVisible=true"></el-button>
            </el-tooltip>
          </el-form-item>
        </el-row>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="warning" @click="clearDialog('rootInfo')">{{ $t('common.clear') }}</el-button>
        <el-button @click="dialog1Visible=false">{{ $t('common.cancel') }}</el-button>
        <el-button type="primary" @click="dialogConfirm">{{ $t('common.confirm') }}</el-button>
      </span>
    </el-dialog>
    <el-dialog
      :title="$t('humanCapital.performanceWarn.checkObj')"
      width="55%"
      :visible.sync="innerVisible">
      <el-form
        label-position="top"
        size="mini"
        ref="rootInfo.searchInfo"
        :model="rootInfo.searchInfo"
        label-width="150"
        :inline="true">
        <el-row>
          <el-form-item :label="$t('humanCapital.performanceWarn.branch')">
            <el-select v-model="rootInfo.searchInfo.branch" :placeholder="$t('humanCapital.performanceWarn.branch')" multiple collapse-tags>
              <el-option
                v-for="item in filters.branchs"
                :key="item"
                :label="item"
                :value="item">
              </el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item :label="$t('humanCapital.performanceWarn.name')">
            <el-input
              v-model="rootInfo.searchInfo.name"
              :placeholder="$t('common.pleaseInput')">
            </el-input>
          </el-form-item>
          <el-form-item :label="$t('humanCapital.performanceWarn.number')">
            <el-input
              type="number"
              v-model="rootInfo.searchInfo.number"
              :placeholder="$t('common.pleaseInput')">
            </el-input>
          </el-form-item>
          <el-form-item :label="$t('humanCapital.performanceWarn.idCard')">
            <el-input
              v-model="rootInfo.searchInfo.idCard"
              :placeholder="$t('common.pleaseInput')">
            </el-input>
          </el-form-item>
        </el-row>
      </el-form>
      <el-row>
        <el-button type="primary"  @click="getObjList">{{ $t('humanCapital.performanceWarn.searchNow') }}</el-button>
      </el-row>
      <el-row></el-row>
      <el-row>
        <el-card shadow="always">
          <el-row>
            <el-table
              v-loading="listLoading"
              :key="tableKey"
              :data="list"
              :header-cell-style="{ backgroundColor: '#f8f8f9', color: '#2c2c2c' }"
              max-height="350"
              highlight-current-row
              @current-change="handleCurrentChange"
              fit
              border>
              <el-table-column prop="number" width="140px" :label="$t('humanCapital.performanceWarn.number')" ></el-table-column>
              <el-table-column prop="name" width="140px" :label="$t('humanCapital.performanceWarn.name')" ></el-table-column>
              <el-table-column prop="idCard" width="140px" :label="$t('humanCapital.performanceWarn.idCard')" ></el-table-column>
              <el-table-column prop="branch" width="140px" :label="$t('humanCapital.performanceWarn.branch')" ></el-table-column>
              <el-table-column prop="dept" width="140px" :label="$t('humanCapital.performanceWarn.dept')" ></el-table-column>
              <el-table-column prop="rank" width="140px" :label="$t('humanCapital.performanceWarn.rank')" ></el-table-column>
            </el-table>
          </el-row>
        </el-card>
      </el-row>
    </el-dialog>
    <el-row>
      <el-card shadow="always">
        <el-tree :data="tree" :highlight-current="true" icon-class="el-icon-more"></el-tree>
      </el-card>
    </el-row>
  </div>
</template>

<script>
  import performanceWarnDialog from '@/mock/templates/performanceWarnDialog'
  import { fetchPeopleList } from '@/api/humanCapital/performanceWarnDialog'
  import { initObject } from '@/shared'
  export default {
    name: 'personnelOrganization',
    methods: {
      search (): void {
        let searchInfo = {
          branch: this.confirmRoot.branch,
          dept: this.confirmRoot.dept,
          name: this.confirmRoot.name,
          number: this.confirmRoot.number,
          idCard: this.confirmRoot.idCard,
          checkPoint: this.baseMonth,
          showLeave: this.showLeave,
          type: this.type,
          level: this.level,
          nameFiled: this.name,
          numberFiled: this.number,
          deptFiled: this.dept,
          rankFiled: this.rank,
          joinDateFiled: this.joinDate,
          rankStateFiled: this.rankState
        }
        console.log(searchInfo)
        //
        this.tree = [{
          label: '员工组织结构图',
          children: [{
            label: '二级 1-1',
            children: [{
              label: '三级 1-1-1'
            }]
          }]
        }]
      },
      clearDialog (formName): void {
        //
        initObject(this.rootInfo)
        this.conditionValue = ''
        this.root = ''
        this.confirmRoot = {
          name: '',
          number: '',
          idCard: '',
          branch: '',
          dept: ''
        }
      },
      dialogConfirm (): void {
        this.confirmRoot.branch = this.rootInfo.branch
        this.confirmRoot.dept = this.rootInfo.dept
        this.confirmRoot.name = this.rootInfo.searchInfo.name
        this.confirmRoot.number = this.rootInfo.searchInfo.number
        this.confirmRoot.idCard = this.rootInfo.searchInfo.idCard
        this.root = this.rootInfo.branch.toString() + '\t' + this.rootInfo.dept.toString() + '\t' + this.conditionValue
        this.dialog1Visible = false
        console.log(this.confirmRoot)
      },
      getObjList (): void {
        this.listLoading = true
        fetchPeopleList(this.searchInfo).then(data => {
          this.list = data
          // eslint-disable-next-line
        }, error => {
          this.list = performanceWarnDialog.data
        })
        setTimeout(() => {
          this.listLoading = false
        }, 200)
      },
      handleCurrentChange (val) {
        this.rootInfo.searchInfo.name = val.name
        this.rootInfo.searchInfo.number = val.number
        this.rootInfo.searchInfo.idCard = val.idCard
        this.conditionValue = val.name + '\t' + val.number
        this.listLoading = false
        this.innerVisible = false
      }
    },
    data () {
      return {
        conditionValue: '',
        listLoading: false,
        list: [],
        tableKey: 0,
        root: '',
        tree: [],
        type: '',
        showLeave: false,
        baseMonth: '',
        level: 1,
        name: false,
        number: false,
        dept: false,
        joinDate: false,
        rankState: false,
        rank: 'name',
        dialog1Visible: false,
        innerVisible: false,
        filters: {
          types: ['关系上属', '介绍人', '行政主管', '行政主管2'],
          branchs: ['安徽分公司', '恩施分公司', '福建分公司', '广西分公司', '海南分公司', '河南分公司',
                    '黑龙江分公司', '湖南分公司', '江苏分公司', '荆门分公司', '辽宁分公司', '宁夏分公司',
                    '陕西分公司', '十堰分公司', '天津分公司', '武昌分公司', '武汉分公司', '仙桃分公司',
                    '咸宁分公司', '襄阳分公司', '新疆分公司', '宜昌分公司', '云南分公司', '总部'],
          depts: ['运营部', '营销部']
        },
        pickerStartOptions: {
          disabledDate: (time) => {
            return time.getTime() > Date.now()
          }
        },
        rootInfo: {
          branch: '',
          dept: '',
          searchInfo: {
            name: '',
            number: '',
            idCard: '',
            branch: ''
          }
        },
        confirmRoot: {
          name: '',
          number: '',
          idCard: '',
          branch: '',
          dept: ''
        }
      }
    }
  }
</script>
