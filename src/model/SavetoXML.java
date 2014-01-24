/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import main.Book;
import main.Page;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author brianyang
 */
public class SavetoXML {
    
    public SavetoXML(ArrayList<Book> bookResult, ArrayList<Page> pageResult,File f){
        
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        
        try {
            
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            // root elements
		Document doc = docBuilder.newDocument();
		Element result = doc.createElement("dataBase");
		doc.appendChild(result);
                
                Element bookList = doc.createElement("BookList");
                result.appendChild(bookList);
                
                Element pageList = doc.createElement("PageList");
                result.appendChild(pageList);
                
                for(Book b: bookResult){
                   //book Element;
                    Element book = doc.createElement("Book");
                    bookList.appendChild(book);
                    
                    book.setAttribute("code",b.getBookCode());
                 
                    //book title element;
                    Element title = doc.createElement("Booktitle");
                    title.appendChild(doc.createTextNode(b.getBookName()));
                    book.appendChild(title);
                    
                    Element path = doc.createElement("Bookpath");
                    path.appendChild(doc.createTextNode(b.getBookPath()));
                    book.appendChild(path);
                    
                    Element author = doc.createElement("Bookauthor");
                    author.appendChild(doc.createTextNode(b.getAuthor()));
                    book.appendChild(author);
                    
                    Element startpage = doc.createElement("BookFirstpage");
                    startpage.appendChild(doc.createTextNode(b.getInitPage()+""));
                    book.appendChild(startpage);
                }
                
                for(Page p: pageResult){
                   //book Element;
                    Element page = doc.createElement("Page");
                    pageList.appendChild(page);
                    
                    page.setAttribute("id",p.getPageID()+"");
                 
                    //book title element;
                    Element title = doc.createElement("Title");
                    title.appendChild(doc.createTextNode(p.getPageTitle()));
                    page.appendChild(title);
                    
                    
                    
                    Element code = doc.createElement("BookCode");
                    code.appendChild(doc.createTextNode(p.getBookCode()));
                    page.appendChild(code);
                    
                    Element pagenum = doc.createElement("pageNum");
                    pagenum.appendChild(doc.createTextNode(p.getPageNum()+""));
                    page.appendChild(pagenum);
                }
                
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult output = new StreamResult(new File(f.getPath()));
                transformer.transform(source, output);
		System.out.println("File saved!");
                
                
                }catch (ParserConfigurationException ex) {
            Logger.getLogger(SavetoXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(SavetoXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(SavetoXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
