<template>
  <div>
    <template v-if="properties.channelId === 'pay.alipay'">
      <alipay-pay-api-properties :properties="properties"/>
    </template>
  </div>
</template>

<script>
import AlipayPayApiProperties from "./alipay/alipay-pay-api-properties"

export default {
  name: "PayApiProperties",
  props: ['properties'],
  components: {
    AlipayPayApiProperties
  }
}
</script>

<style scoped>

</style>