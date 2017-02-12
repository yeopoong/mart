package shop.repository.custom;

import java.util.List;

import shop.domain.Order;
import shop.domain.OrderSearch;

public interface CustomOrderRepository {

    public List<Order> search(OrderSearch orderSearch);

}
