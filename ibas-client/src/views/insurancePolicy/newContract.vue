<template>
  <div class="container">
    <el-row>
      <el-card shadow="always">
        <el-form ref="form">
          <el-form-item label="受理的保险公司">
            <div>
              <el-radio>不区分</el-radio>
            </div>
            <div>
              <el-radio>不区分</el-radio>
            </div>
            <div>
              <el-radio>不区分</el-radio>
            </div>
            <div>
              <el-radio>不区分</el-radio>
            </div>
          </el-form-item>
        </el-form>
      </el-card>
    </el-row>
  </div>
</template>

<style lang="scss">
  .container {
    padding: 15px;
  }
</style>

<script>
  export default {
    name: 'newContract'
  }
</script>
