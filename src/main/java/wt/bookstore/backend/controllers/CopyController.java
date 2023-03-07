package wt.bookstore.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wt.bookstore.backend.domains.Copy;
import wt.bookstore.backend.dto.CopyDto;
import wt.bookstore.backend.dto.SaveCopyDto;
import wt.bookstore.backend.mapping.DtoMapper;
import wt.bookstore.backend.repository.IBookRepository;
import wt.bookstore.backend.repository.ICopyRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@CrossOrigin(maxAge = 3600)
public class CopyController {

    @Autowired
    private ICopyRepository copyRepository;

    @Autowired
    private IBookRepository bookRepository;

    @RequestMapping(value = "copy", method = RequestMethod.GET)
    public Stream<CopyDto> findAll() {
        return copyRepository.findAll().stream().map(DtoMapper::copyToDto);
    }

    @RequestMapping(value = "copy/{id}", method = RequestMethod.GET)
    public Optional<CopyDto> find(@PathVariable long id) {
        return Optional.of(DtoMapper.copyToDto(copyRepository.findById(id).get()));
    }

    @RequestMapping(value="copy/create", method = RequestMethod.POST)
    public boolean create(@RequestBody SaveCopyDto saveCopyDto) {
        Copy copy = DtoMapper.dtoToCopy(saveCopyDto, bookRepository);
        if (copy != null) {
            copyRepository.save(copy);
            return true;
        } else {
            return false;
        }
    }
    


    @RequestMapping(value = "copy/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable long id, @RequestBody Copy copy) {
        Optional<Copy> optional = copyRepository.findById(id);
        optional.get().setAvailable(copy.isAvailable());
//        optional.get().setHeldByUserId(copy.getHeldByUserId());
//        optional.get().setBookId(copy.getBookId());
        copyRepository.save(optional.get());
    }

    @RequestMapping(value = "copy/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        copyRepository.deleteById(id);
    }


}