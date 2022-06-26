package com.climbtogether.climby;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
@TestPropertySource(value = "/application.properties")
public class BootApplicationTest {

	@Test
	public void contextLoads() {
	}
	
//	@Test
//	public void main() {
//		BootApplication.main(new String[] {});
//	}

}
