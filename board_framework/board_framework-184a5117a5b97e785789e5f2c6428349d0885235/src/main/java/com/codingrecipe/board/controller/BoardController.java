package com.codingrecipe.board.controller;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor // 의존성 주입
@RequestMapping("/board") // /board로 들어오는 주소에 대해 다 받음
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/save")
    public String saveForm() {
        return "save"; // save.jsp 호출
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) { // 정보가 boardDTO에 담김
        int saveResult = boardService.save(boardDTO); // boardService.save 호출하여 DTO 넘김
        if (saveResult > 0) {
            return "redirect:/board/"; // 게시판에 글을 작성하면 글 목록을 요청함
        } else {
            return "save"; // 아니면 save페이지에 머무름
        }
    }
    @GetMapping("/")
    public String findAll(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll(); // DB에 저장된 모든 내용을 List객체에 담는다.
        model.addAttribute("boardList", boardDTOList);
        return "list";
    }

    @GetMapping // 링크를 타고왔 으며 파라미터값이기 때문에 따로 주소지정은 안해도 됨
    public String findById(@RequestParam("id") Long id, Model model) {// id에 담긴 파라미터 값을 Long id에 담음, DB에서 가져와야 하기 때문에 Model 객체 사용
        boardService.updateHits(id); // id를 가진 게시물의 조회수를 1 올리고 아래 코드로 가져옴
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "detail"; // model에 담아서 detail.jsp로 넘어옴
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        boardService.delete(id);
        return "redirect:/board/"; // 목록 처리를 하는 주소/board/  요청
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("id") Long id, Model model) {
        // 우선 게시글의 정보를 가져와야 함
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model) {
        boardService.update(boardDTO);
        BoardDTO dto = boardService.findById((boardDTO.getId()));
        model.addAttribute("board", dto);
        return "detail";
    }
}
