<template>
  <div class="container">
    <el-row>
      <el-card
        shadow="always"
        body-style="padding: 20px;">
        <div slot="header">
          <el-steps :active="active" finish-status="success" simple>
            <el-step
              icon="el-icon-download"
              :title="$t('insurancePolicy.dataImport.step1.title')">
            </el-step>
            <el-step
              icon="el-icon-edit"
              :title="$t('insurancePolicy.dataImport.step2.title')">
            </el-step>
            <el-step
              icon="el-icon-document"
              :title="$t('insurancePolicy.dataImport.step3.title')">
            </el-step>
          </el-steps>
        </div>
        <el-row>
          <transition
            name="fade-reverse-transform"
            mode="out-in">
            <div class="step1" v-if="active===1" key="step1">
              <el-card
                class="template-select"
                shadow="never">
                <div slot="header">
                  <el-row type="flex" justify="center" align="middle">
                    <el-col :span="12"><span>{{ $t('insurancePolicy.dataImport.step1.templateSelect') }}</span></el-col>
                    <el-col :span="12">
                      <el-tooltip
                        effect="dark"
                        :content="$t('insurancePolicy.dataImport.step1.importNum')"
                        placement="top">
                        <el-input-number
                          v-model="step1.importNum"
                          :controls="false"
                          size="mini"
                          style="float: right;max-width: 80px">
                        </el-input-number>
                      </el-tooltip>
                    </el-col>
                  </el-row>
                </div>
                <el-row type="flex" align="middle">
                  <el-col :span="16">
                    <el-autocomplete
                      ref="templateSelect"
                      v-model="step1.template.name"
                      @select="handleTemplateSelect"
                      :fetch-suggestions="fetchTemplates"
                      :placeholder="$t('insurancePolicy.dataImport.step1.templateSelect')">
                      <i v-if="step1.mode === 'edit' || step1.mode === 'add'" class="el-icon-edit el-input__icon" style="color: #409EFF" slot="suffix"></i>
                      <i v-else slot="suffix" class="el-icon-tickets el-input__icon"></i>
                      <template slot-scope="{ item }">
                        <div class="name">{{ item.label }}</div>
                      </template>
                    </el-autocomplete>
                  </el-col>
                  <el-col :span="8">
                    <transition name="fade-reverse-transform" mode="out-in">
                      <span class="button-container" v-if="step1.mode === 'normal'" key="normal">
                        <el-tooltip effect="dark" :content="$t('insurancePolicy.dataImport.step1.editTemplate')" placement="top">
                          <svg-icon
                            icon-class="edit-3"
                            :class-name="step1.template.name?'icon-button icon-button-primary':'icon-button-disable icon-button'"
                            @click.native="editTemplate">
                          </svg-icon>
                        </el-tooltip>
                        <popover-tip
                          :message="$t('insurancePolicy.dataImport.step1.delTemplateTip')"
                          :confirm-text="$t('common.confirm')"
                          :cancel-text="$t('common.cancel')"
                          @popover-tip-confirm="delTemplate">
                            <span style="margin-left: 15px">
                              <svg-icon
                                icon-class="x-square"
                                :class-name="step1.template.name?'icon-button icon-button-danger':'icon-button-disable icon-button'">
                              </svg-icon>
                            </span>
                          </popover-tip>
                      </span>
                      <span class="button-container" v-else key="editing">
                        <el-tooltip effect="dark" :content="$t('common.confirm')" placement="top">
                          <svg-icon icon-class="check" class-name="icon-button icon-button-success" @click.native="templateHandleConfirm"></svg-icon>
                        </el-tooltip>
                        <el-tooltip effect="dark" :content="$t('common.cancel')" placement="top">
                          <svg-icon icon-class="x" class-name="icon-button icon-button-danger" @click.native="templateHandleCancel"></svg-icon>
                        </el-tooltip>
                      </span>
                    </transition>
                  </el-col>
                </el-row>
                <el-row>
                  <el-collapse value="1">
                    <el-collapse-item name="1" :title="$t('insurancePolicy.dataImport.step1.fieldsSelect')">
                      <el-tree
                        :props="step1.treeProps"
                        :data="step1.fields"
                        :default-expanded-keys="step1.checkFields"
                        :default-checked-keys="step1.checkFields"
                        show-checkbox
                        @check-change="handleTreeCheckChange">
                      </el-tree>
                    </el-collapse-item>
                  </el-collapse>
                </el-row>
              </el-card>
            </div>
            <div class="step2" v-if="active===2" key="step2">
              <el-card shadow="never">
                <div slot="header">
                  <p>{{ $t('insurancePolicy.dataImport.step2.description') }}</p>
                </div>
                <el-button type="primary" @click="downloadTemplate">
                  <svg-icon icon-class="download-cloud"></svg-icon>
                  {{ $t('insurancePolicy.dataImport.step2.downloadTemplate') }}
                </el-button>
              </el-card>
            </div>
            <div class="step3" v-if="active===3" key="step3">
              <el-card
                shadow="never">
                <div slot="header">
                  <p>{{ $t('insurancePolicy.dataImport.step3.description') }}</p>
                </div>
                <el-row>
                  <el-upload
                    action=""
                    :on-change="handleFileChange"
                    :file-list="step3.fileList">
                    <el-button type="primary">
                      <svg-icon icon-class="upload-cloud"></svg-icon>
                      {{ $t('insurancePolicy.dataImport.step3.selectFile') }}
                    </el-button>
                    <div slot="tip" class="upload-tip">
                      <el-collapse value="1">
                        <el-collapse-item name="1" :title="$t('insurancePolicy.dataImport.step3.options')">
                          <el-form size="mini" :model="step3.options" label-width="120px" label-position="left">
                            <el-form-item :label="$t('insurancePolicy.dataImport.step3.insuranceMatch')">
                              <el-radio-group v-model="step3.options.insuranceMatch">
                                <el-radio label="abbreviation">{{ $t('insurancePolicy.dataImport.step3.abbreviation') }}</el-radio>
                                <el-radio label="fullName">{{ $t('insurancePolicy.dataImport.step3.fullName') }}</el-radio>
                                <el-radio label="code">{{ $t('insurancePolicy.dataImport.step3.code') }}</el-radio>
                              </el-radio-group>
                            </el-form-item>
                            <el-form-item :label="$t('insurancePolicy.dataImport.step3.repeatedData')">
                              <el-radio-group v-model="step3.options.repeatedData">
                                <el-radio label="ignore">{{ $t('insurancePolicy.dataImport.step3.ignore') }}</el-radio>
                                <el-radio label="recover">{{ $t('insurancePolicy.dataImport.step3.recover') }}</el-radio>
                              </el-radio-group>
                            </el-form-item>
                          </el-form>
                        </el-collapse-item>
                      </el-collapse>
                    </div>
                  </el-upload>
                </el-row>
              </el-card>
            </div>
          </transition>
        </el-row>
        <el-row style="margin-top: 20px">
          <transition enter-active-class="animated fadeIn" leave-active-class="animated fadeOut faster" mode="out-in">
            <el-button v-if="active>1" type="primary" @click="handlePrevStep" plain>
              <svg-icon icon-class="arrow-left"></svg-icon>
              {{ $t('common.prevStep') }}
            </el-button>
          </transition>
          <transition enter-active-class="animated fadeIn " leave-active-class="animated fadeOut faster" mode="out-in">
            <el-button v-if="active<3" type="primary" @click="handleNextStep" plain>
              {{ $t('common.nextStep') }}
              <svg-icon icon-class="arrow-right"></svg-icon>
            </el-button>
            <span key="other" v-if="active===3" style="margin-left: 10px">
              <el-button type="success" plain>{{ $t('insurancePolicy.dataImport.step3.dataFormat') }}</el-button>
              <el-button type="primary">{{ $t('insurancePolicy.dataImport.step3.dataImport') }}</el-button>
              <el-button type="danger" @click="handleDataImportCancel" plain>{{ $t('common.cancel') }}</el-button>
            </span>
          </transition>
          <transition enter-active-class="animated fadeIn delay-half-1s" leave-active-class="animated fadeOut faster" mode="out-in">
            <el-button v-if="active === 1" type="primary" @click="addTemplate">
              <svg-icon icon-class="plus"></svg-icon>
              {{ $t('insurancePolicy.dataImport.step1.addTemplate') }}
            </el-button>
          </transition>
        </el-row>
      </el-card>
    </el-row>
  </div>
</template>

<script>
  import { PopoverTip } from '@/components'
  export default {
    name: 'import',
    components: { PopoverTip },
    data () {
      return {
        active: 1,
        step1: {
          importNum: 1000,
          template: {
            name: '',
            value: []
          },
          fields: [
            {
              label: '保单基本信息',
              children: [
                { label: '保险公司', value: 'insurer' },
                { label: '保单号码', value: 'policyNo' }
              ]
            },
            {
              label: '险种信息',
              children: [
                { label: '险种简称', value: 'insurance' },
                { label: '险种保险金额', value: 'account' }
              ]
            },
            {
              label: '投保人信息',
              children: [
                { label: '投保人姓名', value: 'holderName' }
              ]
            },
            {
              label: '被保人信息',
              children: [
                { label: '被保人姓名', value: 'insuredName' }
              ]
            }
          ],
          checkFields: [],
          mode: 'normal',
          treeProps: {
            label: 'label',
            children: 'children'
          }
        },
        step3: {
          fileList: [{
            name: 'insurances.excel',
            url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100',
            status: 'finished'
          }],
          options: {
            insuranceMatch: 'abbreviation',
            repeatedData: 'ignore'
          }
        }
      }
    },

    methods: {
      focusTemplate (): void {
        this.$nextTick(() => {
          this.$refs.templateSelect.$refs.input.focus()
        })
      },
      handleNextStep (): void {
        this.active < 3 && this.active++
      },
      handlePrevStep (): void {
        this.active > 1 && this.active--
      },
      fetchTemplates (query: string, callback: Function): void {
        const templates = [
          { label: '标准寿险模板', id: 1, fields: [] }
        ]
        callback(query ? templates.filter(item => item.label.toLowerCase().trim().indexOf(query.toLowerCase().trim()) > -1) : templates)
      },
      handleTreeCheckChange ():void {},
      handleTemplateSelect (item: Object): void {
        this.step1.template.name = item.label
      },
      addTemplate ():void {
        this.step1.template = {
          name: 'new template',
          value: []
        }
        this.step1.mode = 'add'
        this.focusTemplate()
      },
      editTemplate (): void {
        if (!this.step1.template.name) return null
        this.step1.mode = 'edit'
        this.focusTemplate()
      },
      delTemplate ():void {
        if (!this.step1.template.name) return null
      },
      templateHandleConfirm (): void {},
      templateHandleCancel ():void {
        this.step1.mode = 'normal'
        if (this.step1.template.name === 'new template' && this.step1.template.value.length === 0) {
          this.step1.template = {
            name: '',
            value: []
          }
        }
      },
      downloadTemplate (): void {},
      handleFileChange ():void {},
      handleDataImportCancel (): void {
        this.active = 1
      }
    }
  }
</script>

<style lang="scss">
  .step1 .template-select {
    .el-card__body .el-row {
      margin-bottom: 20px;
    }

    .button-container {
      float: right;

      .icon-button {
        transition: .5s;
        cursor: pointer;
        font-size: 18px;

        &+.icon-button {
          margin-left: 15px;
        }

        &:hover {
          opacity: 0.6;
        }
      }

    }
  }
  .step3 {
    .upload-tip{
      padding-top: 15px;
    }
    .el-collapse-item__content {
      padding-bottom: 0;
    }
  }
</style>
