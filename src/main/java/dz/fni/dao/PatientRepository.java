package dz.fni.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dz.fni.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	List<Patient> findByNom(String nom);
	
//	@Query(value="select p from Patient where p.username = :nom and p.prenom = :prenom")
//	List<Patient> recherche(String nom, String prenom);
}
