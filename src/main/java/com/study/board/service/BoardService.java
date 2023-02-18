package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired // DI가 이거임!
    private BoardRepository boardRepository;

    //글작성
    public void write(Board board) {
        boardRepository.save(board);
    }

    // 게시글 리스트 처리
    public List<Board> boardList() {
        return boardRepository.findAll(); // List<Board>
    }

    // 특정게시글 불러오기
    public Board boardView(Integer id) {
        return boardRepository.findById(id).get(); // optional값으로 받아오기 때문에 get()을 뒤에 적음!
    }

    // 특정 게시글 삭제
    public void boardDelete(Integer id) {
        boardRepository.deleteById(id);
    }
}
