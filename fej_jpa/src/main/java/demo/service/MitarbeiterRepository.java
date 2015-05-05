package demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import demo.model.Filiale;
import demo.model.Mitarbeiter;

public interface MitarbeiterRepository extends CrudRepository<Mitarbeiter, Integer>{
	@Query("select a from Mitarbeiter a where a.name like :name")
	 List<Mitarbeiter> findByNameLike(@Param("name") String name);
	
//	@Query("select a from Filiale a where a.filiale like :name")
//	 List<Filiale> findByNameLike(@Param("name") Filiale name);
}
