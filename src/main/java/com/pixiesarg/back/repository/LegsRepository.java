package com.pixiesarg.back.repository;

import com.pixiesarg.back.domain.assets.Legs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegsRepository extends JpaRepository<Legs,Long> {
}
