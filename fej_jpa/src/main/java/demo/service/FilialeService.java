package demo.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import demo.model.Filiale;
import demo.model.Mitarbeiter;

public interface FilialeService {
	List<Filiale> findByNameLike(String name);
	List<Filiale> findByChef(Mitarbeiter name);
	Filiale findOne(int id);
	Filiale save(Filiale a);
	void delete(int id);
	long length();
}
