package com.pks.orderservice.controller;

import com.pks.orderservice.dto.OrderRequest;
import com.pks.orderservice.service.OrderService;
import java.util.concurrent.CompletableFuture;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@AllArgsConstructor
public class OrderController {

  OrderService orderService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest) {
    //return CompletableFuture.supplyAsync(() -> orderService.placeOrder(orderRequest));
    return null;
  }
}
