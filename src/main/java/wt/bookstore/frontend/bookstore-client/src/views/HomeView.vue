<template>
  <div class="home">
    <!-- <img alt="Vue logo" src="../assets/logo.png"> -->
    <!-- <HelloWorld/> -->
    <LoginCard></LoginCard>


  </div>
</template>

<script>
// @ is an alias to /src
import LoginCard from '@/components/LoginCard.vue';

export default {
  name: 'HomeView',
  components: {
    LoginCard
}
}
</script>
