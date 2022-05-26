package com.hospital_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.hospital_management.model.Appointment;
import com.hospital_management.model.Patient;
import com.hospital_management.repository.AppointmentRepository;
import com.hospital_management.service.AppointmentService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentRestController {

    @Autowired
    private AppointmentService appointmentService;
    
    @Autowired
    private AppointmentRepository appoinmentRepo;

    public AppointmentRestController() {
    }

    public AppointmentRestController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // GET request to return specific appointments
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.GET)
    public Optional<Appointment> findById(@PathVariable Long appointmentId) {
        return appointmentService.findById(appointmentId);
    }

    // GET request to return all appointments ( GET - http://localhost:8080/api/v1/appointments/)
    @RequestMapping(path = "/", method = RequestMethod.GET)
    List<Appointment> findAll() {
        return appointmentService.findAll();
    }


    // POST request to add new appointments ( POST - http://localhost:8080/api/v1/appointments/addAppointment)
    @PostMapping("/addAppointment")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment create(@RequestBody Appointment appointment) {
        return appointmentService.create(appointment);
    }

   // To search appoinment by date by ascending order ( GET - http://localhost:8080/api/v1/appointments/addAppointment)
    @GetMapping("/apByDate")
	public List<Appointment> getAll (@RequestParam String field) {
		return appoinmentRepo.findAll(Sort.by(Direction.ASC, field));
	}


}
