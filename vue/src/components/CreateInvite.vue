// this will be the form to enter info needed to generate an invite - it will populate the home view
<template>
<div class="view-content">
    <div class="invitation">

        <!-- do not show search until invite is created and invite ID is returned -->
        <!-- this deadline box needs to be bound to an invite to send to the db -->
        <form v-on:submit.prevent="submitInvite" class="inviteForm">
            <div id="deadlineDate">
                <label for="dueDate">Deadline Date: </label>
                <input type="date" id="dueDate" name="dueDate" v-model="invite.closing_date"/>
                <!-- <label for="time" > </label> -->
                <input type="text" name="timetrial" id="time" v-model="invite.closing_time" placeholder="enter time (HH:MM:SS)">
                <!-- The time format below does not work with the DB -->
                <!-- <input type="time" id="dueTime" name="dueTime" v-model="invite.closingTime"/> -->
                

                <!-- use the username registration logic here to make sure the link is truly unique -->
                <input type="text" id="uniqueUrl" name="uniqueUrl" v-model="invite.uniqueLink" placeholder="name your invite"/>
                <button type="button" id="searchButton" v-on:click="submitInvite()">SUBMIT</button>

            </div>
        </form>

        <!-- hide this until invite dates are picked -->
        <!-- <div v-bind:class="[showSearchOptions ? ] "> -->
          <search-restaurants/>
          <restaurant-list/>
        <!-- </div> -->
      
    
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
          showSearchOption: false,
          newInvite: [],  //this is where restaurants that are selected are stored
          isLoading: true,
          invite: {
              inviteId: "", 
              senderUserId: "", 
              closing_date: "",
            //   The time format below does not work with the DB
              closing_time: "",
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
              closing_date: this.invite.closing_date,
              //hard coded time - bad
              closing_time: this.invite.closing_time,
              //hard coded link - bad
              uniqueLink: this.invite.uniqueLink
        
          }
          inviteService
            .createInvite(newInvite)
            .then(response => {
                if(response.status === 201){
                alert("invite created")
                this.$store.commit("SET_CURRENT_INVITE", response.data);
                }
            }) 
          }, 

          //deal with the $Store here?
      }
  }
  
</script>

<style>



</style>