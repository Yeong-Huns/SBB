package com.mysite.sbb;

import com.mysite.sbb.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName    : com.mysite.sbb
 * fileName       : SbbServiceTests
 * author         : Yeong-Huns
 * date           : 2024-06-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-12        Yeong-Huns       최초 생성
 */
@SpringBootTest
public class SbbServiceTests {

    @Autowired
    private QuestionService questionService;

    @Test
    @Transactional
    void insertTestData(){
        for(int i = 0; i <= 300; i++){
            String subject = String.format("텍스트 데이터입니다. : [%03d]", i);
            String content = "내용은 없습니다.";
            this.questionService.create(subject, content);
        }
    }
}
