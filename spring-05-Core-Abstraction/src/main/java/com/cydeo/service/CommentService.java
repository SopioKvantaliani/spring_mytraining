package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import com.cydeo.repository.DBCommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    private final CommentRepository commentRepository; //Final is good practice to put, because if we forget to put constructor, final keyword reminds us.
    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(CommentRepository commentRepository,@Qualifier ("Email") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    //If I want to bring any method that belongs to different class, I need to create "has a" relationship.
    //Basically, I need to bring object from that class. We need to create constructor.
    //Another way to use another class method here is to create CommentRepository object inside the method.
    //Always for implementations we need to put interfaces here and not directly that class. if business logic changes we'll update class easily.

    public void publishComment (Comment comment){
        //save in the DB
        //Send email
       commentRepository.storeComment(comment);
       commentNotificationProxy.sendComment(comment);

    }
}
