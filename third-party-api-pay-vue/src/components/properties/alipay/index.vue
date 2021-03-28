<template>
  <div>
    <a-card>
      <a-descriptions :title="t('properties.alipay.name') + t('configurations.columns.properties')">
        <a-descriptions-item :label="t('properties.alipay.protocol')">
          {{ properties.protocol }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.alipay.gatewayHost')">
          {{ properties.gatewayHost }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.alipay.appId')">
          {{ properties.appId }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.alipay.signType')">
          {{ properties.signType }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.alipay.alipayPublicKey')">
          {{ properties.alipayPublicKey }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.alipay.merchantPrivateKey')">
          {{ properties.merchantPrivateKey }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.alipay.merchantCertPath')">
          {{ properties.merchantCertPath }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.alipay.alipayCertPath')">
          {{ properties.alipayCertPath }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.alipay.alipayRootCertPath')">
          {{ properties.alipayRootCertPath }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.alipay.notifyUrl')">
          {{ properties.notifyUrl }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.alipay.encryptKey')">
          {{ properties.encryptKey }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.alipay.signProvider')">
          {{ properties.signProvider }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.alipay.httpProxy')">
          {{ properties.httpProxy }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.alipay.ignoreSsl')">
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