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
      <template #index="{ index }">{{ index + 1 }}</template>
      <template #id="{ text }">{{ text }}</template>
      <template #name="{ text }">{{ text }}</template>
      <template #status="{ text }">{{ t('statuses.' + text) }}</template>
      <template #action="{ record }">
        <a @click="handleEdit(record)">{{ t('actions.edit') }}</a>
        <a-divider type="vertical"/>
        <a @click="handleRemove(record.id)">{{ t('actions.remove') }}
        </a></template>
    </a-table>
  </div>
</template>

<script>
import {useI18n} from "vue-i18n";
import {defineComponent} from "vue";

export default defineComponent({
  name: "Channels",
  setup() {
    const {t} = useI18n();

    const handleEdit = (record) => {
      console.log(record);
    };

    const handleRemove = (id) => {
      console.log(id);
    };

    return {
      t,
      handleEdit,
      handleRemove,
      query: {},
      data: [
        {
          id: 'pay.alipay',
          name: '支付宝',
          status: 'ENABLED',
        },
        {
          id: 'pay.weixin',
          name: '微信',
          status: 'ENABLED',
        },
      ],
      columns: [
        {dataIndex: 'index', fixed: 'left', slots: {customRender: 'index', title: 'columns.index'}},
        {dataIndex: 'id', slots: {customRender: 'id', title: 'columns.id'}},
        {dataIndex: 'name', slots: {customRender: 'name', title: 'columns.name'}},
        {dataIndex: 'status', fixed: 'right', slots: {customRender: 'status', title: 'columns.status'}},
        {dataIndex: 'action', fixed: 'right', slots: {customRender: 'action', title: 'columns.action'}},
      ]
    }
  }
});
</script>

<style scoped>

</style>