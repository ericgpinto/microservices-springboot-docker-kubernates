package br.com.ericpinto.user.repository;

import br.com.ericpinto.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLegalDocumentNumber(String legalDocumentNumber);

    List<User> queryByNameLike(String name);
}
