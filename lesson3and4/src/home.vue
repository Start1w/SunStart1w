<template>
  <router-view></router-view>
  <div class="common-layout">
    <el-container class="cqkPage">
      <el-aside style="width: 21%" class="left-side">
        <Quxian class="shengchan" :pointCodeList="['储平1','储平2','排1', '排2', '监测1']" :carousel="true"></Quxian>
        <Chuqi class="shengchan" :pointCodeList="['储平1', '储平2']"></Chuqi>
        <Paishui class="shengchan" :pointCodeList="['排1', '排2']"></Paishui>
        <QishuiHeight class="shengchan"></QishuiHeight>
      </el-aside>
      <el-container>
        <el-header class="head">永21储气库</el-header>
        <el-main class="main">
          <el-carousel autoplay style="height: 80%">
            <el-carousel-item v-for="image_url in mid_url" :key="image_url"  style="height: 100vh">
              <el-image :src="image_url" fit="cover" style="height: 60vh"></el-image>
            </el-carousel-item>
          </el-carousel>
          <div>
            <!--   这里不知道需不需要获取历史数据展示，这段文字是从资料里提取的         -->
            <span>永21储气库地面位置位于东营市垦利县永安镇东南，是全国第一座强边底水水淹废弃气藏改建储气库，主要承担油田及东营市天然气市场的季节调峰应急供气任务。设计库容4.96亿立方米，垫底气量2.58亿方（基础垫底气量1.04亿方，补充垫底气量1.54亿方），工作气量2.38亿方。部署5口井，注气井2口、排水井2口、监测井1口。可研批复投资总额5.59亿元（其中：建设投资2.57亿元，垫底气3.02亿元）。
按照可研方案设计，将储气库运行分为工程建设期（2021年8月底前）、建库期（2027年前）和运行期（2027年以后）。建库期每年4月至10月为注气期，11月至次年3月为采气期，采用“多注少采，逐年垫气”的运行方式，6年累计注气8.21亿方，采气6.67亿方， 2027年达到稳定工作气量2.38亿方能力，完成建库达容。
2021年～2025年9月底永21储气库累计注气量21853.00万方（含垫底气12838.32万方），采气29.26万方，目前库存工作气量9014.68万方。
</span>
          </div>
        </el-main>
        <span style="display: flex; justify-content: space-between">
          <ZhuqiNum></ZhuqiNum>
          <Table_show></Table_show>
        </span>
      </el-container>
      <el-aside class="right-side" style="width: 21%">
        <span @click="goToDetail('chuping1')" style="width: 50%">
          <el-image :src="chuping1_image"></el-image>
          <p>永21-储平1井实际完井管柱图</p>
        </span>
        <span @click="goToDetail('chuping2')" style="width: 50%">
          <el-image :src="chuping2_image"></el-image>
          <p>永21-储平2井实际完井管柱图</p>
        </span>
        <span @click="goToDetail('jian1')" style="width: 50%">
          <el-image :src="jian1_image"></el-image>
          <p>永21-监1井实际完井管柱图</p>
        </span>
        <span @click="goToDetail('pai1')" style="width: 50%">
          <el-image :src="pai1_image"></el-image>
          <p>永21-排1井实际完井管柱图</p>
        </span>
        <span @click="goToDetail('pai2')" style="width: 50%">
          <el-image :src="pai2_image"></el-image>
          <p>永21-排2井实际完井管柱图</p>
        </span>
      </el-aside>
    </el-container>
  </div>
</template>

<script>
import Quxian from "@/components/quxian.vue";
import Chuqi from "@/components/shengchan.vue";
import Paishui from "@/components/paishui.vue";
import QishuiHeight from "@/components/qishuiHeight.vue";
import ZhuqiNum from "@/components/zhuqiNum.vue";
import Table_show from "@/components/table_show.vue";
import { useRouter } from 'vue-router';

export default {
  name: 'App',
  data() {
    return {
      mid_url: [require("./assets/mid.png"), require("./assets/mid2.png")],
      chuping1_image: require("./assets/chuping1jingtu.png"),
      chuping2_image: require("./assets/chuping2jingtu.png"),
      jian1_image: require("./assets/jian1jing.png"),
      pai1_image: require("./assets/pai1jing.png"),
      pai2_image: require("./assets/pai2jing.png")
    }
  },
  components: {
    Table_show,
    ZhuqiNum,
    QishuiHeight,
    Quxian,
    Chuqi,
    Paishui
  },
  setup(){
    const router = useRouter();
    const goToDetail = (detail) => {
      router.push({name:'wellDetail', params: {pointCode: detail}})
    };
    return {goToDetail};
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
.left-side{
  margin-top: 30px;
}
.right-side{
  margin-top: 30px;
  display: flex;
  flex-wrap: wrap;
}
.right-side span{
  margin-top: 30px;
  display: flex;
  flex-wrap: wrap;
}
.right-side span{
  text-align: center;
  margin: 0 auto 0 auto;
}
.shengchan{
  width: 100%;
}
.cqkPage {
  display: flex;
  justify-content: space-between;
  margin-top: 20px;
}
.head{
  height: 10%;
}
.main{
  margin: 0;
  height: 75%;
}
.foot{
  display: flex;
  flex-direction: row;
  width: 100%;
  height: 20%;
}
</style>
