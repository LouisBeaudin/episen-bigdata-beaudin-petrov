package com.knowmebetter.business.dao;

import com.knowmebetter.business.model.Author4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDAO4 extends JpaRepository<Author4, Long> {

    Author4 findByName(String name);
}
