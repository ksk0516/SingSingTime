<!-- <template>
  <h2><b>Today's Highlight</b></h2>
  <v-carousel v-model="model" align="center">
    <v-carousel-item v-for="(color, i) in colors" :key="color">
      <v-sheet :color="color" height="100%" width="50%" tile>
        <v-row
          class="fill-height"
          align="start"
          justify="space-between"
          style="padding-top: 20px"
        >
          <div class="text-h6" style="margin-left: 20px">View 1,332</div>
          <div class="text-h6">
            오늘의 {{ i + 1 }}번째 영상<v-icon>mdi-heart</v-icon>
          </div>
          <div class="text-h6" style="margin-right: 20px">782 UP</div>
        </v-row>
      </v-sheet>
    </v-carousel-item>
  </v-carousel>
</template> -->

<template>
  <h2><b>Today's Highlight</b></h2>
  <div style="padding: 10px">
    <carousel :items-to-show="3.95" :wrap-around="true" :transition="500">
      <slide v-for="slide in 10" :key="slide">
        <div class="carousel_item">{{ slide }}</div>
      </slide>

      <template #addons>
        <navigation />
        <pagination />
      </template>
    </carousel>
  </div>
</template>

<script>
import { defineComponent } from "vue";
import "vue3-carousel/dist/carousel.css";
import { Carousel, Slide, Pagination, Navigation } from "vue3-carousel";

export default defineComponent({
  name: "HighlightBox",
  data: () => ({
    model: 0,
    colors: ["primary", "secondary", "yellow darken-2", "red", "orange"],
  }),
  components: {
    Carousel,
    Slide,
    Pagination,
    Navigation,
  },
});
</script>

<style scoped>
.carousel__slide {
  padding: 5px;
}

.carousel__viewport {
  perspective: 2000px;
}

.carousel__track {
  transform-style: preserve-3d;
}

.carousel__slide--sliding {
  transition: 0.5s;
}

.carousel__slide {
  opacity: 0.9;
  transform: rotateY(-10deg) scale(0.9);
}

.carousel__slide--active ~ .carousel__slide {
  transform: rotateY(10deg) scale(0.9);
}

.carousel__slide--prev {
  opacity: 1;
  transform: rotateY(-20deg) scale(0.95);
}

.carousel__slide--next {
  opacity: 1;
  transform: rotateY(10deg) scale(0.95);
}

.carousel__slide--active {
  opacity: 1;
  transform: rotateY(0) scale(1.1);
}
.carousel_item {
  width: 500px;
  height: 300px;
  padding: 15px;
  background-color: skyblue;
}
</style>
