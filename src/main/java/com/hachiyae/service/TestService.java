package com.hachiyae.service;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> find(int id) {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from customer where id = " + id);
        return maps;
    }

}
