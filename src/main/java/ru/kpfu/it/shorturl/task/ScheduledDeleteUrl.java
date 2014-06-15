package ru.kpfu.it.shorturl.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import ru.kpfu.it.shorturl.model.Url;
import ru.kpfu.it.shorturl.service.UrlRepository;

import java.util.Date;
import java.util.Iterator;

/**
 * Created by Ayrat on 15.06.2014.
 */
public class ScheduledDeleteUrl {

    @Autowired
    UrlRepository urlRepository;

    @Scheduled(cron = "0 0 12 * * ?")
    public void deleteUrls(){
        Iterable<Url> urls = urlRepository.findAll();
        Iterator<Url> iterator = urls.iterator();
        Date now = new Date();
        while (iterator.hasNext()){
            Url url = iterator.next();
            if (url.getDeletedAt().before(now)){
                urlRepository.delete(url);
            }
        }
    }
}
