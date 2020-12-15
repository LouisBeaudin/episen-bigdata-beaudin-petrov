package com.knowmebetter.business.dao;

import com.knowmebetter.business.model.Jointure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JointureDAO extends JpaRepository<Jointure, Long> {
}
