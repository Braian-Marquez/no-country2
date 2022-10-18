package com.pixiesarg.back.repository;

import com.pixiesarg.back.domain.entity.EquipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipRepository extends JpaRepository<EquipEntity,Long> {
}
