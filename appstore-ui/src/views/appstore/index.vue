<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="应用logo" prop="appLogo">
        <el-input
          v-model="queryParams.appLogo"
          placeholder="请输入应用logo"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="应用名称" prop="appName">
        <el-input
          v-model="queryParams.appName"
          placeholder="请输入应用名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="应用描述" prop="addDescription">
        <el-input
          v-model="queryParams.addDescription"
          placeholder="请输入应用描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="应用版本" prop="appVersion">
        <el-input
          v-model="queryParams.appVersion"
          placeholder="请输入应用版本"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="作者ID" prop="authorId">
        <el-input
          v-model="queryParams.authorId"
          placeholder="请输入作者ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="作者姓名" prop="authorName">
        <el-input
          v-model="queryParams.authorName"
          placeholder="请输入作者姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="作者电话" prop="authorPhone">
        <el-input
          v-model="queryParams.authorPhone"
          placeholder="请输入作者电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="文件路径" prop="appPath">
        <el-input
          v-model="queryParams.appPath"
          placeholder="请输入文件路径"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="文件大小" prop="appSize">
        <el-input
          v-model="queryParams.appSize"
          placeholder="请输入文件大小"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间" prop="creatTime">
        <el-date-picker clearable
          v-model="queryParams.creatTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="是否删除" prop="isDel">
        <el-input
          v-model="queryParams.isDel"
          placeholder="请输入是否删除"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['appstore:appstore:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['appstore:appstore:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['appstore:appstore:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['appstore:appstore:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="appstoreList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="应用ID" align="center" prop="appId" />
      <el-table-column label="应用logo" align="center" prop="appLogo" />
      <el-table-column label="应用名称" align="center" prop="appName" />
      <el-table-column label="应用描述" align="center" prop="addDescription" />
      <el-table-column label="应用版本" align="center" prop="appVersion" />
      <el-table-column label="作者ID" align="center" prop="authorId" />
      <el-table-column label="作者姓名" align="center" prop="authorName" />
      <el-table-column label="作者电话" align="center" prop="authorPhone" />
      <el-table-column label="文件路径" align="center" prop="appPath" />
      <el-table-column label="文件大小" align="center" prop="appSize" />
      <el-table-column label="创建时间" align="center" prop="creatTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.creatTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="是否删除" align="center" prop="isDel" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['appstore:appstore:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['appstore:appstore:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改应用商店对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="应用logo" prop="appLogo">
          <el-input v-model="form.appLogo" placeholder="请输入应用logo" />
        </el-form-item>
        <el-form-item label="应用名称" prop="appName">
          <el-input v-model="form.appName" placeholder="请输入应用名称" />
        </el-form-item>
        <el-form-item label="应用描述" prop="addDescription">
          <el-input v-model="form.addDescription" placeholder="请输入应用描述" />
        </el-form-item>
        <el-form-item label="应用版本" prop="appVersion">
          <el-input v-model="form.appVersion" placeholder="请输入应用版本" />
        </el-form-item>
        <el-form-item label="作者ID" prop="authorId">
          <el-input v-model="form.authorId" placeholder="请输入作者ID" />
        </el-form-item>
        <el-form-item label="作者姓名" prop="authorName">
          <el-input v-model="form.authorName" placeholder="请输入作者姓名" />
        </el-form-item>
        <el-form-item label="作者电话" prop="authorPhone">
          <el-input v-model="form.authorPhone" placeholder="请输入作者电话" />
        </el-form-item>
        <el-form-item label="文件路径" prop="appPath">
          <el-input v-model="form.appPath" placeholder="请输入文件路径" />
        </el-form-item>
        <el-form-item label="文件大小" prop="appSize">
          <el-input v-model="form.appSize" placeholder="请输入文件大小" />
        </el-form-item>
        <el-form-item label="创建时间" prop="creatTime">
          <el-date-picker clearable
            v-model="form.creatTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="是否删除" prop="isDel">
          <el-input v-model="form.isDel" placeholder="请输入是否删除" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listAppstore, getAppstore, delAppstore, addAppstore, updateAppstore } from "@/api/appstore/appstore.js";

export default {
  name: "Appstore",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 应用商店表格数据
      appstoreList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        appLogo: null,
        appName: null,
        addDescription: null,
        appVersion: null,
        authorId: null,
        authorName: null,
        authorPhone: null,
        appPath: null,
        appSize: null,
        creatTime: null,
        isDel: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询应用商店列表 */
    getList() {
      this.loading = true;
      listAppstore(this.queryParams).then(response => {
        this.appstoreList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        appId: null,
        appLogo: null,
        appName: null,
        addDescription: null,
        appVersion: null,
        authorId: null,
        authorName: null,
        authorPhone: null,
        appPath: null,
        appSize: null,
        createBy: null,
        creatTime: null,
        updateTime: null,
        updateBy: null,
        isDel: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.appId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加应用商店";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const appId = row.appId || this.ids
      getAppstore(appId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改应用商店";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.appId != null) {
            updateAppstore(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAppstore(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const appIds = row.appId || this.ids;
      this.$modal.confirm('是否确认删除应用商店编号为"' + appIds + '"的数据项？').then(function() {
        return delAppstore(appIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('appstore/appstore/export', {
        ...this.queryParams
      }, `appstore_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
