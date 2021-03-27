<template>
  <div>
    <!-- content table -->
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
      <template #properties="{ text }">
        <pay-api-properties :properties="text"/>
      </template>
      <template #action="{ record }">
        <a>Invite 一 {{ record.name }}</a>
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
          }
        }
      ],
      columns: [
        {dataIndex: 'index', title: 'index', slots: {customRender: 'index'}},
        {dataIndex: 'channelId', title: 'channelId', slots: {customRender: 'channelId'}},
        {dataIndex: 'propertiesId', title: 'propertiesId', slots: {customRender: 'propertiesId'}},
        {dataIndex: 'properties', title: 'properties', slots: {customRender: 'properties'}},
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