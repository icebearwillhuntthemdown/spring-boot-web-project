package com.hana.boot.springboot.web.domain.posts;

import com.hana.boot.springboot.domain.posts.Posts;
import com.hana.boot.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After //단위 테스트가 끝날 때마다 수행되는 메소드
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void loadingPosts(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()    //save()는 insert 또는 update 쿼리 실행
                .title(title)
                .content(content)
                .author("icebearwillhuntthemdown")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();  //findAll()은 테이블의 모든 데이터 조회

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
