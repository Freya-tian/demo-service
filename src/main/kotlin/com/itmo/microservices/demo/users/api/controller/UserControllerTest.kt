package com.itmo.microservices.demo.users.api



import com.itmo.microservices.demo.DemoServiceApplication

import com.itmo.microservices.demo.users.api.service.UserService

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc


import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles

import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders



@ActiveProfiles("dev")
@RunWith(SpringRunner::class)
@SpringBootTest(classes = [DemoServiceApplication::class])
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    lateinit var userService: UserService
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun register() {
//        val om : ObjectMapper;
//        val re = RegistrationRequest(name = "rq",surname = "yy",username = "123",email = "123@145.com",password = "123");
//        val res= userService.registerUser(re)
//        print(res)
          mockMvc.perform(
            MockMvcRequestBuilders.post("http://127.0.0.1:8080/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        "\"username\": \"t\",\n" +
                        "  \"name\": \"q\",\n" +
                        "  \"surname\":\"t\",\n" +
                        "  \"email\": \"91@qq.com\",\n" +
                        "  \"password\": \"32\n"
                        )
                .accept(MediaType.APPLICATION_JSON)
        ).andReturn()
            .response
            .apply(::println)

    }

    @Test
    fun getAccountData() {
        mockMvc.perform(
            MockMvcRequestBuilders.get("/users/me")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andReturn()
            .response
            .apply(::println)

    }

    @Test
    fun deleteCurrentUser() {
        mockMvc.perform(
            MockMvcRequestBuilders.delete("/users/me")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andReturn()
            .response
            .apply(::println)

    }
}