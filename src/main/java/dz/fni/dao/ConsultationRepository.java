package dz.fni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.fni.model.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {

}
