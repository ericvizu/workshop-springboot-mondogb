package com.ericvizu.workshopmongo.dto;

import java.io.Serializable;

import com.ericvizu.workshopmongo.domain.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String email;

	public UserDTO() {
	}

	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

	/*
	 * O método fromDTO está na classe UserService, pois dependendo da situação,
	 * para instanciar um User eu posso querer acessar um banco de dados e quem tem
	 * a dependência do banco de dados é o UserService. Então, para ficar uma
	 * operação que seja possível fazer uma manutenção no futuro que tenha acesso à
	 * dados é melhor ficar no UserService
	 * 
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
