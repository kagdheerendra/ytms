package com.yash.ytms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ytms.entity.Associate;

/**
 * This will responsible to communicate with associate database table
 * @author dheerendra.kag
 * @version 1.0
 * @since 05/05/2023
 */
@Repository
public interface AssociateRepository extends JpaRepository<Associate, Long>{

}
