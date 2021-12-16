<template>
    <div id="cards">
        <div id="mainCard">
            <div id="restaurant-details" :class="{red:!isShow}">
                <img v-if="restaurant.thumbnailImage" :src="restaurant.thumbnailImage" alt="restaurant.restaurantName" class="thumbnail">
                <div class="rest-name">
                    <h1 id="name" class ="display">{{restaurant.restaurantName}}</h1>
                </div>
                <div class="rest-title">
                    <h2 class ="display">{{restaurant.restaurantType}}</h2>
                </div>
                <p v-if="restaurant.restaurantAddress" class="address display">{{restaurant.restaurantAddress}}</p>
                <br>
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
                <a href="tel:${restaurant.phoneNumber}" target="_blank"><button class="call-button" type="button call">Call to Order</button></a>
                </div>
                <div>
                </div>
                </div>
                    <div class="button-container" v-show="isShow">
                        <button type="button" @click="isShow = !isShow" class="button" ><img src="..\assets\thumbsup.png" alt="like" class="thumb-button"/></button>
                        <button type="button" @click="isShow = !isShow" class="button" v-on:click="submitVote()"><img src="..\assets\thumbsdown.png" alt="like" class="thumb-button"/></button>
                    </div>
            </div>
    </div>
</template>
<script>
import RestaurantService from "../services/RestaurantService";
import InviteServices from "../services/InviteServices";
export default {
    name: 'restaurant-card-vote',
    props: {
        restaurant: {}
    },
    data(){
        return{
            isShow: true,
            inviteRestaurants: [],
            savedToInvite: false,
            isLoading: true,
            restaurantInv: {
                restaurantId: "",
                inviteId: "",
                vetoed: "true",
                restaurant: {}
            }
        }
    },
    created(){
       //UNKNOWN NEED: LifeCycle Hook
       },      
    methods: {
        submitVote(){ 
                 this.restaurantInv.restaurantId = this.restaurant.restaurantId;
                 this.restaurantInv.restaurant = this.restaurant;
                 this.restaurantInv.inviteId = this.$route.params.inviteId;
                 this.restaurantInv.vetoed = true;
                 InviteServices.thumbsDown(this.restaurantInv).then(                    
                    )
                }, 
        populateChoices(){
                RestaurantService.getAllRestaurantsByInviteId(this.$store.state.currentInvite.inviteId).then(response => {
                this.inviteRestaurants = response.data;
                this.$store.commit('SET_PENDING_RESTAURANTS', this.inviteRestaurants);
                this.isLoading = false;
            })
        }   
      },
    computed: {
    }, 
  }
</script>
<style scoped>
@import 'https://use.fontawesome.com/releases/v5.13.0/css/all.css';
.address {
    margin: 2px 8px;
}

.red{
      background-image: linear-gradient(white, lightgray);
  }

  .img-takeout, .img-delivery {
      border-radius: 15px;
  }

#mainCard {
    background-color: white;
    border: 3px solid lightgray;
    border-radius: 10px;
    width: 300px;
    height: 600px;
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
.button {
    height: 90px;
    width: 90px;
    border: 0px;
    background: white;
}
.button-container {
    padding: 5px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin: 0px;
    gap: 110px;
}
.thumb-button {
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