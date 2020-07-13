package com.blacamdk.template.dao;

import static com.blacamdk.template.dao.UserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.blacamdk.template.model.User;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface UserMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.192+08:00", comments="Source Table: user")
    BasicColumn[] selectList = BasicColumn.columnList(userid, username, password, number, majorid, deptid, phone, locked, salt, avatar, realname, roleid);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.183+08:00", comments="Source Table: user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.184+08:00", comments="Source Table: user")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.185+08:00", comments="Source Table: user")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<User> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.186+08:00", comments="Source Table: user")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<User> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.186+08:00", comments="Source Table: user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserResult")
    Optional<User> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.187+08:00", comments="Source Table: user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserResult", value = {
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.VARCHAR),
        @Result(column="majorid", property="majorid", jdbcType=JdbcType.INTEGER),
        @Result(column="deptid", property="deptid", jdbcType=JdbcType.INTEGER),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="locked", property="locked", jdbcType=JdbcType.INTEGER),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="roleid", property="roleid", jdbcType=JdbcType.INTEGER)
    })
    List<User> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.188+08:00", comments="Source Table: user")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.188+08:00", comments="Source Table: user")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.189+08:00", comments="Source Table: user")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.189+08:00", comments="Source Table: user")
    default int deleteByPrimaryKey(Integer userid_) {
        return delete(c -> 
            c.where(userid, isEqualTo(userid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.19+08:00", comments="Source Table: user")
    default int insert(User record) {
        return MyBatis3Utils.insert(this::insert, record, user, c ->
            c.map(userid).toProperty("userid")
            .map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(number).toProperty("number")
            .map(majorid).toProperty("majorid")
            .map(deptid).toProperty("deptid")
            .map(phone).toProperty("phone")
            .map(locked).toProperty("locked")
            .map(salt).toProperty("salt")
            .map(avatar).toProperty("avatar")
            .map(realname).toProperty("realname")
            .map(roleid).toProperty("roleid")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.191+08:00", comments="Source Table: user")
    default int insertMultiple(Collection<User> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, user, c ->
            c.map(userid).toProperty("userid")
            .map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(number).toProperty("number")
            .map(majorid).toProperty("majorid")
            .map(deptid).toProperty("deptid")
            .map(phone).toProperty("phone")
            .map(locked).toProperty("locked")
            .map(salt).toProperty("salt")
            .map(avatar).toProperty("avatar")
            .map(realname).toProperty("realname")
            .map(roleid).toProperty("roleid")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.191+08:00", comments="Source Table: user")
    default int insertSelective(User record) {
        return MyBatis3Utils.insert(this::insert, record, user, c ->
            c.map(userid).toPropertyWhenPresent("userid", record::getUserid)
            .map(username).toPropertyWhenPresent("username", record::getUsername)
            .map(password).toPropertyWhenPresent("password", record::getPassword)
            .map(number).toPropertyWhenPresent("number", record::getNumber)
            .map(majorid).toPropertyWhenPresent("majorid", record::getMajorid)
            .map(deptid).toPropertyWhenPresent("deptid", record::getDeptid)
            .map(phone).toPropertyWhenPresent("phone", record::getPhone)
            .map(locked).toPropertyWhenPresent("locked", record::getLocked)
            .map(salt).toPropertyWhenPresent("salt", record::getSalt)
            .map(avatar).toPropertyWhenPresent("avatar", record::getAvatar)
            .map(realname).toPropertyWhenPresent("realname", record::getRealname)
            .map(roleid).toPropertyWhenPresent("roleid", record::getRoleid)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.193+08:00", comments="Source Table: user")
    default Optional<User> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.194+08:00", comments="Source Table: user")
    default List<User> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.194+08:00", comments="Source Table: user")
    default List<User> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.194+08:00", comments="Source Table: user")
    default Optional<User> selectByPrimaryKey(Integer userid_) {
        return selectOne(c ->
            c.where(userid, isEqualTo(userid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.195+08:00", comments="Source Table: user")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, user, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.195+08:00", comments="Source Table: user")
    static UpdateDSL<UpdateModel> updateAllColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userid).equalTo(record::getUserid)
                .set(username).equalTo(record::getUsername)
                .set(password).equalTo(record::getPassword)
                .set(number).equalTo(record::getNumber)
                .set(majorid).equalTo(record::getMajorid)
                .set(deptid).equalTo(record::getDeptid)
                .set(phone).equalTo(record::getPhone)
                .set(locked).equalTo(record::getLocked)
                .set(salt).equalTo(record::getSalt)
                .set(avatar).equalTo(record::getAvatar)
                .set(realname).equalTo(record::getRealname)
                .set(roleid).equalTo(record::getRoleid);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.196+08:00", comments="Source Table: user")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userid).equalToWhenPresent(record::getUserid)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(number).equalToWhenPresent(record::getNumber)
                .set(majorid).equalToWhenPresent(record::getMajorid)
                .set(deptid).equalToWhenPresent(record::getDeptid)
                .set(phone).equalToWhenPresent(record::getPhone)
                .set(locked).equalToWhenPresent(record::getLocked)
                .set(salt).equalToWhenPresent(record::getSalt)
                .set(avatar).equalToWhenPresent(record::getAvatar)
                .set(realname).equalToWhenPresent(record::getRealname)
                .set(roleid).equalToWhenPresent(record::getRoleid);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.196+08:00", comments="Source Table: user")
    default int updateByPrimaryKey(User record) {
        return update(c ->
            c.set(username).equalTo(record::getUsername)
            .set(password).equalTo(record::getPassword)
            .set(number).equalTo(record::getNumber)
            .set(majorid).equalTo(record::getMajorid)
            .set(deptid).equalTo(record::getDeptid)
            .set(phone).equalTo(record::getPhone)
            .set(locked).equalTo(record::getLocked)
            .set(salt).equalTo(record::getSalt)
            .set(avatar).equalTo(record::getAvatar)
            .set(realname).equalTo(record::getRealname)
            .set(roleid).equalTo(record::getRoleid)
            .where(userid, isEqualTo(record::getUserid))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-05-11T01:04:26.197+08:00", comments="Source Table: user")
    default int updateByPrimaryKeySelective(User record) {
        return update(c ->
            c.set(username).equalToWhenPresent(record::getUsername)
            .set(password).equalToWhenPresent(record::getPassword)
            .set(number).equalToWhenPresent(record::getNumber)
            .set(majorid).equalToWhenPresent(record::getMajorid)
            .set(deptid).equalToWhenPresent(record::getDeptid)
            .set(phone).equalToWhenPresent(record::getPhone)
            .set(locked).equalToWhenPresent(record::getLocked)
            .set(salt).equalToWhenPresent(record::getSalt)
            .set(avatar).equalToWhenPresent(record::getAvatar)
            .set(realname).equalToWhenPresent(record::getRealname)
            .set(roleid).equalToWhenPresent(record::getRoleid)
            .where(userid, isEqualTo(record::getUserid))
        );
    }
}