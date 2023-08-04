package br.senai.sc.trunfo.security.repository;

import br.senai.sc.trunfo.security.model.entity.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSecurityRepository extends JpaRepository<UserSecurity, Long> {
    UserSecurity findByUser_Username(String username);
}
