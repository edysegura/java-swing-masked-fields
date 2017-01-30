package br.edu.univas.si.lab4.advcomponents.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.edu.univas.si.lab4.advcomponents.listeners.ButtonsListener;

public class ButtonsPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton okButton;
	private JButton cancelButton;
	
	private ArrayList<ButtonsListener> listeners = 
		new ArrayList<ButtonsListener>();
	
	public ButtonsPanel() {
		initialize();
	}

	private void initialize() {
		add(getOkButton());
		add(getCancelButton());
	}

	/**
	 * @return the okButton
	 */
	private JButton getOkButton() {
		if(okButton == null) {
			okButton = new JButton();
			okButton.setText("OK");
			okButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (ButtonsListener listener : listeners) {
						if(listener != null) {
							listener.okAction();
						}
					}
				}
			});
		}
		return okButton;
	}

	/**
	 * @return the cancelButton
	 */
	private JButton getCancelButton() {
		if(cancelButton == null) {
			cancelButton = new JButton();
			cancelButton.setText("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (ButtonsListener listener : listeners) {
						if(listener != null) {
							listener.cancelAction();
						}
					}
				}
			});
		}
		return cancelButton;
	}
	
	/**
	 * Method to add listener for the buttons
	 * @param listener
	 */
	public void addButtonsListener(ButtonsListener listener) {
		if(listener != null) {
			listeners.add(listener);
		}
	}
	
	
}
