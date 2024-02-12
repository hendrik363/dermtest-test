package com.hendrik.dermtest;

import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hendrik.dermtest.data.DoctorsDataInterface;
import com.hendrik.dermtest.models.Doctor;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTests {
    @Autowired
    private DoctorsDataInterface repository;

    @Test
    public void testSave() {
        Doctor doctor = new Doctor();

        doctor.setDoctorName("Kaja Tamm");
        doctor.setBirthDate("2002-05-03");
        doctor.setEmail("kaja.tamm@gmail.com");
        doctor.setSpecialization("Hambaarst");
        doctor.setPhoneNumber("50030230");

        Doctor savedDoctor = repository.save(doctor);
        Doctor retrievedDoctor = repository.findById(savedDoctor.getId()).orElse(null);

        assertThat(retrievedDoctor).isNotNull();
        assertThat(retrievedDoctor.getId()).isEqualTo(savedDoctor.getId());
        assertThat(retrievedDoctor.getDoctorName()).isEqualTo("Kaja Tamm");
        assertThat(retrievedDoctor.getSpecialization()).isEqualTo("Hambaarst");
    }

    @Test
    public void testFindAll() {

        Doctor doctor1 = new Doctor();

        doctor1.setDoctorName("Peter Kai");
        doctor1.setBirthDate("1989-02-03");
        doctor1.setEmail("peter.kai@gmail.com");
        doctor1.setSpecialization("Ortopeed");
        doctor1.setPhoneNumber("55230230");

        repository.save(doctor1);

        Doctor doctor2 = new Doctor();

        doctor2.setDoctorName("Andres Puujalg");
        doctor2.setBirthDate("1999-06-04");
        doctor2.setEmail("andres.puujalg@gmail.com");
        doctor2.setSpecialization("Hambaarst");
        doctor2.setPhoneNumber("59030530");

        repository.save(doctor2);

        List<Doctor> allDoctors = repository.findAll();

        assertThat(allDoctors).isNotNull();
        assertThat(allDoctors).hasSize(2);
        assertThat(allDoctors).contains(doctor1, doctor2);

    }

    @Test
    public void testFindById() {
        Doctor doctor = new Doctor();

        doctor.setDoctorName("Ulrik Kask");
        doctor.setBirthDate("1995-07-05");
        doctor.setEmail("ulrik.kask@gmail.com");
        doctor.setSpecialization("Günekoloog");
        doctor.setPhoneNumber("502637230");

        repository.save(doctor);
        Optional<Doctor> foundDoctor = repository.findById(doctor.getId());

        assertThat(foundDoctor).isNotNull();
        assertThat(foundDoctor.get()).isEqualTo(doctor);
    }

    @Test
    public void testDeleteById() {
        Doctor doctor = new Doctor();

        doctor.setDoctorName("Urmas Toompea");
        doctor.setBirthDate("1992-08-05");
        doctor.setEmail("urmas.toompea@gmail.com");
        doctor.setSpecialization("Üldarst");
        doctor.setPhoneNumber("50637830");

        repository.save(doctor);

        // Test the deleteById method
        repository.deleteById(doctor.getId());

        // Verify that the doctor has been deleted from the database
        Optional<Doctor> foundDoctor = repository.findById(doctor.getId());
        assertThat(foundDoctor).isEmpty();
    }
}
