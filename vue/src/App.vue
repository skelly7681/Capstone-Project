<template>
  
  <div id="app">

    <header>

      <img src="C:\Users\Student\final-capstone\phl-5-final-capstone-green-team2\vue\src\assets\tendericon.png" alt="TEnder logo" class="logo">
      <div id="tender">TEnder</div>
      <div class="filler"></div>
      <div id="nav">
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''"> logout </router-link>
        <img src="C:\Users\Student\final-capstone\phl-5-final-capstone-green-team2\vue\src\assets\user.png" alt="User">
      </div>

    </header>

    <router-view></router-view>

    <footer>

      <div id="tenderco">TEnder Co. 2021</div>
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
  }

  header {
    background-color: rgb(255, 255, 205);
    padding: 5px;
    display: flex;
    justify-content: space-between;
    margin: 0px;
  }

  footer {
    background-color: rgb(255, 255, 205);
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

</style>
