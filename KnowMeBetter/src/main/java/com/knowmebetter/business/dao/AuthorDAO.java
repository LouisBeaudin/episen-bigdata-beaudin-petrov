package com.knowmebetter.business.dao;

import com.knowmebetter.business.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDAO extends JpaRepository<Author, Long> {

    Author findByName(String name);
}
