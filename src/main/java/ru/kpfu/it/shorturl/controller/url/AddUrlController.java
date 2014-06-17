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

import javax.servlet.http.HttpServletRequest;
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
    public @ResponseBody Url addUrl(@Valid Url url, BindingResult result, Model model, HttpServletRequest request){
        if(!result.hasErrors()) {
            User author = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
            String originalLink = url.getOriginalLink();

            if(!originalLink.startsWith("http://") && !originalLink.startsWith("https://") && !originalLink.startsWith("ftp://")){
                originalLink = "http://" + originalLink;
                url.setOriginalLink(originalLink);
            }

            url = urlRepository.save(url);
            url.setShortCode(ShortUrlUtil.getShortCodeFromUrlId(url.getId()));
            url.setClicks(0);
            url.setCreatedAt(new Date());
            url.setDeletedAt(DateUtil.addDays(url.getCreatedAt(), 30));
            url.setAuthor(author);

            if(url.isSendEmail()){
                String baseUrl = request.getServerName()+":"+request.getServerPort();
                sendMail.sendMail(url, baseUrl);
            }

            urlRepository.save(url);
            return url;
        }
        return null;
    }

}
