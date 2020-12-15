package com.knowmebetter.api.rest;

import com.knowmebetter.application.manager.TwitterManager;
import com.knowmebetter.application.service.TwitterService;
import com.knowmebetter.business.dto.PoliticDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

import java.util.List;

@RestController
public class TwitterAPIController extends RestBaseController {

    @Autowired
    private TwitterManager twitterManager;

    @GetMapping("politics")
    private List<PoliticDTO> findAllPolitics(){
        return twitterManager.findAllPolitics();
    }

    @GetMapping("populate")
    private void populate() throws InterruptedException{
        twitterManager.populate();
    }
}
