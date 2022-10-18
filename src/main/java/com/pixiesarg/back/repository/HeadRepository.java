package com.pixiesarg.back.repository;

import com.pixiesarg.back.domain.assets.Head;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadRepository extends JpaRepository<Head,Long> {
}
