package me.elaamiri.immatriculationmanagmentservice.query.controlles;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.elaamiri.immatriculationmanagmentservice.query.entities.Vehicle;
import me.elaamiri.queries.vehicleQueries.GetAllVehiclesQuery;
import me.elaamiri.queries.vehicleQueries.GetVehicleByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/query/vehicles")
public class VehicleQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("")
    public List<Vehicle> getAllVehicles(){
        List<Vehicle> vehicles = queryGateway.query(new GetAllVehiclesQuery(), ResponseTypes.multipleInstancesOf(Vehicle.class)).join();
        return  vehicles;
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable String id){
        Vehicle vehicle = queryGateway.query(new GetVehicleByIdQuery(id), ResponseTypes.instanceOf(Vehicle.class)).join();
        return  vehicle;
    }

    //@ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
        );

        return responseEntity;
    }
}
