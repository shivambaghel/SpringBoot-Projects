package com.course.kafka.api.server;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.kafka.api.request.DummyRequest;

@RestController
@RequestMapping("/api")
public class DummyApi {

	@PostMapping(value = "/test")
	public String test(@RequestBody DummyRequest request) {
		return request.toString();
	}

}
