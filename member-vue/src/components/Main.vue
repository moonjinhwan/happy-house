<template>
  <div class="row">
    <div class="bottom-main col-sm-7">
      <h2>Happy House에서 알려주는 부동산 가이드</h2>
      <b-container class="bv-example-row" style="padding-top:30px;">
        <b-row>
          <b-col
            ><div>
              <b-card
                title="부동산 상식"
                img-src="dd.jpg"
                img-alt="Image"
                img-top
                tag="article"
                style="max-width: 20rem;"
                class="mb-2 shadow-sm p-3 mb-5 bg-white rounded"
                
              >
                <b-card-text>
                  임대차 계약서 작성시 이것만 알아두면 당신은 부동산의 왕!
                </b-card-text>

                <b-button
                  href="https://post.naver.com/viewer/postView.nhn?volumeNo=26596142&memberNo=2120568"
                  target="_blank"
                  variant="outline-info"
                  >바로 가기</b-button
                >
              </b-card>
            </div></b-col
          >
          <b-col
            ><div>
              <b-card
                title="생활 꿀팁"
                img-src="bb.jpg"
                img-alt="Image"
                img-top
                tag="article"
                style="max-width: 20rem;"
                class="shadow-sm p-3 mb-5 bg-white rounded"
              >
                <b-card-text>
                  이사를 준비한다면 필독!!! 이사 체크 리스트
                </b-card-text>

                <b-button
                  href="https://post.naver.com/viewer/postView.nhn?volumeNo=25389507&memberNo=2120568"
                  target="_blank"
                  variant="outline-info"
                  >바로 가기</b-button
                >
              </b-card>
            </div></b-col
          >
          <b-col
            ><div>
              <b-card
                title="Happy House이야기"
                img-src="cc.jpg"
                img-alt="Image"
                img-top
                tag="article"
                style="max-width: 20rem;"
                class="mb-2 shadow-sm p-3 mb-5 bg-white rounded"
              >
                <b-card-text>
                  Happy house 와 함꼐 나에게 꼭 맞는 방을 찾는 방법!
                </b-card-text>

                <b-button
                  href="https://post.naver.com/viewer/postView.nhn?volumeNo=26311435&memberNo=2120568"
                  target="_blank"
                  variant="outline-info"
                  >바로 가기</b-button
                >
              </b-card>
            </div></b-col
          >
        </b-row>
      </b-container>
    </div>
    <div
      class="col-sm-3"
      style="padding-left: 3%; padding-right: 3%; padding-top:3%"
    >
      <div class="notification">
        <div>
          <h4 style="display: inline-block; float: left;">
            <strong>공지사항</strong>
          </h4>
          <button class="btn btn-outline-info btn-sm" style="float: right;">
            <router-link
              to="/noticeList"
              style="color: green ;"
              onmouseover="this.style.color='white';"
              onmouseout="this.style.color='green';"
              >더보기</router-link
            >
          </button>
          <br />
        </div>

        <hr />

        <ul class="list-group notilist">
          <list-row
            v-for="(item, index) in items.slice(0,6)"
            :key="`${index}_items`"
            :no="item.no"
            :title="item.title"
            :writer="item.writer"
            :regtime="item.regtime"
          />
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import ListRow from "@/components/mainNoticeRow.vue";
import http from "@/util/http-common";

export default {
  name: "Main",
  components: {
    ListRow,
  },
  data: function() {
    return {
      items: [],
    };
  },
  created() {
    http
      .get("/notice")
      .then(({ data }) => {
        this.items = data;
      })
      .catch(() => {
        alert("에러가 발생했습니다.");
      });
  },
  props: {
    msg: String,
  },
};
</script>

<style scoped>
.bottom-main {
  padding-top: 100px;
  padding-bottom: 100px;
  margin-left: 150px;
}
.box {
  outline: 5px black;
}
.notification {
  padding-top: 100px;
  padding-bottom: 100px;
  margin-left: 0px;
}
.notilist {
  text-align: left;
}
.list-group-item {
  display: inline-block;
  width: 410px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
