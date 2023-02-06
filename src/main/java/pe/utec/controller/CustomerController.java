package pe.utec.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.utec.dto.CustomerDTO;
import pe.utec.exception.ModelNotFoundException;
import pe.utec.model.Customer;
import pe.utec.service.ICustomerService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/customers", produces = "application/json")
public class CustomerController {

    @Autowired
    private ICustomerService service;

    @Autowired
    @Qualifier("customerMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> readAll() throws Exception{
        List<CustomerDTO> list = service.readAll().stream().map(cat -> mapper.map(cat, CustomerDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Customer obj = service.readById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        return new ResponseEntity<>(mapper.map(obj, CustomerDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@Valid @RequestBody CustomerDTO dto) throws Exception{
        Customer obj = service.create(mapper.map(dto, Customer.class));
        return new ResponseEntity<>(mapper.map(obj, CustomerDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> update(@Valid @RequestBody CustomerDTO dto) throws Exception{
        Customer obj = service.readById(dto.getIdCustomer());

        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getIdCustomer());
        }
        Customer cat = service.update(mapper.map(dto, Customer.class));
        return new ResponseEntity<>(mapper.map(cat, CustomerDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        Customer obj = service.readById(id);

        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
