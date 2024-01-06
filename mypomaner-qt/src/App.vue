<script setup>
import {  RouterView } from 'vue-router'
</script>

<template>
  <!-- WelcomeItem.vue <header>
    <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" />

    <div class="wrapper">
      <HelloWorld msg="You did it!" />

      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/about">About</RouterLink>
      </nav>
    </div>
  </header>-->
  <lay-container fluid class="index-app">
    <div class="container-main">
      <RouterView />
    </div>
  </lay-container>


</template>

<style>
.selectCustomCss{
    width:100%;
}
</style>
<style scoped>
.index-app{
  padding:0 0;
}
.container-main {
  width:100%;
  min-height: 100%;
}
</style>
