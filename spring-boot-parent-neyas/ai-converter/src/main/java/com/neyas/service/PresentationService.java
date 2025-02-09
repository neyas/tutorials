package com.neyas.service;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PresentationService {

  public byte[] createPresentation(List<String> slideContents) throws IOException {
    try (XMLSlideShow ppt = new XMLSlideShow()) {
      for (String slideContent : slideContents) {
        XSLFSlide slide = ppt.createSlide();
        XSLFTextBox textBox = slide.createTextBox();
        textBox.setText(slideContent);
      }
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      ppt.write(outputStream);
      return outputStream.toByteArray();
    }
  }
}
