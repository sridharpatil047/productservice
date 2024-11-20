//package org.example.productservice.examples.fetchtypes.lazy;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//
//import java.util.List;
//
//@Getter
//@Entity(name = "l_user")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;
//    String name;
//    @OneToMany(fetch = FetchType.LAZY)
//    List<Post> posts;
//}
