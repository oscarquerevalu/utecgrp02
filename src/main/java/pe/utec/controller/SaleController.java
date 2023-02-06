package pe.utec.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.utec.dto.SaleDTO;
import pe.utec.exception.ModelNotFoundException;
import pe.utec.model.Sale;
import pe.utec.model.Show;
import pe.utec.service.ISaleDetailsService;
import pe.utec.service.ISaleService;
import pe.utec.service.IShowService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/sales", produces = "application/json")
public class SaleController {

    @Autowired
    private ISaleService service;

    @Autowired
    private ISaleDetailsService serviceDetail;

    @Autowired
    @Qualifier("showMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<SaleDTO>> readAll() throws Exception{
        List<Sale> listSale = service.readAll();
        for (Sale sale: listSale) {
            sale.setDetails(serviceDetail.findSaleId(sale.getId()));
        }
        List<SaleDTO> list = service.readAll().stream().map(cat -> mapper.map(cat, SaleDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Sale obj = service.readById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        return new ResponseEntity<>(mapper.map(obj, SaleDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SaleDTO> create(@Valid @RequestBody SaleDTO dto) throws Exception{
        Sale obj = service.create(mapper.map(dto, Sale.class));
        return new ResponseEntity<>(mapper.map(obj, SaleDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<SaleDTO> update(@Valid @RequestBody SaleDTO dto) throws Exception{
        Sale obj = service.readById(dto.getIdSale());

        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getIdSale());
        }
        Sale cat = service.update(mapper.map(dto, Sale.class));
        return new ResponseEntity<>(mapper.map(cat, SaleDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        Sale obj = service.readById(id);

        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
