package com.cydeo.service.impl;

import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository; //as we want to test specific method that need to dependent object, we inject mock object.

    @Mock
    UserMapper userMapper;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void findByUserName_Test() {

        // I'm calling the real method inside the main, which is the method I want to test.
        userService.findByUserName("harold@manager.com");

        // I'm checking if this method ran or not.
        verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com", false);

        //times() method = we are checking how many times we are running this method. if we put 2 times, it should fail.
        verify(userRepository, times(1)).findByUserNameAndIsDeleted("harold@manager.com", false);

        //make sure method is running at least one times.
        verify(userRepository, atLeastOnce()).findByUserNameAndIsDeleted("harold@manager.com", false);

        //exactly the same as atLeastOnce() method.
        verify(userRepository, atLeast(1)).findByUserNameAndIsDeleted("harold@manager.com", false);

        //it might run 0 or 1` time.
        verify(userRepository, atMostOnce()).findByUserNameAndIsDeleted("harold@manager.com", false);
        verify(userRepository, atMost(10)).findByUserNameAndIsDeleted("harold@manager.com", false);

        //to test which method runs first.
        InOrder inOrder = inOrder(userRepository, userMapper);

        inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com", false);
        inOrder.verify(userMapper).convertToDto(null); //in real code instead of null requires user object.


    }

}
