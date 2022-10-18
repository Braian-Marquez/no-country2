package com.pixiesarg.back.repository;

import com.pixiesarg.back.domain.assets.Hair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HairRepository extends JpaRepository<Hair,Long> {
}
