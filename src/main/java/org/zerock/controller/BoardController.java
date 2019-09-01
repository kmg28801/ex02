package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
   private BoardService service;
   //URL의 변화여부가 필요하다면 Redirect를 사용하는 것이 좋습니다.
   //객체를 재사용하거나 공유해야한다면 Forward를 사용하는 것이 좋습니다.
   @GetMapping("/list")
   public void list(Model model) {
      log.info("list");
      model.addAttribute("list",service.getList());
   }
   /*
   @PostMapping("/register")
   //RedirectAttributes는 Model의 확장 버전
   public String register(BoardVO board, RedirectAttributes rttr) {
      log.info("register: "+board);
      service.register(board);
      //addFlashAttribute는 redirect직전 플래시에 저장하는 메소드  -> URL에 노출되지 X
      rttr.addFlashAttribute("result", board.getBno());
      
      return "redirect:/board/list";
   }
   
//   @GetMapping("/get")
//   public void get(@RequestParam("bno") Long bno, Model model) {
//      log.info("/get");
//      model.addAttribute("board", service.get(bno));
//   }
   
   //Get과 Post URL를 배열로 처리 가능
   @GetMapping({"/get","/modify"})
   public void get(@RequestParam("bno") Long bno, Model model) {
      log.info("/get or midify");
      model.addAttribute("board", service.get(bno));
   }
   
   @PostMapping("/modify")
   public String modify(BoardVO board, RedirectAttributes rttr) {
      log.info("modify: " + board);
      
      if(service.modify(board)) {
         rttr.addFlashAttribute("result", "success");
      }
      
      return "redirect:/board/list";
   }
   
   @PostMapping("/remove")
   public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
      log.info("remove... " + bno);
      
      if(service.remove(bno)) {
         rttr.addFlashAttribute("result","success");
      }
      
      return "redirect:/board/list";
   }
   ////노현영이 한 수정
   
   @GetMapping("/register")
   public void register(){
      
   }
   */
}