package com.mysite.sbb.t_board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName    : com.mysite.sbb.t_board
 * fileName       : BoardRepository
 * author         : Yeong-Huns
 * date           : 2024-06-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-12        Yeong-Huns       최초 생성
 */
@Mapper
public interface BoardRepository {
    List<BoardDTO> getBoardList();

}
