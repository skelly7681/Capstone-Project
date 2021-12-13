//this is where people will interact with the invite they have been sent. They can thumbs up or thumbs down a selection
//this needs to pull up the invite from the db based on the unique link - how??
//if user is logged in, thumbs up and thumbs dow buttons are removed 

<template>
<div>
    <router-link v-bind:to="{ name: 'home' }" id="home-button"> home </router-link>&nbsp;



    <!--THIS IS A TEST!!! TESTING PULLING INVITE INFO FROM DB USING INVITE ID-->

          <h2>SEARCH FOR INVITE</h2>
        <form>
            <input type="text" v-model="searchInviteId" placeholder="invite id" id="inviteSearch" />
            <input type="button" v-on:click="findInviteById()"/>  // format this button
        </form>

    <h2>DB API VOMIT</h2>
    <p>{{ currentInvite }}</p>


</div>
  
</template>

<script>
import inviteService from '../services/InviteServices'

export default {
   
    data(){
        return{ // how do we do this but have it reset for each person interacting with this content? 
            rejectedRestaurants: [], //an array?
            approvedRestaurants: [],
            isLoading: true,
            searchInviteId: 0,
            invite: {
              inviteId: "", //this value here will come from the db 
              senderUserId: "",
              closingDate: "",
              closingTime: "",
              uniqueLink: "" //how tf do we make a unique link?
            }
        }
    }, 
    created(){
        inviteService.getInviteByInviteId(this.searchInviteId).then(response => {
            this.invite = response.data;
            this.isLoading = false;
        })

    },

    methods: {
        addRestaurantsToVetoedList(){
            //TODO 

        }, 
        addRestaurantsToApprovedList(){
            //TODO 

        }, 
        findInviteById(){
            inviteService.getInviteByInviteId(this.searchInviteId).then(response => {
            this.invite = response.data;
            this.$store.commit('SET_CURRENT_INVITE', this.invite);
            this.isLoading = false;
        })
        }
     
    }, 
    computed:{
        foundInvitation(){
            return this.$store.state.currentInvite;
        }

    }

}
</script>

<style>

</style>