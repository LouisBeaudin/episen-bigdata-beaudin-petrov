package com.knowmebetter.business.dao;

import com.knowmebetter.business.model.Author3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDAO3 extends JpaRepository<Author3, Long> {

    Author3 findByName(String name);
}
