package guru.springframework.orderservice.bootstrap;

import guru.springframework.orderservice.domain.OrderHeader;
import guru.springframework.orderservice.repositories.OrderHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    OrderHeaderRepository orderHeaderRepository;
    //proxy works in funny way: internal methods even with transactional annotation will not be picked up
    // only external methods will be picked up
    @Autowired
    BootstrapOrderService bootstrapOrderService;

    @Override
    public void run(String... args) throws Exception {
        bootstrapOrderService.readOrderData();

    }
}