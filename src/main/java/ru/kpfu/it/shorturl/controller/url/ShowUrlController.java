package ru.kpfu.it.shorturl.controller.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.it.shorturl.model.Url;
import ru.kpfu.it.shorturl.model.User;
import ru.kpfu.it.shorturl.service.UserRepository;

import java.util.Collections;

/**
 * Created by Ayrat on 14.06.2014.
 */

@Controller("/urls")
public class ShowUrlController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Url> showUrls(Model model){
        User author = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Iterable<Url> urls = author.getUrls();
        if (urls == null){
            return Collections.EMPTY_LIST;
        }
        return urls;
    }
}
