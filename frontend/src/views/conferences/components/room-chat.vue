<template>
  <div
    class="
      absolute
      flex
      top-0
      h-screen
      z-20
      right-0
      flex-row
      border-l border-main-100
    "
  >
    <!-- chat-bar -->
    <div
      ref="content"
      class="
        transition-all
        pt-16
        pb-12
        px-8
        w-80
        duration-700
        bg-main-300
        overflow-hidden
        flex flex-col
        items-center
        justify-between
      "
      style="font-size: 20px"
    >
      <div
        style="
          overflow: scroll;
          height: 800px;
          width: 2400px;
		  margin-left:300px;
          overflow-x: hidden;
        "
      >
        <!-- 채팅 내용 -->
        <ul
          class="
            border-2
            h-full
            w-full
            border-main-100
            bg-tc-500
            p-4
            overflow-y-auto
            m-0
          "
          id="chat-bar"
        >
          <li
            class="flex flex-col mb-2"
            v-for="(chat, idx) in state.chats"
            :key="idx"
          >
            <!-- 내가 보낸 채팅인 경우 -->
            <div v-if="chat.isMyMessage" class="border-r-2 border-sub-200 pr-2">
              <div class="flex flex-row-reverse items-center text-right">
                <span
                  class="text-sub-200 text-md ml-2 font-bold"
                  style="color: whitesmoke; font-size:20px;"
                  >Me
                </span>
                <span class="text-tc-400 text-xs" style="color: whitesmoke; font-size:20px;"
                  >({{ chat.time }})</span
                >
              </div>
              <div>
                <p
                  class="text-tc-300 text-sm break-all"
                  style="color: whitesmoke; font-size:30px;"
                >
                  {{ chat.content }}
                </p>
              </div>
            </div>
            <!-- 다른 사람이 보낸 채팅인 경우 -->
            <div v-else class="border-l-2 border-main-100 pl-2">
              <div class="flex flex-row items-center text-left">
                <span
                  class="text-main-100 text-md mr-2 font-bold"
                  style="color: cornflowerblue; font-size:20px;"
                  >{{ chat.userId }}</span
                >
                <span class="text-tc-400 text-xs" style="color: cornflowerblue; font-size:20px;"
                  >({{ chat.time }})</span
                >
              </div>
              <div>
                <p
                  class="text-tc-300 text-sm break-all"
                  style="color: cornflowerblue; font-size:30px;"
                >
                  {{ chat.content }}
                </p>
              </div>
            </div>
          </li>
        </ul>
      </div>

      <div class="flex flex-col items-start w-full mt-8">
        <!-- 메시지 작성 -->
        <div
          class="w-full p-0 flex flex-row justify-between items-center"
          style="color: whitesmoke"
        >
          <textarea
            placeholder="채팅을 입력해주세요!"
            v-model="state.message"
            @keydown.enter="sendMessage"
            class="
              w-5/6
              border-2 border-main-100
              focus:border-main-100 focus:border-2
              resize-none
            "
            cols=""
            rows=""
            style="
              border: 5px solid whitesmoke;
              font-size: 30px;
              width: 1000px;
              height: 60px;
            "
          ></textarea>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
.border-3 {
  border-width: 3px;
}
.h-5-5 {
  height: 1.375rem;
}
.send-icon {
  fill: #6667ab;
}
</style>

<script>
import { reactive } from "vue";
export default {
  props: {
    subscribers: Object,
  },
  setup(props, { emit }) {
    const state = reactive({
      // right: true,
      isSidebarOpen: true,
      selectedUser: "all",
      message: "",
      subscribers: props.subscribers,
      chats: [],
    });
    const sendMessage = () => {
      let strippeddMessage = state.message.trim();
      if (strippeddMessage === "") return;
      console.log("보낼 메시지 : " + strippeddMessage);
      emit("message", {
        content: strippeddMessage,
        to: state.selectedUser,
      });
      event.preventDefault(); // enter키 누를 때 줄바꿈 방지
      state.message = ""; // 메시지 창 초기화
      console.log(state.subscribers);
    };
    const addMessage = async (messageData, isMyMessage) => {
      let message = JSON.parse(messageData);
      // 내가 보낸 메시지인 경우
      if (isMyMessage) {
        message.sender += " (You)";
      }

      let chatBar = document.querySelector("#chat-bar");
      let isScrollBottom =
        chatBar.scrollHeight - chatBar.scrollTop <= chatBar.clientHeight + 2;
      // await 키워드 => 새로운 채팅 메시지 추가 완료 후 스크롤바가 아래로 이동되도록 함.
      await state.chats.push({
        userId: message.sender,
        time: message.time,
        content: message.content,
        isMyMessage: isMyMessage,
      });
      // 채팅 스크롤이 끝까지 내려가 있는 경우 => 스크롤바 맨 아래로 이동시키기
      if (isScrollBottom) {
        chatBar.scrollTo({ top: chatBar.scrollHeight, behavior: "smooth" });
      }
      console.log("메시지 수신 완료");
    };
    return { state, sendMessage, addMessage };
  },
};
</script>
