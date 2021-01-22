package com.knowmebetter.business.dao;

import com.knowmebetter.business.model.Jointure3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JointureDAO3 extends JpaRepository<Jointure3, Long> {
}
