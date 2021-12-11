<template>

  <div id="app">
    <div id="tender">TEnder</div>
    <div id="nav">
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''"> logout </router-link>
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

@import url('https://fonts.googleapis.com/css2?family=Rubik:ital,wght@1,900&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Rubik&display=swap');

 #tender{
   font-family: 'Rubik', sans-serif;
   font-weight: 1000;
   font-style: italic;
   font-size: 80px;
   color: plum;


   /* alt header */
   /* color: rgb(179, 146, 172); */

  }

  #app{
    font-family: 'Rubik', sans-serif;
  }

  #nav{
    font-family: 'Rubik', sans-serif;
  }

</style>
