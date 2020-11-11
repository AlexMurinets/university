import axios from 'axios'

const AXIOS = axios.create({
    baseURL: `/api`,
    timeout: 1000
});


export default {
    hello() {
        return AXIOS.get(`/students/hello`);
    },

    getSubjects() {
      return AXIOS.get('/subjects/all');
    },
    getUser(userId) {
        return AXIOS.get(`/user/` + userId);
    },
    createUser(firstName, lastName) {
        return AXIOS.post(`/user/` + firstName + '/' + lastName);
    },
    getSecured(user, password) {
        return AXIOS.get(`/secured/`,{
            auth: {
                username: user,
                password: password
            }});
    }
}
