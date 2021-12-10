<template>
    <div>
        <h1>THIS IS WHERE YOU BROWSE RESTAURANTS</h1>
        //change this header, of course --> for testing purposes only

    <div id="searchbar">
      <h1>SEARCH BAR</h1>
      <input type="text" v-model="location" placeholder="City/Zip Code" id="location" >
      <button v-click="search">Submit</button>
      <p>{{ searchResults }}</p>
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
            searchLocation: "",
            searchResults: [],
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
        restuarantService.search(this.searchLocation).then(response => {
            this.searchResults = response.data;
        })
    },
  methods: {
    search() {
      restuarantService
      .search(this.location).then(response => {
        if(response.status === 200){                   //should be 201?
           this.resturant = response.data.resturant;
          
        }
      })
    }
}

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