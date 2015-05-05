package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import demo.model.Filiale;
import demo.model.Mitarbeiter;

@Component("service.MitarbeiterService")
@Transactional // Spring provides a transaction manager specifically for JPA.

	public class MitarbeiterServiceImpl implements MitarbeiterService {
	 
	private final MitarbeiterRepository MitarbeiterRepository;
	 @Autowired 
	 
	 public MitarbeiterServiceImpl(MitarbeiterRepository MitarbeiterRepository) {
	  this.MitarbeiterRepository = MitarbeiterRepository;
	 }

	 @Override
	 @Transactional(readOnly=true)
	 public List<Mitarbeiter> findByNameLike(String name) {
	  return MitarbeiterRepository.findByNameLike(name);
	 }
	 @Override
	 @Transactional(readOnly=true)
	 public Mitarbeiter findOne(int id) {
	  return MitarbeiterRepository.findOne(id);
	 }
	 @Override
	 public Mitarbeiter save(Mitarbeiter a) {
	  return MitarbeiterRepository.save(a);
	 }
	 @Override
	 public void delete(int id) {
	  MitarbeiterRepository.delete(id);
	 }
	 @Override
	 @Transactional(readOnly=true)
	 public long length() {
	  return MitarbeiterRepository.count();
	 }

	@Override
	public List<Mitarbeiter> findByFiliale(Filiale name) {
		// TODO Auto-generated method stub
		return name.getMitarbeiters();
	}
	 

	}

