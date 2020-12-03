package dz.fni.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema = "cabinet", name = "consultation")
public class Consultation implements Serializable {

	private static final long serialVersionUID = -3669998604878710274L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "motif", nullable = false, length = 255)
    private String motif;

    @Column(name = "date_consultation", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateConsultation;

    @ManyToOne()
    @JoinColumn(name = "id_patient", nullable = false)
    private Patient patient;
    
    @JsonIgnore
    @OneToMany(mappedBy = "consultation")
    private List<LigneConsultation> ligneConsultations = new ArrayList<>();

    /////////////////////////////////////
    
    public Consultation() {
		
	}

	public Consultation(int id, String motif, Date dateConsultation, Patient patient) {
		this.id = id;
		this.motif = motif;
		this.dateConsultation = dateConsultation;
		this.patient = patient;
	}
	
	/////////////////////////////////////

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Date getDateConsultation() {
		return dateConsultation;
	}

	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<LigneConsultation> getLigneConsultations() {
		return ligneConsultations;
	}

	public void setLigneConsultations(List<LigneConsultation> ligneConsultations) {
		this.ligneConsultations = ligneConsultations;
	}
    
}
