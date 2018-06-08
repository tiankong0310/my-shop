<template>
  <yd-list theme="3">
    <yd-list-item v-for="item, key in list" :key="key">
      <img slot="img" :src="item.img">
      <span slot="title">{{item.title}}</span>
      <yd-list-other slot="other">
        <div>
          <span class="demo-list-del-price"><em>¥</em>{{item.price}}</span>
          <span class="demo-list-price">¥{{item.w_price}}</span>
        </div>
      </yd-list-other>
    </yd-list-item>
  </yd-list>
</template>

<script type="text/babel">
  export default {
    name: 'GoodsList',
    data() {
      return {
        list: [
          {img: "//img1.shikee.com/try/2016/06/23/14381920926024616259.jpg", title: "标题111标题标题标题标题", price: 156.23, w_price: 89.36},
          {img: "//img1.shikee.com/try/2016/06/21/10172020923917672923.jpg", title: "标题222标题标题标题标题", price: 256.23, w_price: 89.36},
          {img: "//img1.shikee.com/try/2016/06/23/15395220917905380014.jpg", title: "标题333标题标题标题标题", price: 356.23, w_price: 89.36},
          {img: "//img1.shikee.com/try/2016/06/25/14244120933639105658.jpg", title: "标题444标题标题标题标题", price: 456.23, w_price: 89.36},
          {img: "//img1.shikee.com/try/2016/06/26/12365720933909085511.jpg", title: "标题555标题标题标题标题", price: 556.23, w_price: 89.36},
          {img: "//img1.shikee.com/try/2016/06/19/09430120929215230041.jpg", title: "标题666标题标题标题标题", price: 656.23, w_price: 89.36}
        ]
      }
    }
  }
</script>
<style scoped>
  .demo-list-del-price{
    text-decoration-line: line-through;
    text-decoration-color: red;
  }
</style>
