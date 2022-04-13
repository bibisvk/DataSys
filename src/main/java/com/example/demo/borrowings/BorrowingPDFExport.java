package com.example.demo.borrowings;

import com.example.demo.cars.CarEntity;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import lombok.Setter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Setter
public class BorrowingPDFExport {
    private List<BorrowingEntity> borrowingEntityList;

    public void generate(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN, Font.BOLD);
        fontTitle.setSize(20);

        Paragraph paragraph = new Paragraph("Zoznam vypoziciek", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new int[] {1,2,2,3,3});
        table.setSpacingBefore(5);

        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Zakaznik", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Auto", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Zaciatok vypozicky", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Koniec vypozicky", font));
        table.addCell(cell);

        for(BorrowingEntity borrowingEntity : borrowingEntityList){
            table.addCell(String.valueOf(borrowingEntity.getBorrowingId()));
            table.addCell(String.valueOf(borrowingEntity.getBorrower()));
            table.addCell(String.valueOf(borrowingEntity.getBorrowedCar()));
            table.addCell(String.valueOf(borrowingEntity.getBorrowingStartDate()));
            table.addCell(String.valueOf(borrowingEntity.getBorrowingEndDate()));
        }

        document.add(table);
        document.add(new Paragraph(" "));
        document.add(new Paragraph("___________________"));
        document.add(new Paragraph("Podpísaný/á"));
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String currentDateTime = dateFormat.format(new Date());
        document.add(new Paragraph(currentDateTime));
        document.close();
    }
}
