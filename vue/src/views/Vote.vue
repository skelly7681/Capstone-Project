<template>
  <div class="vote" id="vote">
      <restaurant-list-vote/>
  </div>
</template>

<script>

import RestaurantListVote from '../components/RestaurantListVote.vue'

export default {
  name: "vote",
  components: { RestaurantListVote },

}
</script>

<style>

</style>