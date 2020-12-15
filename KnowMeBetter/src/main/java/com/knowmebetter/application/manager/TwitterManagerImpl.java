package com.knowmebetter.application.manager;

import com.knowmebetter.business.OrikaBeanMapper;
import com.knowmebetter.business.dao.FriendDAO;
import com.knowmebetter.business.dao.PoliticDAO;
import com.knowmebetter.business.dto.PoliticDTO;
import com.knowmebetter.business.model.Friend;
import com.knowmebetter.business.model.Politic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.CursoredList;

import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Service;
import twitter4j.PagableResponseList;


import java.util.ArrayList;
import java.util.List;

import static org.omg.PortableServer.IdAssignmentPolicyValue.USER_ID;

@Service
public class TwitterManagerImpl implements TwitterManager {

    private final OrikaBeanMapper orikaBeanMapper;

    private final PoliticDAO politicDAO;

    private final FriendDAO friendDAO;

    private final Twitter twitter;

    public TwitterManagerImpl(PoliticDAO politicDAO, OrikaBeanMapper orikaBeanMapper, Twitter twitter, FriendDAO friendDAO) {
        this.politicDAO = politicDAO;
        this.orikaBeanMapper = orikaBeanMapper;
        this.twitter = twitter;
        this.friendDAO = friendDAO;
    }

    public List<PoliticDTO> findAllPolitics() {
        return orikaBeanMapper.mapAsList(politicDAO.findAll(), PoliticDTO.class);
    }

    @Override
    public void populate() throws InterruptedException {

        List<Politic> politics = politicDAO.findAll();
        int compteur = 1;
        for(Politic politic: politics){
            if(politic.getTwitteraccount() !=null && !politic.getTwitteraccount().equals("")){
                List<TwitterProfile> friends = new ArrayList<>();
                List<TwitterProfile> allFriends = new ArrayList<>();
                String nomTwitter = politic.getTwitteraccount().substring(1);
                if(compteur % 900 == 0){
                    Thread.sleep(900000);
                }
                friends = twitter.friendOperations().getFriendsInCursor(nomTwitter,-1);
                compteur = compteur + 1;
                allFriends.addAll(friends);
                //long cursor = twitter.friendOperations().getFriendsInCursor("realDonalTrump",-1).getNextCursor();
                if(compteur % 900 == 0){
                    Thread.sleep(900000);
                }
                long cursor = twitter.friendOperations().getFriendsInCursor(nomTwitter,-1).getNextCursor();
                compteur = compteur + 1;
                boolean con = true;

                while(con){
                    if(compteur % 900 == 0){
                        Thread.sleep(900000);
                    }
                    friends = twitter.friendOperations().getFriendsInCursor(nomTwitter, cursor);
                    compteur = compteur + 1;
                    //friends = twitter.friendOperations().getFriendsInCursor("realDonalTrump", cursor);
                    if(compteur % 900 == 0){
                        Thread.sleep(900000);
                    }
                    cursor = twitter.friendOperations().getFriendsInCursor(nomTwitter,cursor).getNextCursor();
                    compteur = compteur + 1;
                    //cursor = twitter.friendOperations().getFriendsInCursor("realDonalTrump",cursor).getNextCursor();
                    allFriends.addAll(friends);
                    if(friends.size()<20){
                        con = false;
                    }
                }

                for(TwitterProfile friend: allFriends){
                    Friend friendToAdd = new Friend(friend.getScreenName());
                    friendDAO.save(friendToAdd);
                }
            }
        }

    }
}
