package com.knowmebetter.business.dao;

import com.knowmebetter.business.model.Author5;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDAO5 extends JpaRepository<Author5, Long> {

    Author5 findByName(String name);
}
