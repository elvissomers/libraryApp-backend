package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wt.bookstore.backend.domains.Reservation;
import wt.bookstore.backend.repository.IReservationRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class reservationController {

    @Autowired
    private IReservationRepository repository;

    @RequestMapping(value = "reservation", method = RequestMethod.GET)
    public List<Reservation> findAll() {
        return repository.findAll();
    }

    @RequestMapping(value="reservation/create", method = RequestMethod.POST)
    public void create(@RequestBody Reservation reservation) {
        repository.save(reservation);
    }

    @RequestMapping(value = "reservation/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable long id, @RequestBody Reservation reservation) {
        Optional<Reservation> optional = repository.findById(id);
        optional.get().setBookid(reservation.getBookid());
        optional.get().setUserid(reservation.getUserid());
        optional.get().setDate(reservation.getDate());
        repository.save(optional.get());
    }

    @RequestMapping(value = "reservation/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }


}