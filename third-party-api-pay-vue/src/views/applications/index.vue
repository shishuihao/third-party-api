<template>
  <div>
    <!-- search -->
    <a-input-group style="text-align: left">
      <a-input style="width: 15%" :value="query.mchId"
               :placeholder="t('applications.columns.mchId')"/>
      <a-input style="width: 15%" :value="query.appId"
               :placeholder="t('applications.columns.appId')"/>
      <a-input style="width: 15%" :value="query.name"
               :placeholder="t('applications.columns.name')"/>
      <a-input style="width: 15%" :value="query.status"
               :placeholder="t('columns.status')"/>
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
      <a-button type="dashed">
        <ExportOutlined/>
        {{ t('actions.export') }}
      </a-button>
    </a-input-group>
    <!-- content -->
    <a-table
        row-key="propertiesId"
        :columns="columns"
        :data-source="data"
    >
      <template v-slot:[`columns.index`]>{{ t('columns.index') }}</template>
      <template v-slot:[`applications.columns.mchId`]>{{ t('applications.columns.mchId') }}</template>
      <template v-slot:[`applications.columns.appId`]>{{ t('applications.columns.appId') }}</template>
      <template v-slot:[`applications.columns.name`]>{{ t('applications.columns.name') }}</template>
      <template v-slot:[`applications.columns.icon`]>{{ t('applications.columns.icon') }}</template>
      <template v-slot:[`applications.columns.description`]>{{ t('applications.columns.description') }}</template>
      <template v-slot:[`columns.status`]>{{ t('columns.status') }}</template>
      <template v-slot:[`columns.action`]>{{ t('columns.action') }}</template>
      <template #index="{ index }">{{ index + 1 }}</template>
      <template #mchId="{ text }">{{ text }}</template>
      <template #appId="{ text }">{{ text }}</template>
      <template #name="{ text }">{{ text }}</template>
      <template #icon="{ text }">{{ text }}</template>
      <template #description="{ text }">{{ text }}</template>
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
  PlusOutlined,
  ReloadOutlined,
  SearchOutlined
} from "@ant-design/icons-vue";

export default defineComponent({
  name: "Applications",
  components: {
    SearchOutlined,
    ReloadOutlined,
    PlusOutlined,
    EditOutlined,
    DeleteOutlined,
    ExportOutlined
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
      query: {},
      data: [
        {
          mchId: '1230000109',
          appId: 'd678efh567hg6787',
          name: '测试应用',
          icon: '/icons/d678efh567hg6787.png',
          description: '用来测试',
          status: 'ENABLED',
        }
      ],
      columns: [
        {dataIndex: 'index', fixed: 'left', slots: {customRender: 'index', title: 'columns.index'}},
        {dataIndex: 'mchId', slots: {customRender: 'mchId', title: 'applications.columns.mchId'}},
        {dataIndex: 'appId', slots: {customRender: 'appId', title: 'applications.columns.appId'}},
        {dataIndex: 'name', slots: {customRender: 'name', title: 'applications.columns.name'}},
        {dataIndex: 'icon', slots: {customRender: 'icon', title: 'applications.columns.icon'}},
        {dataIndex: 'description', slots: {customRender: 'description', title: 'applications.columns.description'}},
        {dataIndex: 'status', fixed: 'right', slots: {customRender: 'status', title: 'columns.status'}},
        {dataIndex: 'action', fixed: 'right', slots: {customRender: 'action', title: 'columns.action'}},
      ]
    }
  }
});
</script>

<style scoped>

</style>