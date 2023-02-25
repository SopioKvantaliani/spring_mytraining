package com.cydeo;

import com.cydeo.config.CommentConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp {
    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("SpringFramework");

        //This Comment portion never done in real application. It's comes from UI, or it is created in DB and comes from there.

        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);
        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);


    }
}
