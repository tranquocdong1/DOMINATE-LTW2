package donga.edu.example1.controller;

import donga.edu.example1.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class MemberController {

    @GetMapping("/members")
    public String getMembers(Model model) {
        List<Member> members = Arrays.asList(
                new Member("Trần Quốc Đông"),
                new Member("Hồ Quang Lành"),
                new Member("Huỳnh Hoàng Trâm")
        );

        model.addAttribute("members", members);

        return "members";
    }
}