package com.pixiesarg.back.repository;

import com.pixiesarg.back.domain.entity.AssetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetsRepository extends JpaRepository<AssetsEntity,Long> {
}
