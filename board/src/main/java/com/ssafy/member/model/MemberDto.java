package com.ssafy.member.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@ApiModel(value = "MemberDto(회원정보)", description = "아이디, 비밀번호, 이름을 가진 Domain")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Builder
public class MemberDto {
    @ApiModelProperty(value = "회원 아이디")
    private String userId;
    @ApiModelProperty(value = "회원 이름")
    private String userName;
    @ApiModelProperty(value = "회원 비밀 번호")
    private String userPwd;
    private String emailId;
    private String emailDomain;
    private String joinDate;
}
