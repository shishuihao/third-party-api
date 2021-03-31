<template>
  <a-input-group style="text-align: left">
    <template v-for="column in columns" :key="column.dataIndex">
      <template v-if="data.hasOwnProperty(column.dataIndex)">
        <a-input style="width: 15%"
                 :value="data[column.dataIndex]"
                 :placeholder="t(column.slots.title)"/>
      </template>
    </template>
    <a-button type="primary">
      <SearchOutlined/>
      {{ t('actions.search') }}
    </a-button>
    <a-button type="default">
      <ReloadOutlined/>
      {{ t('actions.reset') }}
    </a-button>
  </a-input-group>
</template>

<script>
import {defineComponent} from "vue";
import {useI18n} from "vue-i18n";

export default defineComponent({
  name: "Search",
  props: ['columns', 'data'],
  setup() {
    const {t} = useI18n();

    return {
      t
    }
  }
});
</script>

<style scoped>

</style>