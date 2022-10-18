package com.pixiesarg.back.repository;

import com.pixiesarg.back.domain.assets.Hand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandRepository extends JpaRepository<Hand,Long> {
}
