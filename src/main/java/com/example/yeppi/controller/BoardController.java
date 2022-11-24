package com.example.yeppi.controller;

import java.util.List;

import com.example.yeppi.entity.Board;
import com.example.yeppi.repository.BoardRepository;
import com.example.yeppi.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // get all board
    @GetMapping("/board")
    public List<Board> getAllBoards() {

        return boardService.getAllBoard();
    }

    // create board
    @PostMapping("/board")
    public Board createBoard(@RequestBody Board board) {
        return boardService.createBoard(board);
    }

    // get board
    // 게시판 조회하기
    @GetMapping("/board/{no}")
    public ResponseEntity<Board> getBoardByNo(
            @PathVariable Integer no) {
        return boardService.getBoard(no);
    }

    //Modify board
    @GetMapping("/modifyBoard")
    public String modifyBoard(@RequestParam("no") Integer no, @RequestParam("title") String title, @RequestParam("contents") String contents, Model model) throws Exception {
        Board data = boardService.getOneBoard(no);
        model.addAttribute("data", data);
        return "boardModify";
    }
}
