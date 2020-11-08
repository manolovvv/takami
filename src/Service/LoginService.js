import axios from 'axios'

const LOGIN_API_BASE_URL = "http://localhost:8080/customers/login"


class LoginService{
    login(username,password){
        return axios.get(LOGIN_API_BASE_URL,
            {
               params:{
                    username: username,
                    password: password
               }
            });
    }

}

export default new LoginService()