package com.pixiesarg.back.repository;

import com.pixiesarg.back.domain.assets.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetsRepository extends JpaRepository<Pet,Long> {
}
