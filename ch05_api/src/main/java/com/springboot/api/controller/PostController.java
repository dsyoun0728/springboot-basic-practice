package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

  @RequestMapping(value = "/domain", method = RequestMethod.POST)
  public String postExample() {
    return "Hello Post API";
  }

  // http://localhost:8080/api/v1/post-api/member
  @PostMapping("/member")
  public String postMember(@RequestBody Map<String, Object> postData) {
    StringBuilder sb = new StringBuilder();

    postData.entrySet().forEach(map -> {
      sb.append(map.getKey() + " : " + map.getValue() + "\n");
    });

    return sb.toString();
  }

  // http://localhost:8080/api/v1/post-api/member2
  @ApiOperation(value = "POST method 예제", notes = "MemberDto를 활용한 POST method")
  @PostMapping("/member2")
  public String postMemberDto(@ApiParam(value = "MemberDto", required = true) @RequestBody MemberDto memberDto) {
    return memberDto.toString();
  }
}
