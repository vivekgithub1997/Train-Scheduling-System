package com.tss.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.tss.entity.TrainDetails;
import com.tss.services.TrainServicesImpl;

@WebMvcTest
public class TrainControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TrainServicesImpl trainServices;

	@Test
	public void givenListOfTrain_whenGetAllTrain_thenReturnTrainList() throws Exception {

		List<TrainDetails> trainDetails = new ArrayList<>();
		trainDetails.add(new TrainDetails(1, "taj", Arrays.asList("chitrakoot", "delhi")));
		trainDetails.add(new TrainDetails(2, "vande bharat", Arrays.asList("chitrakoot", "agra", "delhi")));

		when(trainServices.getAllTrains()).thenReturn(trainDetails);

		ResultActions response = mockMvc.perform(get("/train/alltrains"));

		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(trainDetails.size())));

	}

	
}
