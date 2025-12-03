package com.example.vet_availability_mock_service.controller;

import com.example.vet_availability_mock_service.dto.AvailabilityRequest;
import com.example.vet_availability_mock_service.dto.AvailabilityResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvailabilityController {


    @PostMapping("/availability")
    public AvailabilityResponse availabilityResponse
            (@RequestBody AvailabilityRequest availabilityRequest) {
        String hash = availabilityRequest.veterinarianId() + availabilityRequest.date() + availabilityRequest.hour();

        int hashCode = Math.abs(hash.hashCode());
        boolean available = (hashCode % 2 == 0);

        String cause;
        if(available){
            cause=("You can set an apoiment");
        }else {cause = ("You can't set an apoiment");
        }
        return new AvailabilityResponse(availabilityRequest.veterinarianId(), available, cause);
    }
}
