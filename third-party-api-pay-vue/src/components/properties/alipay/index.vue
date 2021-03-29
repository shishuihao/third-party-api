<template>
  <div>
    <a-card>
      <a-descriptions :title="t('properties.' + properties.channelId + '.name') + t('configurations.columns.properties')">
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.protocol')">
          {{ properties.protocol }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.gatewayHost')">
          {{ properties.gatewayHost }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.appId')">
          {{ properties.appId }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.signType')">
          {{ properties.signType }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.alipayPublicKey')">
          {{ properties.alipayPublicKey }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.merchantPrivateKey')">
          {{ properties.merchantPrivateKey }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.merchantCertPath')">
          {{ properties.merchantCertPath }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.alipayCertPath')">
          {{ properties.alipayCertPath }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.alipayRootCertPath')">
          {{ properties.alipayRootCertPath }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.notifyUrl')">
          {{ properties.notifyUrl }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.encryptKey')">
          {{ properties.encryptKey }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.signProvider')">
          {{ properties.signProvider }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.httpProxy')">
          {{ properties.httpProxy }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.ignoreSsl')">
          {{ properties.ignoreSsl }}
        </a-descriptions-item>
      </a-descriptions>
    </a-card>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import {useI18n} from "vue-i18n";

export default defineComponent({
  props: ['properties'],
  setup() {
    const {t} = useI18n();

    return {
      t
    }
  }
})
</script>

<style scoped>

</style>