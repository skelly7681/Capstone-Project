import axios from 'axios';

export default {

    getFinalistsByInviteId(inviteId) {
        return axios.get('/finalists', inviteId)
    },

    getInviteByInviteId(inviteId) {
        return axios.put('/invites/${inviteId}', inviteId)
    },

    thumbsDown(restaurant) {
        return axios.put('/vetoed', restaurant)
    },

    getAllInvitesBySenderId(senderUserId) {
        return axios.get('/invites', senderUserId)
    },
    
    createInvite(senderUserId) {
        return axios.post('/invites/create', senderUserId)
    },








}