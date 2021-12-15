// this will be the form to enter info needed to generate an invite - it will populate the home view
<template>
<div class="view-content">
    <div class="invitation">
      <h2 id="inviteTitle" >CREATE YOUR INVITE</h2>
        <!-- do not show search until invite is created and invite ID is returned -->
        <!-- this deadline box needs to be bound to an invite to send to the db -->
        <form v-on:submit.prevent="submitInvite" class="inviteForm">
            <div id="deadlineDate">
                <h3>Enter closing date:</h3>
                <input type="date" id="dueDate" name="dueDate" v-model="invite.closing_date"/>
                <br>
                <!-- <label for="time" > </label> -->
                <h3>Enter closing time:</h3>
                <input type="text" name="timetrial" id="time" v-model="invite.closing_time" placeholder="(hh:mm:ss)">
                <br>
                <!-- The time format below does not work with the DB -->
                <!-- <input type="time" id="dueTime" name="dueTime" v-model="invite.closingTime"/> -->
                <!-- use the username registration logic here to make sure the link is truly unique -->
                <h3>Enter invite name:</h3>
                <input type="text" id="uniqueUrl" name="uniqueUrl" v-model="invite.uniqueLink" placeholder="name"/>
                <br>
                <br>
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
              inviteId: "", //rip this from an axios call when we create an invite.
              senderUserId: "", //rip this from the current user object in the store
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
form.inviteForm {
    display: flex;
    flex-direction: row;
    justify-content: center;
}
#inviteTitle {
    display: flex;
    flex-direction: column;
    flex-basis: 1;
    padding: 10px;
    color: white;
    background-image: linear-gradient(to bottom right, rgb(114, 227, 241), rgb(235, 124, 235));
    font-weight: 600;
    font-style: italic;
}
input {
  width: 215px;
  padding: 10px 15px;
  border: 3px solid lightgray;
  border-radius: 10px;
  font-size: 16px;
  margin-right: 15px;
}
input:focus {
  border: 3px solid black;
}
#searchButton {
  border: none;
  background-color: rgb(243, 214, 243);
  font-size: 20px;
  border-radius: 25px;
  width: 250px;
  padding: 12px 32px;
}
#searchButton:hover {
  background-color: plum;
  color: white;
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}
</style>