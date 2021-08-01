package com.cognizant.authorizationService.model;
	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.junit.jupiter.api.Assertions.assertTrue;

	import org.aspectj.lang.annotation.Before;
	import org.junit.jupiter.api.Test;
	import org.junit.runner.RunWith;
	import org.mockito.Mock;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.test.context.junit4.SpringRunner;

	@SpringBootTest
	@RunWith(SpringRunner.class)
	public class AuthenticationRequestTest {

		@Mock
		public AuthenticationRequest authenticationRequest;
		
		@Before(value="")
		public void setup() {
			authenticationRequest=new AuthenticationRequest("admin","admin");
		}
		
		@Test
		public void testAllArgumentConstructor() {
			AuthenticationRequest userLog =new AuthenticationRequest("admin","admin");
			assertEquals("admin",userLog.getUsername());
		}
		
		@Test
		public void testEquals() {
			boolean res=authenticationRequest.equals(authenticationRequest);
			assertTrue(res);
		}
		
		@Test
		public void testNoArgConstructor() {
			AuthenticationRequest ulc=new AuthenticationRequest();
			assertEquals(ulc,ulc);
		}
		
		 @Test
	     void testingAuthenticationRequest(){
			 authenticationRequest=new AuthenticationRequest("suman","suman");
			 authenticationRequest.setUsername("admin");
			 authenticationRequest.setPassword("admin"); 
	        
	        
	        assertEquals("admin",authenticationRequest.getUsername());
	        assertEquals("admin",authenticationRequest.getPassword()); 
	    }
	}


