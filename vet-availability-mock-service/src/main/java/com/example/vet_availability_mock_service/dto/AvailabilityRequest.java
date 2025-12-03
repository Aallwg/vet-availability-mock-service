package com.example.vet_availability_mock_service.dto;



public record AvailabilityRequest(
        Long veterinarianId,
        String date,
        String hour
) {}



