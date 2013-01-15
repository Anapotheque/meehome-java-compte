package fr.meehome.user.services.dto;

public class UserDto {

    private int id;

    private String login;

    private String password;

    private String nom;

    private String prenom;

    private RoleEnumDto roleEnumDto;

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

    public RoleEnumDto getRoleEnumDto() {
        return roleEnumDto;
    }

    public void setRoleEnumDto(RoleEnumDto roleEnumDto) {
        this.roleEnumDto = roleEnumDto;
    }
}
