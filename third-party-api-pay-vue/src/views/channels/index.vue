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
      <template v-slot:[`columns.id`]>{{ t('columns.id') }}</template>
      <template v-slot:[`columns.name`]>{{ t('columns.name') }}</template>
      <template v-slot:[`columns.status`]>{{ t('columns.status') }}</template>
      <template v-slot:[`columns.action`]>{{ t('columns.action') }}</template>
      <template #index="{ index }">{{ index + 1 }}</template>
      <template #id="{ text }">{{ text }}</template>
      <template #name="{ text }">{{ text }}</template>
      <template #status="{ text }">{{ t('statuses.' + text) }}</template>
      <template #action="{ record }">
        <a @click="handleEdit(record)">
          <EditOutlined/>
          {{ t('actions.edit') }}
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
import {EditOutlined} from "@ant-design/icons-vue";

export default defineComponent({
  name: "Channels",
  components: {
    Search,
    Actions,
    EditOutlined
  },
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
      query: {
        id: '',
        name: '',
        status: ''
      },
      actions: {
        'actions.add': () => console.log('actions.add'),
        'actions.edit': () => console.log('actions.edit'),
        'actions.remove': () => console.log('actions.remove'),
        'actions.export': () => console.log('actions.export')
      },
      data: [
        {
          id: 'pay.alipay',
          name: '支付宝',
          status: 'ENABLED',
        },
        {
          id: 'pay.wechat',
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