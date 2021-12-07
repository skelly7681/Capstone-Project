<template>
    <div>
        <h1>THIS IS WHERE YOU BROWSE RESTAURANTS</h1>
        //change this header, of course --> for testing purposes only

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

    methods: {
        getRestaurantByLocation(searchLocation){ //this parameter is from user search

        }
    }
//end of export default block  
};
</script>

<style>

</style>