import axios from 'axios';

axios.create({
  baseURL: 'http://localhost:8080'
})

export default {

  search(searchLocation) {
    return axios.get('/search', searchLocation)
  },

  getRestaurantById(id) {
    return axios.get('/restaurants/${restaurantId}', id)
  },

  saveRestaurant(restaurant) {
    return axios.post('/restaurants/save', restaurant)
  },

  addRestaurantToInvite(inviteId, restaurantId) {
    return axios.post('/invites/add/restaurant', inviteId, restaurantId)
  }
}