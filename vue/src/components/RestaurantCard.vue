
<template>
    <div id="mainCard" class="card">
        <h1 id="name">Restaurant Name</h1>
        <h2>Restaurant Category</h2>
        <!-- <img class="thumbnail" v-if="restaurant.thumbnailimg" v-bind:src="restaurant.thumbnailimg" />
        <button class="mark_invite" v-on:click.prevent="setInvite(true)" v-if=" !restaurant.invite">PLUS SIGN WILL GO HERE</button>
        <h3 class="restaurant-name">restaurant{{restaurant.name}}</h3>
        <h1 class="restaurant-type">{{restaurant.type}}</h1>
        <h1 class="restaurant-star-rating">*****</h1> -->

        <div id="address">
            <h3>Address</h3>
        </div>
        <div id="hours">
            <h3>Hours</h3>
        </div>
        <div id="phoneNumber">
        
            <button>Call To Order</button>
        </div>
        <br>
        <div id="container">
            <button type="button thumbsUp" id="button1" v-on:click="submitRestaurant()">Thumbs Up</button>
            <button type="button thumbsDown" id="button2">Thumbs Down</button>
        </div>
    </div>
</template>

<script>
import RestaurantService from "../services/RestaurantService";


export default {
    name: 'restaurant-card',

    // props: {
    //     restaurant: Object
    // },
    data(){
        return {
            restaurant: {
                name: ''
            }

        }
    },
    created(){
        RestaurantService.submitRestaurant().then(response => {
            this.restaurant.name = response.data;
            this.isLoading = false;
        })
    },      
    methods: {
      submitRestaurant(){
          RestaurantService
            .saveRestaurant(this.restaurant.name)
            .then(response => {
                if(response.status === 201){
                this.$router.push('/')
                }
            }) 
          }
      }
  }

</script>

<style>

#mainCard {
    border-width: 10px;
    border-color: black;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid black;
    display: flex;
    flex-wrap: wrap;
    flex-direction: column;
    justify-content: center;
    width: 20rem;
    margin: 0 .5rem 2.3rem .5rem;
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

</style>