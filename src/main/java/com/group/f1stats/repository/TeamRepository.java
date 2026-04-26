// Author: Izhan Akhtar - 421009836
// Entity: Team
package com.group.f1stats.repository;

import com.group.f1stats.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    // findAll - inherited from JpaRepository

    // findById
    Optional<Team> findById(Long id);

    // findByNationality - derived method
    List<Team> findByNationality(String nationality);

    // findByNameContaining - custom JPQL query
    @Query("SELECT t FROM Team t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Team> findByNameContaining(@Param("name") String name);

    // updatePrincipalById - @Modifying + @Query
    @Modifying
    @Query("UPDATE Team t SET t.principal = :principal WHERE t.id = :id")
    int updatePrincipalById(@Param("id") Long id, @Param("principal") String principal);

    // deleteById
    void deleteById(Long id);
}