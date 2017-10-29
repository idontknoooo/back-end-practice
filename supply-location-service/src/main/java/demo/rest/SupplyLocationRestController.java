package demo.rest;

import demo.domain.SupplyLocation;
import demo.domain.SupplyLocationRepository;
import demo.service.SupplyLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplyLocationRestController {

    @Autowired
    private SupplyLocationRepository repository;

//    @Autowired
//    private SupplyLocationRestController service;

    @Autowired
    private SupplyLocationService service;

    @RequestMapping(value = "/supplyLocations", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<SupplyLocation> locations){
        repository.save(locations);
    }
}
