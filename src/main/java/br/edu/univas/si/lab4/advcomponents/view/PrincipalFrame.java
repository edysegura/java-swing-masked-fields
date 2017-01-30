package br.edu.univas.si.lab4.advcomponents.view;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.edu.univas.si.lab4.advcomponents.listeners.ButtonsListener;
import br.edu.univas.si.lab4.advcomponents.model.Contact;

public class PrincipalFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private DataPanel dataPanel;
	private ButtonsPanel buttonsPanel;
	
	public PrincipalFrame() {
		setTitle("Advanced Components");
		initialize();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}

	private void initialize() {
		add(getDataPanel(), BorderLayout.CENTER);
		add(getButtonsPanel(), BorderLayout.SOUTH);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}
			@Override
			public void windowClosed(WindowEvent e) {
				JOptionPane.showMessageDialog(PrincipalFrame.this, "All your data has been lost.");
			}
		});
	}

	private void close() {
		int choice = JOptionPane.showConfirmDialog(
			 this, "Do you want really to close this window?", 
			 "Close the window?", 
			 JOptionPane.YES_NO_OPTION, 
			 JOptionPane.QUESTION_MESSAGE);
		if(choice == JOptionPane.YES_OPTION) {
			dispose(); //method responsible to close the frame.
		}
	}

	/**
	 * @return the dataPanel
	 */
	private DataPanel getDataPanel() {
		if(dataPanel == null) {
			dataPanel = new DataPanel();
		}
		return dataPanel;
	}

	/**
	 * @return the buttonsPanel
	 */
	private ButtonsPanel getButtonsPanel() {
		if(buttonsPanel == null) {
			buttonsPanel = new ButtonsPanel();
			buttonsPanel.addButtonsListener(new ButtonsListener() {
				@Override
				public void okAction() {
					Contact contact = getDataPanel().getContact();
					JOptionPane.showMessageDialog(PrincipalFrame.this, contact);
				}
				@Override
				public void cancelAction() {
					close();					
				}
			});
		}
		return buttonsPanel;
	}

}
