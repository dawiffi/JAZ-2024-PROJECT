package com.example.orders.service;

import com.example.orders.model.Order;
import com.example.orders.repository.OrderRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void generateOrderSummary(){
        List<Order> orders = orderRepository.findAll();
        Document document = null;
        try {
            document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("order_summary.pdf"));
            document.open();
            document.add(new Paragraph("Book orders summary"));
            for (Order order : orders){
                document.add(new Paragraph("Book ID: " + order.getBookId() + ", Book title: " + order.getBookTitle() + ", Quantity: " + order.getQuantityToOrder() + "\n"));
            }
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }finally{
            if (document != null){
                document.close();
            }
        }
    }

    public String generateOrderReport(){
        List <Order> orders = orderRepository.findAll();

        if (orders.isEmpty()){
            return "No orders found";
        }

        StringBuilder report = new StringBuilder();

        for (Order order : orders){
            report.append("Book ID: ").append(order.getBookId()).append(", Book title: ").append(order.getBookTitle()).append(", Quantity: ").append(order.getQuantityToOrder()).append("\n");
        }

        return "Order report generated successfully: " + report.toString();
    }
}
