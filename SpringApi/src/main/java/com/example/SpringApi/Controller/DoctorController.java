package com.example.SpringApi.Controller;



import java.util.List;


import com.example.SpringApi.Model.Doctor;
import com.example.SpringApi.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/medical-care")
public class DoctorController {

    @Autowired
    private DoctorService doc;

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getDoctors() {
        List<Doctor> doctors = doc.getDoctor();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/doctors/{doctorId}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable int doctorId) {
        Doctor doctor = doc.getDoctorById(doctorId);
        return doctor != null
                ? new ResponseEntity<>(doctor, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/doctors/add")
    public void addDoctor(@RequestBody Doctor doctor) {
        doc.addDoctor(doctor);
    }

    @PutMapping("/doctors/update")
    public void updateDoctor(@RequestBody Doctor doctor) {
        doc.updateDoctor(doctor);

    }

    @DeleteMapping("/doctors/delete/{doctorId}")
    public ResponseEntity<Void> deleteDoctorById(@PathVariable int doctorId) {
        doc.deleteDoctorById(doctorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
