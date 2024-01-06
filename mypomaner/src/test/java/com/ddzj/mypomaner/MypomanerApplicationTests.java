package com.ddzj.mypomaner;

import com.ddzj.mypomaner.entity.TblDictType;
import com.ddzj.mypomaner.service.ITblDictTypeService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan(basePackages = "com.ddzj.mypomaner.mapper")
class MypomanerApplicationTests {

	@Autowired
	private ITblDictTypeService iTblDictTypeService;

	@Test
	void contextLoads() {
		iTblDictTypeService.list();
	}

}
