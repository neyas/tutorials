package com.neyas.service;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentProcessor {
  public List<String> extractTextFromWord(InputStream inputStream) throws IOException {
    try (XWPFDocument document = new XWPFDocument(inputStream)) {
      return document.getParagraphs()
          .stream()
          .map(paragraph -> paragraph.getText().trim())
          .filter(text -> !text.isEmpty())
          .collect(Collectors.toList());
    }
  }
}
