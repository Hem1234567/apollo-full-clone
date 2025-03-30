package com.example.SpringApi.Service;




import com.example.SpringApi.Model.Doctor;
import com.example.SpringApi.Repository.DoctorRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo repo;

    public List<Doctor> getDoctor() {
        return repo.findAll();
    }

    public Doctor getDoctorById(int doctorId) {
        return repo.findById(doctorId).orElse(new Doctor());
    }

    @Transactional
    public void addDoctor(Doctor doctor) {
        repo.save(doctor);
    }

    @Transactional
    public void updateDoctor(Doctor doctor) {
        repo.save(doctor);
    }

    @Transactional
    public void deleteDoctorById(int doctorId) {
        if (repo.existsById(doctorId)) {
            repo.deleteById(doctorId);
        } else {
            throw new RuntimeException("Doctor with ID " + doctorId + " not found.");
        }
    }
}
