/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

/**
 *
 * @author brianyang
 */
public interface DialogClient {
    public static enum operation {update,Delete};
    public void dialogFinished (operation anOperation);
    public void dialogCancelled();
    
    
}
