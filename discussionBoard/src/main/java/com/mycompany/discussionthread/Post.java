/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discussionthread;

/**
 *
 * @author  Hyung-jun An
 */
public class Post {
    
    public Post(String content, String username, String time) {
        
        this.time = time;
        this.username = username;
        this.content = content;  
    }
    
    public String getTime() {
        return time;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getContent() {
        return time;
    }
          @Override
       public String toString() {
            return content;
       }    
    private String time;
    private String username;
    private String content;
}
