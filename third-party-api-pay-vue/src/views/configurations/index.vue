<template>
  <div>
    <!-- search -->
    <a-input-group style="text-align: left">
      <a-input style="width: 15%" :value="query.channelId"
               :placeholder="t('placeholders.please-enter') + t('configurations.columns.channelId')"/>
      <a-input style="width: 15%" :value="query.propertiesId"
               :placeholder="t('placeholders.please-enter') + t('configurations.columns.propertiesId')"/>
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
        row-key="propertiesId"
        :columns="columns"
        :data-source="data">
      <template #index="{ index }">
        <span>{{ index + 1 }}</span>
      </template>
      <template #channelId="{ text }">
        <span>{{ text }}</span>
      </template>
      <template #propertiesId="{ text }">
        <span>{{ text }}</span>
      </template>
      <template #status="{ text }">
        <span>{{ text }}</span>
      </template>
      <template #properties="{ text }">
        <pay-api-properties :properties="text"/>
      </template>
      <template #action="{ record }">
        <a @click="handleEdit(record)">{{ t('actions.edit') }}</a>
        <a-divider type="vertical"/>
        <a @click="handleRemove(record.id)">{{ t('actions.remove') }}</a>
      </template>
    </a-table>
  </div>
</template>

<script>
import {useI18n} from "vue-i18n";
import PayApiProperties from "@/components/properties/pay-api-properties"

export default {
  name: "Configurations",
  components: {
    PayApiProperties
  },
  data() {
    return {
      query: {},
      data: [
        {
          channelId: 'pay.alipay',
          propertiesId: '2021000117624946',
          properties: {
            "channelId": "pay.alipay",
            "protocol": "https",
            "gatewayHost": "openapi.alipaydev.com",
            "appId": "2021000117624946",
            "signType": "RSA2",
            "alipayPublicKey": "******",
            "merchantPrivateKey": "******",
            "ignoreSsl": false
          },
          status: 'ENABLED',
        }
      ],
      columns: [
        {dataIndex: 'index', title: 'index', slots: {customRender: 'index'}},
        {dataIndex: 'channelId', title: 'channelId', slots: {customRender: 'channelId'}},
        {dataIndex: 'propertiesId', title: 'propertiesId', slots: {customRender: 'propertiesId'}},
        {dataIndex: 'status', title: 'status', slots: {customRender: 'status'}},
        {dataIndex: 'properties', title: 'properties', slots: {customRender: 'properties'}},
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