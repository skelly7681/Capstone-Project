import axios from 'axios';

export default {

    getFinalistsByInviteId(inviteId) {
        return axios.post('/finalists/${inviteId}', inviteId)
    },

    getInviteByInviteId(inviteId) {
        return axios.get(`/invites/${inviteId}`, inviteId)
    },

    thumbsDown(restaurantInviteDTO) {
        return axios.post('/vetoed', restaurantInviteDTO)
    },

    getAllInvitesBySenderId(senderUserId) {
        return axios.post(`/UserInvites/${senderUserId}`, senderUserId)
    },
    
    createInvite(invite) {
        return axios.post('/invites/create', invite)
    },

    








}