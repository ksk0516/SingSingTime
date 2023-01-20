import { createRouter, createWebHashHistory } from "vue-router";
import CommunityView from "../views/community/community.vue";
import ConferencesView from "../views/conferences/conferences.vue";
import HomeView from "../views/home/home.vue";
import MypageView from "../views/mypage/mypage.vue";
import RankView from "../views/rank/rank.vue";

const routes = [
  {
    path: "/",
    name: "HomeBox",
    component: HomeView,
  },
  {
    path: "/rank",
    name: "RankBox",
    component: RankView,
  },
  {
    path: "/conferences",
    name: "ConferencesBox",
    component: ConferencesView,
  },
  {
    path: "/community",
    name: "CommunityBox",
    component: CommunityView,
  },
  {
    path: "/mypage",
    name: "MypageBox",
    component: MypageView,
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
