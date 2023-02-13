package com.pks.orderservice.service;

import com.pks.orderservice.dto.OrderLineItemsDto;
import com.pks.orderservice.dto.OrderRequest;
import com.pks.orderservice.entity.Order;
import com.pks.orderservice.entity.OrderLineItems;
import com.pks.orderservice.repository.OrderRepository;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
  private final OrderRepository orderRepository;

  public void placeOrder(OrderRequest orderRequest){
    Order order = new Order();
    order.setOrderNumber(UUID.randomUUID().toString());

    List<OrderLineItems> orderLineItemsList;
    orderLineItemsList = (List<OrderLineItems>) orderRequest.getOrderLineItemsDtoList()
        .stream()
        .map(this::mapToDto);
    order.setOrderLineItemsList(orderLineItemsList);
    orderRepository.save(order);
  }


  private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
    OrderLineItems orderLineItems = new OrderLineItems();
    orderLineItems.setPrice(orderLineItemsDto.getPrice());
    orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
    orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
    return orderLineItems;
  }

}
