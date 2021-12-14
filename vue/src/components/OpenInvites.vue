<template>
<div>
    <div>
    <input type="text" v-model.number="inviteId"/>
    
        <button type="button" :value="inviteId" v-on:click="findInviteById()">SUBMIT</button>
    </div>
    <div id="inviteCard">
        <h2>Pending Invites</h2>
        <h3>Invite ID: {{this.invite.invite_id}}</h3>
        <h3>This Invite will expire on: {{ this.invite.closing_date}} @ {{this.invite.closing_time}}</h3>
        <h3>Your Invitation Link is: {{this.invite.unique_link}}</h3>
        {{ this.invite.closingDate}}
        <!-- below can be removed, this is just to remeber  -->
        {{this.invite}}

        <br>

        Populate List of Restuarants with Invites and Thumbs Up vs Thumbs Down
    </div>

</div> 
</template>

<script>
import InviteServices from "../services/InviteServices"

export default {
    name: 'open-invites',
   
    data() {
        return {
            inviteId: 0,
            invite: {}
        }
    },
    methods: {
         findInviteById() {
            alert("Looking for " + this.inviteId);
            InviteServices.getInviteByInviteId(this.inviteId).then(response => {
            this.invite = response.data;
            this.$store.commit('SET_CURRENT_INVITE', this.invite);
            this.isLoading = false;
            })
        }
    }
}
</script>

<style>

#inviteCard{
    border-width: 10px;
    border-color: black;
    border: 1px solid black;
}

</style>