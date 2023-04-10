package com.example.payment.common.dummy;

import com.example.payment.user.domain.Member;
import com.example.payment.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberDummy implements CommandLineRunner {

    private final MemberRepository memberRepository;

    @Override
    public void run(String... args) throws Exception {
        addMember();
    }

    private void addMember(){
        for (int i = 0; i < 10; i++) {
            Member member = Member.builder()
                    .name("test" + i)
                    .nickname("test" + i)
                    .point(0).build();
            memberRepository.save(member);
        }
    }

}
