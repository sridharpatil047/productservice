//package org.example.productservice.examples.fetchtypes.eager;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.List;
//
//@Getter
//@Setter
//@Entity(name = "e_user")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;
//    String name;
//    @OneToMany (mappedBy = "user", fetch = FetchType.EAGER)
//    List<Post> posts;
//}
//
//
