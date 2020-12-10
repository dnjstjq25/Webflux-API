package com.webflux.api;

import com.webflux.api.controller.APIController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.awt.*;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;

@WebMvcTest(APIController.class)
@AutoConfigureRestDocs
public class ApiApplicationTests {

	/*@Autowired
	MockMvc mockMvc;
	private String version_id;
	private String updated;
	private String version;
	private String up_url;
	private String up_title;
	private String up_info;
	private String pop;
	private String pop_url;
	@Test
	public void test() {
		mockMvc.perform(get("/version")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(document("version",
					responseFields(
						fieldWithPath("version_id").description("버전_ID"),
						fieldWithPath("").description(""),
					)
				))

	}*/

}
