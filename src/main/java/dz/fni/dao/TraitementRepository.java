package dz.fni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.fni.model.Traitement;

@Repository
public interface TraitementRepository extends JpaRepository<Traitement, Integer> {

}
