package fr.meehome.user.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.meehome.compte.dao.IUserDao;
import fr.meehome.compte.dao.domain.User;
import fr.meehome.user.services.IUserService;
import fr.meehome.user.services.dto.UserDto;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    @Qualifier("dozerBeanMapper")
    private Mapper Mapper;

    @Override
    public List<UserDto> getAll() {
        List<UserDto> listUserDto = new ArrayList<UserDto>();
        List<User> listUser = userDao.findAll();
        for (User user : listUser) {
            listUserDto.add(Mapper.map(user, UserDto.class));
        }
        return listUserDto;
    }

    @Override
    public UserDto isAuthorized(String login, String password) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(UserDto user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveOrUpdate(UserDto user) {
        // TODO Auto-generated method stub

    }
}
