import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";
import { loadFonts } from "./plugins/webfontloader";
import infiniteScroll from "vue-infinite-scroll";
import Carousel3d from "vue-carousel-3d";
import coverflow from "vue-coverflow";

loadFonts();

createApp(App)
  .use(router)
  .use(infiniteScroll)
  .use(store)
  .use(vuetify)
  .use(Carousel3d)
  .use(coverflow)
  .mount("#app");
