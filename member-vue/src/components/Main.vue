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
                class="mb-2"
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
                class="mb-2"
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
                class="mb-2"
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
          <button class="btn btn-outline-info btn-sm " style="float: right;">
            더보기
          </button>
          <br />
        </div>

        <hr />

        <ul class="list-group notilist">
          <a
            href="http://blog.naver.com/zigbang/222066167555"
            target="_blank"
            class="list-group-item list-group-item-action"
            data-toggle="tooltip"
            title="[공지] HappyHouse 개인정보처리방침(2020/08/27) 개정 안내"
            >[공지] HappyHouse 개인정보처리방침(2020/08/27) 개정 안내</a
          >
          <a
            href="http://blog.naver.com/zigbang/222066167555"
            target="_blank"
            class="list-group-item list-group-item-action"
            data-toggle="tooltip"
            title="[공지] HappyHouse 개인정보처리방침(2020/08/27) 개정 안내"
            >[공지] HappyHouse 개인정보처리방침(2020/08/27) 개정 안내</a
          >
          <a
            href="http://blog.naver.com/zigbang/222066167555"
            target="_blank"
            class="list-group-item list-group-item-action"
            data-toggle="tooltip"
            title="[공지] HappyHouse 개인정보처리방침(2020/08/27) 개정 안내"
            >[공지] HappyHouse 개인정보처리방침(2020/08/27) 개정 안내</a
          >
          <a
            href="http://blog.naver.com/zigbang/222066167555"
            target="_blank"
            class="list-group-item list-group-item-action"
            data-toggle="tooltip"
            title="[공지] HappyHouse 개인정보처리방침(2020/08/27) 개정 안내"
            >[공지] HappyHouse 개인정보처리방침(2020/08/27) 개정 안내</a
          >
          <a
            href="http://blog.naver.com/zigbang/222066167555"
            target="_blank"
            class="list-group-item list-group-item-action"
            data-toggle="tooltip"
            title="[공지] HappyHouse 개인정보처리방침(2020/08/27) 개정 안내"
            >[공지] HappyHouse 개인정보처리방침(2020/08/27) 개정 안내</a
          >
          <a
            href="http://blog.naver.com/zigbang/222066167555"
            target="_blank"
            class="list-group-item list-group-item-action"
            data-toggle="tooltip"
            title="[공지] HappyHouse 개인정보처리방침(2020/08/27) 개정 안내"
            >[공지] HappyHouse 개인정보처리방침(2020/08/27) 개정 안내</a
          >
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Main",
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
