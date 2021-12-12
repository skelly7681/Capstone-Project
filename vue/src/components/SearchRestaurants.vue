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


        <!-- This is the API vomit -->
      <p>{{ foundRestaurants }}</p>
    </div>

        <!-- Below is implemented in Restaurant Card but it is not showing up -->
        <div id="mainCard" class="card" v-for="result in searchResults" :key="result.id">
        <h1 id="name">Restaurant Name {{result.name}}</h1>
        <h2 >Restaurant Category{{result.categories}}</h2>
        <h3>Address {{result.location}}</h3>
        <h2>Is Closed: {{result.closed}}</h2>
                <div id="container">
            <button type="button thumbsUp" id="button1" v-on:click="submitRestaurant()">Thumbs Up</button>
            <button type="button thumbsDown" id="button2">Thumbs Down</button>
        </div>
    </div>

    </div>
</template>

<script>
import RestaurantService from "../services/RestaurantService";

export default {
    name: "searchRestaurants",
    data(){
        return{
            searchLocation: "",
            searchResults: [],
            resturant: {
                id: "",
                categories:{  //is this how we pull information from a nested object
                  alias:""  
                },
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
    // put a method to clear search bar after search is submitted
    
    }, 
    computed: {
        foundRestaurants(){
            return this.$store.state.searchResults;
            
        }
        // foundRestaurants(){
        //     parseData = JSON.parse(this.$store.state.searchResults)
        //     return parseData;
    

    }
//end of export default block  
};
</script>

<style>

</style>