package com.knowmebetter.business.dao;

import com.knowmebetter.business.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendDAO extends JpaRepository<Friend, Long> {
}
