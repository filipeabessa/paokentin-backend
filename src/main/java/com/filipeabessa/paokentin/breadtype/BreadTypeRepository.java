package com.filipeabessa.paokentin.breadtype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreadTypeRepository extends JpaRepository<BreadTypeEntity, Long> {
}
