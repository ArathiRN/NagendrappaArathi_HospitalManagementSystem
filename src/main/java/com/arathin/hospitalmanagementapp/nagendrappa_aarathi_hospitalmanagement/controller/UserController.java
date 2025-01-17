package com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.controller;


import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.dto.UserDto;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.entity.User;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }



    @GetMapping("/index")
    public String homePage(Model model)


    {
        return "index";
    }

    //Displays the user registration form.
    //Adds an empty UserDto object to the model to bind form data.
    @GetMapping("/userRegistration")
    public String userRegistration(Model model){
        UserDto userDto =new UserDto();
        model.addAttribute("user", userDto);
        return "user-registration";
    }

    //Handles the submission of the user registration form.
    // Validates the form data and checks for existing users with the same email.
    @PostMapping("/userRegistration/save")
    public String saveRegistration(@Valid @ModelAttribute("user") UserDto user, BindingResult result, Model model) {
        User existing =userService.findUserByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "user-registration";
        }

        userService.saveUser(user);
        return "redirect:/userRegistration?success";
    }


//     Displays a list of all registered users.
    @GetMapping("/registeredUsers")
    public String listRegisteredUsers(Model model){
        List<UserDto> users= userService.findAllUsers();
        model.addAttribute("users", users);
        return "registered-users";

    }
//
//    @GetMapping("/deleteParent")
//    public String showDeleteParentPage() {
//        return "deleteParent";
//    }
//
//    @PostMapping("/deleteParent")
//    public String deleteParent(@RequestParam("email") String email, Model model) {
//        if (email.endsWith("@admin.com")) {
//            model.addAttribute("errorMessage", "This is an admin email, not able to delete.");
//        } else if (!userService.deleteParentByEmail(email)) {
//            model.addAttribute("errorMessage", "Invalid email, not present.");
//        } else {
//            model.addAttribute("successMessage", "Parent deleted successfully.");
//        }
//        return "deleteParent";
//    }
}


