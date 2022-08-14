package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : A 사용자가 10,000원을 주문
        int userAPrice = statefulService1.order("userA", 10000);

        // ThreadB : B 사용자가 20,000원을 주문
        int userBPrice = statefulService2.order("userB", 20000);

        // ThreadA : A 사용자의 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice);

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

        /**
         * 단순히 이해해보기 위해, 실제 Thread 를 사용하지는 않음
         * 특정 클라이언트에 의해 price 라는 공유되는 필드의 값이 변경됨
         * 공유 필드는 조심해야 하는 문제 중 하나임
         * Spring Bean은 항상 Stateless 로 설계하도록 하자
         */
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}