<template>
  <div>
    <a-card>
      <a-descriptions :title="t('properties.icbc.name') + t('configurations.columns.properties')">
        <a-descriptions-item :label="t('properties.icbc.appId')">
          {{ properties.appId }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.icbc.privateKey')">
          {{ properties.privateKey }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.icbc.signType')">
          {{ properties.signType }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.icbc.charset')">
          {{ properties.charset }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.icbc.format')">
          {{ properties.format }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.icbc.icbcPublicKey')">
          {{ properties.icbcPublicKey }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.icbc.encryptKey')">
          {{ properties.encryptKey }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.icbc.encryptType')">
          {{ properties.encryptType }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.icbc.ca')">
          {{ properties.ca }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.icbc.password')">
          {{ properties.password }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.icbc.emSignIp')">
          {{ properties.emSignIp }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.icbc.emSignPort')">
          {{ properties.emSignPort }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.icbc.emProduct')">
          {{ properties.emProduct }}
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