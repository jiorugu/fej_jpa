package demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mitarbeiter database table.
 * 
 */
@Entity
@NamedQuery(name="Mitarbeiter.findAll", query="SELECT m FROM Mitarbeiter m")
public class Mitarbeiter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idMitarbeiter;

	private String name;

	//bi-directional many-to-one association to Filiale
	@OneToMany(mappedBy="mitarbeiter")
	private List<Filiale> filiales1;

	//bi-directional many-to-many association to Filiale
	@ManyToMany
	@JoinTable(
		name="filiale_has_mitarbeiter"
		, joinColumns={
			@JoinColumn(name="Mitarbeiter_idMitarbeiter")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Filiale_idFiliale")
			}
		)
	private List<Filiale> filiales2;

	public Mitarbeiter() {
	}

	public int getIdMitarbeiter() {
		return this.idMitarbeiter;
	}

	public void setIdMitarbeiter(int idMitarbeiter) {
		this.idMitarbeiter = idMitarbeiter;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Filiale> getFiliales1() {
		return this.filiales1;
	}

	public void setFiliales1(List<Filiale> filiales1) {
		this.filiales1 = filiales1;
	}

	public Filiale addFiliales1(Filiale filiales1) {
		getFiliales1().add(filiales1);
		filiales1.setMitarbeiter(this);

		return filiales1;
	}

	public Filiale removeFiliales1(Filiale filiales1) {
		getFiliales1().remove(filiales1);
		filiales1.setMitarbeiter(null);

		return filiales1;
	}

	public List<Filiale> getFiliales2() {
		return this.filiales2;
	}

	public void setFiliales2(List<Filiale> filiales2) {
		this.filiales2 = filiales2;
	}

	@Override
	public String toString() {
		return "Mitarbeiter [idMitarbeiter=" + idMitarbeiter + ", name=" + name
				+ "]";
	}

}