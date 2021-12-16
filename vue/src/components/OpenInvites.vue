<template>
<div>
    <div class="home-container" id="home">
    <input type="text"  placeholder="ENTER INVITE ID" v-model.number="inviteId"/>
    
        <button type="button" :value="inviteId" @click="isShow = !isShow" id="searchB"  v-on:click="findInviteById()">SUBMIT INVITE ID</button>
    </div>
    <br>
    <div id="inviteCard" v-show="!isShow" class="home-container">
        <h1 id="h1under">Pending Invites</h1>
        <h3>Invite ID: {{this.invite.inviteId}}</h3>
        <h3>This Invite will expire on: {{ this.invite.closing_date}} @ {{this.invite.closing_time}}</h3>
        <div id="finalist2">
        <button type="button" id="finalist" v-on:click="viewFinalist()">view final selection</button>
        </div>
        <!-- below can be removed, this is just to remeber  -->
    </div>

</div> 
</template>

<script>
import InviteServices from "../services/InviteServices"

export default {
    name: 'open-invites',
   
    data() {
        return {
            isSearching: true,
            isShow: true,
            inviteId: 0,
            invite: {}
        }
    },
    methods: {
         findInviteById() {
            InviteServices.getInviteByInviteId(this.inviteId).then(response => {
            this.invite = response.data;
            this.$store.commit('SET_CURRENT_INVITE', this.invite);
            this.isLoading = false;
            })
        }, 
        viewFinalist(){
            let linkUrl = "http://localhost:8081/finalist/" + this.invite.inviteId;
            window.open(linkUrl);
        }
    }
}
</script>

<style>

#inviteCard{
    border-width: 10px;
    border-color: plum;
    border: 1px solid plum;
    background-color: white;
    margin: auto;
    width: 50%;
    padding: 10px;   
}

#finalist2{
    margin: auto;
    width: 200%;
    padding: 10px;  
}

#h1under {
    text-decoration: underline;
}

#searchB {
    border: none;
    background-color: rgb(243, 214, 243);
    font-size: 20px;
    border-radius: 25px;
    width: 20%;
    padding: 12px 12px;
    ;
}

#searchButton:hover {
  background-color: plum;
  color: white;
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}

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

#finalist {
    border: none;
    background-color: rgb(243, 214, 243);
    font-size: 20px;
    border-radius: 25px;
    width: 25%;
    padding: 12px 12px;
}

#finalist:hover, #searchB:hover {
  background-color: plum;
  color: white;
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}

</style>