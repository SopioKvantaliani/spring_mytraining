package com.cydeo;

import com.cydeo.config.CommentConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class CommentApp {

    public static void main(String[] args) {
        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext container = new AnnotationConfigApplicationContext(CommentConfig.class);

        CommentService cs1 = container.getBean(CommentService.class);
        CommentService cs2 = container.getBean(CommentService.class);

        System.out.println(cs1==cs2); //When we mentioned prototype Spring created one more object and here result is false;
                                        //But if we don't use @Scope approach than here result will be "true", because default approach (Singleton)
                                        //creates only one instance and uses that all the time.
//
//        String str1 = container.getBean(String.class); //we can use method with @Bean annotation.
//        System.out.println(str1);


    }
    @Bean
    public String stringBean () {
        return "Cydeo";
    }

}
