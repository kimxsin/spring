package com.ohgiraffers.section01.scope.subsection02.prototype;

import com.ohgiraffers.common.Cart;
import com.ohgiraffers.common.Drink;
import com.ohgiraffers.common.Food;
import com.ohgiraffers.common.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
public class ContextConfig {

    @Bean
    public Product kimchi() {
        return new Food("겉절이", 2000, new Date());
    }

    @Bean
    public Product coke() {
        return new Drink("콜라", 1500, 500);
    }

    @Bean
    public Product soda() {
        return new Drink("밀키스", 1800, 250);
    }

    @Bean
    /* comment.
    *   @Bean 의 기본 DefaultScope 는 Singleton 이다.
    *   하지만 우리가 prototype 이라는 문자열을 @Scope 어노테이션에
    *   전달을 하게 된다면, getBean 으로 객체를 꺼낼 때마다
    *   새로운 인스턴스를 생성해주게 된다.
    *  */
    @Scope("prototype")
    // 상품을 담기 위한 카트 객체 생성
    public Cart cart() {
        return new Cart();
    }
}
