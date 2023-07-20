package com.leonardoSiqueira.WorkshopMongoDB.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.events.CommentEvent;

import com.leonardoSiqueira.WorkshopMongoDB.domain.Post;
import com.leonardoSiqueira.WorkshopMongoDB.domain.User;
import com.leonardoSiqueira.WorkshopMongoDB.dto.AuthorDTO;
import com.leonardoSiqueira.WorkshopMongoDB.dto.CommentDTO;
import com.leonardoSiqueira.WorkshopMongoDB.repository.PostRepository;
import com.leonardoSiqueira.WorkshopMongoDB.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		// criação de usuários
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		// salvando users no repositório(no banco de dados)
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		// criação dos posts
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para São paulo, abraços!",
				new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

		// criação dos comentários nos posts associados com os respectivos autores
		CommentDTO cm1 = new CommentDTO("Boa viagem irmão!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO cm2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO cm3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

		// adicionando os comentarios aos posts
		post1.getComments().addAll(Arrays.asList(cm1, cm2));
		post2.getComments().addAll(Arrays.asList(cm3));

		// salvando os posts com os comentários no banco de dados
		postRepository.saveAll(Arrays.asList(post1, post2));

		// User maria sendo associada aos 2 posts que foram feitos
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		//Salvando esta associação na tabela user no banco de dados
		userRepository.save(maria);
	}
}
