package com.mysite.sbb;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionWantColumn;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Log4j2
class SbbRepositoryTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
    @Test
    @DisplayName("QuestionRepository_저장에_성공한다.")
    void testCreateQuestionData() {
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다.");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);  // 첫번째 질문 저장

        Question q2 = new Question();
        q2.setSubject("스프링부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);  // 두번째 질문 저장
    }

    @Test
    @Timeout(value = 3, unit = TimeUnit.SECONDS)
    void testFindAll() {
        try{
            Thread.sleep(2500);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2, all.size());
        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }

    @Test
    @DisplayName("ID로 조회에 성공한다.")
    void findById() {
        Optional<Question> oq = this.questionRepository.findById(1);
        if(oq.isPresent()) {
            Question q = oq.get();
            assertEquals("sbb가 무엇인가요?", q.getSubject());
        }
    }

    @Test
    @DisplayName("Subject 조회에 성공한다.")
    void findBySubject() {
        Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
        assertEquals(11, q.getId());
    }
    @Test
    @DisplayName("Subject와 Content로 조회에 성공한다.")
    void findBySubjectAndContent(){
        Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
        assertEquals(11, q.getId());
    }

    @Test
    @DisplayName("특정_문자열을_포함하는_데이터_조회")
    void findBySubjectLike(){
        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
        Question q = qList.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }

    @Test
    @Transactional
    @DisplayName("질문_엔티티_수정_테스트")
    void updateQuestion(){
        Optional<Question> oq = this.questionRepository.findById(11);
        assertTrue(oq.isPresent());
        Question q = oq.get(); q = oq.get();
        q.setSubject("수정된 제목");
        this.questionRepository.save(q);
    }

    @Test
    @Transactional
    @DisplayName("질문_삭제_테스트")
    void deleteQuestion(){
        assertEquals(2, this.questionRepository.count());
        Optional<Question> oq = this.questionRepository.findById(11);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        this.questionRepository.delete(q);
        assertEquals(1, this.questionRepository.count());
    }


    @Test
    @DisplayName("특정_컬럼만_조회")
    void testWantColumn(){
        Optional<QuestionWantColumn> q = this.questionRepository.findSubjectById(11);
        assertTrue(q.isPresent());
        assertEquals("sbb가 무엇인가요?",  q.get().getSubject());
        assertEquals("sbb에 대해서 알고 싶습니다.", q.get().getContent());
    }

    @Test
    @DisplayName("답변_추가_테스트")
    @Transactional
    void testCreateAnswer(){
        Optional<Question> oq = this.questionRepository.findById(11);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer a = new Answer();
        a.setContent("네 자동으로 생성됩니다.");
        a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
    }

    @Test
    @DisplayName("답변_조회_테스트")
    void findAnswerById(){
        Optional<Answer> oa = this.answerRepository.findById(1);
        assertTrue(oa.isPresent());
        Answer a = oa.get();
        assertEquals(11, a.getQuestion().getId());
    }

    @Test
    @Transactional
    @DisplayName("QuestionID를 통해 조회에 성공한다.")
    void findAnswerByQuestionId(){
        Optional<Question> oq = this.questionRepository.findById(11);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.getFirst().getContent());
    }

}
