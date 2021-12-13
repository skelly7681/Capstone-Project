import axios from 'axios';

export default {
    // need to refactor all of these endpoints

    getFinalistsByInviteId(inviteId) {
        return axios.post('/finalists', inviteId)
    },

    getInviteByInviteId(inviteId) {
        return axios.get(`/invites/${inviteId}`)
    },

    thumbsDown(restaurant) {
        return axios.put('/vetoed', restaurant)
    },

    getAllInvitesBySenderId(senderUserId) {
        return axios.post('/UserInvites', senderUserId)
    },
    
    createInvite(senderUserId) {
        return axios.post('/invites/create', senderUserId)
    },








}