/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author brianyang
 */
public interface dialogClient {
    //launch a JDialog. 
	//It provides call back methods for the Dialog to call to inform the client that
	//the dialog has been OK'ed or Cancelled.
	
	public static enum operation {ADD,UPDATE, DELETE};
	
	public void bookDialogFinished(operation anOperation);
        public void pageDialogFinished(operation anOperation);
	public void dialogCancelled();
}
