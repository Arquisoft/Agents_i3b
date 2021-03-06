package uniovi.es;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import uniovi.es.entities.Agent;
import uniovi.es.services.AgentsService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class APIControllerTest {

    private MockMvc mockMvc;
    
    // Log
    private static final Logger LOG = LoggerFactory.getLogger(APIControllerTest.class);

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private AgentsService agentsService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testDatabase() throws Exception {
    	Agent user = new Agent("11111111A","123456","Pepe","mail@mail.com","Oviedo","Person","1");
        agentsService.deleteUser(user);
        agentsService.insertUser(user);
        
        Agent userFromDB = agentsService.getAgent("11111111A", "123456", "1");
        assertThat(user.getId(), equalTo(userFromDB.getId()));
        assertThat(user.getPassword(), equalTo(userFromDB.getPassword()));
        assertThat(user.getKind(), equalTo(userFromDB.getKind()));  

    }

    @Test
    public void postTestUser() throws Exception {
		  Agent user = new Agent("11111111A","123456","Pepe","mail@mail.com","Oviedo","Person","1");
		  agentsService.deleteUser(user);
		  agentsService.insertUser(user);
		  try {
		  mockMvc.perform(post("/checkAgent")
		          .content("{ \"login\": \"11111111A\", \"password\": \"123456\", \"kind\": \"1\"}")
		          .contentType(new MediaType(MediaType.APPLICATION_JSON.getType(),
		                  MediaType.APPLICATION_JSON.getSubtype(),
		                  Charset.forName("utf8"))))
		          .andExpect(status().isOk());
		  }catch(Exception e)
		  {
			  LOG.error(e.getMessage(), e);
		  }
    }

    @Test
    public void postTestNotFoundUser() throws Exception {
        mockMvc.perform(post("/checkAgent")
                .content("{ \"login\": \"11111111A\", \"password\": \"123456\", \"kind\": \"3\"}")
                .contentType(new MediaType(MediaType.APPLICATION_JSON.getType(),
                        MediaType.APPLICATION_JSON.getSubtype(),
                        Charset.forName("utf8"))))
                .andExpect(status().isNotFound()
                );

    }


}
