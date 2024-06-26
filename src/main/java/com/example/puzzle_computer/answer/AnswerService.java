package com.example.puzzle_computer.answer;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.puzzle_computer.DataNotFoundException;
import com.example.puzzle_computer.question.Question;
import com.example.puzzle_computer.user.WebUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {

	private final AnswerRepository answerRepository;

	public Answer create(Question question, String content, WebUser author) {
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		answer.setAuthor(author);
		this.answerRepository.save(answer);
		return answer;
	}

	public Answer getAnswer(Integer id) {
		Optional<Answer> answer = this.answerRepository.findById(id);
		if(answer.isPresent()) {
			return answer.get();
		}
		else {
			throw new DataNotFoundException("answer not found");
		}

	}

	public void modify(Answer answer, String content) {
		answer.setContent(content); // 내용 수정
		answer.setModifyDate(LocalDateTime.now()); // 시간 수정 (현재시간)
		this.answerRepository.save(answer);  //내용 저장
	}


	
	
	public void delete(Answer answer) {
		this.answerRepository.delete(answer);
	}

	public void vote(Answer answer, WebUser webUser) {
        answer.getVoter().add(webUser);
        this.answerRepository.save(answer);
    }
	
}