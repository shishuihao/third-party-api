<template>
  <div>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import {useI18n} from "vue-i18n";

export default defineComponent({
  name: "Transactions",
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