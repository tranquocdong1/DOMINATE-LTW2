package donga.edu.example1.controller;

import donga.edu.example1.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller
public class MemberController {

    // Danh sách thành viên (dữ liệu tĩnh)
    private List<Member> getMembers() {
        return Arrays.asList(
                new Member(1L, "Trần Quốc Đông", "tranquocdong10.2@gmail.com", "0363903243"),
                new Member(2L, "Hồ Quang Lành", "lanh100139@donga.edu.vn", "0927192731"),
                new Member(3L, "Huỳnh Hoàng Trâm", "tram12121@donga.edu.vn", "0912345678")
        );

    @GetMapping("/members")
    public String getMembers(Model model) {
        // Thêm danh sách thành viên vào model
        model.addAttribute("members", getMembers());
        return "members";
    }

    @GetMapping("/members/{id}")
    public String getMemberDetail(@PathVariable Long id, Model model) {
        // Tìm thành viên theo id
        Member member = getMembers().stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (member == null) {
            // Nếu không tìm thấy, chuyển hướng về danh sách
            return "redirect:/members";
        }

        // Thêm thông tin thành viên vào model
        model.addAttribute("member", member);
        return "member-detail";
    }
}