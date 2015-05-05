package demo.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import demo.model.Filiale;
import demo.model.Mitarbeiter;

public interface MitarbeiterService {
	List<Mitarbeiter> findByNameLike(String name);
	List<Mitarbeiter> findByFiliale(Filiale name);
	 Mitarbeiter findOne(int id);
	 Mitarbeiter save(Mitarbeiter a);
	 void delete(int id);
	 long length();
}