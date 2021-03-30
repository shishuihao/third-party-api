<template>
  <div>
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
        :data-source="configurations"
    >
      <template v-slot:[`columns.index`]>{{ t('columns.index') }}</template>
      <template v-slot:[`configurations.columns.channelId`]>{{ t('configurations.columns.channelId') }}</template>
      <template v-slot:[`configurations.columns.propertiesId`]>{{ t('configurations.columns.propertiesId') }}</template>
      <template v-slot:[`configurations.columns.properties`]>{{ t('configurations.columns.properties') }}</template>
      <template v-slot:[`columns.status`]>{{ t('columns.status') }}</template>
      <template v-slot:[`columns.action`]>{{ t('columns.action') }}</template>
      <template #index="{ index }">{{ index + 1 }}</template>
      <template #channelId="{ text }">{{ t('properties.' + text + ".name") }}</template>
      <template #propertiesId="{ text }">{{ text }}</template>
      <template #properties="{ text }">
        <pay-api-properties :properties="text"/>
      </template>
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
import PayApiProperties from "@/components/properties/index"
import {DeleteOutlined, EditOutlined, ExportOutlined, PlusOutlined} from "@ant-design/icons-vue";

export default defineComponent({
  name: "Configurations",
  props: ['configurations'],
  components: {
    PayApiProperties,
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
      columns: [
        {dataIndex: 'index', fixed: 'left', slots: {customRender: 'index', title: 'columns.index'}},
        {
          dataIndex: 'channelId', width: 110,
          slots: {customRender: 'channelId', title: 'configurations.columns.channelId'}
        },
        {
          dataIndex: 'propertiesId',
          slots: {customRender: 'propertiesId', title: 'configurations.columns.propertiesId'}
        },
        {dataIndex: 'properties', slots: {customRender: 'properties', title: 'configurations.columns.properties'}},
        {dataIndex: 'status', fixed: 'right', slots: {customRender: 'status', title: 'columns.status'}},
        {dataIndex: 'action', fixed: 'right', slots: {customRender: 'action', title: 'columns.action'}},
      ]
    }
  }
});
</script>

<style scoped>

</style>