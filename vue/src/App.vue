<template>
  
  <div id="app">

    <header>

      <img src=".\assets\tendericon.png" alt="TEnder logo" class="logo">
      <div id="tender">TEnder</div>
      <div class="filler"></div>
      <div id="nav">
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''"> Logout </router-link>
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
   font-size: 10vh;
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
    width: 10vh;
    height: 10vh;
  }

  /* SCREEN DIFFERENCES */

  @media screen and (max-width: 400px) {

    .logo {
      width: 12vw;
      height: 12vw;
    }

    #tender {
      font-size: 12vw;
    }

    #garydanko {
      display: none;
    }
    
  }

  @media screen and (max-width: 600px) and (min-width: 400px) {

    .logo {
      width: 14vw;
      height: 14vw;
    }

    #tender {
      font-size: 14vw;
    }

  }

</style>
