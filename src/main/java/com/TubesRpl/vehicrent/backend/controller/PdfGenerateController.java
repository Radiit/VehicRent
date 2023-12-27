// package com.TubesRpl.vehicrent.backend.controller;

// import java.io.FileNotFoundException;
// import java.io.FileOutputStream;

// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.thymeleaf.TemplateEngine;
// import org.thymeleaf.context.Context;
// import org.xhtmlrenderer.pdf.ITextRenderer;

// // map
// import java.util.Map;

// import com.TubesRpl.vehicrent.backend.services.PdfGenerateServices;
// import com.lowagie.text.DocumentException;

// import org.springframework.stereotype.Service;

// @Service
// public class PdfGenerateController implements PdfGenerateServices {

// @Autowired
// private TemplateEngine templateEngine;

// @Value("${pdf.directory}")
// private String pdfDirectory;

// @Override
// public void generatePdfFile(String templateName, Map<String, Object> data,
// String pdfFileName) {
// Context context = new Context();
// context.setVariables(data);

// String htmlContent = templateEngine
// .process("/home/abd/Test/radit/VehicRent/src/main/resources/pdf-templates/receipt",
// context);
// try {
// FileOutputStream fileOutputStream = new FileOutputStream(pdfDirectory +
// pdfFileName);
// ITextRenderer renderer = new ITextRenderer();
// renderer.setDocumentFromString(htmlContent);
// renderer.layout();
// renderer.createPDF(fileOutputStream, false);
// renderer.finishPDF();
// } catch (FileNotFoundException e) {
// System.out.println(e.getMessage());
// } catch (DocumentException e) {
// System.out.println(e.getMessage());
// }
// }
// }
