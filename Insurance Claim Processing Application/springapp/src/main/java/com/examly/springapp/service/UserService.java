// package com.examly.springapp.service;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.examly.springapp.model.User;
// import com.examly.springapp.repository.UserRepository;
// import com.examly.springapp.model.User;

// @Service
// public class UserService {
//     @Autowired
//     PasswordEncoder encoder;

//     @Autowired
//     UserRepository repo;

//     public String insert(User ent){
//         ent.setPassword(encoder.encode(ent.getPassword()));
//         repo.save(ent);
//         return "Registered";
//     }

//     public User autheticate(String email,String password){
//         return repo.findByEmail(email).filter(user->encoder.matches(password, user.getPassword())).orElse(null);
//     }    
// }
