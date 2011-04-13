package com.prefabsoft.dev.util;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.IntellitypeListener;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Dimension;

public class PrefabToolGui extends JFrame implements HotkeyListener,
		IntellitypeListener {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField jTextField = null;
	private JTextArea jTextArea = null;

	public void onIntellitype(int arg0) {
		// TODO Auto-generated method stub

	}

	public void onHotKey(int arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField("shortcut");
			
			KeyListener keyListener = new KeyListener() {
			      public void keyPressed(KeyEvent keyEvent) {
//			        printIt("Pressed", keyEvent);
			      }

			      public void keyReleased(KeyEvent keyEvent) {
//			        printIt("Released", keyEvent);
			      }

			      public void keyTyped(KeyEvent keyEvent) {
			        printIt("Typed", keyEvent);
			      }


			    };
			
			jTextField.addKeyListener(keyListener);
		}
		return jTextField;
	}

	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea(20,50);
		}
		return jTextArea;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PrefabToolGui thisClass = new PrefabToolGui();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public PrefabToolGui() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(778, 391);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		

	}

    private void printIt(String title, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        String keyText = KeyEvent.getKeyText(keyCode);
        System.out.println(title + " : " + keyText + " / " + keyEvent.getKeyChar());
        System.out.println(KeyEvent.getKeyModifiersText(keyEvent.getModifiers()));
        System.out.println(keyEvent.getKeyCode());
      }
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
//			jContentPane.setLayout(new FlowLayout());
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJTextArea(), null);
			
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
