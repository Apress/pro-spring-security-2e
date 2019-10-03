package com.apress.pss.acl;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.FileCopyUtils;

public class DatabaseSeeder {
    public DatabaseSeeder(JdbcTemplate jdbcTemplate) throws IOException{
    	String sql = new String(FileCopyUtils.copyToByteArray(new ClassPathResource("customCreateAclSchema.sql").getInputStream()));
    	jdbcTemplate.execute(sql);
    }	
}
