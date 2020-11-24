<template>
        <div class="jumb jumbotron jumbotron-fluid bg-dark">
      <div class="jumbotron-background-hi">
        <img src="https://placeimg.com/2000/1000/nature" class="blur " />
      </div>

      <div class="container text-white">
        <h1 class="display-4">Q&A 게시판</h1>
        <p class="lead">
          HappyHouse에서는 고객님을 항상 최우선시 하며, 24시간 질의응답을 합니다.
        </p>
      </div>
      <!-- /.container -->
    </div>
</template>

<script>
export default {
    
}
</script>

<style>
.jumb {
  position: relative;
  overflow: hidden;
}

.jumb .container {
  position: relative;
  z-index: 2;

  background: rgba(0, 0, 0, 0.2);
  padding: 2rem;
  border: 1px solid rgba(0, 0, 0, 0.1);
  border-radius: 3px;
}

.jumbotron-background-hi {
  object-fit: cover;
  font-family: "object-fit: cover;";
  position: absolute;
  top: 0;
  z-index: 1;
  width: 100%;
  height: 100%;
  opacity: 0.5;
}

img.blur {
  -webkit-filter: blur(4px);
  filter: blur(4px);
  filter: progid:DXImageTransform.Microsoft.Blur(PixelRadius='4');
}
</style>