package com.ssafy.board.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class BoardDto {
    private int ArticleNo;
    private String userId;
    private String userName;
    private String subject;
    private String content;
    private int hit;
    private String registerTime;

}
