package com.food.ordering.system.order.application.rest;

import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.service.domain.dto.track.TrackerOrderQuery;
import com.food.ordering.system.order.service.domain.dto.track.TrackerOrderResponse;
import com.food.ordering.system.order.service.domain.ports.input.service.OrderApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/orders", produces = "application/vnd.api.v1+json")
public class OrderController {

    private final OrderApplicationService service;

    public OrderController(OrderApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderCommand command) {
        log.info("Create order for customer: {} at restaurant: {}", command.getCustomerId(), command.getRestaurantId());
        CreateOrderResponse createOrderResponse = service.createOrder(command);
        log.info("Order created with tracking id: {}", createOrderResponse.getOrderTrackingId());
        return ResponseEntity.ok(createOrderResponse);
    }

    @GetMapping("/{trackingId}")
    public ResponseEntity<TrackerOrderResponse> getOrderByTrackingId(@PathVariable UUID trackingId) {
        TrackerOrderResponse response = service.trackOrder(TrackerOrderQuery.builder().orderTrackingId(trackingId).build());
        log.info("Returning order status with tracking id: {}", response.getOrderTrackingId());
        return ResponseEntity.ok(response);
    }

}
