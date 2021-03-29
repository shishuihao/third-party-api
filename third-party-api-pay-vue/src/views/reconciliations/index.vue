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
        <ul class="events">
          <li v-for="item in getMonthData(value)" :key="item.content">
            <a-badge :status="item.type" :text="item.content"/>
          </li>
        </ul>
      </template>
    </a-calendar>
  </div>
</template>

<script>
import {defineComponent, ref} from "vue";
import {useI18n} from "vue-i18n";

export default defineComponent({
  name: "Reconciliations",
  setup() {
    const {t} = useI18n();

    const value = ref();

    const getDateData = (current) => {
      let listData;
      switch (current.date()) {
        case 25:
          listData = [
            {type: 'success', content: '本日无收支'},
          ];
          break;
        case 27:
          listData = [
            {type: 'error', content: '生成失败'},
          ];
          break;
        case 28:
          listData = [
            {type: 'warning', content: '账单未生成'},
          ];
          break;
        default:
      }
      return listData || [];
    };

    const getMonthData = (current) => {
      let listData;
      switch (current.month()) {
        case 3:
          listData = [
            {type: 'warning', content: '账单未生成'},
          ];
          break;
        default:
      }
      return listData || [];
    };

    return {
      t,
      value,
      getListData: getDateData,
      getMonthData,
    };
  },
});
</script>

<style scoped>

</style>