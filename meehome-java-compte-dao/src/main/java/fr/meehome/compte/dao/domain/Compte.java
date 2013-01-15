package fr.meehome.compte.dao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Hibernate;

import fr.meehome.user.dao.domain.User;

@Entity
@Table(name = "COMPTE")
public class Compte {

    @Id
    @GeneratedValue
    @Column(name = "COMPTE_ID")
    private int id;

    @ManyToOne
    @Column(name = "COMPTE_USER")
    private User user;

    @Column(name = "COMPTE_LIBELLE")
    private String libelle;

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
        final Compte other = (Compte ) obj;
        if (getLibelle() == null) {
            if (other.getLibelle() != null) {
                return false;
            }
        } else if (!(getLibelle() == other.getLibelle())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLibelle() == null) ? 0 : getLibelle().hashCode());
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
