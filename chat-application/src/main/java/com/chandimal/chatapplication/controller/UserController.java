package com.chandimal.chatapplication.controller;
import com.chandimal.chatapplication.dto.UserDTO;
import com.chandimal.chatapplication.service.UserService;
import com.chandimal.chatapplication.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveUser(@RequestBody UserDTO userDTO){
     String msg = userService.saveUser(userDTO);
     StandardResponse standardResponse = new StandardResponse(201,"saved done",msg);
     return new ResponseEntity<>(
             standardResponse, HttpStatus.CREATED
     );
    }

    @GetMapping("/get-all")
    public ResponseEntity<StandardResponse> getAllUsers(){
        List<UserDTO> userDTOList = userService.getAllUsers();
        StandardResponse standardResponse = new StandardResponse(200,"done",userDTOList);
        return new ResponseEntity<>(
                standardResponse,
                HttpStatus.OK
        );

    }

    @PostMapping(
            path = "/save-img",
            params = {"imgUrl" , "email"})
    public ResponseEntity<StandardResponse> saveImageUrl(
            @RequestParam(value = "imgUrl") String imgUrl,
            @RequestParam(value = "email")  String email
     ){
        String msg = userService.saveUserImage(email,imgUrl);
        StandardResponse standardResponse = new StandardResponse(201,"image saved",msg);
        return new ResponseEntity<>(
                standardResponse,
                HttpStatus.CREATED
        );

    }



}
