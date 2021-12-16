<template>
  <div>
      <div id="generalDisplay">
        <!-- this will first display a list of user invites with a indication if it is pending or completed -->
        <!-- clicking a completed invite in the list takes them to a view that displays the finalist -->
        <!-- clicking a pending invite shows them which restaurants were selected for the invitation --> 
      </div>

      
      <open-invites/>
      <!-- <display-finalist/> -->
      <br>
      <br>
      <br>
      
  </div>
</template>

<script>
// import DisplayFinalist from '../components/DisplayFinalist.vue'
import OpenInvites from '../components/OpenInvites'


export default {
    components :{
        // DisplayFinalist, 
        OpenInvites,
    }

}
</script>

<style>
        
</style>
