<template>
  <div>
     
    <button type="view-pending" class="display" id="button2" v-on:click="populateChoices()"> Do it you beast. </button>

    <restaurant-card-vote class="card" v-for="restaurant in inviteRestaurants" v-bind:key="restaurant.id"  v-bind:restaurant="restaurant"/>
  </div>
</template>

<script>
import RestaurantCardVote from './RestaurantCardVote.vue';
import RestaurantService from "../services/RestaurantService";


export default {
    name: 'restaurant-list-vote',
    date(){
        return{
            inviteRestaurants: []
        }
    },
    props: {
        RestaurantCardVote,

    },
    components: {RestaurantCardVote},
    methods: {
        populateChoices(){
            alert("Looking for " + this.$route.params.inviteId);
            RestaurantService.getAllRestaurantsByInviteId(this.$route.params.inviteId).then(response => {
                this.inviteRestaurants = response.data;
                alert("restaurants may be in the store")
                this.$store.commit('SET_CURRENT_INVITE_ID', this.$route.params.inviteId);
                this.$store.commit('SET_PENDING_RESTAURANTS', this.inviteRestaurants);
                this.isLoading = false; 
            })

        }
    }, 
    created() {
        this.$store.subscribe(mutatation => {
            if(mutatation.type === "SET_PENDING_RESTAURANTS") {
                this.inviteRestaurants = this.$store.state.inviteRestaurants;
            }

        })

    }
        
}
</script>

<style>

</style>