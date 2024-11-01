package com.clubs.eliteclub.repository;

import com.clubs.eliteclub.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EliteClubRepository extends JpaRepository<Club, Long> {
    @Query("SELECT x from Club x WHERE lower(x.name) LIKE :searchTerm order by x.name asc")
    List<Club> findClubs(@Param("searchTerm") String searchTerm);

}
