package com.LearningHub.SpringAlBot.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PdfInjectionService {

    private final VectorStore vectorStore;

    public PdfInjectionService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }


    // Ingest the PDF doc into vector databse
    public void ingestPdf(String filePath) throws IOException {
        File file = new File(filePath);
        PDDocument document = PDDocument.load(file);
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);

        document.close();

        List<Document> documents = chunkText(text, 800);

        vectorStore.add(documents);

        System.out.println("PDF content inserted into Pinecone!");

    }

    private List<Document> chunkText(String text, int chunkSize) {

        List<Document> chunks = new ArrayList<>();
        int start = 0;

        while (start < text.length()) {
            int end = Math.min(start + chunkSize, text.length());
            String chunk = text.substring(start, end);
            chunks.add(new Document(chunk));
            start = end;
        }

        return chunks;
    }
}
