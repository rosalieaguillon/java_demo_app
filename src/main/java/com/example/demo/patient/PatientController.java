package com.example.demo.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @GetMapping("{patientId}")
    public Patient getPatient(
            @PathVariable("patientId") Long patientId) {
        return patientService.getPatient(patientId);
    }

    @PostMapping
    public void registerNewPatient(@RequestBody Patient patient) {
        patientService.addNewPatient(patient);
    }

    @DeleteMapping("{patientId}")
    public void deletePatient(
            @PathVariable("patientId") Long patientId) {
        patientService.deletePatient(patientId);
    }

    @PutMapping("{patientId}")
    public void updateStudent(
            @PathVariable("patientId") Long patientId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        patientService.updatePatient(patientId, name, email);
    }
}
