import axios from 'axios';

axios.create({
  baseURL: 'http://localhost:8080'
})

export default {

  search(searchLocation) {
    return axios.post('/search', searchLocation)
  },

  getRestaurantById(id) {
    return axios.get('/restaurants/${restaurantId}', id)
  },

  saveRestaurant(restaurant) {
    return axios.post('/restaurants/save', restaurant)
  },

  saveRestaurantInvite(restaurantInv) {
    return axios.post('/invites/add', restaurantInv)
  },

  addRestaurantToInvite(inviteId, restaurantId) {
    return axios.post('/invites/add/restaurant', inviteId, restaurantId)
  },

  getAllRestaurantsByInviteId(inviteId){
    return axios.get(`/restaurants/all/${inviteId}`);
  }






}