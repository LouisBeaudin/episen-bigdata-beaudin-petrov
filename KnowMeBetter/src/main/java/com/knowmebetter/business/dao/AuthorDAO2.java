package com.knowmebetter.business.dao;

import com.knowmebetter.business.model.Author2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDAO2 extends JpaRepository<Author2, Long> {

    Author2 findByName(String name);
}
