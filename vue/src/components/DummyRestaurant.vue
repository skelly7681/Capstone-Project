<template>
    <div>
    
    <div id="searchbar">
      <h1>SEARCH BAR</h1>
      <form>
        <input type="text" v-model="searchLocation" placeholder="City/Zip Code" id="location" />
        <input type="submit" v-on:change="search()"/> 
      </form>

      <div class="loading" v-if="isLoading">
        <img src="../assets/loading.gif" alt="HELP!!!">
      </div>

      <p>{{ searchResults }}</p>
    </div>

    <div id="restaurantDisplay">
        <h1>DISPLAY RESTAURANT CARDS HERE</h1>
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
import RestuarantService from "../services/RestaurantService";

export default {
    name: "restaurant",

    components: {},
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
        RestuarantService.search(this.searchLocation).then(response => {
            this.searchResults = response.data;
            this.isLoading = false;
        })
    }
    // methods: {

    // },
    // computed: {

    // }
//end of export default block  
};
</script>

<style>

</style>