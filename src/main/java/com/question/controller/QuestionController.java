package com.question.controller;

import com.question.QuestionService;
import com.question.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
@Autowired
    private QuestionService questionService;

    @PostMapping
    public Question create(@RequestBody Question question){
        return  questionService.create(question);
    }

    @GetMapping
    public List<Question> getAll(){
        return questionService.get();
    }

    @GetMapping("/{questionId}")
    public Question getQuestion(@PathVariable Long questionId){
        return questionService.getOne(questionId);
    }

    @GetMapping("/quiz/{quizId}")
    public  List<Question> getQuestionofQuiz(@PathVariable Long quizId){
        return questionService.getQuestionofQuiz(quizId);
    }



}
