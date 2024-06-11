package com.mysite.sbb.answer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.mysite.sbb
 * fileName       : AnswerRepository
 * author         : Yeong-Huns
 * date           : 2024-06-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-11        Yeong-Huns       최초 생성
 */
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
