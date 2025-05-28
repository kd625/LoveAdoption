package com.KevinCx;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class LoveAdoptionApplicationTests {

	@Test
	void testLogin(){
		String password = DigestUtils.md5DigestAsHex("123".getBytes());
		System.out.println(password);
	}

}
