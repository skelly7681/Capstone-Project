// this will be the form to enter info needed to generate an invite - it will populate the home view
<template>
<div class="view-content">
    <div class="invitation">
        <div class="nav">
            <router-link v-bind:to="{ name: 'home' }" id="home-button"> HOME </router-link>&nbsp;
        </div>

        <!-- this deadline box needs to be bound to an invite to send to the db -->
        <form v-on:submit.prevent="submitInvite" class="inviteForm">
            <div id="deadlineDate">
                <label for="dueDate">deadline date: </label>
                <input type="date" id="dueDate" name="dueDate" v-model="invite.closingDate"/> 
                <!-- The time format below does not work with the DB -->
                <!-- <input type="time" id="dueTime" name="dueTime" v-model="invite.closingTime"/> -->
                <button type="button" id="searchButton" v-on:click="submitInvite()">SUBMIT</button>
            </div>
        </form>

        <!-- hide this until invite dates are picked -->
        <search-restaurants/>
        
        <restaurant-list/>

        <!-- all imported componets here -->
    
    </div>
</div>
</template>

<script>
import SearchRestaurants from './SearchRestaurants.vue';
import inviteService from '../services/InviteServices';
import RestaurantList from './RestaurantList.vue';


export default {
  components: { SearchRestaurants, RestaurantList },
  data(){
      return{
          newInvite: [],  //this is where restaurants that are selected are stored
          isLoading: true,
          invite: {
              inviteId: "", //this is serial, so does it need to be here?
              senderUserId: "", //rip this from the current user object in the store
              closingDate: "",
            //   The time format below does not work with the DB
              closingTime: "",
              uniqueLink: "" //how tf do we make a unique link --> http://localhost8081/
        }
      }
  },
  created(){
      
  },
  methods: {
      submitInvite(){
          const newInvite = {
              inviteId: "",
            //   WE NEED TO PULL THE USERID OR HAVE THEM ENTER IT
              senderUserId: 3,  
              closingDate: this.invite.closingDate,
              closingTime: "12:00:00",
              uniqueLink: "23323"
            //   senderUserId: this.invite.senderUserId,
            //   closingDate: this.invite.closingDate,
            //   closingTime: this.invite.closingTime,
            //   uniqueLink: this.invite.uniqueLink
          }
          inviteService
            .createInvite(newInvite)
            .then(response => {
                if(response.status === 201){
                alert("invite created")
                }
            }) 
          }, 

          //deal with the $Store here?
      }
  }
  
</script>

<style>

</style>