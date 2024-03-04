package com.tss.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tss.entity.TrainDetails;
import com.tss.repo.TrainRepo;

@Service
public class TrainServicesImpl implements TrainServices {

	@Autowired
	private TrainRepo trainRepo;

	@Override
	public TrainDetails saveTrain(TrainDetails trainDetails) {
		// TODO Auto-generated method stub
		TrainDetails save = trainRepo.save(trainDetails);
		if (save != null) {

			return save;
		}
		return null;
	}

	@Override
	public TrainDetails updateTrain(TrainDetails trainDetails, Integer trainNumber) {
		// TODO Auto-generated method stub
		TrainDetails trainDetail = null;
		Optional<TrainDetails> getTrainById = trainRepo.findById(trainNumber);
		if (getTrainById.isPresent()) {
			TrainDetails getTrainDetails = getTrainById.get();

			getTrainDetails.setTrainName(trainDetails.getTrainName());
			getTrainDetails.setTrainStations(trainDetails.getTrainStations());
			trainDetail = trainRepo.save(getTrainDetails);

		}
		return trainDetail;
	}

	@Override
	public Boolean deleteTrain(Integer TrainNumber) {
		// TODO Auto-generated method stub
		boolean status = false;
		trainRepo.deleteById(TrainNumber);
		status = true;
		return status;
	}

	@Override
	public List<TrainDetails> getAllTrains() {
		// TODO Auto-generated method stub
		List<TrainDetails> getAllTrains = trainRepo.findAll();
		return getAllTrains;
	}

	@Override
	public TrainDetails getTrainByTrainNumber(Integer trainNumber) {
		// TODO Auto-generated method stub
		Optional<TrainDetails> trainById = trainRepo.findById(trainNumber);
		if (trainById.isPresent()) {
			TrainDetails trainDetails = trainById.get();
			return trainDetails;
		}

		return null;
	}

	@Override
	public List<TrainDetails> getTrainAllStations(String source, String destination) {
		// TODO Auto-generated method stub
		List<TrainDetails> allTrains = trainRepo.findAll();

		List<TrainDetails> trainsFromSourceToDestination = allTrains.stream().filter(
				train -> train.getTrainStations().contains(source) && train.getTrainStations().contains(destination))
				.filter(train -> {
					List<String> stations = train.getTrainStations();
					int sourceIndex = stations.indexOf(source);
					int destinationIndex = stations.indexOf(destination);
					return sourceIndex != -1 && destinationIndex != -1 && sourceIndex < destinationIndex;
				}).collect(Collectors.toList());

		List<TrainDetails> trainsFromDestinationToSource = allTrains.stream()
				.filter(train -> train.getTrainStations().contains(source.toLowerCase())
						&& train.getTrainStations().contains(destination))
				.filter(train -> {
					List<String> stations = train.getTrainStations();
					int sourceIndex = stations.indexOf(source);
					int destinationIndex = stations.indexOf(destination);
					return sourceIndex != -1 && destinationIndex != -1 && sourceIndex > destinationIndex;
				}).collect(Collectors.toList());

		List<TrainDetails> trainsBetweenStations = new ArrayList<>();
		trainsBetweenStations.addAll(trainsFromSourceToDestination);
		trainsBetweenStations.addAll(trainsFromDestinationToSource);

		return trainsBetweenStations;
	}

}
