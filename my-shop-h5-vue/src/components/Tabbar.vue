<template>
  <yd-tabbar fixed>
    <yd-tabbar-item title="首页" link="#" active>
      <yd-icon name="home-outline" slot="icon" size="0.54px"></yd-icon>
    </yd-tabbar-item>
    <yd-tabbar-item title="购物车" link="#" dot>
      <yd-icon name="shopcart-outline" slot="icon" size="0.54px"></yd-icon>
    </yd-tabbar-item>
    <yd-tabbar-item title="个人中心" link="#">
      <yd-icon name="ucenter" slot="icon" size="0.54px"></yd-icon>
      <yd-badge slot="badge" type="danger">2</yd-badge>
    </yd-tabbar-item>
  </yd-tabbar>
</template>

<script type="text/babel">
  export default {
    name: 'Tabbar'
  }
</script>
