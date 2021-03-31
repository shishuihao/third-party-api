<template>
  <div>
    <search :columns="columns" :data="query"/>
    <actions :data="actions"/>
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
          {{ t('actions.edit') }}
        </a>
        <a-divider type="vertical"/>
        <a @click="handleRemove(record.id)">
          <DeleteOutlined/>
          {{ t('actions.remove') }}
        </a>
        <a-divider type="vertical"/>
        <a @click="handleChangePassword(record)">
          <KeyOutlined/>
          {{ t('users.actions.change-password') }}
        </a>
      </template>
    </a-table>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import {useI18n} from "vue-i18n";
import Search from "@/components/search"
import Actions from "@/components/actions"
import {DeleteOutlined, EditOutlined, KeyOutlined,} from "@ant-design/icons-vue";

export default defineComponent({
  name: "Users",
  components: {
    Search,
    Actions,
    EditOutlined,
    DeleteOutlined,
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
      query: {
        type: '',
        id: '',
        username: '',
        nickname: '',
        status: '',
      },
      actions: {
        'actions.add': () => console.log('actions.add'),
        'actions.edit': () => console.log('actions.edit'),
        'actions.remove': () => console.log('actions.remove'),
        'actions.import': () => console.log('actions.import'),
        'actions.export': () => console.log('actions.export')
      },
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