package shop.domain;

import org.springframework.data.jpa.domain.Specifications;

import static org.springframework.data.jpa.domain.Specifications.where;
import static shop.domain.OrderSpec.memberNameLike;
import static shop.domain.OrderSpec.orderStatusEq;

public class OrderSearch {

    private String memberName;      //회원 이름
    private OrderStatus orderStatus;//주문 상태

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Specifications<Order> toSpecification() {
        return where(memberNameLike(memberName))
                .and(orderStatusEq(orderStatus));
    }

}
