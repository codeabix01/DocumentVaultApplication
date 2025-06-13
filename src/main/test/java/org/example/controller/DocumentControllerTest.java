package org.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DocumentController.class)
class DocumentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void upload() throws Exception {
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "test.txt",
                "text/plain",
                "Sample content".getBytes()
        );

        mockMvc.perform(multipart("/documents/upload").file(file))
                .andExpect(status().isOk())
                .andExpect(content().string("Uploaded test.txt"));
    }

    @Test
    void download() throws Exception {
        String filename = "test.txt";

        mockMvc.perform(get("/documents/download/{filename}", filename))
                .andExpect(status().isOk())
                .andExpect(content().string("Pretending to download test.txt"));
    }
}