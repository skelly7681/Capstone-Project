// this will be the form to enter info needed to generate an invite - it will populate the home view
<template>
<div class="view-content">
    <search-restaurants/>
    <restaurant-list/>
    <div class="invitation">
        <div class="nav">
            <router-link v-bind:to="{ name: 'home' }" id="home-button"> home </router-link>&nbsp;
        </div>


        <!-- this deadline box needs to be bound to an invite to send to the db -->
        <form v-on:submit.prevent="submitInvite" class="inviteForm">
            <div id="deadlineDate">
                <label for="dueDate">deadline date: </label>
                <input type="date" id="dueDate" name="dueDate" v-model="invite.closingDate"/> 
                <input type="time" id="dueTime" name="dueTime" v-model="invite.closingTime"/>
            </div>
            <div>
                <label for="userId">User ID: Enter number to track your Invite</label>
                <input type="text" name="userId" id="userId" v-model="invite.senderUserId">
            </div>
        </form>

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
              senderUserId: "",
              closingDate: "",
              closingTime: "",
              uniqueLink: "" //how tf do we make a unique link
        }
      }
  },
  created(){
      
  },
  methods: {
      submitInvite(){
          const newInvite = {
              inviteId: "",
              senderUserId: this.invite.senderUserId,
              closingDate: this.invite.closingDate,
              closingTime: this.invite.closingTime,
              uniqueLink: this.invite.uniqueLink
          }
          inviteService
            .createInvite(newInvite)
            .then(response => {
                if(response.status === 201){
                this.$router.push('/')
                }
            }) 
          }, 

          //deal with the $Store here?
      }
  }
  
</script>

<style>

</style>