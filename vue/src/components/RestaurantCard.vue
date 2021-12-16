
<template>
    <div id="cards">

        <div id="mainCard">
            <div id="restaurant-details" :class="{red:!isShow}">
                <img v-if="restaurant.image_url" :src="restaurant.image_url" alt="restaurant.name" class="thumbnail">

                <div class="rest-name">
                    <h1 id="name">{{restaurant.name}}</h1>
                </div>
                
                <div class="rest-title">
                    <h1 id="title">{{restaurant.categories[0].title}}</h1>
                </div>

                <p v-if="restaurant.location.address1" class="address display">{{restaurant.location.address1}}</p>
                <p v-if="restaurant.location.address2" class="address display">{{ restaurant.location.address2}}</p>
                <p v-if="restaurant.location.address3" class="address display">{{ restaurant.location.address3}}</p>
                <span class="address cs display" >{{ restaurant.location.city}}, {{ restaurant.location.state}} {{ restaurant.location.zip_code}}</span>

                <br>
                <br>

                <!-- <div class="take-out">
                    <img v-f="restaurant.takeout" src="..\assets\takeout.png" alt="like" height="40px"/>
                </div>

                 <div class="delivery">
                    <img v-f="restaurant.delivery" src="..\assets\delivery.png" alt="like" height="40px"/>
                </div> -->
                <div class="icon-container">
                    <div class="take-out">
                        <img v-f="restaurant.takeout" src="..\assets\takeout.png" alt="like" height="40px"/>
                    </div>

                    <div class="delivery">
                        <img v-f="restaurant.delivery" src="..\assets\delivery.png" alt="like" height="40px"/>
                    </div>
                </div>    

                <br>
                    
                <div class="phone-div">
                    <a href="tel:${restaurant.displayPhoneNumber}" target="_blank"><button class="call-button" type="button call">Call to Order</button></a>
                </div>

                <br>

                <div class="plusButton" v-show="isShow">
                    <button type="save" @click="isShow = !isShow" class="display" id="button2" v-on:click="saveRestaurant(restaurant)"><img src="..\assets\plus.png" class="plusButtonImg" alt="plus"/></button>
                </div>

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
            isShow: true,
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

  .red{
      background-color:#e6e6e6;
  }

#mainCard {
    background-color: white;

    border: 3px solid lightgray;
    border-radius: 10px;

    width: 300px;
    height: 625px;
    
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