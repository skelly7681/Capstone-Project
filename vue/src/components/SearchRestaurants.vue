<template>
    <div>
    
    <div id="searchbar">
      <h1>SEARCH BAR</h1>
      <form>
        <input type="text" v-model="searchLocation" placeholder="City/Zip Code" id="location" />
        <input type="button" v-on:click="search()"/> 
      </form>

      <div class="loading" v-if="isLoading">
        <img src="../assets/loading.gif" alt="HELP!!!">
      </div>

      <p>{{ foundRestaurants }}</p>
    </div>

    <div id="restaurantDisplay">
        <h1>DISPLAY RESTAURANT CARDS HERE</h1>
         <restaurant-card />
         
    </div>

    <div>
       
        <!-- <li class="restaurant" v-for="restaurant in searchResults" v-bind:key="restaurant.id">
            <img v-bind:src="photo.download_url" />
            <span class="author">{{ photo.author }}</span>
        </li> -->
    </div>

    </div>
</template>

<script>
import RestaurantService from "../services/RestaurantService";
import RestaurantCard from "../components/RestaurantCard"

export default {
    name: "searchRestaurants",

    components: {
        RestaurantCard
    },
    data(){
        return{
            searchLocation: "",
            searchResults: [],
            resturant: {
                id: "",
                alais: "",
                name: "",
                url: "",
                type: "",
                address: "", 
                openNow: false, // may have an issue with this/ db different
                phoneNumber: "", 
                thumbnailImg: "", 
                starRating: 0, 
                hasTakeOut: false, 
                hasDelivery: false, 
                imgUrl: "", 
                coordinates: {
                    longitude: "", 
                    latitude: ""
                }
            },
            savedToInvite: false, 
            isLoading: true
        };
    },
    created(){
        RestaurantService.search(this.searchLocation).then(response => {
            this.searchResults = response.data;
            this.isLoading = false;
        })
    }, 
    methods: {
        search(){
            RestaurantService.search(this.searchLocation).then(response => {
            this.searchResults = response.data;
            this.$store.commit('SET_SEARCH_RESULTS', this.searchResults);
            this.isLoading = false;
        })
    }, 

    // put a method here to make sure search bar only sends what Yelp will accept
    
    }, 
    computed: {
        foundRestaurants(){
            return this.$store.state.searchResults;
        }

    }
//end of export default block  
};
</script>

<style>

</style>