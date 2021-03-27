<template>
  <div>
    <!-- content table -->
    <a-table
        row-key="id"
        :columns="columns"
        :data-source="data">
      <template #index="{ index }">
        <span>{{ index + 1 }}</span>
      </template>
      <template #id="{ text }">
        <span>{{ text }}</span>
      </template>
      <template #name="{ text }">
        <span>{{ text }}</span>
      </template>
      <template #action="{ record }">
        <a>Invite 一 {{ record.name }}</a>
      </template>
    </a-table>
  </div>
</template>

<script>

import {useI18n} from "vue-i18n";

const data = [
  {
    id: 'pay.alipay',
    name: '支付宝',
  },
  {
    id: 'pay.weixin',
    name: '微信',
  },
];

export default {
  name: "channels",
  data() {
    return {
      data,
      columns: [
        {dataIndex: 'index', title: 'index', slots: {customRender: 'index'}},
        {dataIndex: 'id', title: 'id', slots: {customRender: 'id'}},
        {dataIndex: 'name', title: 'name', slots: {customRender: 'name'}},
        {dataIndex: 'action', title: 'action', slots: {customRender: 'action'},},
      ]
    };
  },
  setup() {
    const {t} = useI18n();

    return {
      t
    }
  }
};
</script>

<style scoped>

</style>