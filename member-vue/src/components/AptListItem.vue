<template>
  <tr @click="aptDetail">
    <td>{{ aptInfo.dong }}</td>
    <td>{{ aptInfo.aptName }}</td>
    <td>{{ aptInfo.jibun }}</td>
  </tr>
</template>

<script>
import axios from 'axios';
import { mapMutations } from 'vuex';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  data() {
    return {};
  },
  props: {
    aptInfo: Object,
  },
  methods: {
    ...mapMutations({
      setDetail: 'APTDETAIL',
    }),

    aptDetail: function() {
      // const API_KEY =
      //   '9Xo0vlglWcOBGUDxH8PPbuKnlBwbWU6aO7%2Bk3FV4baF9GXok1yxIEF%2BIwr2%2B%2F%2F4oVLT8bekKU%2Bk9ztkJO0wsBw%3D%3D';
      // const API_URL =
      //   'http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?LAWD_CD=' +
      //   this.aptInfo.code +
      //   '&DEAL_YMD=202010&serviceKey=' +
      //   API_KEY;

      axios
        .post(`${SERVER_URL}/map/detail`, {
          dong: this.aptInfo.dong,
          aptName: this.aptInfo.aptName,
        })
        .then((response) => {
          console.log(response);
          // this.setDetail(response.data.response.body.items.item);
          this.setDetail(response.data.detailInfo);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
