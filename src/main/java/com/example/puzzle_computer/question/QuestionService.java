package com.example.puzzle_computer.question;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.puzzle_computer.DataNotFoundException;
import com.example.puzzle_computer.user.WebUser;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service

public class QuestionService {
    
    private final QuestionRepository questionRepository;

    public List<Question> getList(){ // 질문 목록 데이터를 조회하여 리턴
        return this.questionRepository.findAll();
    }

    public Page<Question> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10,Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }

    public Question getQuestion(Integer id) {
        
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(String subject, String content, WebUser user){
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        q.setAuthor(user);
        this.questionRepository.save(q);
    }

    public void modify(Question question, String subject, String content){
        question.setSubject(subject);
        question.setContent(content);
        question.setModifyDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }

    
    public void delete(Question question) {
        this.questionRepository.delete(question);
    }

    public void vote(Question question, WebUser webUser) {
        question.getVoter().add(webUser);
        this.questionRepository.save(question);
    }
}
