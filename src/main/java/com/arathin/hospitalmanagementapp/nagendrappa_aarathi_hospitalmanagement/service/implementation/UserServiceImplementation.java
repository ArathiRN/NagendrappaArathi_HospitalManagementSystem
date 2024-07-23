package com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.service.implementation;

import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.dto.UserDto;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.entity.Role;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.entity.User;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.repository.RoleRepository;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.repository.UserRepository;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImplementation(UserRepository userRepository,
                                     RoleRepository roleRepository,
                                     PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();

        user.setEmail(userDto.getEmail());

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setDob(userDto.getDob());
        user.setGender(userDto.getGender());
        user.setAddress(userDto.getAddress());
        userRepository.save(user);

        //Determine the role based on registration criteria
//        String roleName;
//        if(userDto.isAdminRegistration()){
//            roleName = "ROLE_ADMIN";
//        }else{
//            roleName= "ROLE_PATIENT";
//        }

//        //Check if role already exists in database, otherwise create it
//        Role role = roleRepository.findByName(roleName);
//        if(role == null) {
//            role = new Role();
//            role.setName((roleName));
//            roleRepository.save(role);
//        }

        //Assign the role to the user
//        user.setRoles((Collections.singletonList(role)));
        userRepository.save(user);
    }

    //Find user by email
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

//    @Transactional
//    public boolean deleteParentByEmail(String email) {
//        var user = userRepository.findByEmail(email);
//        if (user != null) {
//            user.getRoles().clear();  // Disassociate roles
//            userRepository.delete(user);
//            return true;
//        }
//        return false;
//    }


    //Retrieve the list of users
    @Override
    public List<UserDto> findAllUsers() {
        List<User> users= userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }

    //getting user by id
    @Override
    public Optional<User> getUserById(Long parentId) {
        return Optional.empty();
    }

    //Convert user entity to UserDto
    private UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setDob(user.getDob());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setAddress(user.getAddress());
        userDto.setGender(user.getGender());

        return userDto;
    }
}