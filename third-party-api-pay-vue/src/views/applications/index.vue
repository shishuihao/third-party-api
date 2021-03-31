<template>
  <div>
    <search :columns="columns" :data="query"/>
    <actions :data="actions"/>
    <!-- content -->
    <a-tabs>
      <a-tab-pane key="table" :tab="t('applications.columns.table')">
        <a-table
            row-key="propertiesId"
            :columns="columns"
            :data-source="data"
            :customRow="customRow"
        >
          <template v-slot:[`columns.index`]>{{ t('columns.index') }}</template>
          <template v-slot:[`applications.columns.mchId`]>{{ t('applications.columns.mchId') }}</template>
          <template v-slot:[`applications.columns.appId`]>{{ t('applications.columns.appId') }}</template>
          <template v-slot:[`applications.columns.name`]>{{ t('applications.columns.name') }}</template>
          <template v-slot:[`applications.columns.icon`]>{{ t('applications.columns.icon') }}</template>
          <template v-slot:[`applications.columns.description`]>{{ t('applications.columns.description') }}</template>
          <template v-slot:[`applications.columns.signType`]>{{ t('applications.columns.signType') }}</template>
          <template v-slot:[`applications.columns.publicKey`]>{{ t('applications.columns.publicKey') }}</template>
          <template v-slot:[`columns.status`]>{{ t('columns.status') }}</template>
          <template v-slot:[`columns.action`]>{{ t('columns.action') }}</template>
          <template #index="{ index }">{{ index + 1 }}</template>
          <template #mchId="{ text }">{{ text }}</template>
          <template #appId="{ text }">{{ text }}</template>
          <template #name="{ text }">{{ text }}</template>
          <template #icon="{ text }"><img :src="text" :alt="text"></template>
          <template #description="{ text }">{{ text }}</template>
          <template #signType="{ text }">{{ text }}</template>
          <template #publicKey="{ text }">{{ text }}</template>
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
      </a-tab-pane>
      <a-tab-pane key="configurations" :tab=" t('applications.columns.configurations') + '(' + application.name  + ')'">
        <configurations :configurations="application.configurations"/>
      </a-tab-pane>
    </a-tabs>
  </div>
</template>

<script>
import {defineComponent, ref} from "vue";
import {useI18n} from "vue-i18n";
import Search from "@/components/search"
import Actions from "@/components/actions"
import Configurations from "@/components/configurations"
import {DeleteOutlined, EditOutlined} from "@ant-design/icons-vue";

export default defineComponent({
  name: "Applications",
  components: {
    Search,
    Actions,
    Configurations,
    EditOutlined,
    DeleteOutlined,
  },
  setup() {
    const {t} = useI18n();

    const application = ref([]);

    const handleEdit = (record) => {
      console.log(record);
    };

    const handleRemove = (id) => {
      console.log(id);
    };

    const customRow = (record) => {
      return {
        onClick: () => {
          application.value = record;
        },
      };
    }

    return {
      t,
      application,
      customRow,
      handleEdit,
      handleRemove,
      query: {
        mchId: '',
        appId: '',
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
          mchId: '1230000109',
          appId: 'd678efh567hg6787',
          name: '测试应用',
          icon: '/icons/d678efh567hg6787.png',
          description: '用来测试',
          status: 'ENABLED',
          signType: "RSA2",
          publicKey: "******",
          configurations: [
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
            },
            {
              channelId: 'pay.icbc',
              propertiesId: '10000000000000004925',
              properties: {
                "channelId": "pay.icbc",
                "appId": "10000000000000004925",
                "privateKey": "******",
                "signType": "RSA",
                "charset": "UTF-8",
                "format": "json",
                "icbcPublicKey": "******",
                "encryptType": "AES",
                "encryptKey": "******",
              },
              status: 'ENABLED',
            }
          ]
        }
      ],
      columns: [
        {dataIndex: 'index', fixed: 'left', slots: {customRender: 'index', title: 'columns.index'}},
        {dataIndex: 'mchId', slots: {customRender: 'mchId', title: 'applications.columns.mchId'}},
        {dataIndex: 'appId', slots: {customRender: 'appId', title: 'applications.columns.appId'}},
        {dataIndex: 'name', slots: {customRender: 'name', title: 'applications.columns.name'}},
        {dataIndex: 'icon', slots: {customRender: 'icon', title: 'applications.columns.icon'}},
        {dataIndex: 'description', slots: {customRender: 'description', title: 'applications.columns.description'}},
        {dataIndex: 'signType', slots: {customRender: 'signType', title: 'applications.columns.signType'}},
        {dataIndex: 'publicKey', slots: {customRender: 'publicKey', title: 'applications.columns.publicKey'}},
        {dataIndex: 'status', fixed: 'right', slots: {customRender: 'status', title: 'columns.status'}},
        {dataIndex: 'action', fixed: 'right', slots: {customRender: 'action', title: 'columns.action'}},
      ]
    }
  }
});
</script>

<style scoped>

</style>