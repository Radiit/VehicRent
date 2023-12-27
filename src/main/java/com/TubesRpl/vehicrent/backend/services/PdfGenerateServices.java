package com.TubesRpl.vehicrent.backend.services;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface PdfGenerateServices {
    void generatePdfFile(String templateName, Map<String, Object> data, String pdfFileName);
}