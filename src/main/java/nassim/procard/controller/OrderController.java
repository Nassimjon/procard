package nassim.procard.controller;

import nassim.procard.model.Order;
import nassim.procard.repository.OrderRepository;
import nassim.procard.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;

    }

    @PostMapping("/uploadFile")
    public ResponseEntity<List<String>> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            List<String> lines = orderService.saveData(file);
            return ResponseEntity.ok(lines);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        Order addedOrder = orderService.addOrder(order);
        return ResponseEntity.ok(addedOrder);
    }







    @PostMapping("/split")
    public ResponseEntity<List<String>> splitText(@RequestParam("file") MultipartFile file) {
        try {
            List<String> words = orderService.splitText(file.getInputStream());
            return ResponseEntity.ok(words);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/addFromFile")
    public ResponseEntity<Void> addOrdersFromFile(@RequestParam("file") MultipartFile file) {
        try {
            orderService.addOrdersFromFile(file.getInputStream());
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
