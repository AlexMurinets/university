import axios from 'axios'

const AXIOS = axios.create({
    baseURL: `http://localhost:9090/api`,
    timeout: 1000
});


export default {
    hello() {
        return AXIOS.get(`/students/hello`);
    },

    getSubjects() {
      return AXIOS.get('/subjects/all');
    },

    download(fileId) {
        return AXIOS.get('/downloadFile/' + fileId);
      },

    getFiles() {
        return AXIOS.get('/allFiles');
      },
  

    getSubject(id){
        return AXIOS.get('/subjects/' + id);
    },

    getTask(id){
        return AXIOS.get('/subjects/task/' + id);
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
    },

    creteFile(file){
        return AXIOS.post('/uploadFile', file);
    },

    getProfessors(){
        return AXIOS.get('/professors');
    },

    editProfessor(id, professor){
        return AXIOS.put('/edit_professor/'+id, professor)
    },

    newProfessor(professor){
        return AXIOS.post('/new_professor', professor)
    },

    deleteProfessor(id){
        return AXIOS.delete('/delete_professor/'+id)
    },

    getStudents(){
        return AXIOS.get('/students');
    },

    newStudent(student){
        return AXIOS.post('/new_student', student)
    },

}
