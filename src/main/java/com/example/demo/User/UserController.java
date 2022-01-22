package com.example.demo.User;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "users")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User register(@RequestBody Form form){

        return userService.register(form);
    }

    @GetMapping("/{id}")
    public User getuser(@PathVariable String id){
        return userService.getUser(id);
    }

}

class Form {
    private User user;
    private Long role_id;

    public User getUser() {
        return user;
    }

    public Long getRole_id() {
        return role_id;
    }
}