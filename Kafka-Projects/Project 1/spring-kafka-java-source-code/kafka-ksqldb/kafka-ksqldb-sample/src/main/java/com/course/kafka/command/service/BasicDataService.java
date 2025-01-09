package com.course.kafka.command.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.kafka.api.request.BasicDataCountryRequest;
import com.course.kafka.api.request.BasicDataFiveRequest;
import com.course.kafka.api.request.BasicDataFourRequest;
import com.course.kafka.api.request.BasicDataOneRequest;
import com.course.kafka.api.request.BasicDataPersonRequest;
import com.course.kafka.api.request.BasicDataThreeRequest;
import com.course.kafka.api.request.BasicDataTwoRequest;
import com.course.kafka.command.action.BasicDataAction;

@Service
public class BasicDataService {

	@Autowired
	private BasicDataAction action;

	public void createBasicDataCountry(BasicDataCountryRequest request) {
		var message = action.toKafkaMessage(request);
		action.publishBasicDataCountry(message);
	}

	public void createBasicDataFive(BasicDataFiveRequest request) {
		var message = action.toKafkaMessage(request);
		action.publishBasicDataFive(message);
	}

	public void createBasicDataFour(BasicDataFourRequest request) {
		var message = action.toKafkaMessage(request);
		action.publishBasicDataFour(message);
	}

	public void createBasicDataOne(BasicDataOneRequest request) {
		var message = action.toKafkaMessage(request);
		action.publishBasicDataOne(message);
	}

	public void createBasicDataPerson(BasicDataPersonRequest request) {
		var message = action.toKafkaMessage(request);
		action.publishBasicDataPerson(message);
	}

	public void createBasicDataThree(BasicDataThreeRequest request) {
		var message = action.toKafkaMessage(request);
		action.publishBasicDataThree(message);
	}

	public void createBasicDataTwo(BasicDataTwoRequest request) {
		var message = action.toKafkaMessage(request);
		action.publishBasicDataTwo(message);
	}

	public void deleteBasicDataCountry(String countryName) {
		action.deleteBasicDataCountry(countryName);
	}

}
