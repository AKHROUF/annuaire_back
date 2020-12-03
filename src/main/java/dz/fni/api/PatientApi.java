package dz.fni.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dz.fni.dao.PatientRepository;
import dz.fni.model.Patient;

@RestController
public class PatientApi {

	@Autowired
	private PatientRepository patientRepository;

	@GetMapping(value = "/api/patients")
	public ResponseEntity<Object> listePatients() {
		return new ResponseEntity<>(patientRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = "/api/patients")
	public ResponseEntity<Object> creerPatient(@RequestBody Patient patient) {
		try {
			patientRepository.save(patient);
			return new ResponseEntity<>("Patient ajoute avec succès", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Erreur d'insertion", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/api/patients/{id}")
	public ResponseEntity<Object> recupererPatient(@PathVariable("id") String id) {
		Patient p = patientRepository.findById(Integer.parseInt(id)).orElse(null);
		if (p == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@PutMapping(value = "/api/patients/{id}")
	public ResponseEntity<Object> modifierPatient(@PathVariable("id") String id, @RequestBody Patient patient) {
		patientRepository.save(patient);
		return new ResponseEntity<>("Patient modifié avec succès", HttpStatus.OK);
	}

	@DeleteMapping(value = "/api/patients/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		patientRepository.delete(patientRepository.getOne(Integer.parseInt(id)));
		return new ResponseEntity<>("Patient supprimé avec succès", HttpStatus.OK);
	}

}
