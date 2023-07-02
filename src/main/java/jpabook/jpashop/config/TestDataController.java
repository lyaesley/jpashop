package jpabook.jpashop.config;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataController {

    private final MemberService memberService;
    private final ItemService itemService;

    @PostConstruct
    @Transactional
    public void init() {
        //더미데이터

        Address address = new Address("서울", "양천", "123123");

        Member member1 = new Member();
        member1.setName("이준영");
        member1.setAddress(address);

        Member member2 = new Member();
        member2.setName("박향주");
        member2.setAddress(address);

        Member member3 = new Member();
        member3.setName("이수호");
        member3.setAddress(address);

        Member member4 = new Member();
        member4.setName("이은호");
        member4.setAddress(address);

        memberService.join(member1);
        memberService.join(member2);
        memberService.join(member3);
        memberService.join(member4);

        Book book = new Book();
        book.setName("JPA");
        book.setAuthor("김영한");
        book.setPrice(20000);
        book.setStockQuantity(200);
        book.setIsbn("1111");

        Book book2 = new Book();
        book2.setName("사랑해");
        book2.setAuthor("이준영");
        book2.setPrice(50000);
        book2.setStockQuantity(700);
        book2.setIsbn("1001");

        itemService.saveItem(book);
        itemService.saveItem(book2);
    }


}
