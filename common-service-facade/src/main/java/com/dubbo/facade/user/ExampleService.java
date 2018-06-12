package com.dubbo.facade.user;

import com.dubbo.entity.user.ArticleEntity;

import java.util.List;

public interface ExampleService {

    public String hello();

    /**
     * 查询指定作者的所有文章
     * @param userId 作者id
     * @return 该作者的所有文章
     */
    public List<ArticleEntity> findArticlesByUserId(String userId);

}
