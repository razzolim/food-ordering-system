package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.order.service.domain.dto.track.TrackerOrderQuery;
import com.food.ordering.system.order.service.domain.dto.track.TrackerOrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderTrackCommandHandler {

    public TrackerOrderResponse trackOrder(TrackerOrderQuery trackerOrderQuery) {
        return null;
    }
}
