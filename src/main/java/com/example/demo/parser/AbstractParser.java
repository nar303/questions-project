package com.example.demo.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractParser<T> {

    public List<T> parse(String filePath) throws Exception {
        try {
            Document doc = makeDocumentByFilePath(filePath);
            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("row");
            return mapNodesToDtos(nodes);
        }
        catch (ParserConfigurationException parserConfigurationException){
            System.out.println("Something went wrong with function dbFactory.newDocumentBuilder()");
            parserConfigurationException.printStackTrace();
            throw new Exception("Parsing not done",parserConfigurationException);
        }
        catch (SAXException saxException){
            System.out.println("Something went wrong with function dBuilder.parse()");
            saxException.printStackTrace();
            throw new Exception("Parsing not done",saxException);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception("Parsing not done",e);
        }
    }

    public Document makeDocumentByFilePath(String filePath) throws ParserConfigurationException, SAXException, IOException {
        File fXmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(fXmlFile);
        return document;
    }

    public List<T> mapNodesToDtos(NodeList nodes) {
        List<T> dtos = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                dtos.add(mapElementToDto(element));
            }
        }
        return dtos;
    }

    public abstract T mapElementToDto(Element element);
}