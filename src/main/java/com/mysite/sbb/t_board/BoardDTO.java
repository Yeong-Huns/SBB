package com.mysite.sbb.t_board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName    : com.mysite.sbb
 * fileName       : BoardDTO
 * author         : Yeong-Huns
 * date           : 2024-06-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-12        Yeong-Huns       최초 생성
 */
@Getter
@Setter
@ToString
public class BoardDTO {
    private Long no;
    private String title;
    private int re;
    private String reddate;
}
