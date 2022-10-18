package com.pixiesarg.back.repository;

import com.pixiesarg.back.domain.entity.AvatarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepository extends JpaRepository<AvatarEntity,Long> {
}
