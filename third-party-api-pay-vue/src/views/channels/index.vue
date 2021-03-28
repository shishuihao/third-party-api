<template>
  <div>
    <!-- search -->
    <a-input-group style="text-align: left">
      <a-input style="width: 15%" :value="query.id"
               :placeholder="t('placeholders.please-enter') + t('columns.id')"/>
      <a-input style="width: 15%" :value="query.name"
               :placeholder="t('placeholders.please-enter') + t('columns.name')"/>
      <a-input style="width: 15%" :value="query.status"
               :placeholder="t('placeholders.please-enter') + t('columns.status')"/>
      <a-button type="primary">{{ t('actions.search') }}</a-button>
      <a-button type="default">{{ t('actions.reset') }}</a-button>
    </a-input-group>
    <!-- action -->
    <a-input-group style="text-align: left">
      <a-button type="primary">{{ t('actions.add') }}</a-button>
      <a-button type="default">{{ t('actions.edit') }}</a-button>
      <a-button type="danger">{{ t('actions.remove') }}</a-button>
      <a-button type="dashed">{{ t('actions.export') }}</a-button>
    </a-input-group>
    <!-- content -->
    <a-table
        row-key="id"
        :columns="columns"
        :data-source="data">
      <template v-slot:[`columns.index`]>{{ t('columns.index') }}</template>
      <template v-slot:[`columns.id`]>{{ t('columns.id') }}</template>
      <template v-slot:[`columns.name`]>{{ t('columns.name') }}</template>
      <template v-slot:[`columns.status`]>{{ t('columns.status') }}</template>
      <template v-slot:[`columns.action`]>{{ t('columns.action') }}</template>
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
        <a>{{ record.name }}</a>
      </template>
    </a-table>
  </div>
</template>

<script>
import {useI18n} from "vue-i18n";

export default {
  name: "Channels",
  data() {
    return {
      query: {},
      data: [
        {
          id: 'pay.alipay',
          name: '支付宝',
        },
        {
          id: 'pay.weixin',
          name: '微信',
        },
      ],
      columns: [
        {dataIndex: 'index', slots: {customRender: 'index', title: 'columns.index'}},
        {dataIndex: 'id', slots: {customRender: 'id', title: 'columns.id'}},
        {dataIndex: 'name', slots: {customRender: 'name', title: 'columns.name'}},
        {dataIndex: 'action', slots: {customRender: 'action', title: 'columns.action'}},
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