
<template>
    <div id="cards">

        <!-- Below is implemented in Restaurant Card but it is not showing up -->
        <div id="mainCard">
        <h1 id="name">{{restaurant.name}}</h1>
        <br>
        <h2 >{{restaurant.categories[0].title}}</h2>
        <br>
        <p v-if="restaurant.location.address1" class="address">{{restaurant.location.address1}}</p>
        <p v-if="restaurant.location.address2" class="address">{{ restaurant.location.address2}}</p>
        <p v-if="restaurant.location.address3" class="address">{{ restaurant.location.address3}}</p>
        <span class="address cs" >{{ restaurant.location.city}}, {{ restaurant.location.state}} {{ restaurant.location.zip_code}}</span>
        <!-- <h2>Is Closed: {{restaurant.closed}}</h2> -->
        
        <!-- this adds a restaurant to an invite  // TESTING: using this to save a restaurant to BE db -->
        <button type="button thumbsDown" id="button2" v-on:click="saveRestaurant(restaurant)"><img src="..\assets\plus.png" alt="like" height="60px"/></button>


        <!-- Functional if we call the phone number to the alert and your phone will do the rest -->
        <button type="call to Order" id="call-btn" v-on:click="searchResults(restaurant.phoneNumber)">Call to Order</button>

            <!-- toggle this if this is a pending invite being viewed by a non logged in user -->
            <!-- <div id="container">
                <button type="button thumbsUp" id="button1" v-on:click="submitRestaurant()"><img src="..\assets\thumbsup.png" alt="like" height="60px"/></button>
                <button type="button thumbsDown" id="button2"><img src="..\assets\thumbsdown.png" alt="like" height="60px"/></button>
            </div> -->



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
            isLoading: true
        }
    },
    created(){
       //UNKNOWN NEED: LifeCycle Hook
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
          }, 

        saveRestaurant(){
            RestaurantService.saveRestaurant(this.restaurant).then(response => {
                if (response.status === 201){
                    alert("IT WORKED!!!!! Check the db!")
                }
            })

        }
      },
    computed: {
        foundRestaurants(){
            return this.$store.state.searchResults;
        }
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
    border-color: black;
    
    margin-bottom: 10px;
    border: 1px solid black;
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

</style>