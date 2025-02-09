package com.neyas.controller;

import com.neyas.service.DocumentProcessor;
import com.neyas.service.AiService;
import com.neyas.service.PresentationService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PresentationController {
  private final DocumentProcessor documentProcessor;
  private final AiService aiService;
  private final PresentationService presentationService;

  @PostMapping("/generate-ppt")
  public ResponseEntity<Resource> generatePpt(@RequestParam("file") MultipartFile file) {
    try (InputStream inputStream = file.getInputStream()) {
      List<String> content = documentProcessor.extractTextFromWord(inputStream);
      List<String> slideContents = aiService.generateSlides(content);
      byte[] pptData = presentationService.createPresentation(slideContents);

      ByteArrayResource resource = new ByteArrayResource(pptData);
      return ResponseEntity.ok()
          .contentType(MediaType.APPLICATION_OCTET_STREAM)
          .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"presentation.pptx\"")
          .body(resource);
    } catch (IOException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }
}
