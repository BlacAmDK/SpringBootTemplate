package com.blacamdk.template.controller;

import com.blacamdk.template.dao.UserMapper;
import com.blacamdk.template.model.Result;
import com.blacamdk.template.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.blacamdk.template.dao.UserDynamicSqlSupport.userid;
import static org.mybatis.dynamic.sql.SqlBuilder.isLessThan;

@RestController
public class TestController {

  private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

  @Autowired private UserMapper userMapper;

  @GetMapping("/")
  public Result test() {
    List<User> userList =
        userMapper.select(c -> c.where(userid, isLessThan(10)));
    LOGGER.info("userList: {}", userList);
    return Result.ok(userList);
  }

}
