<template>
  <a-tabs>
    <a-tab-pane v-for="(properties) in propertiesList"
                :key="properties.channelId"
                :tab="t('properties.' + properties.channelId + '.name')">
      <pay-api-properties :properties="properties"/>
    </a-tab-pane>
  </a-tabs>
</template>

<script>
import {defineComponent} from "vue";
import PayApiProperties from "@/components/properties/index"
import {useI18n} from "vue-i18n";

export default defineComponent({
  name: "PropertiesTabs",
  props: ['propertiesList'],
  components: {
    PayApiProperties,
  },
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