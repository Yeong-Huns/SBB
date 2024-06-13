package com.mysite.sbb;

import com.mysite.sbb.t_board.BoardDTO;
import com.mysite.sbb.t_board.BoardRepository;
import groovy.util.logging.Log;
import groovy.util.logging.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * packageName    : com.mysite.sbb
 * fileName       : BoardRepositoryTest
 * author         : Yeong-Huns
 * date           : 2024-06-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-12        Yeong-Huns       최초 생성
 */
@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
    @Autowired
    BoardRepository boardRepository;

    @Test
    @DisplayName("게시글 조회에 성공한다.")
    void findById() {
        List<BoardDTO> list = this.boardRepository.getBoardList();
        for(BoardDTO boardDTO : list) {
            //System.out.println(boardDTO.toString());
           // Log.info(boardDTO.toString());
        }

    }
}
