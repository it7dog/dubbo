package com.dubbo.entity.user;

import java.io.Serializable;

/**
 * @author: wangw
 * @date: 2018/6/10 22:20
 * @description:
 */
public class CommentEntity implements Serializable {
  private String id;
  private String comment;
  private String articleId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getArticleId() {
    return articleId;
  }

  public void setArticleId(String articleId) {
    this.articleId = articleId;
  }

  @Override
  public String toString() {
    return "CommentEntity{" +
               "id='" + id + '\'' +
               ", comment='" + comment + '\'' +
               ", articleId='" + articleId + '\'' +
               '}';
  }
}
