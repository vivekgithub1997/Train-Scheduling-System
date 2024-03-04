package com.tss.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tss.entity.TrainDetails;

@Repository
public interface TrainRepo extends JpaRepository<TrainDetails, Integer>{

}
