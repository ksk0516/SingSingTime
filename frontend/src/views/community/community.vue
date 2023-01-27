<template>
  <h2><b>Community</b></h2>

  <ul class="infinite-list" v-infinite-scroll="load" style="overflow: auto">
    <li
      v-for="i in state.count"
      class="infinite-list-item"
      @click="clickContent(i)"
      :key="i"
    >
      <ContentBox />
    </li>
  </ul>
</template>

<script>
import ContentBox from "./component/content.vue";
import { reactive } from "vue";
import { useRouter } from "vue-router";

export default {
  name: "CommunityBox",
  components: {
    ContentBox,
  },
  setup() {
    const router = useRouter();
    // const store = createStore();
    const state = reactive({
      count: 12,
    });

    const load = function () {
      state.count += 4;
    };

    const clickContent = function (id) {
      router.push({
        name: "ContentsBox",
        params: { Id: id },
      });
    };

    return { state, load, clickContent };
  },
};
</script>

<style>
.infinite-list {
  padding-left: 0;
  max-height: calc(100% - 35px);
}

@media (min-width: 701px) and (max-width: 1269px) {
  .infinite-list {
    min-width: 700px;
  }
}

@media (min-width: 1270px) {
  .infinite-list {
    min-width: 1021px;
  }
}

.infinite-list .infinite-list-item {
  min-width: 335px;
  max-width: 25%;
  display: inline-block;
  cursor: pointer;
}
</style>
