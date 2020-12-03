package dz.fni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.fni.model.RendezVous;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Integer> {

}
