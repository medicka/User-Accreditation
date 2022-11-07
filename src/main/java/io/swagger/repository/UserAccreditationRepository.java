package io.swagger.repository;

import io.swagger.entity.UserAccreditation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccreditationRepository extends JpaRepository<UserAccreditation, Integer> {

    List<UserAccreditation> findByClientUserId(String id);
}
