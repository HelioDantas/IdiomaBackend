package br.com.matrix.idioma.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.matrix.idioma.model.UserOld;

@Repository
public interface UserOldRepository  extends JpaRepository<UserOld, Long> {

	Optional<UserOld> findByLogin(String login); 	
	Optional<UserOld> findByEmail(String email);

}
