package com.cydeo.proxy;

import com.cydeo.model.Comment;

public interface CommentNotificationProxy {
    void sendComment (Comment comment); //get comment object and send.
    //Comment in this method is Object Parameter
}
