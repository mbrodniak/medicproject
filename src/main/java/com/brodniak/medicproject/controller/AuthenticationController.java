//package com.brodniak.medicproject.controller;
//
//import com.brodniak.medicproject.config.JwtTokenUtil;
//import com.brodniak.medicproject.dto.UserDTO;
//import com.brodniak.medicproject.entity.User;
//import com.brodniak.medicproject.service.JwtAuthenticationResponse;
//import com.brodniak.medicproject.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping
//public class AuthenticationController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping(path = "/generate-token", method = RequestMethod.POST)
//    public ResponseEntity register(@RequestBody com.brodniak.medicproject.model.User loginUser) throws AuthenticationException {
//        System.out.println(loginUser.toString());
//        final Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginUser.getUsername(),
//                        loginUser.getPassword()
//                )
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        final User user = userService.findOne(loginUser.getUsername());
//        final String token = jwtTokenUtil.generateToken(user);
//        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
//
//    }
//    @RequestMapping(path="/signup", method = RequestMethod.POST)
//    public User saveUser(@RequestBody UserDTO user){
//
//        return userService.save(user);
//    }
//}