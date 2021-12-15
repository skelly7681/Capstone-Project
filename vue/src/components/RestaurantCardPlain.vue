<template>
<div id="cards">
    <div id="mainCard">
        <div id="restaurant-details">
            <br>
            <br>
            <h1 id="name">{{restaurant.name}}</h1>

        </div>
    </div>


</div>
</template>

<script>
import RestaurantService from "../services/RestaurantService";

export default {
    name: 'restaurant-card-plain',
    inviteRestaurants: [],
    props: {
        restaurant: {}
    },

    data(){
        return{
            
        }
    }, 
    created(){{
        RestaurantService.getAllRestaurantsByInviteId(this.$route.params.inviteId).then(response => {
            this.inviteRestaurants = response.data;
            this.isLoading = false;
        })
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