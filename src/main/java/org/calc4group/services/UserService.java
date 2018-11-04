package org.calc4group.services;

import org.calc4group.dtos.UserDto;
import org.calc4group.entities.User;
import org.calc4group.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return userRepository.save(user);
    }

    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> getUsersByIds(List<Integer> userIds) {
        return userRepository.findAllById(userIds);
    }

    public void deleteUser(Integer userId) {
        if(userRepository.existsById(userId)){
            userRepository.deleteById(userId);
        }
    }
}
