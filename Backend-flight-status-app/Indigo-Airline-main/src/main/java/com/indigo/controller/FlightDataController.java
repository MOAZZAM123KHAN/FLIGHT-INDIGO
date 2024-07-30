package com.indigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indigo.entity.FlightData;
import com.indigo.response.Response;
import com.indigo.service.FlightDataService;

@RestController
@RequestMapping("/api/flights")
public class FlightDataController {

	@Autowired
    private FlightDataService flightDataService;

	@PostMapping("/add")
	public ResponseEntity<Response> addFlightData(@RequestBody List<FlightData> flightDataList) {
	    try {
	        flightDataService.saveFlightData(flightDataList);
	        Response response = new Response(null, false, "Flight data added successfully");
	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        Response response = new Response(null, true, "Failed to add flight data");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	@GetMapping("/all")
	public ResponseEntity<Response> getAllFlightData() {
	    try {
	        List<FlightData> flightDataList = flightDataService.getAllFlightData();
	        Response response = new Response(flightDataList, false, "Flight data retrieved successfully");
	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	    	Response response = new Response(null, true, "Failed to retrieve flight data");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

//    @PostMapping("/notify/{flightId}")
//    public void notifyPassengers(@PathVariable String flightId) {
//        flightDataService.notifyPassengers(flightId);
//    }
}
