package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wt.bookstore.backend.domains.Reservation;
import wt.bookstore.backend.repository.IReservationRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class ReservationController {

    @Autowired
    private IReservationRepository reservationRepository;

    @RequestMapping(value = "reservation", method = RequestMethod.GET)
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @RequestMapping(value="reservation/create", method = RequestMethod.POST)
    public void create(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
    }
    
    @RequestMapping(value = "reservation/{id}", method = RequestMethod.GET)
    public Optional<Reservation> find(@PathVariable long id) {
        return reservationRepository.findById(id);
    }

    @RequestMapping(value = "reservation/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable long id, @RequestBody Reservation reservation) {
        Optional<Reservation> optional = reservationRepository.findById(id);
        optional.get().setBookId(reservation.getBookId());
        optional.get().setUserId(reservation.getUserId());
        optional.get().setDate(reservation.getDate());
        reservationRepository.save(optional.get());
    }

    @RequestMapping(value = "reservation/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        reservationRepository.deleteById(id);
    }


}