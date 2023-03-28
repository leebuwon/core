package com.hello.core;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import com.hello.core.member.MemoryMemberRepository;
import com.hello.core.order.OrderService;
import com.hello.core.order.OrderServiceImpl;

public class AppConfig {

    // 생성자 주입
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
