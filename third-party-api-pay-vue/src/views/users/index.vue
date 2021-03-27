<template>
  <div>
    <!-- search -->
    <div>
      <a-input-group compact>
        <a-input style="width: 20%" :value="query.type" :placeholder="t('please enter') + t('type')"/>
        <a-input style="width: 20%" :value="query.id" :placeholder="t('please enter') + t('id')"/>
        <a-input style="width: 20%" :value="query.username" :placeholder="t('please enter') + t('users.username')"/>
        <a-input style="width: 20%" :value="query.nickname" :placeholder="t('please enter') + t('users.nickname')"/>
        <a-input style="width: 20%" :value="query.status" :placeholder="t('please enter') + t('status')"/>
      </a-input-group>
    </div>
    <!-- content table -->
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
        <a @click="handleEdit(record)">{{ t('edit') }}</a>
        <a-divider type="vertical"/>
        <a @click="handleRemove(record.id)">{{ t('remove') }}</a>
        <a-divider type="vertical"/>
        <a @click="handleChangePassword(record)">{{ t('users.change password') }}</a>
      </template>
    </a-table>
  </div>
</template>

<script>
import {useI18n} from "vue-i18n";

export default {
  name: "Users",
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