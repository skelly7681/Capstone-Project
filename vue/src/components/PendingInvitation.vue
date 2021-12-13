//this is where people will interact with the invite they have been sent. They can thumbs up or thumbs down a selection
//this needs to pull up the invite from the db based on the unique link - how??
//if user is logged in, thumbs up and thumbs dow buttons are removed 

<template>
<div>
    <router-link v-bind:to="{ name: 'home' }" id="home-button"> home </router-link>&nbsp;

        <h2>SEARCH FOR INVITE</h2>

        <form>
            <input type="text" v-model="searchInviteId" placeholder="invite id" id="inviteSearch" />
            <input type="button" v-on:click="findInviteById()"/>  // format this button
        </form>

    <h2>DB API VOMIT</h2>
    <p>{{ currentInvite }}</p>
        
        <h2></h2>


</div>
  
</template>

<script>
import inviteService from '../services/InviteServices'

export default {
    props: {
        restaurant: {}
    },
   
    data(){
        return{ // how do we do this but have it reset for each person interacting with this content? 
            rejectedRestaurants: [], //an array?
            approvedRestaurants: [],
            isLoading: true,
            searchInviteId: {
                inviteid: 0
            },
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
            //TODO thumbs down click toggles veto to true
            inviteService.thumbsDown(this.restaurant)
            .then(response => {
                if(response.status === 201){
                    alert("This should have toggled false to true in the DB")
                }
            })

        }, 
        addRestaurantsToApprovedList(){
            //TODO thumbs up keeps veto false

        }, 
        findInviteById(){
            inviteService.getInviteByInviteId(this.searchInviteId).then(response => {
            this.invite = response.data;
            this.$store.commit('SET_CURRENT_INVITE', this.invite);
            this.isLoading = false;
        })
        }, 
        getInvite(){
            inviteService.findInviteById(this.searchedInviteId).then(response => {
                if (response.status === 201){
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