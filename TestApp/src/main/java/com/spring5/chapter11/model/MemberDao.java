package com.spring5.chapter11.model;

import com.spring5.chapter11.service.MemberRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class MemberDao {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Member> memberRowMapper= new RowMapper<Member>() {
        @Override
        public Member mapRow(ResultSet resultSet, int i) throws SQLException {
            Member member = new Member(
                    resultSet.getString("EMAIL"),
                    resultSet.getString("PASSWORD"),
                    resultSet.getString("NAME"),
                    resultSet.getTimestamp("REGDATE").toLocalDateTime()
            );
            member.setId(resultSet.getLong("ID"));
            return member;
        }
    };

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Member selectByEmail(String email) {
        List<Member> results = jdbcTemplate.query("select * from MEMBER where EMAIL = ?", memberRowMapper, email);
        return results.isEmpty() ? null : results.get(0);
    }

    public List<Member> selectByRegdate(LocalDateTime from, LocalDateTime to) {
        List<Member> results = jdbcTemplate.query("select * from MEMBER where REGDATE between ? and ? " +
                "order by REGDATE desc", memberRowMapper, from, to);

        return results;
    }

    public Member selectById(Long memberId) {
        List<Member> results = jdbcTemplate.query(
                "select * from MEMBER where ID = ?", memberRowMapper, memberId
        );

        return results.isEmpty() ? null : results.get(0);
    }

    public List<Member> selectAll() {
        List<Member> results = jdbcTemplate.query("select * from MEMBER", memberRowMapper);
        return results;
    }

    public int count() {
        Integer count = jdbcTemplate.queryForObject(
                "select count(*) from MEMBER", Integer.class
        );
        return count;
    }

    public void update(Member member) {
        jdbcTemplate.update(
                "update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?",
                member.getName(), member.getPassword(), member.getEmail()
        );
    }

    public void delete(Long memberId) {
        jdbcTemplate.update("delete from MEMBER where ID = ?", memberId);
    }

    public void insert(Member member) {
        // Key값을 담을 KeyHolder 객체 생성
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                con -> {
                    // 파라미터로 전달 받은 Connnection을 이용해서 PreparedStatement 생성
                    // 자동 증가되는 ID 필드를 변수로 저장하고, update의 인자로 들어온 keyHolder에 넘겨줌
                    PreparedStatement preparedStatement = con.prepareStatement(
                            "insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) values (?, ?, ?, ?)",
                            new String[] {"ID"}
                    );

                    // 인덱스 파라미터의 값 설정
                    preparedStatement.setString(1, member.getEmail());
                    preparedStatement.setString(2, member.getPassword());
                    preparedStatement.setString(3, member.getName());
                    preparedStatement.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));

                    return preparedStatement;
                }, keyHolder
        );

        Number keyValue = keyHolder.getKey();
        member.setId(keyValue.longValue());
    }
}
