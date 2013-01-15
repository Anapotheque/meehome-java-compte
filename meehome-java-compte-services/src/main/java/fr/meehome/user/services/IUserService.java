package fr.meehome.user.services;

import java.util.List;

import fr.meehome.user.services.dto.UserDto;

public interface IUserService {

    public List<UserDto> getAll();

    public UserDto isAuthorized(String login, String password);

    public void delete(UserDto user);

    public void saveOrUpdate(UserDto user);
}
