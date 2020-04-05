package com.app.odapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OdApiTaskController.class);

	@GetMapping(produces = "application/json")
	public ResponseEntity<OdApiResponse> odApiTask() throws Exception {
		OdApiResponse odApiResponse = new OdApiResponse();
		LOGGER.info("Calling odApiTask");
		try {
			odApiResponse = odApiTaskService.getAllOdApiData();
			return new ResponseEntity<>(odApiResponse,HttpStatus.OK);
		}
		catch(Exception e)
		{
			LOGGER.error("Exception occured while creating a Request Call: {}", e.getMessage(), e);
			return new ResponseEntity<>(odApiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}

}
