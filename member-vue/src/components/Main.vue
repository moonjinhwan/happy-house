<template>
  <div class="bottom-main">
    <h2>Happy House에서 알려주는 부동산 가이드</h2>
    <b-container class="bv-example-row" style="padding:30px">
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
  padding: 100px;
}
.box {
  outline: 5px black;
}
</style>
