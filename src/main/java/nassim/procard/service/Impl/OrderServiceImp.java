package nassim.procard.service.Impl;

import nassim.procard.model.Order;
import nassim.procard.repository.OrderRepository;
import nassim.procard.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


@Service
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<String> saveData(MultipartFile file) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }









    public List<String> splitText(InputStream fileInputStream) throws IOException {
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\|"); // Разделение по точке
                for (String word : lineWords) {
                    words.add(word);
                }
            }
        }
        return words;
    }

    public void addOrdersFromFile(InputStream fileInputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 13) { // Проверяем, что есть все необходимые поля
                    Order order = new Order();
                    order.setClientPAN(parts[0]);
                    order.setClientMBR(Integer.parseInt(parts[1]));
                    order.setServiceCode(parts[2]);
                    order.setFirstName(parts[3]);
                    order.setSecondName(parts[4]);
                    order.setFirstNameOnCard(parts[5]);
                    order.setSecondNameOnCard(parts[6]);
                    order.setCardDateInput(parts[7]);
                    order.setCardDateExpire(parts[8]);
                    order.setFullNameOnEnv(parts[9]);
                    order.setNameBank(parts[10]);
                    order.setCardStatus(parts[11]);
                    order.setPassportNo(parts[12]);
                    orderRepository.save(order);
                }
            }
        }
    }
}
