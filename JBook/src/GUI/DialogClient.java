/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Source.Book;
import Source.Page;

/**
 *
 * @author brianyang
 */
public interface DialogClient {
	
	
    public static enum operation {AddBook,AddPage,update,Delete};
    public void AddBookdialogFinished (operation anOperation,Book b);
    public void AddPagedialogFinished (operation anOperation,Page p);
    public void addPageDialogCancelled();
    public void AddBookdialogCancelled();
    
    
}
