package com.systemsguy.userapi.controller;

import org.springframework.web.bind.annotation.RestController;


import com.systemsguy.userapi.exception.ResourceNotFound;
import com.systemsguy.userapi.model.UserEntity;
import com.systemsguy.userapi.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired 
    private UserRepository userRepository;
    
    @GetMapping("")
    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }
    
    @PostMapping("/user_id")
    public UserEntity addUser(@RequestBody UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    @GetMapping("/user_id{id}")
   public ResponseEntity<UserEntity> getUserById(@PathVariable long id){
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("No User with the ID: "+id));
        return ResponseEntity.ok(user);
   } 

   //build update person REST API
  @PutMapping("/user_id{id}")
  public ResponseEntity<UserEntity> updateUser(@PathVariable long id, @RequestBody UserEntity user){
    UserEntity userEntity = userRepository.findById(id).orElseThrow((() -> new ResourceNotFound("There is no user with ID: "+id)));

    userEntity.setFullName(user.getFullName());
    userEntity.setEmail(user.getEmail());

    userRepository.save(userEntity);

    return ResponseEntity.ok(userEntity);
  }

  //build delete user REST API
  @DeleteMapping("/user_id{id}")
  public ResponseEntity<String> deleteUserById(@PathVariable long id){
    UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("No user with the ID "+id) );
    userRepository.delete(userEntity);

    return ResponseEntity.ok("User with ID "+id+" deleted succesfully");
  }

}

   /**
    * 
    ##################################################################################


   @GetMapping("/user_id")
   public List<UserEntity> getUserByName(@RequestParam(value = "name") String name) {
       List<UserEntity> users = userRepository.findAll();
       List<Long> idList = new ArrayList<Long>();
       for (UserEntity user : users) {
           if (user.getFirstName().startsWith(name) || user.getLastName().startsWith(name)) {
               idList.add(user.getId());
           }
       }
       Iterable <Long> usersId = idList;
       List<UserEntity> userEntities = userRepository.findAllById(usersId);
       return userEntities;    

       ################################################################################
    }   
}
*/

