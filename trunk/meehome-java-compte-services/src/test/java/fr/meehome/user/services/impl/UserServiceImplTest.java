package fr.meehome.user.services.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import fr.meehome.compte.dao.IUserDao;
import fr.meehome.compte.dao.domain.User;
import fr.meehome.user.services.IUserService;
import fr.meehome.user.services.dto.UserDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/fr/meehome/user/services/applicationContext-test.xml" })
public class UserServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private IUserService userService;

    @Mock
    private IUserDao userDaoMock;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(userService, "userDao", userDaoMock, IUserDao.class);

        // gestion des mocks
        when(userDaoMock.findAll()).thenReturn(populate_users_dao_mock());
    }

    private List<User> populate_users_dao_mock() {
        List<User> listUser = new ArrayList<User>();
        User user1 = new User();
        user1.setLogin("test1");
        User user2 = new User();
        user2.setLogin("test2");
        listUser.add(user1);
        listUser.add(user2);
        return listUser;
    }

    @Test
    public void should_return_all_users() {

        List<UserDto> listUserDto = userService.getAll();
        assertEquals(2, listUserDto.size());
    }
}
