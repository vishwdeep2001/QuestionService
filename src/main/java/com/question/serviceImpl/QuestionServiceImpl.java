package com.question.serviceImpl;

import com.question.QuestionService;
import com.question.entity.Question;
import com.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Question create(Question question) {
      return  questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepository.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getQuestionofQuiz(Long questionId) {
        return questionRepository.findByQuizId(questionId);
    }
}
