package hello.core.order;

// 최종 주문 결과를 반환하는 interface (역할)
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
