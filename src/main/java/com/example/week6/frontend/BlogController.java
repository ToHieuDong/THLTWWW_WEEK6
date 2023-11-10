package com.example.week6.frontend;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.week6.backend.entities.Post;
import com.example.week6.backend.entities.PostComment;
import com.example.week6.backend.entities.User;
import com.example.week6.backend.repositories.PostCommentRepository;
import com.example.week6.backend.repositories.PostRepository;
import com.example.week6.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostCommentRepository postCommentRepository;

    @PostMapping("/login")
    public String addToCart(@RequestParam String email, @RequestParam String password) {
        Optional<User> user = userRepository.findByEmail(email);
//        if (user.isPresent() && BCrypt.verifyer().verify(password.toCharArray(), user.get().getPasswordHash()).verified ) {
        if (user.isPresent() && password.equals(user.get().getPasswordHash()) ) {
            return "redirect:/blog/getBlog/" + user.get().getId();
        } else {
            return "index";
        }
    }

    @GetMapping("/getBlog/{userId}")
    public String getBlog(@PathVariable Long userId, Model model) {
        model.addAttribute("user", userRepository.findById(userId));
        List<Post> posts = (List<Post>) postRepository.findAllByAuthorId(userId);
        model.addAttribute("posts", posts);
//        List<PostComment> postComments = postCommentRepository.findAllByPostId();
//        Map<Long, List<PostComment>> postListMap = new HashMap<>();
//        for (Post post: posts ) {
//            postListMap.put(post.getId(), postCommentRepository.findAllByPostId(post.getId()));
//        }
//        System.out.println(postListMap);
//        model.addAttribute("postListMap", postListMap);
        return "home";
    }

    @GetMapping("/getBlogSingle/{postId}")
    public String getBlogComment(@PathVariable Long postId, Model model) {
        model.addAttribute("userLogin", postRepository.findById(postId).get().getAuthor());
        model.addAttribute("postPre", postRepository.findById(postId));

        List<PostComment> postComments = postCommentRepository.findAllByPostId(postId);
        model.addAttribute("postComments", postComments);
        return "single";
    }

}
