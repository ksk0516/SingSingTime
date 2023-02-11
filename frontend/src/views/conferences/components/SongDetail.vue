<template>
  <div v-if="video">
    <vue-countdown
      v-if="!this.selectedVideo"
      :time="4 * 60 * 1000"
      v-slot="{ minutes, seconds }"
    >
      <h3 :class="{ hurryup: minutes == 0 && seconds <= 30 }">
        남은 투표 시간 : {{ minutes }} 분 {{ seconds }} 초
      </h3>
    </vue-countdown>
    <iframe
      :src="`https://www.youtube.com/embed/${videoId}?autoplay=1`"
      frameborder="0"
      style="width: 700px; height: 500px"
      allow="autoplay"
    ></iframe>
    <!-- <h5>{{ video.snippet.title | stringUnescape }}</h5> -->
  </div>
</template>
<script>
import VueCountdown from "@chenfengyuan/vue-countdown";

export default {
  name: "SongDetail",
  components: {
    VueCountdown
  },
  data: function () {
    return {
      videoId: undefined,
      video: false,
    };
  },
  props: {
    selectvideo: "",
    session: Object,
  },
  created() {
    this.video = false;
    console.log();
    this.session.on("signal:song", (event) => {
      const id = event.data.slice(1, -1);
      console.log("session에서 받은 id : " + id);
      this.videoId = id;
      console.log(id);
      this.video = true;
    });
  },
};
</script>

<style scoped></style>
