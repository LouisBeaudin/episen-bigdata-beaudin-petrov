package com.knowmebetter.business.dao;

import com.knowmebetter.business.model.Politic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliticDAO extends JpaRepository<Politic, Long> {
}
