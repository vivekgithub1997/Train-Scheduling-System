package com.tss.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TrainDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer trainNumber;
	private String trainName;
	private List<String> trainStations;
	public Integer getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(Integer trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public List<String> getTrainStations() {
		return trainStations;
	}
	public void setTrainStations(List<String> trainStations) {
		this.trainStations = trainStations;
	}
	public TrainDetails(Integer trainNumber, String trainName, List<String> trainStations) {
		super();
		this.trainNumber = trainNumber;
		this.trainName = trainName;
		this.trainStations = trainStations;
	}
	public TrainDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TrainDetails [trainNumber=" + trainNumber + ", trainName=" + trainName + ", trainStations="
				+ trainStations + "]";
	}
	
	

}
