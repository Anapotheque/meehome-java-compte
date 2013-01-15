package fr.meehome.user.services.dto;

public enum RoleEnumDto {
    ADMINISTRATEUR(1, "adminsitrateur"), VISITEUR(2, "visiteur");

    private int code;

    private String value;

    private RoleEnumDto(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
