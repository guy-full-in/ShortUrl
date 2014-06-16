package ru.kpfu.it.shorturl.controller.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.it.shorturl.model.Url;
import ru.kpfu.it.shorturl.service.UrlRepository;
import ru.kpfu.it.shorturl.utils.DateUtil;

/**
 * Created by Ayrat on 16.06.2014.
 */
@Controller
public class ExtendUrlController {

    @Autowired
    UrlRepository urlRepository;

    @RequestMapping(value = "url/{id}/extend", method = RequestMethod.POST)
    public @ResponseBody
    String extend(@PathVariable Long id) {
        Url url = urlRepository.findOne(id);
        url.setDeletedAt(DateUtil.addDays(url.getDeletedAt(), 30));
        urlRepository.save(url);
        return "ok";
    }

}
