package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wt.bookstore.backend.domains.Book;
import wt.bookstore.backend.domains.Copy;
import wt.bookstore.backend.dto.ChangeCopyDto;
import wt.bookstore.backend.dto.CopyDto;
import wt.bookstore.backend.dto.SaveCopyDto;
import wt.bookstore.backend.mapping.CopyDtoMapper;
import wt.bookstore.backend.repository.IBookRepository;
import wt.bookstore.backend.repository.ICopyRepository;

import java.util.List;
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
    @GetMapping("copy")
    public Stream<CopyDto> findAll() {
        return copyRepository.findAll().stream().map(copyMapper::copyToDto);
    }

    /**
     * Returns a single {@link wt.bookstore.backend.dto.CopyDto} with a certain id for a GET request to {database_location}/copy/{id}.
     * @param id (long) of the copy you want to get.
     * @return Single {@link wt.bookstore.backend.dto.CopyDto}
     */
    @GetMapping("copy/{id}")
    public Optional<CopyDto> find(@PathVariable long id) {
        return Optional.of(copyMapper.copyToDto(copyRepository.findById(id).get()));
    }

    @GetMapping("book/copies/available/{id}")
    public Stream<CopyDto> findAvailableByBook(@PathVariable long id){
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isEmpty()){
            // TODO: implement some other error message here
            return null;
        }

        return copyRepository.findByAvailableTrueAndBookAndArchivedFalse(optionalBook.get()).stream().map(copyMapper::copyToDto);
    }


    /*
     * POST endpoints starting from here
     */
     
    /**
     * Creates a {@link wt.bookstore.backend.domains.Copy} object from a {@link wt.bookstore.backend.dto.SaveCopyDto} and saves it to the database for a POST request to {database_location}/copy/create. The id is autogenerated.
     * @param saveCopyDto ({@link wt.bookstore.backend.dto.SaveCopyDto}) is generated from the json body in the POST request and contains the information needed to create a {@link wt.bookstore.backend.domains.Copy} object.
     */
    @PostMapping("copy/create")
    public boolean create(@RequestBody SaveCopyDto saveCopyDto) {
        List<Copy> copyList = copyMapper.dtoToCopy(saveCopyDto);
        if (!copyList.isEmpty()) {
            for (Copy copy : copyList){
                copyRepository.save(copy);
            }
            return true;
        } else {
            return false;
        }
    }
    

    /*
     * PUT endpoints from here
     */

    @PutMapping("copy/archive/{id}")
    public void archive(@PathVariable long id){

        Optional<Copy> optionalCopy = copyRepository.findById(id);
        optionalCopy.get().setArchived(!optionalCopy.get().getArchived());

        copyRepository.save(optionalCopy.get());
    }

    @PutMapping("copy/{id}")
    public void update(@PathVariable long id, @RequestBody ChangeCopyDto changeCopyDto){

        Optional<Copy> optionalCopy = copyRepository.findById(id);
        optionalCopy.get().setAvailable(changeCopyDto.isAvailable());
        optionalCopy.get().setNumber(changeCopyDto.getNumber());
        optionalCopy.get().setArchived(changeCopyDto.getArchived());

        copyRepository.save(optionalCopy.get());
    }




}