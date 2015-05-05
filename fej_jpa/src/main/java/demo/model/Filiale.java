package demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the filiale database table.
 * 
 */
@Entity
@Table(name="filiale")
@NamedQuery(name="Filiale.findAll", query="SELECT f FROM Filiale f")
public class Filiale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idFiliale;

	@Temporal(TemporalType.DATE)
	private Date eroeffnung;

	private String name;

	//bi-directional many-to-one association to Mitarbeiter
	@ManyToOne
	@JoinColumn(name="filialeleiter")
	private Mitarbeiter mitarbeiter;

	//bi-directional many-to-many association to Mitarbeiter
	@ManyToMany(mappedBy="filiales2", fetch=FetchType.EAGER)
	private List<Mitarbeiter> mitarbeiters;

	public Filiale() {
	}

	public int getIdFiliale() {
		return this.idFiliale;
	}

	public void setIdFiliale(int idFiliale) {
		this.idFiliale = idFiliale;
	}

	public Date getEroeffnung() {
		return this.eroeffnung;
	}

	public void setEroeffnung(Date eroeffnung) {
		this.eroeffnung = eroeffnung;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Mitarbeiter getMitarbeiter() {
		return this.mitarbeiter;
	}

	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	public List<Mitarbeiter> getMitarbeiters() {
		return this.mitarbeiters;
	}

	public void setMitarbeiters(List<Mitarbeiter> mitarbeiters) {
		this.mitarbeiters = mitarbeiters;
	}

}