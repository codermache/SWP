/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author pc
 */
public class Post {

    private int post_id;
    private String title;
    private String content;
    private String post_image;
    private boolean status_post;
    private String type;
    private String description;
    private User user;

    public Post() {
    }

    public Post(int post_id, String title, String content, String post_image, boolean status_post, String type, String description, User user) {
        this.post_id = post_id;
        this.title = title;
        this.content = content;
        this.post_image = post_image;
        this.status_post = status_post;
        this.type = type;
        this.description = description;
        this.user = user;
    }

    public Post(int post_id, String title, String content, String post_image, String type, String description, User user) {
        this.post_id = post_id;
        this.title = title;
        this.content = content;
        this.post_image = post_image;
        this.type = type;
        this.description = description;
        this.user = user;
    }

    public Post(int post_id, String title, String content, String post_image, String type, String description) {
        this.post_id = post_id;
        this.title = title;
        this.content = content;
        this.post_image = post_image;
        this.type = type;
        this.description = description;
    }

    

    
    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPost_image() {
        return post_image;
    }

    public void setPost_image(String post_image) {
        this.post_image = post_image;
    }

    public boolean isStatus_post() {
        return status_post;
    }

    public void setStatus_post(boolean status_post) {
        this.status_post = status_post;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
