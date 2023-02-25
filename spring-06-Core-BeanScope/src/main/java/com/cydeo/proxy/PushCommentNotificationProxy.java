package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.stereotype.Component;

@Component

public class PushCommentNotificationProxy implements CommentNotificationProxy  {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending pursh notification for comment: "+ comment.getText());
    }
}
