package com.leonardoSiqueira.WorkshopMongoDB.config;

<<<<<<< HEAD
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;
=======
import java.util.Arrays;
>>>>>>> f961d1ea2c8308453e6c785ba13c0c7ee08cc2d5

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

<<<<<<< HEAD
import com.leonardoSiqueira.WorkshopMongoDB.domain.Post;
import com.leonardoSiqueira.WorkshopMongoDB.domain.User;
import com.leonardoSiqueira.WorkshopMongoDB.repository.PostRepository;
=======
import com.leonardoSiqueira.WorkshopMongoDB.domain.User;
>>>>>>> f961d1ea2c8308453e6c785ba13c0c7ee08cc2d5
import com.leonardoSiqueira.WorkshopMongoDB.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
<<<<<<< HEAD
	@Autowired
	private PostRepository postRepository;
=======
>>>>>>> f961d1ea2c8308453e6c785ba13c0c7ee08cc2d5

	@Override
	public void run(String... args) throws Exception {

<<<<<<< HEAD
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para São paulo, abraços!", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
=======
		userRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
>>>>>>> f961d1ea2c8308453e6c785ba13c0c7ee08cc2d5

	}

}
