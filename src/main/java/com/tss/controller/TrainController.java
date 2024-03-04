package com.tss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tss.entity.TrainDetails;
import com.tss.services.TrainServices;

@RestController
@RequestMapping("/train")

public class TrainController {

	@Autowired
	private TrainServices trainServices;

	@PostMapping("/savetrain")
	public TrainDetails addNewTrain(@RequestBody TrainDetails trainDetails) {

		TrainDetails saveTrain = trainServices.saveTrain(trainDetails);
		return saveTrain;
	}

	@PutMapping("/{trainNumber}")
	public TrainDetails updateTrain(@RequestBody TrainDetails trainDetails, @PathVariable Integer trainNumber) {

		TrainDetails updateTrain = trainServices.updateTrain(trainDetails, trainNumber);
		return updateTrain;
	}

	@GetMapping("/{trainSource}/{trainDestination}")
	public List<TrainDetails> findTrainBySourceAndDestination(@PathVariable String trainSource,
			@PathVariable String trainDestination) {
		List<TrainDetails> trainSourceAndDestination = trainServices.getTrainAllStations(trainSource, trainDestination);
		return trainSourceAndDestination;
	}

	@GetMapping("/alltrains")
	public List<TrainDetails> getAllTrains() {
		List<TrainDetails> allTrains = trainServices.getAllTrains();
		return allTrains;
	}

	@GetMapping("/{trainNumber}")
	public TrainDetails getTrainByTrainNumber(@PathVariable Integer trainNumber) {

		TrainDetails trainByTrainNumber = trainServices.getTrainByTrainNumber(trainNumber);
		return trainByTrainNumber;

	}

	@DeleteMapping("/remove/{trainNumber}")
	public String removeTrain(@PathVariable Integer trainNumber) {
		Boolean deleteTrain = trainServices.deleteTrain(trainNumber);
		if (deleteTrain) {

			return "Train Deleted..!!";

		}

		return "Train Not Deleted Something Went Wrong....!!";
	}
}
