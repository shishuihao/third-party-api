<template>
  <div>
    <template v-if="properties.channelId === 'pay.alipay'">
      <alipay-pay-api-properties :properties="properties"/>
    </template>
    <template v-if="properties.channelId === 'pay.icbc'">
      <icbc-pay-api-properties :properties="properties"/>
    </template>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import AlipayPayApiProperties from "./alipay/index"
import IcbcPayApiProperties from "./icbc/index"

export default defineComponent({
  props: ['properties'],
  components: {
    AlipayPayApiProperties,
    IcbcPayApiProperties
  }
});
</script>

<style scoped>

</style>