<template>

  <div class="home" id="home">

    <!-- <h1 class="pagename">Home</h1> -->
    

    <div class="buttons">
      <router-link to="/invite" id="createButton" tag="button">create an invite</router-link>
      <router-link to="/invite" id="viewButton" tag="button">view all invites</router-link>
    </div>
   

  </div>


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
  heigh

}



</style>