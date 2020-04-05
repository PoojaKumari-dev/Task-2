package com.app.odapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.odapi.model.OdApiResponse;
import com.app.odapi.service.OdApiTaskService;

@Controller
@RequestMapping("odapiall")
public class OdApiTaskController {

	@Autowired
	OdApiTaskService odApiTaskService;

	@GetMapping(produces = "application/json")
	public ResponseEntity<OdApiResponse> odApiTask() throws Exception {
		
		OdApiResponse odApiResponse = new OdApiResponse();
		odApiResponse = odApiTaskService.getAllOdApiData();
		return new ResponseEntity<>(odApiResponse,HttpStatus.OK);
	}

}
