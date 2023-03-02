<template>
  <div class="about">
    <!-- <img alt="Vue logo" src="../assets/logo.png"> -->
    <!-- <HelloWorld/> -->
    <SideBar></SideBar>


  </div>
</template>

<script>
// @ is an alias to /src
import SideBar from '@/components/SideBar.vue';

export default {
  name: 'AboutView',
  components: {
    SideBar
}
}
</script>