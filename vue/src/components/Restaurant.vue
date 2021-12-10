<template>
    <div>
        <h1>THIS IS WHERE YOU BROWSE RESTAURANTS</h1>
        //change this header, of course --> for testing purposes only

    <div id="searchbar">
      <h1>SEARCH BAR</h1>
      <input type="text" v-model="search" placeholder="Search For">

    </div>

    </div>
</template>

<script>
import restuarantService from "../services/RestaurantService";

export default {
    name: "restaurant",
    components: {},
    data(){
        return{
            resturant: {
                name: "",
                type: "",
                address: "", 
                openNow: false, // may have an issue with this/ db different
                phoneNumber: "", 
                thumbnailImg: "", 
                starRating: 0, 
                hasTakeOut: false, 
                hasDelivery: false
            },
            savedToInvite: false
        };
    },
    created(){
        this.searchRestaurants();
    },

    // methods: {
    //     searchRestaurants(){
    //         restuarantService.getRestaurantsByLocation().then(response => {
    //             this.$router.push(`/`);  //don't know where to push
    //         })

    //     }
    // },
    // computed: (
    //     filteredRestuarant
    // )
//end of export default block  
};
</script>

<style>

</style>