package com.mysite.sbb.answer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * packageName    : com.mysite.sbb.answer
 * fileName       : AnswerFrom
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
public class AnswerForm {
    @NotEmpty(message = "내용은 필수항목입니다.")
    @Size(max= 1000, message = "내용은 1000글자 이하로 작성하셔야 합니다.")
    private String content;
}
