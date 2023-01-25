<template>
  <div>
    {{ $route.params.Id + "번 방 상세 보기 페이지" }}
  </div>
</template>
<style></style>
<script>
import { reactive, onMounted, onUnmounted } from "vue";
// import { useStore } from "vuex";
import { useRoute } from "vue-router";

export default {
  name: "Conference_Detail",

  setup() {
    const route = useRoute();
    // const store = useStore();
    const state = reactive({
      conferenceId: "",
    });
    onMounted(() => {
      console.log(route.params.name);
      state.conferenceId = route.params.Id;
    });
    onUnmounted(() => {
      state.conferenceId = "";
    });
    return { state };
  },
};
</script>
