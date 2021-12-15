<template>
  <div>
    <restaurant-card-vote/>
    <input type="text" v-model.number="inviteId"/>
    
    <div>
        <button type="button" :value="inviteId" v-on:click="populateChoices()">SEE SELECTION</button>
    </div>

  </div>
</template>

<script>
import RestaurantCardVote from './RestaurantCardVote.vue'
import RestaurantService from "../services/RestaurantService";


export default {
  components: { RestaurantCardVote },
  methods: {
        populateChoices(){
            RestaurantService.getAllRestaurantsByInviteId(this.$store.state.currentInvite.inviteId).then(response =>{
                this.inviteRestaurants = response.data;
                this.$store.commit('SET_PENDING RESTAURANTS', this.inviteRestaurants);
                this.isLoading = false;
            })
        }
    }, 
    created() {
        this.$store.subscribe(mutatation => { 
            if(mutatation.type === 'SET_PENDING RESTAURANTS')
                { this.restaurants =  this.$store.state.inviteRestaurants; }
            }
        )
    }
}
</script>

<style>

</style>