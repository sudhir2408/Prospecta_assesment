package repository;

import java.security.KeyStore;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface entryRepository extends JpaRepository<KeyStore.Entry, Integer>{
	
	Optional<KeyStore.Entry> findapi(String Api);

}
