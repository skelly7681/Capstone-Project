//this is where people will interact with the invite they have been sent. They can thumbs up or thumbs down a selection
//this needs to pull up the invite from the db based on the unique link - how??
//if user is logged in, thumbs up and thumbs dow buttons are removed 

<template>
<div>
    <router-link v-bind:to="{ name: 'home' }" id="home-button"> home </router-link>&nbsp;
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
        inviteService.search(this.inviteId).then(response => {
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