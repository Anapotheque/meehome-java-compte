package fr.meehome.compte.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.meehome.compte.dao.IUserDao;
import fr.meehome.compte.dao.domain.User;
import fr.meehome.compte.services.IUserService;
import fr.meehome.compte.services.dto.UserDto;

@Service(value = "IUserService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    @Qualifier("dozerBeanMapper")
    private Mapper mapper;

    private List<UserDto> populate(List<User> list) {
        List<UserDto> listUserDto = new ArrayList<UserDto>();
        for (User user : list) {
            listUserDto.add(mapper.map(user, UserDto.class));
        }
        return listUserDto;
    }

    @Override
    public List<UserDto> getAll() {
        return populate(userDao.findAll());
    }

    @Override
    public List<UserDto> getUserByLogin(String login) {
        return populate(userDao.findByLogin(login));
    }

    @Override
    public boolean isAuthorized(String login, String password) {
        List<UserDto> listUserDto = populate(userDao.findByLoginAndPwd(login, password));
        return listUserDto != null && listUserDto.size() == 1 ? true : false;
    }

    @Override
    public boolean delete(List<UserDto> listUser) {
        boolean result = false;
        for (UserDto userDto : listUser) {
            List<User> listUserFind = userDao.findByLogin(userDto.getLogin());
            if (listUserFind != null && !listUserFind.isEmpty()) {
                result = userDao.remove(listUserFind.get(0));
            }
        }
        return result;
    }

    @Override
    public boolean add(List<UserDto> listUser) {
        boolean result = false;
        for (UserDto userDto : listUser) {
            result = userDao.save(mapper.map(userDto, User.class));
        }
        return result;
    }

    @Override
    public boolean update(List<UserDto> listUser) {
        boolean result = false;
        for (UserDto userDto : listUser) {
            result = userDao.save(mapper.map(userDto, User.class));
        }
        return result;
    }
}
