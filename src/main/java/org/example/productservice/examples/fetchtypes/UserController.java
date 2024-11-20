//package org.example.productservice.examples.fetchtypes;
//
//import org.example.productservice.examples.fetchtypes.dtos.*;
//import org.example.productservice.examples.fetchtypes.eager.Post;
//import org.example.productservice.examples.fetchtypes.eager.User;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//public class UserController {
//    UserRepo userRepo;
//    PostRepo postRepo;
//
//    public UserController(UserRepo userRepo, PostRepo postRepo) {
//        this.userRepo = userRepo;
//        this.postRepo = postRepo;
//    }
//
//    @PostMapping("/users")
//    public CreateUserResponseDto createUser(@RequestBody CreateUserRequestDto createUserRequestDto){
//        User user = new User();
//        user.setName(createUserRequestDto.getName());
//
//        User savedUser = userRepo.save(user);
//
//        CreateUserResponseDto createUserResponseDto = new CreateUserResponseDto();
//        createUserResponseDto.setId(savedUser.getId());
//        createUserResponseDto.setName(savedUser.getName());
//
//        return createUserResponseDto;
//    }
//
//    @GetMapping("/users/{id}")
//    public GetUserResponseDto getUser(@PathVariable("id") Long id){
//        User user = userRepo.findById(id).get();
//
//        GetUserResponseDto getUserResponseDto = new GetUserResponseDto();
//        getUserResponseDto.setId(user.getId());
//        getUserResponseDto.setName(user.getName());
//
//        return getUserResponseDto;
//    }
//
//    @PostMapping("/posts")
//    public CreatePostResponseDto createPost(@RequestBody CreatePostRequestDto createPostRequestDto){
//        User user = userRepo.findById(createPostRequestDto.getUserId()).get();
//
//        Post post = new Post();
//        post.setTitle(createPostRequestDto.getTitle());
//        post.setUser(user);
//
//        Post savedPost = postRepo.save(post);
//
//        CreatePostResponseDto createPostResponseDto = new CreatePostResponseDto();
//        createPostResponseDto.setId(savedPost.getId());
//        createPostResponseDto.setTitle(savedPost.getTitle());
//        createPostResponseDto.setUserId(user.getId());
//
//        return createPostResponseDto;
//    }
//}
