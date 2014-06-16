package ru.kpfu.it.shorturl.controller.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.it.shorturl.mail.SendMail;
import ru.kpfu.it.shorturl.model.Url;
import ru.kpfu.it.shorturl.model.User;
import ru.kpfu.it.shorturl.service.UrlRepository;
import ru.kpfu.it.shorturl.service.UserRepository;
import ru.kpfu.it.shorturl.utils.DateUtil;
import ru.kpfu.it.shorturl.utils.ShortUrlUtil;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by Ayrat on 14.06.2014.
 */

@Controller
public class AddUrlController {

    @Autowired
    UrlRepository urlRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SendMail sendMail;

    @RequestMapping(value = "/url", method = RequestMethod.POST)
    public @ResponseBody Url addUrl(@Valid Url url, BindingResult result, Model model){
        if(!result.hasErrors()) {
            String originalLink = url.getOriginalLink();
            if(!originalLink.startsWith("http://") && !originalLink.startsWith("https://") && !originalLink.startsWith("ftp://")){
                originalLink = "http://" + originalLink;
                url.setOriginalLink(originalLink);
            }
            Url oldUrl = urlRepository.findByOriginalLink(url.getOriginalLink());
            if (oldUrl != null) {
                return oldUrl;
            }
            url = urlRepository.save(url);
            url.setShortCode(ShortUrlUtil.getShortCodeFromUrlId(url.getId()));
            url.setClicks(0);
            url.setCreatedAt(new Date());
            url.setDeletedAt(DateUtil.addDays(url.getCreatedAt(), 30));
            User author = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
            url.setAuthor(author);

            System.out.println(url.isSendEmail());
            if(url.isSendEmail()){
                sendMail.sendMail(url);
            }

            urlRepository.save(url);
            return url;
        }
        return url;
    }

}
