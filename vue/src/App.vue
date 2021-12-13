<template>
  
  <div id="app">

    <header>

      <img src=".\assets\tendericon.png" alt="TEnder logo" class="logo">
      <div id="tender">TEnder</div>
      <div class="filler"></div>
      <div id="nav">
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''"> logout </router-link>
        <img src=".\assets\user.png" alt="User" class="user-icon">
      </div>

    </header>

    <router-view></router-view>

    <footer>

      <div id="tenderco">© TEnder Co. 2021</div>
      <div id="garydanko">With special thanks to Gary Danko</div>

    </footer>

  </div>
</template>

<style>
@import url('https://fonts.googleapis.com/css2?family=Rubik:ital,wght@1,900&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Rubik&display=swap');


#nav{
  float: right;
}

 #tender{
   font-family: 'Rubik', sans-serif;
   font-weight: 1000;
   font-style: italic;
   font-size: 75px;
   color: plum;
   text-shadow: 1px 5px purple;
  }

  #app{
    font-family: 'Rubik', sans-serif;
    background-color: rgb(255, 255, 235);
  }

  header {
    background-color:  rgb(255, 255, 235);
    padding: 5px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin: 0px;
  }

  footer {
    background-color:  rgb(255, 255, 235);
    padding: 10px;
    display: flex;
    justify-content: space-between;
  }

  .filler {
    flex-grow: 1;
  }

  #tenderco, #garydanko {
    font-family: 'Rubik', sans-serif;
    font-weight: 500;
    font-size: 15px;
  }

  button {
    font-family: 'Rubik', sans-serif;
  }
  
  input {
    font-family: 'Rubik', sans-serif;
  }

  .logo {
    width: 75px;
    height: 75px;
  }

  .user-icon {
    width: 50px;
    height: 50px;
  }

  /* SCREEN DIFFERENCES */

  @media screen and (max-width: 450px) {

    #tender {
      font-size: 40px;
    }

    .logo {
      width: 40px;
      height: 40px;
    }

    .user-icon {
      width: 30px;
      height: 30px;
    }

  }

  @media screen and (max-width: 800px) and (min-width: 450px) {

    #tender {
      font-size: 60px;
    }

    .logo {
      width: 60px;
      height: 60px;
    }

    .user-icon {
      width: 40px;
      height: 40px;
    }

  }

</style>
