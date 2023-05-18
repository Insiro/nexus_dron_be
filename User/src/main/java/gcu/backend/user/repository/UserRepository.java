package gcu.backend.user.repository;

import gcu.backend.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Auth", path="Auth")
public interface UserRepository extends JpaRepository<User,Long> , CrudRepository<User,Long> {
    public User findByID(String ID);

}
