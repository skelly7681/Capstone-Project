import axios from 'axios';

export default {

  search(location) {
    return axios.get('/search', location)
  },

  getRestaurantById(id) {
    return axios.get('/restaurants/{restaurantId}', id)
  },

  saveRestaurant(restaurant) {
    return axios.post('/restaurants/save', restaurant)
  },

  addRestaurantToInvite(inviteId, restaurantId) {
    return axios.post('/invites/add/restaurant', inviteId, restaurantId)
  }
}