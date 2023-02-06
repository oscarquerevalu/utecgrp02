package pe.utec.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.utec.dto.ShowDTO;
import pe.utec.exception.ModelNotFoundException;
import pe.utec.model.Customer;
import pe.utec.model.Show;
import pe.utec.service.ICustomerService;
import pe.utec.service.IShowService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/shows", produces = "application/json")
public class ShowController {

    @Autowired
    private IShowService service;

    @Autowired
    @Qualifier("showMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ShowDTO>> readAll() throws Exception{
        List<ShowDTO> list = service.readAll().stream().map(cat -> mapper.map(cat, ShowDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Show obj = service.readById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        return new ResponseEntity<>(mapper.map(obj, ShowDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShowDTO> create(@Valid @RequestBody ShowDTO dto) throws Exception{
        Show obj = service.create(mapper.map(dto, Show.class));
        return new ResponseEntity<>(mapper.map(obj, ShowDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ShowDTO> update(@Valid @RequestBody ShowDTO dto) throws Exception{
        Show obj = service.readById(dto.getIdShow());

        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getIdShow());
        }
        Show cat = service.update(mapper.map(dto, Show.class));
        return new ResponseEntity<>(mapper.map(cat, ShowDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        Show obj = service.readById(id);

        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
