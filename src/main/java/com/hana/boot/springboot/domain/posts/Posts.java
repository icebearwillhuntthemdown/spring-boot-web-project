package com.hana.boot.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity //JPA annotation, DB의 테이블과 매칭될 엔티티 클래스
public class Posts {

    @Id //PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성규칙, auto_increment
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 컬럼. 꼭 선언 안 해도 필드는 컬럼으로 인식. String은 기본값이 VARCHAR(255)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
