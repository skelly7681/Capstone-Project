//this is where people will interact with the invite they have been sent. They can thumbs up or thumbs down a selection
//this needs to pull up the invite from the db based on the unique link - how??
//if user is logged in, thumbs up and thumbs dow buttons are removed 

<template>
<div>
    <router-link v-bind:to="{ name: 'home' }" id="home-button"> home </router-link>&nbsp;



    <!--THIS IS A TEST!!! TESTING PULLING INVITE INFO FROM DB USING INVITE ID-->

        <h2>SEARCH FOR INVITE</h2>
        <form @submit="findInviteById">
            <input type="text" v-model.number="searchInviteId" placeholder="invite id" id="inviteSearch" />
            <button type="button" v-on:click="findInviteById()">SUBMIT</button>  // format this button
        </form>

    <h2>DB API VOMIT</h2>
    <p>{{ foundInvitation }}</p>
        
        <h2></h2>

</div>
  
</template>

<script>
import InviteService from '../services/InviteServices'

export default {
    props: {
        restaurant: {}
    },
   
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
        InviteService.getInviteByInviteId(this.searchInviteId).then(response => {
            this.invite = response.data;
            this.isLoading = false;
        })

    },
    methods: {
        addRestaurantsToVetoedList(){
            //TODO thumbs down click toggles veto to true
            InviteService.thumbsDown(this.restaurant)
            .then(response => {
                if(response.status === 200){
                    alert("This should have toggled false to true in the DB")
                }
            })

        }, 
        addRestaurantsToApprovedList(){
            //TODO thumbs up keeps veto false

        }, 
        findInviteById(){
            InviteService.getInviteByInviteId(this.searchInviteId).then(response => {
            this.invite = response.data;
            this.$store.commit('SET_CURRENT_INVITE', this.invite);
            this.isLoading = false;
        })
        }, 
        getInvite(){
            InviteService.findInviteById(this.searchedInviteId).then(response => {
                if (response.status === 200){
                    alert("IT WORKED!!!!! Check the db!")
                }
            })
     
    }, 
    computed:{
        foundInvitation(){
            return this.$store.state.currentInvite;
        }

    }
    }
}
</script>

<style>

</style>