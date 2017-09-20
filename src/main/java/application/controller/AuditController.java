package application.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import application.model.Order;
import application.repository.AuditRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/audit")
public class AuditController {

	private static final Logger LOG = LoggerFactory.getLogger(AuditController.class);

	@Autowired
	private AuditRepository auditRepository;

	@RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE}, value = "/auditOrder")
	@ApiOperation(value = "Audit Service", notes = "Audit an order. SLA:500")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Order audited Successfully"),
			@ApiResponse(code = 400, message = "Invalid Input Provided"), @ApiResponse(code = 404, message = "Error") })
	public ResponseEntity<?> auditOrder(Order order) {
		LOG.info("System URL : " + order.getSystemUrl());
		LOG.info("Order Number : " + order.getOrderNumber());
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "Order audited successfully");
		response.put("product", auditRepository.save(order));
		return ResponseEntity.ok(response);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/retrieveOrderAudits")
	@ApiOperation(value = "Audit Service", notes = "Retrieves all orders audit information. SLA:500")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retrieved audit details successfully"),
			@ApiResponse(code = 400, message = "Invalid Input Provided"), @ApiResponse(code = 404, message = "Error") })
	public Map<String, Object> getAllOrderOrditInfo() {
		LOG.info("Application is invoked!");
		List<Order> orders = auditRepository.findAll();
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("totalAudits", orders.size());
		response.put("orders", orders);
		return response;
	}

}
