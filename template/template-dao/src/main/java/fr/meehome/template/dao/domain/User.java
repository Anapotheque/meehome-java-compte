package fr.meehome.template.dao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Hibernate;

@Entity
@Table(name = "TEMPLATE_USER")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "TEMPLATE_USER_ID")
	private int id;

	@Column(name = "TEMPLATE_USER_LOGIN")
	private String login;

	@Column(name = "TEMPLATE_USER_PASSWORD")
	private String password;

	@Column(name = "TEMPLATE_USER_NOM")
	private String nom;

	@Column(name = "TEMPLATE_USER_PRENOM")
	private String prenom;

	@Enumerated(EnumType.STRING)
	@Column(name = "TEMPLATE_USER_ROLE")
	private RoleEnum roleEnum;

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (Hibernate.getClass(this) != Hibernate.getClass(obj)) {
			return false;
		}
		final User other = (User) obj;
		if (getLogin() == null) {
			if (other.getLogin() != null) {
				return false;
			}
		} else if (!getLogin().equals(other.getLogin())) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getLogin() == null) ? 0 : getLogin().hashCode());
		return result;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
