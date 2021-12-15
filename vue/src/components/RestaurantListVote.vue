<template>
  <div>
    <restaurant-card/>
  </div>
</template>

<script>
import RestaurantService from "../services/RestaurantService";
import RestaurantCard from './RestaurantCard.vue';


export default {
    name: 'restaurant-list-vote',
    date(){
        return{
            inviteRestaurants: []
        }
    },
    props: {
        RestaurantCard,

    },
    components: {RestaurantCard},
    methods: {}, 
    created() {
        RestaurantService.getAllRestaurantsByInviteId(this.$route.params.inviteId).then(response => {
            this.inviteRestaurants = response.data;
            this.isLoading = false;
        })
    }
}
</script>

<style>

</style>