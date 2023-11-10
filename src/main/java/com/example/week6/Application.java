package com.example.week6;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.week6.backend.entities.Post;
import com.example.week6.backend.entities.PostComment;
import com.example.week6.backend.entities.User;
import com.example.week6.backend.repositories.PostCommentRepository;
import com.example.week6.backend.repositories.PostRepository;
import com.example.week6.backend.repositories.UserRepository;
import org.loremipsum.LoremIpsum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
    private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private PostCommentRepository postCommentRepository;
    @Bean
	CommandLineRunner initData(){
        return args -> {
			Random random = new Random();
			String pa = "Dong123";
			String enpass = BCrypt.withDefaults().hashToString(17, pa.toCharArray());
			User us1 = new User("To", "Dong", "Hieu", "hieudong.dongthanh.01", "0859505384",
					enpass, LocalDate.of(2023,10,21),
					LocalDate.of(2002,11,02), "THD", "QWERTY");

			User us2 = new User("To", "Gnoodd", "", "hieudong.dongthanh.02", "0848525414",
					enpass, LocalDate.of(2023,10,21),
					LocalDate.of(2002,03,28), "DTHN", "QWERTYN");

			userRepository.save(us1);
			userRepository.save(us2);
			List<Post> lst = new ArrayList<>();

			for (int i = 0; i < 10; i++) {
				Post p = new Post(new Random().nextInt(2)==0?true:false,
						LoremIpsum.createParagraph(100), LoremIpsum.createSentence(10),
						LoremIpsum.createSentence(5), LoremIpsum.createSentence(1),
						LocalDate.of(2002,03,28), LocalDate.of(2002,03,28),
						LocalDate.of(2002,03,28), random.nextInt(10)%2==0? us1 : us2);
				lst.add(p);
			}
			postRepository.saveAll(lst);

			for (Post post : lst) {
				PostComment postComment = new PostComment("Comment", true, LoremIpsum.createSentence(10),
						LocalDate.of(2002,03,28), LocalDate.of(2002,03,28),
						post, random.nextInt(10)%2==0? us1 : us2);
				postCommentRepository.save(postComment);
			}

        };
    }

}
