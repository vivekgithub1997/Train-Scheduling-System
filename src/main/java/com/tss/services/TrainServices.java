package com.tss.services;

import java.util.List;

import com.tss.entity.TrainDetails;

public interface TrainServices {
	
	TrainDetails saveTrain(TrainDetails trainDetails);
	TrainDetails updateTrain(TrainDetails trainDetails , Integer trainNumber);
	Boolean deleteTrain(Integer TrainNumber);
	List<TrainDetails> getAllTrains();
	TrainDetails getTrainByTrainNumber(Integer trainNumber);
	List<TrainDetails> getTrainAllStations(String source,String destination);

}
