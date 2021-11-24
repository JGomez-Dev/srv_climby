//package com.climbtogether.app.controller;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.ResultMatcher;
//
//import com.climbtogether.app.util.UserMapperUtil;
//import com.climbtogether.climby.controller.UserController;
//import com.climbtogether.climby.dto.UserDTO;
//import com.climbtogether.climby.service.UserService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = UserController.class)
//@TestPropertySource(value = "/application.properties")
//public class UserControllerTest {
//
//	@MockBean
//	private UserService userService;
//	
//	@Autowired
//	private MockMvc mockvc;
//	
//	protected static ObjectMapper om = new ObjectMapper().registerModule(new JavaTimeModule()).
//			configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//	
//	@Test
//	public void resgisterUserTest()throws Exception {
//		
//		//GIVEN
//		UserDTO creationRequestDTO = UserMapperUtil.generateTestUserDTO();
//		UserDTO defaultResponseDTO = UserMapperUtil.generateTestUserDTO();
//		String id = "1";
//		
//		when(userService.resgisterUser(creationRequestDTO)).thenReturn(defaultResponseDTO);
//		
//		//WHEN
//		ResultActions resultActions = mockvc.perform(post("/user").content(om.writeValueAsString(creationRequestDTO)).with(csrf()).contentType(MediaType.APPLICATION_JSON_VALUE));
//		
//		resultActions.andExpect(status().isCreated()).andExpect((ResultMatcher) jsonPath(String.valueOf(id)));
//				
//		
//	}
//	
//}
