package com.blacamdk.template.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.181+08:00", comments="Source Table: user")
    public static final User user = new User();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.182+08:00", comments="Source field: user.userid")
    public static final SqlColumn<Integer> userid = user.userid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.182+08:00", comments="Source field: user.username")
    public static final SqlColumn<String> username = user.username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.182+08:00", comments="Source field: user.password")
    public static final SqlColumn<String> password = user.password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.182+08:00", comments="Source field: user.number")
    public static final SqlColumn<String> number = user.number;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.182+08:00", comments="Source field: user.majorid")
    public static final SqlColumn<Integer> majorid = user.majorid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.182+08:00", comments="Source field: user.deptid")
    public static final SqlColumn<Integer> deptid = user.deptid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.182+08:00", comments="Source field: user.phone")
    public static final SqlColumn<String> phone = user.phone;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.183+08:00", comments="Source field: user.locked")
    public static final SqlColumn<Integer> locked = user.locked;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.183+08:00", comments="Source field: user.salt")
    public static final SqlColumn<String> salt = user.salt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.183+08:00", comments="Source field: user.avatar")
    public static final SqlColumn<String> avatar = user.avatar;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.183+08:00", comments="Source field: user.realname")
    public static final SqlColumn<String> realname = user.realname;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.183+08:00", comments="Source field: user.roleid")
    public static final SqlColumn<Integer> roleid = user.roleid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.181+08:00", comments="Source Table: user")
    public static final class User extends SqlTable {
        public final SqlColumn<Integer> userid = column("userid", JDBCType.INTEGER);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("`password`", JDBCType.VARCHAR);

        public final SqlColumn<String> number = column("`number`", JDBCType.VARCHAR);

        public final SqlColumn<Integer> majorid = column("majorid", JDBCType.INTEGER);

        public final SqlColumn<Integer> deptid = column("deptid", JDBCType.INTEGER);

        public final SqlColumn<String> phone = column("phone", JDBCType.VARCHAR);

        public final SqlColumn<Integer> locked = column("locked", JDBCType.INTEGER);

        public final SqlColumn<String> salt = column("salt", JDBCType.VARCHAR);

        public final SqlColumn<String> avatar = column("avatar", JDBCType.VARCHAR);

        public final SqlColumn<String> realname = column("realname", JDBCType.VARCHAR);

        public final SqlColumn<Integer> roleid = column("roleid", JDBCType.INTEGER);

        public User() {
            super("user");
        }
    }
}