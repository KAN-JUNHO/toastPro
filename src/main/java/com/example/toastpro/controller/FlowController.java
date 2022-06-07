package com.example.toastpro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FlowController {
    private static final Logger logger = LoggerFactory.getLogger(FlowController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public String noticeList() {
        return "/notice/list";
    }
    @RequestMapping(value = "/notice/{noticeIdx}", method = RequestMethod.GET)
    public String notice(@PathVariable("noticeIdx") Long noticeIdx, Model model) {
        model.addAttribute("noticeIdx",noticeIdx);
        return "/notice/view";
    }
    @RequestMapping(value = "/notice/modify/{noticeIdx}", method = RequestMethod.GET)
    public String noticeModify(@PathVariable("noticeIdx") Long noticeIdx, Model model) {
        model.addAttribute("noticeIdx",noticeIdx);
        return "/notice/modify";
    }

    @RequestMapping(value = "/notice/register", method = RequestMethod.GET)
    public String noticeRegister() {
        return "/notice/register";
    }



    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String sceduleList() {
        return "/schedule/list";
    }

    @RequestMapping(value = "/user/{employeeIdx}", method = RequestMethod.GET)
    public String userProfile(@PathVariable("employeeIdx") Long employeeIdx ,Model model) {
        model.addAttribute("employeeIdx",employeeIdx);
        return "/employee/profile";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login/login";
    }
    @RequestMapping(value = "/sign", method = RequestMethod.GET)
    public String sign() {
        return "/login/sign";
    }
    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String boardList() {
        return "/board/list";
    }
    @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.GET)
    public String board(@PathVariable("boardIdx") Long boardIdx, Model model) {
        model.addAttribute("boardIdx",boardIdx);
        return "/board/view";
    }
    @RequestMapping(value = "/board/modify/{boardIdx}", method = RequestMethod.GET)
    public String boardModify(@PathVariable("boardIdx") Long boardIdx, Model model) {
        model.addAttribute("boardIdx",boardIdx);
        return "/board/modify";
    }

    @RequestMapping(value = "/board/register", method = RequestMethod.GET)
    public String boardRegister() {
        return "/board/register";
    }
}
