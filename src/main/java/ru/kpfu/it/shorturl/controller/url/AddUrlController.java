package ru.kpfu.it.shorturl.controller.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.it.shorturl.model.Url;
import ru.kpfu.it.shorturl.model.User;
import ru.kpfu.it.shorturl.service.UrlRepository;
import ru.kpfu.it.shorturl.service.UserRepository;
import ru.kpfu.it.shorturl.utils.ShortUrl;

import javax.validation.Valid;

/**
 * Created by Ayrat on 14.06.2014.
 */

@Controller
public class AddUrlController {

    @Autowired
    UrlRepository urlRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "url", method = RequestMethod.POST)
    public @ResponseBody Url addUrl(@Valid Url url, BindingResult result, Model model){
        Url oldUrl = urlRepository.findByOriginalLink(url.getOriginalLink());
        if(oldUrl != null){
            return oldUrl;
        }

        urlRepository.save(url);
        url.setShortcode(ShortUrl.getShortCodeFromUrlId(url.getId()));

        User author = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        url.setAuthor(author);

        return url;
    }

}
