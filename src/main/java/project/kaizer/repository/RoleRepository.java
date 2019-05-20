package project.kaizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.kaizer.domain.entities.UserRole;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, String> {
    UserRole getByAuthority(String authority);
}
