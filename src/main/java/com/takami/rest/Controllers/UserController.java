package com.takami.rest.Controllers;


import com.takami.rest.Exceptions.EmailExistException;
import com.takami.rest.Service.UserService;
import com.takami.rest.jwt.JwtUtils;
import com.takami.rest.model.User;
import com.takami.rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    public final UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PutMapping("/changePassword/{id}")
    public String changePasswordOfUser(@RequestBody User user, @PathVariable Long id){
        User u  = userService.changePasswordOfUser(user, id);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(u.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);





        return jwt;
    }

    @GetMapping
    public String getHeader(@RequestHeader("Authorization") String authorization){
        return authorization;
    }

  //  @PostMapping("/login")
    //public String asd(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
      //  return "ok";
       /* try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password",e);
        }
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));*/
        //return userService.login(user.getUsername(),user.getPassword());
   // }

    /*@PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password",e);
        }
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));*/
        //return userService.login(user.getUsername(),user.getPassword());
    //}






    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

}
