package demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import demo.model.Filiale;
import demo.model.Mitarbeiter;

public interface FilialeRepository extends CrudRepository<Filiale, Integer>{
	@Query("select a from Filiale a where a.name like :name")
	 List<Filiale> findByNameLike(@Param("name") String name);
	@Query("select a from Filiale a where a.mitarbeiter like :name")
	 List<Filiale> findByChef(@Param("name") Mitarbeiter name);
}
