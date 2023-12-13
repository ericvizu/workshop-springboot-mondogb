package com.ericvizu.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericvizu.workshopmongo.domain.User;
import com.ericvizu.workshopmongo.dto.UserDTO;
import com.ericvizu.workshopmongo.repository.UserRepository;
import com.ericvizu.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public User fromDTO(UserDTO objDto) {
		/*
		 * O método fromDTO está na classe UserService, pois dependendo da situação,
		 * para instanciar um User eu posso querer acessar um banco de dados e quem tem
		 * a dependência do banco de dados é o UserService. Então, para ficar uma
		 * operação que seja possível fazer uma manutenção no futuro que tenha acesso à
		 * dados é melhor ficar no UserService
		 * 
		 */
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
