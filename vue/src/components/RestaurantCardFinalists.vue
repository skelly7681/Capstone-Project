<template>
    <div id="cards">

        
        <div id="mainCard">
            <div id="restaurant-details">
                <img v-if="restaurant.thumbnailImage" :src="restaurant.thumbnailImage" alt="restaurant.restaurantName" class="thumbnail">
               
                <div class="rest-name">
                    <h1 id="name" class ="display">{{restaurant.restaurantName}}</h1>
                </div>
                
                <div class="rest-title">
                    <h2 class ="display">{{restaurant.restaurantType}}</h2>
                </div>

                
                <p v-if="restaurant.restaurantAddress" class="address display">{{restaurant.restaurantAddress}}</p>
        
                <br>
                <br>

                <div class="icon-container">
                    <div class="take-out">
                        <img v-f="restaurant.takeout" src="..\assets\takeout.png" alt="like" height="40px"/>
                    </div>

                    <div class="delivery">
                        <img v-f="restaurant.delivery" src="..\assets\delivery.png" alt="like" height="40px"/>
                    </div>
                </div> 
            
                <div class="phone-div">
                <a href="tel:${restaurant.phoneNumber}" target="_blank"><button class="call-button" type="button call">Call to Order</button></a>
                </div>

                </div>
            </div>
    </div>
</template>

<script>
import RestaurantService from "../services/RestaurantService";


export default {
    name: 'restaurant-card-finalists',

    props: [ 'restaurant' ],
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
            }
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

#mainCard {
    background-color: white;

    border: 3px solid lightgray;
    border-radius: 10px;

    width: 300px;
    height: 575px;
    
    display: flex;
    flex-wrap: wrap;

    overflow-x: auto;
    justify-content: flex-start;
    margin: 10px; 
}

.thumbnail {
    width: 300px;
    height: 125px;
    object-fit: cover;
    opacity: 0.7;
}

.thumbnail:hover {
    opacity: 1.0;
}

  #name{
    font-size: 25px;
    font-weight: 600;
    font-style: italic;
}

.rest-name {
    display: flex;
    flex-direction: row;
    justify-content: center;
}

#title {
    font-size: 20px;
}

.rest-title {
    display: flex;
    justify-content: space-around;
}

.plusButton {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 15px;
}

.call-button {
    border: none;
    background-color: rgb(243, 214, 243);
    font-size: 20px;
    border-radius: 25px;
    width: 200px;
    padding: 12px 32px;
}

.call-button:hover {
    background-color: plum;
    color: white;
    box-shadow: 0 6px 8px 0 rgba(0,0,0,0.24), 0 10px 8px 0 rgba(0,0,0,0.19);
}

.phone-div {
    display: flex;
    flex-direction: column;
    align-items: center;
}

#button2 {
    height: 125px;
    width: 125px;
    border: 0px;
    background: white;
}

.plusButtonImg {
    height: 95%;
    width: 100%;
}

.icon-container {
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    margin: 0px;
    gap: 30px;
}

</style>