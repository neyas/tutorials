package com.neyas.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AiService {
  private final OpenAiService openAiService;

  public AiService(@Value("${openai.api.key}") String apiKey) {
    this.openAiService = new OpenAiService(apiKey);
  }

  public List<String> generateSlides(List<String> content) {
    return content.stream()
        .map(this::createSlideContent)
        .collect(Collectors.toList());
  }

  private String createSlideContent(String paragraph) {
    CompletionRequest request = CompletionRequest.builder()
        .model("babbage-002")
        .prompt("Convert the following text into a PowerPoint slide with a title and 3-5 bullet points:\n\n" + paragraph)
        .maxTokens(150)
        .temperature(0.7)
        .build();

    CompletionResult result = openAiService.createCompletion(request);
    return result.getChoices().getFirst().getText();
  }
}
