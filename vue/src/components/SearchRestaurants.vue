<template>
    <div>
    
        <div id="searchbar">
            <h2 id="searchTitle" >SEARCH FOR SOMEWHERE TO EAT</h2>
            <form class="search-form" ref="anyName" @submit="search" v-if="!searchSent">
                <input type="text" class="form-control" v-model="searchLocation" placeholder="City / Zip Code" id="location" />
                <!-- disable this button if a invite id is not active -->
                <!-- create isempty property, if current invite is empty, button is disabled -->
                <button type="button" id="searchButton" v-on:click="search()">SUBMIT</button>
            </form>
            <div class="search-text" v-if="searchSent">
                <h1> {{this.searchLocation}} </h1>
            </div>

            <div class="loading" v-if="isLoading">
                <img class="pizza-gif" src="../assets/loading.gif" alt="HELP!!!">
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
            searchSent: false,
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
            isLoading: false
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
            this.isLoading = true;
            RestaurantService.search(this.searchLocation).then(response => {
            this.searchResults = response.data;
            this.$store.commit('SET_SEARCH_RESULTS', this.searchResults);
            this.isLoading = false;
            this.searchSent = true;
            // this.$refs.anyName.reset();
        })
    }, 

    // put a method here to make sure search bar only sends what Yelp will accept
    // put a method to clear search bar after search is submitted
    // yelp gives us limited options + also will return restaurants outside of the zipcode
    
    
    }, 
    computed: {
        foundRestaurants(){
            return this.$store.state.searchResults;
        }
    }

};
</script>

<style scoped>

.address {
    margin: 2px 8px;
}

.cs {
    display: inline-block;
}

#searchTitle {
    order: 1;
    padding: 10px;
    flex-basis: 67%;
    color: white;
    background-image: linear-gradient(to bottom right, rgb(114, 227, 241), rgb(235, 124, 235));
    font-weight: 600;
    font-style: italic;
}

#searchButton {
    border: none;
    background-color: rgb(243, 214, 243);
    font-size: 20px;
    border-radius: 25px;
    width: 25%;
    padding: 12px 12px;
}

#searchButton:hover {
  background-color: plum;
  color: white;
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}

input.form-control {
  width: 45%;
  padding: 10px 15px;
  border: 3px solid lightgray;
  border-radius: 10px;
  font-size: 16px;
  margin-right: 15px;
}

input.form-control:focus {
  border: 3px solid black;
}

form.search-form {
    display: flex;
    flex-direction: row;
    justify-content: center;
}

.loading {
    display: flex;
    flex-direction: row;
    justify-content: space-around;
}

.pizza-gif {
    width: 50vw;
    height: auto;
    margin-top: 15px;
}


/* SCREEN DIFFERENCES */

@media screen and (max-width: 350px) {


    #searchButton {
        font-size: 14px;
    }

    #searchTitle {
        font-size: 15px;
    }

    .pizza-gif {
        width: 70vw;
        height: auto;
    }
    
}

@media screen and (max-width: 450px) and (min-width: 350px) {

    #searchButton {
        font-size: 14px;
    }

    #searchTitle {
        font-size: 18px;
    }

    .pizza-gif {
        width: 60vw;
        height: auto;
    }

}

</style>