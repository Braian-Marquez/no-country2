package com.pixiesarg.back.repository;

import com.pixiesarg.back.domain.assets.BodyAssets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyRepository extends JpaRepository<BodyAssets,Long> {
}
