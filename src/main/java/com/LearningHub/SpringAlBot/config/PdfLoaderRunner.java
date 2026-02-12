package com.LearningHub.SpringAlBot.config;

import com.LearningHub.SpringAlBot.service.PdfInjectionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PdfLoaderRunner implements CommandLineRunner {

    private final PdfInjectionService pdfInjectionService;

    public PdfLoaderRunner(PdfInjectionService pdfInjectionService) {
        this.pdfInjectionService = pdfInjectionService;
    }


    @Override
    public void run(String... args) throws Exception {
        pdfInjectionService.ingestPdf("C:/Users/HP/Downloads/Shyam_Sah_Detailed_Profile.pdf");
    }
}
