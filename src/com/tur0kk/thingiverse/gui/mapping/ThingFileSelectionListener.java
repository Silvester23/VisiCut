/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tur0kk.thingiverse.gui.mapping;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Sven
 */
public class ThingFileSelectionListener implements ListSelectionListener
{
  JButton btnOpenFile;;
  
  public ThingFileSelectionListener(JButton btnOpenFile){
    this.btnOpenFile = btnOpenFile;
  }
  public void valueChanged(ListSelectionEvent e)
  {
    boolean adjust = e.getValueIsAdjusting();
    if (!adjust) // wait until list finisehd adjusting
    {
      // get selected list element
      JList list = (JList) e.getSource();
      int selection = list.getSelectedIndex();
          
      if(selection != -1){ // something is selected
        this.btnOpenFile.setEnabled(true);
      }
      else{
        // nothing is selected
        this.btnOpenFile.setEnabled(false); // to upload "I made one" a thing must be selected
      }
    }
  }
  
}
