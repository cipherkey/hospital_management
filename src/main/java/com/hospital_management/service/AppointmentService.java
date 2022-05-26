package com.hospital_management.service;




import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.hospital_management.model.Appointment;

public interface AppointmentService {

    Optional<Appointment> findById(Long appointmentId);

    List<Appointment> findAll();


    Appointment create(Appointment appointment);


    Appointment updateStatus(Long appointmentId, Appointment appointment);


}