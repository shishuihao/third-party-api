<template>
  <div>
    <!-- content -->
    <a-table
        row-key="transactionId"
        :columns="columns"
        :data-source="data"
        :scroll="{ x: 1800 }"
    >
      <template v-slot:[`columns.index`]>{{ t('columns.index') }}</template>
      <template v-slot:[`transactions.columns.userId`]>{{ t('transactions.columns.userId') }}</template>
      <template v-slot:[`transactions.columns.tradeType`]>{{ t('transactions.columns.tradeType') }}</template>
      <template v-slot:[`transactions.columns.channelId`]>{{ t('transactions.columns.channelId') }}</template>
      <template v-slot:[`transactions.columns.propertiesId`]>{{ t('transactions.columns.propertiesId') }}</template>
      <template v-slot:[`transactions.columns.transactionId`]>{{ t('transactions.columns.transactionId') }}</template>
      <template v-slot:[`transactions.columns.outTradeNo`]>{{ t('transactions.columns.outTradeNo') }}</template>
      <template v-slot:[`transactions.columns.payerId`]>{{ t('transactions.columns.payerId') }}</template>
      <template v-slot:[`transactions.columns.currency`]>{{ t('transactions.columns.currency') }}</template>
      <template v-slot:[`transactions.columns.totalAmount`]>{{ t('transactions.columns.totalAmount') }}</template>
      <template v-slot:[`transactions.columns.payCurrency`]>{{ t('transactions.columns.payCurrency') }}</template>
      <template v-slot:[`transactions.columns.payTotalAmount`]>{{ t('transactions.columns.payTotalAmount') }}</template>
      <template v-slot:[`transactions.columns.tradeStatus`]>{{ t('transactions.columns.tradeStatus') }}</template>
      <template v-slot:[`columns.action`]>{{ t('columns.action') }}</template>
      <template #index="{ index }">{{ index + 1 }}</template>
      <template #userId="{ text }">{{ text }}</template>
      <template #tradeType="{ text }">{{ t('transactions.tradeTypes.' + text) }}</template>
      <template #channelId="{ text }">{{ t('properties.' + text + ".name") }}</template>
      <template #propertiesId="{ text }">{{ text }}</template>
      <template #transactionId="{ text }">{{ text }}</template>
      <template #outTradeNo="{ text }">{{ text }}</template>
      <template #payerId="{ text }">{{ text }}</template>
      <template #currency="{ text }">{{ t('transactions.currencies.' + text) }}</template>
      <template #totalAmount="{ text }">{{ text }}</template>
      <template #payCurrency="{ text }">{{ t('transactions.currencies.' + text) }}</template>
      <template #payTotalAmount="{ text }">{{ text }}</template>
      <template #tradeStatus="{ text }">{{ t('transactions.tradeStatuses.' + text) }}</template>
      <template #action="{ record }">
        <a @click="handleEdit(record)">
          <EditOutlined/>
          {{ t('actions.edit') }}</a>
        <a-divider type="vertical"/>
        <a @click="handleRemove(record.id)">
          <DeleteOutlined/>
          {{ t('actions.remove') }}</a>
      </template>
    </a-table>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import {useI18n} from "vue-i18n";

export default defineComponent({
  name: "Transactions",
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
          userId: '2021000117624946',
          channelId: 'pay.alipay',
          tradeType: 'CODE',
          propertiesId: '2021000117624946',
          transactionId: '1217752501201407033233368018',
          outTradeNo: '1217752501201407033233368018',
          payerId: 'oUpF8uMuAJO_M2pxb1Q9zNjWeS6o',
          currency: 'CNY',
          totalAmount: 1,
          payCurrency: 'CNY',
          payTotalAmount: 1,
          tradeStatus: 'TRADE_SUCCESS',
        }
      ],
      columns: [
        {dataIndex: 'index', fixed: 'left', slots: {customRender: 'index', title: 'columns.index'}},
        {dataIndex: 'userId', fixed: 'left', slots: {customRender: 'userId', title: 'transactions.columns.userId'}},
        {
          dataIndex: 'tradeType',
          fixed: 'left',
          slots: {customRender: 'tradeType', title: 'transactions.columns.tradeType'}
        },
        {
          dataIndex: 'channelId',
          fixed: 'left',
          slots: {customRender: 'channelId', title: 'transactions.columns.channelId'}
        },
        {dataIndex: 'propertiesId', slots: {customRender: 'propertiesId', title: 'transactions.columns.propertiesId'}},
        {
          dataIndex: 'transactionId',
          slots: {customRender: 'transactionId', title: 'transactions.columns.transactionId'}
        },
        {dataIndex: 'outTradeNo', slots: {customRender: 'outTradeNo', title: 'transactions.columns.outTradeNo'}},
        {dataIndex: 'payerId', slots: {customRender: 'payerId', title: 'transactions.columns.payerId'}},
        {dataIndex: 'currency', slots: {customRender: 'currency', title: 'transactions.columns.currency'}},
        {dataIndex: 'totalAmount', slots: {customRender: 'totalAmount', title: 'transactions.columns.totalAmount'}},
        {dataIndex: 'payCurrency', slots: {customRender: 'payCurrency', title: 'transactions.columns.payCurrency'}},
        {
          dataIndex: 'payTotalAmount',
          slots: {customRender: 'payTotalAmount', title: 'transactions.columns.payTotalAmount'}
        },
        {
          dataIndex: 'tradeStatus',
          fixed: 'right',
          slots: {customRender: 'tradeStatus', title: 'transactions.columns.tradeStatus'}
        },
        {dataIndex: 'action', fixed: 'right', slots: {customRender: 'action', title: 'columns.action'}},
      ]
    }
  }
});
</script>

<style scoped>

</style>