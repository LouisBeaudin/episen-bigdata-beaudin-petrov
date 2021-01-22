package com.knowmebetter.business.dao;

import com.knowmebetter.business.model.Jointure2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JointureDAO2 extends JpaRepository<Jointure2, Long> {
}
