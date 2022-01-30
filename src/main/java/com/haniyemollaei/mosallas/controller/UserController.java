package com.haniyemollaei.mosallas.controller;

import com.haniyemollaei.mosallas.domain.User;
import com.haniyemollaei.mosallas.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static jdk.nashorn.internal.objects.Global.print;

@RestController
@RequestMapping(path = "user-info")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/user-type")
    public ResponseEntity<String> getUserType(@RequestParam("mobileNo") String mobileNo) throws JsonProcessingException {
        List<User> userList = userRepository.findByMobileNo(mobileNo);
        HashMap<String, String> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        if(userList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "message");
        }else {
            try {
                map.put("userType", userList.get(0).getUserType());
                return ResponseEntity.ok(objectMapper.writeValueAsString(map));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "message");
    }

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public List<User> list() {
        return userRepository.findAll();
    }


    @GetMapping("/find-by-id")
    @ResponseBody
    public ResponseEntity<User> getUser(@RequestParam("id") Long id) {
        List<User> userList = userRepository.findAll();
        User user = null;
        for (int i = 0 ; i < userList.size() ; i++) {
            if(userList.get(i).getId()==id){
                user = userList.get(i);
            }
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/find-by-mobile-no")
    @ResponseBody
    public ResponseEntity<User> getUserByMobileNo(@RequestParam("mobileNo") String mobileNo) {
        List<User> userList = userRepository.findByMobileNo(mobileNo);
        return ResponseEntity.ok(userList.get(0));
    }

    @PostMapping(
            value = "/register-user",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> postBody(@RequestBody User user) {
        User persistedPerson = userRepository.save(user);
        return ResponseEntity
                .created(URI
                        .create(String.format("/persons/%s", user.getId())))
                .body(persistedPerson);
    }


    public boolean checkIfMobileNoExists(String mobileNo)
    {
        if(!userRepository.findByMobileNo(mobileNo).isEmpty())
        {
            return true;
        }
        return false;
    }

    public String registerUserService(User user)
    {
        try
        {
            user.setPassword(user.getPassword());
            userRepository.save(user);
        }
        catch (Exception e)
        {
            return  "An error occurred User not saved!";
        }

        return "User saved";
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws Exception
    {
        HashMap<String, String> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        //Objects.requireNonNull(user);
        System.out.println(user.getMobileNo());
        if(checkIfMobileNoExists(user.getMobileNo()))
        {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User with this mobile number exists");
        }

        String result = registerUserService(user);

        if (result.equals("User saved"))
        {
            map.put("id", user.getId().toString());
            return ResponseEntity.ok(objectMapper.writeValueAsString(map));

        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while saving user");
    }

}
