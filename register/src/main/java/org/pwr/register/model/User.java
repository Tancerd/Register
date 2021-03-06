package org.pwr.register.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "user", uniqueConstraints = {
		@UniqueConstraint(columnNames = "login"),
		@UniqueConstraint(columnNames = "id") })

public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	@Column(name = "login", unique = true, nullable = false)
	private String login;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name="role", nullable = false)
	private String role;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "user")
	private UserGame userGame;
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserGame getUserGame() {
		return userGame;
	}

	public void setUserGame(UserGame userGame) {
		this.userGame = userGame;
	}
	
}