package nassim.procard.service;

import nassim.procard.model.Order;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface OrderService {

    void addOrdersFromFile(InputStream fileInputStream) throws IOException;
    List<String> splitText(InputStream fileInputStream) throws IOException;
    List<String> saveData(MultipartFile file) throws IOException;
    Order addOrder(Order order);
}
