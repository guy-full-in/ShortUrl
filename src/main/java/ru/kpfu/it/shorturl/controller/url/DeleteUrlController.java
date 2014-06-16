package ru.kpfu.it.shorturl.controller.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.it.shorturl.service.UrlRepository;

/**
 * Created by Ayrat on 16.06.2014.
 */
@Controller
public class DeleteUrlController {

    @Autowired
    UrlRepository urlRepository;

    @RequestMapping(value = "url/{id}/delete", method = RequestMethod.POST)
    public @ResponseBody String delete(@PathVariable Long id) {
        urlRepository.delete(id);
        return "ok";
    }
}
