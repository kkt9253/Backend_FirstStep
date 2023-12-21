package com.codingrecipe.board.repository;

import com.codingrecipe.board.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final SqlSessionTemplate sql;
    public int save(BoardDTO boardDTO) {
        return sql.insert("Board.save", boardDTO); // boardMapper.xml의 namespace인 Board, id인 save를 가르킴
    }

    public List<BoardDTO> findAll() {
        return sql.selectList("Board.findAll"); // 위하 동일
    }

    public BoardDTO findById(Long id) {
        return sql.selectOne("Board.findById", id); // 모두가 각각의 쿼리임. selectList, selectOne 등등
    }

    public void updateHits(Long id) {
        sql.update("Board.updateHits", id);
    }

    public void delete(Long id) {
        sql.delete("Board.delete", id);
    }

    public void update(BoardDTO boardDTO) {
        sql.update("Board.update", boardDTO);
    }
}
