// package com.examly.springapp.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.examly.springapp.config.JWTUtil;
// import com.examly.springapp.model.User;
// import com.examly.springapp.service.UserService;

// @RestController
// @RequestMapping("/auth")
// class UserController {
//     @Autowired
//     UserService ser;

//     @PostMapping("/reg")
//     public String insert(@RequestBody User ent){
//         ser.insert(ent);
//         return ("User inserted successfully");
//     }

//     @PostMapping("/login")
//     public String login(@RequestBody User vuser){
//         User user=ser.autheticate(vuser.getEmail(), vuser.getPassword());
//         if(user!=null){
//             String token=JWTUtil.generateToken(user.getEmail());
//             System.out.println("Generated JWT Token: "+token);
//             return "Logged in";
//         }
//         else{
//             return "Invalid inputs";
//         }
//     }
// }
