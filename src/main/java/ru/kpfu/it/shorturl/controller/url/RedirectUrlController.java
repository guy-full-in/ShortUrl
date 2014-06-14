package ru.kpfu.it.shorturl.controller.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.it.shorturl.model.Url;
import ru.kpfu.it.shorturl.service.UrlRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ayrat on 14.06.2014.
 */
@Controller
public class RedirectUrlController {

    @Autowired
    UrlRepository urlRepository;

    @RequestMapping(value = "/{shortCode}", method = RequestMethod.GET)
    public String redirectToOriginalUrl(@PathVariable String shortCode, Model model, HttpServletResponse response) throws IOException {
        Url url = urlRepository.findByShortcode(shortCode);
        if (url == null){
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return "";
        }

        url.setClicks(url.getClicks()+1);
        urlRepository.save(url);

        return "redirect:"+url.getOriginalLink();
    }
}
