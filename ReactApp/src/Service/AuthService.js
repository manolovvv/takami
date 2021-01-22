import axios from 'axios'

const AUTH_API_BASE_URL = "http://localhost:8080/"


class AuthService{
    login(username,password){
        return axios.post(AUTH_API_BASE_URL+"signin",
            {
             
                    username: username,
                    password: password
               
            });
    }

    register(username, password, email, firstName, familyName, address){
        return axios.post(AUTH_API_BASE_URL+"signup",
        {
            username:username,
            password:password,
            email:email,
            firstName:firstName,
            familyName:familyName,
            adress:address
        } );
        
    }

}

export default new AuthService()