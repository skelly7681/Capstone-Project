<template>
    <div id="cards">

        <!-- Below is implemented in Restaurant Card but it is not showing up -->
        <div id="mainCard" v-bind:style='{ background: `url("${restaurant.image_url}")` }'>
                   <div id="mainCard" v-bind:style='{ background: `url("${restaurant.thumbnailImage}")` }'>
            <div id="restaurant-details">
                <br>
                <br>
                <h1 id="name" class ="display">{{restaurant.restaurantName}}</h1>
                <br>
                <h2 class ="display">{{restaurant.restaurantType}}</h2>
                <br>
                <span class="rating"></span>
                <br>
                <p v-if="restaurant.restaurantAddress" class="address display">{{restaurant.restaurantAddress}}</p>
        
                <br>
                <!-- <h2>Is Closed: {{restaurant.closed}}</h2> -->

                 <!-- create a pop up frame for browsers -->
                 <!-- Functional if we call the phone number to the alert and your phone will do the rest -->
                <a href="tel:${restaurant.phoneNumber}" target="_blank"><button type="button call">Call to Order</button></a>
                <!--  <i class="fas fa-phone fa-3x"></i>-->

                <!-- thumbnail image -->
                <div>
                    <img :src="restaurant.thumbnailImage" alt="restaurant.restaurantName" class="thumbnail">
                </div>
            
                </div>
                
                    <div id="container">
                        <button type="button thumbsUp" id="button1" ><img src="..\assets\thumbsup.png" alt="like" height="60px"/></button>
                        <button type="button thumbsDown" id="button2" v-on:click="submitVote()"><img src="..\assets\thumbsdown.png" alt="like" height="60px"/></button>
                    </div>
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
            alert("checkpoint")   
                    this.restaurantInv.restaurantId = this.restaurant.restaurantId;
                    this.restaurantInv.restaurant = this.restaurant;
                    this.restaurantInv.inviteId = this.$route.params.inviteId;
                    this.restaurantInv.vetoed = true;
                    InviteServices.thumbsDown(this.restaurantInv).then(
                        alert("check the db")                      
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

.cs {
    display: inline-block;
}


    #mainCard {
    border-width: 10px;
    border-color: black;
    
    margin-bottom: 10px;
    
    display: flex;
    flex-wrap: wrap;
    /* flex-direction: column; */
    overflow-x: auto;
    justify-content: center;
    width: 20rem;
    margin: 0 .5rem 2.3rem .5rem;
    height: 100%;
    
}

  #name{
     text-decoration: underline;
     text-align: center;
}

#thumbsUp{
    width: 300px;
    height: 40px;
}
#thumbsDown{
    width: 300px;
    height: 40px;
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

#restaurant-details{
    opacity: 0.6;
    background-color: #ffffff;

   
}

.display {
    font-weight: bold;
    color: black;
    width: 100%;
}

</style>