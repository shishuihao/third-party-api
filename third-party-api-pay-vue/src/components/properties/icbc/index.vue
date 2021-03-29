<template>
  <div>
    <a-card>
      <a-descriptions :title="t('properties.' + properties.channelId + '.name') + t('configurations.columns.properties')">
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.appId')">
          {{ properties.appId }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.privateKey')">
          {{ properties.privateKey }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.signType')">
          {{ properties.signType }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.charset')">
          {{ properties.charset }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.format')">
          {{ properties.format }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.icbcPublicKey')">
          {{ properties.icbcPublicKey }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.encryptKey')">
          {{ properties.encryptKey }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.encryptType')">
          {{ properties.encryptType }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.ca')">
          {{ properties.ca }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.password')">
          {{ properties.password }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.emSignIp')">
          {{ properties.emSignIp }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.emSignPort')">
          {{ properties.emSignPort }}
        </a-descriptions-item>
        <a-descriptions-item :label="t('properties.' + properties.channelId + '.emProduct')">
          {{ properties.emProduct }}
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
});
</script>

<style scoped>

</style>