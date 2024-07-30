package com.indigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indigo.entity.FlightData;

@Repository
public interface FlightRepository extends JpaRepository<FlightData, String>  {

}
