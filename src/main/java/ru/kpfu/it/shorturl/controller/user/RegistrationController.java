package ru.kpfu.it.shorturl.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.it.shorturl.model.User;
import ru.kpfu.it.shorturl.model.UserRole;
import ru.kpfu.it.shorturl.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ayrat on 23.04.2014.
 */
@Controller
@RequestMapping("/registr")
public class RegistrationController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getForm(Model model){
        model.addAttribute("user",new User());
        return "registr";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registr(@Valid User user,
                               BindingResult result,
                               Model model){
        if(userService.exists(user.getUsername())){
            result.addError(new ObjectError("username", "Это имя уже используется"));
            model.addAttribute("user", user);
            return "register";
        }

        if(!user.getPassword().equals(user.getConfirmPassword())){
            result.addError(new ObjectError("confirmPassword", "Пароли не совпадают"));
            model.addAttribute("user", user);
            return "registr";
        }

        if (!result.hasErrors()) {
            userService.saveAsUser(user);
            List<UserRole> userRoles = user.getRole();
            List<GrantedAuthority> authorities = new ArrayList<>();
            for(UserRole role : userRoles){
                authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
            }
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), authorities));
            return "redirect:/";
        } else {
            model.addAttribute("user", user);
            return "registr";
        }
    }
}
