package ru.kpfu.it.shorturl.service;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.it.shorturl.model.Url;

/**
 * Created by Ayrat on 14.06.2014.
 */
public interface UrlRepository extends CrudRepository<Url, Long>{
    Url findByShortCode(String shortCode);

    Url findByOriginalLink(String originalLink);
}
