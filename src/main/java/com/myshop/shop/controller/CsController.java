package com.myshop.shop.controller;

import com.myshop.shop.dto.CsDTO;
import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.service.CsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("cs")
@Log4j2
@RequiredArgsConstructor //자동 주입을 위한 Annotation
public class CsController {

    private final CsService service; //final로 선언

    @GetMapping("/")
    public String index() {

        return "redirect:/cs/list";
    }


    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){

        log.info("list............." + pageRequestDTO);

        model.addAttribute("result", service.getList(pageRequestDTO));

    }

    @GetMapping("/register")
    public void register(){
        log.info("regiser get...");
    }

    @PostMapping("/register")
    public String registerPost(CsDTO dto, RedirectAttributes redirectAttributes){

        log.info("dto..." + dto);

        //새로 추가된 엔티티의 번호
        Long no = service.register(dto);

        redirectAttributes.addFlashAttribute("msg", no);

        return "redirect:/cs/list";
    }

    //@GetMapping("/read")

    @GetMapping({"/read", "/modify", "/reply"})
    public void read(long no, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model ){

        log.info("no: " + no);

        CsDTO dto = service.read(no);

        model.addAttribute("dto", dto);

    }

    @PostMapping("/remove")
    public String remove(long no, RedirectAttributes redirectAttributes){


        log.info("no: " + no);

        service.remove(no);

        redirectAttributes.addFlashAttribute("msg", no);

        return "redirect:/cs/list";

    }

    @PostMapping("/modify")
    public String modify(CsDTO dto,
                         @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
                         RedirectAttributes redirectAttributes){


        log.info("post modify.........................................");
        log.info("dto: " + dto);

        service.modify(dto);

        redirectAttributes.addAttribute("page",requestDTO.getPage());
        redirectAttributes.addAttribute("type",requestDTO.getType());
        redirectAttributes.addAttribute("keyword",requestDTO.getKeyword());

        redirectAttributes.addAttribute("no",dto.getNo());


        return "redirect:/cs/read";

    }

    @PostMapping("/reply")
    public String reply(CsDTO dto,
                         @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
                         RedirectAttributes redirectAttributes){


        log.info("post reply.........................................");
        log.info("dto: " + dto);

        service.reply(dto);

        redirectAttributes.addAttribute("page",requestDTO.getPage());
        redirectAttributes.addAttribute("type",requestDTO.getType());
        redirectAttributes.addAttribute("keyword",requestDTO.getKeyword());

        redirectAttributes.addAttribute("no",dto.getNo());


        return "redirect:/cs/read";

    }

    @GetMapping("/main")
    public String main(){
        log.info("main...");
        return "/cs/main";
    }



}
