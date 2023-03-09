package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wt.bookstore.backend.domains.Copy;
import wt.bookstore.backend.dto.CopyDto;
import wt.bookstore.backend.dto.SaveCopyDto;
import wt.bookstore.backend.mapping.CopyDtoMapper;
import wt.bookstore.backend.repository.IBookRepository;
import wt.bookstore.backend.repository.ICopyRepository;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * The controller class that sets the API endpoints for the CRUD operations of the database that handles the copies.
 */
@RestController
@CrossOrigin(maxAge = 3600)
public class CopyController {

    @Autowired
    private ICopyRepository copyRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private CopyDtoMapper copyMapper;


    /*
     * GET endpoints starting from here
     */
     
    /**
     * Returns a Stream of {@link wt.bookstore.backend.dto.CopyDto} for a GET request to {database_location}/copy.
     * @return Stream of {@link wt.bookstore.backend.dto.CopyDto}'s
     */
    @RequestMapping(value = "copy", method = RequestMethod.GET)
    public Stream<CopyDto> findAll() {
        return copyRepository.findAll().stream().map(copyMapper::copyToDto);
    }

    /**
     * Returns a single {@link wt.bookstore.backend.dto.CopyDto} with a certain id for a GET request to {database_location}/copy/{id}.
     * @param id (long) of the copy you want to get.
     * @return Single {@link wt.bookstore.backend.dto.CopyDto}
     */
    @RequestMapping(value = "copy/{id}", method = RequestMethod.GET)
    public Optional<CopyDto> find(@PathVariable long id) {
        return Optional.of(copyMapper.copyToDto(copyRepository.findById(id).get()));
    }


    /*
     * POST endpoints starting from here
     */
     
    /**
     * Creates a {@link wt.bookstore.backend.domains.Copy} object from a {@link wt.bookstore.backend.dto.SaveCopyDto} and saves it to the database for a POST request to {database_location}/copy/create. The id is autogenerated.
     * @param saveCopyDto ({@link wt.bookstore.backend.dto.SaveCopyDto}) is generated from the json body in the POST request and contains the information needed to create a {@link wt.bookstore.backend.domains.Copy} object.
     */
    @RequestMapping(value="copy/create", method = RequestMethod.POST)
    public boolean create(@RequestBody SaveCopyDto saveCopyDto) {
        Copy copy = copyMapper.dtoToCopy(saveCopyDto);
        if (copy != null) {
            copyRepository.save(copy);
            return true;
        } else {
            return false;
        }
    }
    

    /*
     * PUT endpoints from here
     */
    @RequestMapping(value="copy/{id}/available", method = RequestMethod.PUT)
    public void updateAvailable(@PathVariable long id, @RequestBody boolean available){
        Optional<Copy> optionalCopy = copyRepository.findById(id);
        optionalCopy.get().setAvailable(available);

        copyRepository.save(optionalCopy.get());
    }

//    @RequestMapping(value = "copy/{id}", method = RequestMethod.PUT)
//    public void update(@PathVariable long id, @RequestBody Copy copy) {
//        Optional<Copy> optional = copyRepository.findById(id);
//        optional.get().setAvailable(copy.isAvailable());
////        optional.get().setHeldByUserId(copy.getHeldByUserId());
////        optional.get().setBookId(copy.getBookId());
//        copyRepository.save(optional.get());
//    }

    @RequestMapping(value = "copy/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        copyRepository.deleteById(id);
    }


}