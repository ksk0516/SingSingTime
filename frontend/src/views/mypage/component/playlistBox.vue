<template>
  <v-row justify="sapce-between">
    <v-col align="start">제목</v-col>
    <v-col align="end">가수</v-col>
  </v-row>
  <ul>
    <li
      v-for="song in state.songs"
      :key="song"
      <songInfo :song="song"/>
    ></li>
  </ul>
</template>

<script>
import axios from "axios";
import { onMounted, reactive } from "vue";
import songInfo from "./songInfo.vue";
// import { onMounted, computed } from "vue";
// import { useStore } from "vuex";
// import { useRouter } from "vue-router";
// import { reactive } from "vue";

export default {
  name: "playlistBox",
  components: {
    songInfo,
  },
  setup() {
    // 사이트에 등록된 노래 리스트
    const state = reactive({
      songs: [],
    });
    onMounted(() => {
      axios({
        method: "get",
        url: import.meta.env.VITE_APP_URL + "/api/v1/users/songs",
        // url: import.meta.env.VITE_APP_URL + "/api/v1/users/",
      })
        .then((res) => {
          console.log(res.data);
          state.songs = res.data;
          console.log(state.songs);
        })
        .catch((err) => {
          console.log(err);
        });
    });
    // 사이트에 등록된 전체 노래 조회
    return {
      state,
    };
  },
};
</script>

<style>
</style>