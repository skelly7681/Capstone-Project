<template>
      <div id="cards">
    
        <!-- Below is implemented in Restaurant Card but it is not showing up -->
        <div id="mainCard" v-bind:style='{ background: `url("${restaurant.image_url}")` }'>
            <div id="restaurant-details">
                <br>
                <br>
                <h1 id="name" class ="display">{{restaurant.name}}</h1>
                <br>
                <h2 class ="display">{{restaurant.categories[0].title}}</h2>
                <br>
                <span class="rating"></span>
                <br>
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

                <!-- thumbnail image -->
                <div>
                    <img :src="restaurant.image_url" alt="restaurant.name" class="thumbnail">
                </div>
                

                    <div id="container">
                        <button type="button thumbsUp" id="button1" v-on:click="thumbsDown()"><img src="..\assets\thumbsup.png" alt="like" height="60px"/></button>
                        <button type="button thumbsDown" id="button2"><img src="..\assets\thumbsdown.png" alt="like" height="60px"/></button>
                    </div>
            </div>
        </div>
        
    </div>
</template>

<script>
import RestaurantService from '../services/RestaurantService';
export default {
    name: 'restaurant-card-vote', 
    props: {
        restaurant: {}
    },
    data(){
        return{
            inviteRestaurants: [],
            isLoading: true,
            restaurantInv: {
                restaurantId : '',
                inviteId: '', 
                isVetoed: '',
            }
        }
    }, 
    methods: {
        thumbsDown(){
            this.restaurantInv.restaurant = this.restaurant;
            this.restaurantInv.inviteId = this.$store.state.currentInvite; 
            this.restaurantInv.vetoed = true;
            RestaurantService.thumbsDown(this.restaurantInv).then()
        }
 
    }, 
    created() {
        alert("Looking for " + this.$route.params.inviteId);
        RestaurantService.getAllRestaurantsByInviteId(this.$route.params.inviteId).then(response => {
            this.inviteRestaurants = response.data;
            this.$store.commit('SET_CURRENT_INVITE_ID', this.$route.params.inviteId);
            this.$store.commit('SET_PENDING_RESTAURANTS', this.inviteRestaurants);
            this.isLoading = false; 
        })
    }, 
    computed: {
        dbRestaurants(){
            return this.$store.state.inviteRestaurants;
        }
    }
}
</script>

<style scoped>

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