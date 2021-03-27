<template>
  <div>
    <a-card>
      <a-descriptions :title="t('channels.alipay.name') + t('configurations.properties')">
        <a-descriptions-item :label="t('channels.alipay.properties.protocol')">
          {{ properties.protocol }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('channels.alipay.properties.gatewayHost')">
          {{ properties.gatewayHost }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('channels.alipay.properties.appId')">
          {{ properties.appId }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('channels.alipay.properties.signType')">
          {{ properties.signType }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('channels.alipay.properties.alipayPublicKey')">
          {{ properties.alipayPublicKey }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('channels.alipay.properties.merchantPrivateKey')">
          {{ properties.merchantPrivateKey }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('channels.alipay.properties.merchantCertPath')">
          {{ properties.merchantCertPath }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('channels.alipay.properties.alipayCertPath')">
          {{ properties.alipayCertPath }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('channels.alipay.properties.alipayRootCertPath')">
          {{ properties.alipayRootCertPath }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('channels.alipay.properties.notifyUrl')">
          {{ properties.notifyUrl }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('channels.alipay.properties.encryptKey')">
          {{ properties.encryptKey }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('channels.alipay.properties.signProvider')">
          {{ properties.signProvider }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('channels.alipay.properties.httpProxy')">
          {{ properties.httpProxy }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('channels.alipay.properties.ignoreSsl')">
          {{ properties.ignoreSsl }}
        </a-descriptions-item>
      </a-descriptions>
    </a-card>
  </div>
</template>

<script>
import {useI18n} from "vue-i18n";

export default {
  props: ['properties'],
  setup() {
    const {t} = useI18n();

    return {
      t
    }
  }
}
</script>

<style scoped>

</style>