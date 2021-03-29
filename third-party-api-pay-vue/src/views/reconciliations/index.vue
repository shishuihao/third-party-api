<template>
  <div>
    <a-calendar v-model:value="value">
      <template #dateCellRender="{ current: value }">
        <ul class="events">
          <li v-for="item in getListData(value)" :key="item.content">
            <a-badge :status="item.type" :text="item.content"/>
          </li>
        </ul>
      </template>
      <template #monthCellRender="{ current: value }">
        <div v-if="getMonthData(value)" class="notes-month">
          <section>{{ getMonthData(value) }}</section>
          <span>Backlog number</span>
        </div>
      </template>
    </a-calendar>
    <!-- content -->
<!--    <a-table-->
<!--        row-key="id"-->
<!--        :columns="columns"-->
<!--        :data-source="data">-->
<!--      <template v-slot:[`columns.index`]>{{ t('columns.index') }}</template>-->
<!--      <template v-slot:[`columns.type`]>{{ t('columns.type') }}</template>-->
<!--      <template v-slot:[`columns.id`]>{{ t('columns.id') }}</template>-->
<!--      <template v-slot:[`users.columns.username`]>{{ t('users.columns.username') }}</template>-->
<!--      <template v-slot:[`users.columns.nickname`]>{{ t('users.columns.nickname') }}</template>-->
<!--      <template v-slot:[`columns.status`]>{{ t('columns.status') }}</template>-->
<!--      <template v-slot:[`columns.action`]>{{ t('columns.action') }}</template>-->
<!--      <template #index="{ index }">{{ index + 1 }}</template>-->
<!--      <template #type="{ text }">{{ t('users.types.' + text) }}</template>-->
<!--      <template #id="{ text }">{{ text }}</template>-->
<!--      <template #username="{ text }">{{ text }}</template>-->
<!--      <template #nickname="{ text }">{{ text }}</template>-->
<!--      <template #status="{ text }">{{ t('statuses.' + text) }}</template>-->
<!--      <template #action="{ record }">-->
<!--        <a @click="handleEdit(record)">{{ t('actions.edit') }}</a>-->
<!--        <a-divider type="vertical"/>-->
<!--        <a @click="handleRemove(record.id)">{{ t('actions.remove') }}</a>-->
<!--        <a-divider type="vertical"/>-->
<!--        <a @click="handleChangePassword(record)">{{ t('users.actions.change-password') }}</a>-->
<!--      </template>-->
<!--    </a-table>-->
  </div>
</template>

<script>
// import {useI18n} from "vue-i18n";
import {defineComponent, ref} from 'vue';

export default defineComponent({
  name: "Reconciliations",
  setup() {
    const value = ref();

    const getListData = (current) => {
      let listData;
      switch (current.date()) {
        case 8:
          listData = [
            {type: 'warning', content: 'This is warning event.'},
            {type: 'success', content: 'This is usual event.'},
          ];
          break;
        case 10:
          listData = [
            {type: 'warning', content: 'This is warning event.'},
            {type: 'success', content: 'This is usual event.'},
            {type: 'error', content: 'This is error event.'},
          ];
          break;
        case 15:
          listData = [
            {type: 'warning', content: 'This is warning event'},
            {type: 'success', content: 'This is very long usual event。。....'},
            {type: 'error', content: 'This is error event 1.'},
            {type: 'error', content: 'This is error event 2.'},
            {type: 'error', content: 'This is error event 3.'},
            {type: 'error', content: 'This is error event 4.'},
          ];
          break;
        default:
      }
      return listData || [];
    };

    const getMonthData = (current) => {
      if (current.month() === 8) {
        return 1394;
      }
    };

    return {
      value,
      getListData,
      getMonthData,
    };
  },
});
</script>

<style scoped>

</style>