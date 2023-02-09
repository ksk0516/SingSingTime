import { createStore } from "vuex";
import createPersistedState from "vuex-persistedstate";
import accountStore from "./accountStore";
import youtubeStore from "./youtubeStore";
import contentStore from "./contentStore";


export default createStore({
  modules: {
    accountStore,
    youtubeStore,
    contentStore,
  },
  plugins: [
    createPersistedState({
      paths: ["accountStore"],
    }),
  ],
});
