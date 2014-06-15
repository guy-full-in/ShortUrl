package ru.kpfu.it.shorturl.controller.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.it.shorturl.model.Url;
import ru.kpfu.it.shorturl.model.User;
import ru.kpfu.it.shorturl.service.UserRepository;

import java.util.Collections;

/**
 * Created by Ayrat on 14.06.2014.
 */

@Controller
public class ShowUrlController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/urls", method = RequestMethod.GET)
    public @ResponseBody Iterable<Url> showUrls(Model model){
        Iterable<Url> urls;
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        if(user != null) {
            User author = userRepository.findByUsername(user);
            if(author!=null) {
                urls = author.getUrls();
                if (urls != null) {
                    return urls;
                }
            }
        }
        return Collections.EMPTY_LIST;
    }
}
