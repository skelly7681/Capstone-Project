
<template>
    <div id="cards">

        <!-- Below is implemented in Restaurant Card but it is not showing up -->
        <div id="mainCard">
        <h1 id="name">{{restaurant.name}}</h1>
        <h2 >Restaurant Category: {{restaurant.categories[0].title}}</h2>
        
        <p v-if="restaurant.location.address1" class="address">Address {{restaurant.location.address1}}</p>
        <p v-if="restaurant.location.address2" class="address">{{ restaurant.location.address2}}</p>
        <p v-if="restaurant.location.address3" class="address">{{ restaurant.location.address3}}</p>
        <span class="address cs" >{{ restaurant.location.city}}, {{ restaurant.location.state}} {{ restaurant.location.zip_code}}</span>
        <!-- <h2>Is Closed: {{restaurant.closed}}</h2> -->
            <div id="container">
                <button type="button thumbsUp" id="button1" v-on:click="submitRestaurant()"><i class="far fa-grin-stars fa-3x"/>
</button>
                <button type="button thumbsDown" id="button2"><i class="far fa-dizzy fa-3x"/>
</button>
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
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid black;
    display: flex;
    flex-wrap: wrap;
    /* flex-direction: column; */
    overflow-x: auto;
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