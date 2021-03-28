<template>
  <div>
    <!-- search -->
    <a-input-group  style="text-align: left">
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
      <a-button type="primary">{{ t('actions.search') }}</a-button>
      <a-button type="default">{{ t('actions.reset') }}</a-button>
    </a-input-group>
    <!-- action -->
    <a-input-group  style="text-align: left">
      <a-button type="primary">{{ t('actions.add') }}</a-button>
      <a-button type="default">{{ t('actions.edit') }}</a-button>
      <a-button type="danger">{{ t('actions.remove') }}</a-button>
      <a-button type="default">{{ t('actions.import') }}</a-button>
      <a-button type="dashed">{{ t('actions.export') }}</a-button>
    </a-input-group>
    <!-- content -->
    <a-table
        row-key="id"
        :columns="columns"
        :data-source="data">
      <template #index="{ index }">
        <span>{{ index + 1 }}</span>
      </template>
      <template #type="{ text }">
        <span>{{ text }}</span>
      </template>
      <template #id="{ text }">
        <span>{{ text }}</span>
      </template>
      <template #username="{ text }">
        <span>{{ text }}</span>
      </template>
      <template #nickname="{ text }">
        <span>{{ text }}</span>
      </template>
      <template #status="{ text }">
        <span>{{ text }}</span>
      </template>
      <template #action="{ record }">
        <a @click="handleEdit(record)">{{ t('actions.edit') }}</a>
        <a-divider type="vertical"/>
        <a @click="handleRemove(record.id)">{{ t('actions.remove') }}</a>
        <a-divider type="vertical"/>
        <a @click="handleChangePassword(record)">{{ t('users.actions.change-password') }}</a>
      </template>
    </a-table>
  </div>
</template>

<script>
import {useI18n} from "vue-i18n";

export default {
  name: "Transactions",
  data() {
    return {
      query: {},
      data: [
        {
          type: 'admin',
          id: '2021000117624946',
          username: 'admin',
          nickname: 'admin',
          status: 'ENABLED',
        }
      ],
      columns: [
        {dataIndex: 'index', title: 'index', slots: {customRender: 'index'}},
        {dataIndex: 'type', title: 'type', slots: {customRender: 'type'}},
        {dataIndex: 'id', title: 'id', slots: {customRender: 'id'}},
        {dataIndex: 'username', title: 'username', slots: {customRender: 'username'}},
        {dataIndex: 'nickname', title: 'nickname', slots: {customRender: 'nickname'}},
        {dataIndex: 'status', title: 'status', slots: {customRender: 'status'}},
        {dataIndex: 'action', title: 'action', slots: {customRender: 'action'},},
      ]
    };
  },
  methods: {
    handleEdit(record) {
      console.log(record)
    },
    handleRemove(id) {
      console.log(id)
    },
    handleChangePassword(record) {
      console.log(record)
    }
  },
  setup() {
    const {t} = useI18n();

    return {
      t
    }
  }
}
</script>

<style scoped>

</style>