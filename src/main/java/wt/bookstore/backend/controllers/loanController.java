package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wt.bookstore.backend.domains.Loan;
import wt.bookstore.backend.repository.ILoanRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class loanController {

    @Autowired
    private ILoanRepository loanRepository;

    @RequestMapping(value = "loan", method = RequestMethod.GET)
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    @RequestMapping(value="loan/create", method = RequestMethod.POST)
    public void create(@RequestBody Loan loan) {
        loanRepository.save(loan);
    }
    
    @RequestMapping(value = "loan/{id}", method = RequestMethod.GET)
    public Optional<Loan> find(@PathVariable long id) {
        return loanRepository.findById(id);
    }

    @RequestMapping(value = "loan/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable long id, @RequestBody Loan loan) {
        Optional<Loan> optional = loanRepository.findById(id);
        optional.get().setCopyId(loan.getCopyId());
        optional.get().setEndDate(loan.getEndDate());
        optional.get().setReservationId(loan.getReservationId());
        optional.get().setStartDate(loan.getStartDate());
        optional.get().setUserId(loan.getUserId());
        loanRepository.save(optional.get());
    }

    @RequestMapping(value = "loan/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        loanRepository.deleteById(id);
    }


}