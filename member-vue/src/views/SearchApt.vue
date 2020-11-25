<template>
  <div>
    <div class="jumb jumbotron jumbotron-fluid bg-dark">
      <div class="jumbotron-background-hi">
        <img src="https://placeimg.com/2000/1000/nature" class="blur " />
      </div>

      <div class="container text-white">
        <h1 class="display-4">Search House</h1>
        <p class="lead">
          HappyHouse에서는 보다 최신의 부동산 데이터를 제공하려 노력하고
          있습니다.
        </p>
      </div>
      <!-- /.container -->
    </div>

    <div class="container"></div>
    <!-- google map 부분  -->
    <div id="app">
      <google-map />
    </div>
  </div>
</template>

<script>
import GoogleMap from "../components/GoogleMap";

export default {
  name: "App",
  components: {
    GoogleMap,
    // AptList,
  },
};
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
