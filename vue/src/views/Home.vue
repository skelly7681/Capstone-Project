<template>

  <body>

    <div class="home-container" id="home">

      <!-- <h1 class="pagename">Home</h1> -->
      

      <div class="buttons">
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <router-link to="/invite" class="createButton" tag="button">CREATE AN INVITE</router-link>
        <br>
        <br>
        <br>
        <router-link to="/viewInvites" class="viewButton" tag="button">VIEW ALL INVITES</router-link>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
      </div>
    

    </div>

  </body>


</template>

<script>



export default {
  name: "home",
    data() {
    return {
      
      isLoading: true
    };
  },

  components: {
    
  }
}

</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Rubik:ital,wght@1,900&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Rubik&display=swap');

#createButton, #viewButton{
  font-family: 'Rubik', sans-serif;
  
}

body {
  display: flex;
  flex-direction: column;
  flex: 1;
  flex-grow: 1;
  flex-basis: 100%;
}

#home {
  display: flex;
  justify-content: center;
  background-image: linear-gradient(to bottom right, rgb(114, 227, 241), rgb(235, 124, 235));
}

button.createButton, button.viewButton {
  border: none;
  background-color: white;
  font-size: 24px;
  font-weight: 600;
  font-style: italic;
  border-radius: 25px;
  height: 100px;
  width: 350px;
  padding: 12px 32px;
  border: 5px solid plum;
}

button.createButton:hover, button.viewButton:hover {
  background-color: plum;
  color: white;
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}

/* SCREEN DIFFERENCES */

@media screen and (max-width: 400px) {
  button.createButton, button.viewButton {
  font-size: 18px;
  height: 75px;
  width: 275px;
}
}

</style>