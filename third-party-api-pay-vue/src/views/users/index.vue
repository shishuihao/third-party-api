<template>
  <div>
    <!-- search -->
    <a-input-group style="text-align: left">
      <a-input style="width: 15%" :value="query.type"
               :placeholder="t('placeholders.please-enter') + t('columns.type')"/>
      <a-input style="width: 15%" :value="query.id"
               :placeholder="t('placeholders.please-enter') + t('columns.id')"/>
      <a-input style="width: 15%" :value="query.username"
               :placeholder="t('placeholders.please-enter') + t('users.columns.username')"/>
      <a-input style="width: 15%" :value="query.nickname"
               :placeholder="t('placeholders.please-enter') + t('users.columns.nickname')"/>
      <a-input style="width: 15%" :value="query.status"
               :placeholder="t('placeholders.please-enter') + t('columns.status')"/>
      <a-button type="primary">
        <SearchOutlined/>
        {{ t('actions.search') }}
      </a-button>
      <a-button type="default">
        <ReloadOutlined/>
        {{ t('actions.reset') }}
      </a-button>
    </a-input-group>
    <!-- action -->
    <a-input-group style="text-align: left">
      <a-button type="primary">
        <PlusOutlined/>
        {{ t('actions.add') }}
      </a-button>
      <a-button type="default">
        <EditOutlined/>
        {{ t('actions.edit') }}
      </a-button>
      <a-button type="danger">
        <DeleteOutlined/>
        {{ t('actions.remove') }}
      </a-button>
      <a-button type="default">
        <ImportOutlined/>
        {{ t('actions.import') }}
      </a-button>
      <a-button type="dashed">
        <ExportOutlined/>
        {{ t('actions.export') }}
      </a-button>
    </a-input-group>
    <!-- content -->
    <a-table
        row-key="id"
        :columns="columns"
        :data-source="data">
      <template v-slot:[`columns.index`]>{{ t('columns.index') }}</template>
      <template v-slot:[`columns.type`]>{{ t('columns.type') }}</template>
      <template v-slot:[`columns.id`]>{{ t('columns.id') }}</template>
      <template v-slot:[`users.columns.username`]>{{ t('users.columns.username') }}</template>
      <template v-slot:[`users.columns.nickname`]>{{ t('users.columns.nickname') }}</template>
      <template v-slot:[`columns.status`]>{{ t('columns.status') }}</template>
      <template v-slot:[`columns.action`]>{{ t('columns.action') }}</template>
      <template #index="{ index }">{{ index + 1 }}</template>
      <template #type="{ text }">{{ t('users.types.' + text) }}</template>
      <template #id="{ text }">{{ text }}</template>
      <template #username="{ text }">{{ text }}</template>
      <template #nickname="{ text }">{{ text }}</template>
      <template #status="{ text }">{{ t('statuses.' + text) }}</template>
      <template #action="{ record }">
        <a @click="handleEdit(record)">
          <EditOutlined/>
          {{ t('actions.edit') }}</a>
        <a-divider type="vertical"/>
        <a @click="handleRemove(record.id)">
          <DeleteOutlined/>
          {{ t('actions.remove') }}</a>
        <a-divider type="vertical"/>
        <a @click="handleChangePassword(record)">
          <KeyOutlined/>
          {{ t('users.actions.change-password') }}</a>
      </template>
    </a-table>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import {useI18n} from "vue-i18n";
import {
  DeleteOutlined,
  EditOutlined,
  ExportOutlined,
  ImportOutlined,
  KeyOutlined,
  PlusOutlined,
  ReloadOutlined,
  SearchOutlined
} from "@ant-design/icons-vue";

export default defineComponent({
  name: "Users",
  components: {
    SearchOutlined,
    ReloadOutlined,
    PlusOutlined,
    EditOutlined,
    DeleteOutlined,
    ImportOutlined,
    ExportOutlined,
    KeyOutlined
  },
  setup() {
    const {t} = useI18n();

    const handleEdit = (record) => {
      console.log(record);
    };

    const handleRemove = (id) => {
      console.log(id);
    };

    const handleChangePassword = (record) => {
      console.log(record);
    };

    return {
      t,
      handleEdit,
      handleRemove,
      handleChangePassword,
      query: {},
      data: [
        {
          type: 'admin',
          id: '2021000117624946',
          username: 'admin001',
          nickname: 'admin001',
          status: 'ENABLED',
        },
        {
          type: 'user',
          id: '2021000117624947',
          username: 'user001',
          nickname: 'user001',
          status: 'DISABLED',
        }
      ],
      columns: [
        {dataIndex: 'index', fixed: 'left', slots: {customRender: 'index', title: 'columns.index'}},
        {dataIndex: 'type', slots: {customRender: 'type', title: 'columns.type'}},
        {dataIndex: 'id', slots: {customRender: 'id', title: 'columns.id'}},
        {dataIndex: 'username', slots: {customRender: 'username', title: 'users.columns.username'}},
        {dataIndex: 'nickname', slots: {customRender: 'nickname', title: 'users.columns.nickname'}},
        {dataIndex: 'status', fixed: 'right', slots: {customRender: 'status', title: 'columns.status'}},
        {dataIndex: 'action', fixed: 'right', slots: {customRender: 'action', title: 'columns.action'}},
      ]
    }
  }
});
</script>

<style scoped>

</style>