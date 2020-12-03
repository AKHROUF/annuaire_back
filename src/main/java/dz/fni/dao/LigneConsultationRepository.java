package dz.fni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.fni.model.LigneConsultation;

@Repository
public interface LigneConsultationRepository extends JpaRepository<LigneConsultation, Integer> {

}
