package shop.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import shop.domain.Member;
import shop.domain.Order;
import shop.domain.OrderSearch;
import shop.domain.OrderStatus;
import shop.domain.item.Book;
import shop.repository.OrderRepository;
import shop.service.ItemService;
import shop.service.MemberService;
import shop.service.OrderService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class OrderRepositoryTest {

    @Autowired MemberService memberService;
    @Autowired ItemService itemService;
    @Autowired OrderService orderService;
    @Autowired OrderRepository orderRepository;

    @Test
    public void test() throws Exception {

        //Given
        Member member = createMember("hello");
        Book book = createItem("시골 Book", 10);
        orderService.order(member.getId(), book.getId(), 1);

        //When
        OrderSearch orderSearch = new OrderSearch();
        orderSearch.setMemberName("hello");
        orderSearch.setOrderStatus(OrderStatus.ORDER);

        List<Order> search = orderRepository.search(orderSearch);

        //Then
        Assert.assertEquals(1, search.size());
    }

    private Member createMember(String name) {
        Member member = new Member();
        member.setName(name);
        memberService.join(member);
        return member;
    }

    private Book createItem(String name, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setStockQuantity(stockQuantity);
        itemService.saveItem(book);
        return book;
    }

}