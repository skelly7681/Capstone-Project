<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }" id="home-button">Home |</router-link>&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>

#home-button{
  display: flex;
}

#nav{
  float: right;
}

</style>
