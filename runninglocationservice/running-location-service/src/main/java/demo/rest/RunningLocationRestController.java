package demo.rest;

import demo.domain.Location;
import demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST API: Request Mapping
@RestController
public class RunningLocationRestController {

    private LocationService locationService;

    @Autowired
    public RunningLocationRestController(LocationService locationService){
        this.locationService = locationService;
    }

    @RequestMapping(value = "/running", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED) // CREATED: 201, OK: 201
    public void upload(@RequestBody List<Location> runningLocations){
        this.locationService.saveRunningLocations(runningLocations);
    }

    // TODO
    @RequestMapping(value = "/purged", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void purge(){
        this.locationService.deleteAll();
    }

    @RequestMapping(value = "/running/{movementType}", method = RequestMethod.GET)
    public Page<Location> findByMovementType(@PathVariable String movementType, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return this.locationService.findByRunnerMovementType(movementType, new PageRequest(page, size));
    }
}
