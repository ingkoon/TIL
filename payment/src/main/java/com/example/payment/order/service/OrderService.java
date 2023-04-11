package com.example.payment.order.service;

import com.example.payment.common.bootpay.BootPayComponent;
import com.example.payment.item.repostiory.ItemRepository;
import com.example.payment.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final BootPayComponent bootPayComponent;

    public void getTokenByBootPay() throws Exception{
        HashMap<String, Object> hashMap = bootPayComponent.connectBootpay();
        System.out.println(hashMap.get("access_token"));
    }

    public void orderItem(){

    }
}
