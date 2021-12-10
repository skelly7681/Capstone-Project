import axios from 'axios';

// const http = axios.create({
//     baseURL: "http://localhost:8080"  //or this this 8081?
//   });

export default {

  getRestaurantsByLocation(location) {
    return axios.get('/search', location)
  },

//   register(user) {
//     return axios.post('/register', user)
//   }

}