import axios from 'axios'

const LOGIN_API_BASE_URL = "http://localhost:8080/signin"


class LoginService{
    login(username,password){
        return axios.post(LOGIN_API_BASE_URL,
            {
             
                    username: username,
                    password: password
               
            });
    }

}

export default new LoginService()