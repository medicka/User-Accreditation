package io.swagger.repository;

import io.swagger.entity.UserAccreditation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface UserAccreditationRepository extends JpaRepository<UserAccreditation, Integer> {

    List<UserAccreditation> findByClientUserId(String id);

    List<UserAccreditation> findByStatusAndLastUpdateBefore(String status, Timestamp time);
}
