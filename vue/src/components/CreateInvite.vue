// this will be the form to enter info needed to generate an invite - it will populate the home view
<template>
<div class="view-content">
    <div class="invitation">
      <h2 id="inviteTitle" >CREATE YOUR INVITE</h2>
      
        <form v-on:submit.prevent="submitInvite" class="inviteForm" v-if="inProcess">
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

        <div class="tender-deadline" v-if="!inProcess">
          <h2> Your friends must pick by {{this.invite.closing_date}} at {{this.invite.closing_time}}</h2>
          <h2> Send them this link: http://localhost:8081/vote/{{this.invite.inviteId}} </h2>

          <button type="button" id="pending" v-on:click="viewVote()">view pending invite</button>
          <h2> Hold onto this, this is your invite ID: {{this.invite.inviteId}} (you'll need this to see final selections)</h2>


        </div>

        <!-- hide this until invite dates are picked -->
        <!-- <div v-bind:class="[showSearchOptions ? ] "> -->

          <search-restaurants v-if="!inProcess"/>
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
          searchCompleted: true,
          inProcess: true,
          newInvite: [],  //this is where restaurants that are selected are stored
          isLoading: true,
          invite: {
              inviteId: "", //rip this from an axios call when we create an invite.
              senderUserId: "", //rip this from the current user object in the store
              closing_date: "",
            //   The time format below does not work with the DB
              closing_time: "",
              uniqueLink: "" 
        }
      }
  },
  created(){
  },
  methods: {
      submitInvite(){
          this.inProcess = false;
          this.showSearchOption = true;
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
                this.$store.commit("SET_CURRENT_INVITE", response.data);
                this.invite.inviteId = response.data;
                }
            }) 
          }, 
          viewVote(){
            let linkUrl = "http://localhost:8081/vote/" + this.invite.inviteId;
            window.open(linkUrl);
        }
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
#searchButton, #pending {
  border: none;
  background-color: rgb(243, 214, 243);
  font-size: 20px;
  border-radius: 25px;
  width: 250px;
  padding: 12px 32px;
}
#searchButton:hover, #pending:hover {
  background-color: plum;
  color: white;
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}

.tender-deadline {
  order: 1;
  padding: 10px;
  flex-basis: 67%;
  color: white;
  background-image: linear-gradient(to bottom right, rgb(235, 124, 235), rgb(114, 227, 241))
}

</style>