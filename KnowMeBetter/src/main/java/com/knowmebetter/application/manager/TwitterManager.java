package com.knowmebetter.application.manager;

import com.knowmebetter.business.dto.PoliticDTO;
import twitter4j.TwitterException;

import java.util.List;

public interface TwitterManager {

    List<PoliticDTO> findAllPolitics();

    void populate() throws InterruptedException;
}
