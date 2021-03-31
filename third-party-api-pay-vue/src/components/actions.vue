<template>
  <a-input-group style="text-align: left">
    <template v-for="(click, key) in data" :key="key">
      <template v-if="columns.hasOwnProperty(key)">
        <a-button :type="columns[key].type" @click="click">
          <component :is="$antIcons[columns[key].icon]"/>
          {{ t(key) }}
        </a-button>
      </template>
    </template>
  </a-input-group>
</template>

<script>
import {defineComponent} from "vue";
import {useI18n} from "vue-i18n";

export default defineComponent({
  name: "Actions",
  props: ['data'],
  setup() {
    const {t} = useI18n();

    return {
      t,
      columns: {
        "actions.add": {
          type: "primary",
          icon: "PlusOutlined"
        },
        "actions.edit": {
          type: "default",
          icon: "EditOutlined"
        },
        "actions.remove": {
          type: "danger",
          icon: "DeleteOutlined"
        },
        "actions.import": {
          type: "default",
          icon: "ImportOutlined"
        },
        "actions.export": {
          type: "dashed",
          icon: "ExportOutlined"
        },
      }
    }
  }
});
</script>

<style scoped>

</style>