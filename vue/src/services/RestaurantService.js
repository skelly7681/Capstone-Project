import axios from 'axios';

export default {

  search(location) {
    return axios.get('/search', location)
  },

//   register(user) {
//     return axios.post('/register', user)
//   }

}