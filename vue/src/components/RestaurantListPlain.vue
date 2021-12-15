<template>
  <div>
      <restaurant-card-plain/>
  </div>
</template>

<script>
import RestaurantCardPlain from './RestaurantCardPlain.vue'
export default {
  components: { RestaurantCardPlain },
  created() {
    this.$store.subscribe(mutatation => { 
      if(mutatation.type === 'SET_PENDING RESTAURANTS')
        { this.restaurants =  this.$store.state.inviteRestaurants; }
    })
  }
}
</script>

<style>

</style>