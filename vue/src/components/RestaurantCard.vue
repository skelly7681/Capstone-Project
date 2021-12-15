
<template>
    <div id="cards">

        <div id="mainCard">
            <div id="restaurant-details">
                <br>
                <div>
                    <img :src="restaurant.image_url" alt="restaurant.name" class="thumbnail">
                </div>
                <h1 id="name">{{restaurant.name}}</h1>
                
                <h2>{{restaurant.categories[0].title}}</h2>
                
                <span class="rating"></span>
                
                <p v-if="restaurant.location.address1" class="address display">{{restaurant.location.address1}}</p>
                <p v-if="restaurant.location.address2" class="address display">{{ restaurant.location.address2}}</p>
                <p v-if="restaurant.location.address3" class="address display">{{ restaurant.location.address3}}</p>
                <span class="address cs display" >{{ restaurant.location.city}}, {{ restaurant.location.state}} {{ restaurant.location.zip_code}}</span>

                <br>
                <!-- <h2>Is Closed: {{restaurant.closed}}</h2> -->

                 <!-- create a pop up frame for browsers -->
                 <!-- Functional if we call the phone number to the alert and your phone will do the rest -->
                <a href="tel:${restaurant.displayPhoneNumber}" target="_blank"><button type="button call">Call to Order</button></a>
                <!--  <i class="fas fa-phone fa-3x"></i>-->
                
                <!-- toggle these depending on the view (create, pending, finalist)-->
                <!--this adds a restaurant to an invite  // TESTING: using this to save a restaurant to BE db -->

                <div class="plusButton">
                    <button type="save" class="display" id="button2" v-on:click="saveRestaurant(restaurant)"><img src="..\assets\plus.png" class="plusButtonImg" alt="plus"/></button>
                </div>

                    <!-- toggle this if this is a pending invite being viewed by a non logged in user -->
                    <!-- <div id="container">
                        <button type="button thumbsUp" id="button1" v-on:click="submitRestaurant()"><img src="..\assets\thumbsup.png" alt="like" height="60px"/></button>
                        <button type="button thumbsDown" id="button2"><img src="..\assets\thumbsdown.png" alt="like" height="60px"/></button>
                    </div> -->

            </div>



        </div>
        
    </div>
</template>

<script>
import RestaurantService from "../services/RestaurantService";
export default {
    name: 'restaurant-card',
    props: {
        restaurant: {}
    },
    data(){
        return{
            searchLocation: "",
            searchResults: [],
            savedToInvite: false,
            vetoed: false,
            isLoading: true,
            restaurantInv: {
                restaurantId: "",
                inviteId: "",
                vetoed: "false",
                restaurant: {}
            }, 
            hasTakeOut: "false"
        }
    },
    created(){
       //UNKNOWN NEED: LifeCycle Hook
       },      
    methods: {
        saveRestaurant(){    
                    this.restaurantInv.restaurant = this.restaurant;
                    this.restaurantInv.inviteId = this.$store.state.currentInvite;
                    RestaurantService.saveRestaurantInvite(this.restaurantInv).then(                      
                    )
                }
      },
    computed: {
        foundRestaurants(){
            return this.$store.state.searchResults;
        }
    }, 
    revealNumber(restaurant){
        return restaurant.displayPhoneNumber;
    }

  }

</script>

<style scoped>
@import 'https://use.fontawesome.com/releases/v5.13.0/css/all.css';

.address {
    margin: 2px 8px;
}

.cs {
    display: inline-block;
}


    #mainCard {
    border-width: 10px;
    border-color: lightgray;
    background-color: white;

    padding: 10px 15px;
    border: 3px solid lightgray;
    border-radius: 10px;

    width: 300px;
    height: 500px;
    
    display: flex;
    flex-wrap: wrap;
    /* flex-direction: column; */
    overflow-x: auto;
    justify-content: center;
    padding: 5px;
    margin: 10px;
    
}

  #name{
     text-decoration: underline;
     text-align: center;
}

#container{
    text-align: center;
}

#address{
    display: flex;
}

#phoneNumber{
    display: block;
    margin: 0

}  

.thumbnail {
    width: 40%;
    height: 40%;
}



.plusButton {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 15px;
}

#button2 {
    height: 150px;
    width: 150px;
    border: 0px;
    background: white;
}

.plusButtonImg {
    height: 95%;
    width: 100%;
}

</style>