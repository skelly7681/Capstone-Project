<template>
<div>
    

    <input type="text" v-model.number="inviteId"/>
    <div>
        <input type="button" :value="inviteId" v-on:click="findInviteById()"/>
    </div>
    <div>
        {{ this.invite}}
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

</style>