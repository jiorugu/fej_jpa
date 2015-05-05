package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import demo.model.Filiale;
import demo.model.Mitarbeiter;

@Component("service.FilialeService")
@Transactional // Spring provides a transaction manager specifically for JPA.

	public class FilialeServiceImpl implements FilialeService {
	 
	private final FilialeRepository filialeRepository;
	 @Autowired 
	 
	 public FilialeServiceImpl(FilialeRepository filialeRepository) {
	  this.filialeRepository = filialeRepository;
	 }

	 @Override
	 @Transactional(readOnly=true)
	 public List<Filiale> findByNameLike(String name) {
	  return filialeRepository.findByNameLike(name);
	 }
	 @Override
	 @Transactional(readOnly=true)
	 public Filiale findOne(int id) {
	  return filialeRepository.findOne(id);
	 }
	 @Override
	 public Filiale save(Filiale a) {
	  return filialeRepository.save(a);
	 }
	 @Override
	 public void delete(int id) {
	  filialeRepository.delete(id);
	 }
	 @Override
	 @Transactional(readOnly=true)
	 public long length() {
	  return filialeRepository.count();
	 }

	@Override
	public List<Filiale> findByChef(Mitarbeiter name) {
		// TODO Auto-generated method stub
		return filialeRepository.findByChef(name);
	}
	 

	}

