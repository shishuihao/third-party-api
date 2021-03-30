<template>
  <div>
    <!-- search -->
    <a-input-group style="text-align: left">
      <a-input style="width: 15%" :value="query.userId"
               :placeholder="t('transactions.columns.appId')"/>
      <a-input style="width: 15%" :value="query.userId"
               :placeholder="t('transactions.columns.mchId')"/>
      <a-input style="width: 15%" :value="query.tradeType"
               :placeholder="t('transactions.columns.tradeType')"/>
      <a-input style="width: 15%" :value="query.channelId"
               :placeholder="t('transactions.columns.channelId')"/>
      <a-input style="width: 15%" :value="query.transactionId"
               :placeholder="t('transactions.columns.transactionId')"/>
      <a-input style="width: 15%" :value="query.outTradeNo"
               :placeholder="t('transactions.columns.outTradeNo')"/>
      <a-input style="width: 15%" :value="query.payerId"
               :placeholder="t('transactions.columns.payerId')"/>
      <a-input style="width: 15%" :value="query.authCode"
               :placeholder="t('transactions.columns.authCode')"/>
      <a-input style="width: 15%" :value="query.currency"
               :placeholder="t('transactions.columns.currency')"/>
      <a-input style="width: 15%" :value="query.totalAmount"
               :placeholder="t('transactions.columns.totalAmount')"/>
      <a-input style="width: 15%" :value="query.tradeStatus"
               :placeholder="t('transactions.columns.tradeStatus')"/>
      <a-button type="primary">
        <SearchOutlined/>
        {{ t('actions.search') }}
      </a-button>
      <a-button type="default">
        <ReloadOutlined/>
        {{ t('actions.reset') }}
      </a-button>
    </a-input-group>
    <!-- content -->
    <a-table
        row-key="transactionId"
        :columns="columns"
        :data-source="data"
        :scroll="{ x: 1800 }"
        :pagination="pagination"
    >
      <template v-slot:[`columns.index`]>{{ t('columns.index') }}</template>
      <template v-slot:[`transactions.columns.appId`]>{{ t('transactions.columns.appId') }}</template>
      <template v-slot:[`transactions.columns.mchId`]>{{ t('transactions.columns.mchId') }}</template>
      <template v-slot:[`transactions.columns.tradeType`]>{{ t('transactions.columns.tradeType') }}</template>
      <template v-slot:[`transactions.columns.channelId`]>{{ t('transactions.columns.channelId') }}</template>
      <template v-slot:[`transactions.columns.transactionId`]>{{ t('transactions.columns.transactionId') }}</template>
      <template v-slot:[`transactions.columns.outTradeNo`]>{{ t('transactions.columns.outTradeNo') }}</template>
      <template v-slot:[`transactions.columns.payerId`]>{{ t('transactions.columns.payerId') }}</template>
      <template v-slot:[`transactions.columns.authCode`]>{{ t('transactions.columns.authCode') }}</template>
      <template v-slot:[`transactions.columns.currency`]>{{ t('transactions.columns.currency') }}</template>
      <template v-slot:[`transactions.columns.totalAmount`]>{{ t('transactions.columns.totalAmount') }}</template>
      <template v-slot:[`transactions.columns.payCurrency`]>{{ t('transactions.columns.payCurrency') }}</template>
      <template v-slot:[`transactions.columns.payTotalAmount`]>{{ t('transactions.columns.payTotalAmount') }}</template>
      <template v-slot:[`transactions.columns.tradeStatus`]>{{ t('transactions.columns.tradeStatus') }}</template>
      <template v-slot:[`columns.action`]>{{ t('columns.action') }}</template>
      <template #index="{ index }">{{ index + 1 }}</template>
      <template #appId="{ text }">{{ text }}</template>
      <template #mchId="{ text }">{{ text }}</template>
      <template #tradeType="{ text }">{{ t('transactions.tradeTypes.' + text) }}</template>
      <template #channelId="{ text }">{{ t('properties.' + text + ".name") + '(' + text + ')' }}</template>
      <template #propertiesId="{ text }">{{ text }}</template>
      <template #transactionId="{ text }">{{ text }}</template>
      <template #outTradeNo="{ text }">{{ text }}</template>
      <template #payerId="{ text }">{{ text }}</template>
      <template #authCode="{ text }">{{ text }}</template>
      <template #currency="{ text }">{{ t('transactions.currencies.' + text) + '(' + text + ')' }}</template>
      <template #totalAmount="{ text }">{{ text }}</template>
      <template #payCurrency="{ text }">{{ t('transactions.currencies.' + text) + '(' + text + ')' }}</template>
      <template #payTotalAmount="{ text }">{{ text }}</template>
      <template #tradeStatus="{ text }">{{ t('transactions.tradeStatuses.' + text) }}</template>
      <template #action="{ record }">
        <a @click="handleQuery(record.transactionId)">
          {{ t('transactions.actions.query') }}
        </a>
        <a-divider type="vertical"/>
        <a @click="handleCancel(record.transactionId)">
          {{ t('transactions.actions.cancel') }}
        </a>
        <a-divider type="vertical"/>
        <a @click="handleRefund(record.transactionId)">
          {{ t('transactions.actions.refund') }}
        </a>
      </template>
    </a-table>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import {useI18n} from "vue-i18n";

export default defineComponent({
  name: "Transactions",
  components: {
  },
  setup() {
    const {t} = useI18n();

    const handleQuery = (id) => {
      console.log(id);
    };

    const handleCancel = (id) => {
      console.log(id);
    };

    const handleRefund = (id) => {
      console.log(id);
    };

    const handleRefundQuery = (id) => {
      console.log(id);
    };

    return {
      t,
      handleQuery,
      handleCancel,
      handleRefund,
      handleRefundQuery,
      pagination: {
        showSizeChanger: true,
      },
      query: {},
      data: [
        {
          appId: 'd678efh567hg6787',
          mchId: '1230000109',
          channelId: 'pay.alipay',
          tradeType: 'JSAPI',
          transactionId: '1217752501201407033233368018',
          outTradeNo: '1217752501201407033233368018',
          payerId: 'oUpF8uMuAJO_M2pxb1Q9zNjWeS6o',
          currency: 'CNY',
          totalAmount: 1,
          payCurrency: 'CNY',
          payTotalAmount: 1,
          tradeStatus: 'TRADE_SUCCESS',
        },
        {
          appId: 'd678efh567hg6787',
          mchId: '1230000109',
          channelId: 'pay.icbc',
          tradeType: 'CODE',
          transactionId: '1217752501201407033233368018',
          outTradeNo: '1217752501201407033233368018',
          authCode: '28763443825664394',
          currency: 'CNY',
          totalAmount: 1,
          payCurrency: 'CNY',
          payTotalAmount: 1,
          tradeStatus: 'TRADE_SUCCESS',
        }
      ],
      columns: [
        {dataIndex: 'index', fixed: 'left', slots: {customRender: 'index', title: 'columns.index'}},
        {dataIndex: 'appId', fixed: 'left', slots: {customRender: 'appId', title: 'transactions.columns.appId'}},
        {dataIndex: 'mchId', fixed: 'left', slots: {customRender: 'mchId', title: 'transactions.columns.mchId'}},
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
        {
          dataIndex: 'transactionId',
          slots: {customRender: 'transactionId', title: 'transactions.columns.transactionId'}
        },
        {dataIndex: 'outTradeNo', slots: {customRender: 'outTradeNo', title: 'transactions.columns.outTradeNo'}},
        {dataIndex: 'payerId', slots: {customRender: 'payerId', title: 'transactions.columns.payerId'}},
        {dataIndex: 'authCode', slots: {customRender: 'authCode', title: 'transactions.columns.authCode'}},
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