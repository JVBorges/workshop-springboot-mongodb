package com.jvborges.wsmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jvborges.wsmongodb.domain.Post;
import com.jvborges.wsmongodb.domain.User;
import com.jvborges.wsmongodb.dto.AuthorDTO;
import com.jvborges.wsmongodb.repository.PostRepository;
import com.jvborges.wsmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		postRepo.deleteAll();
		userRepo.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepo.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2019"), "Partiu viagem", "Vou viajar para São Paulo, abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2019"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		postRepo.saveAll(Arrays.asList(post1, post2));
	}

}
