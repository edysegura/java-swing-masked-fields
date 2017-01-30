package br.edu.univas.si.lab4.advcomponents.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.edu.univas.si.lab4.advcomponents.model.Contact;

public class DataPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final String ZIPCODE_MASK = "#####-###";
	private static final String PHONE_MASK = "(##) #####-####";

	
	private JLabel phone1Label;
	private JLabel phone2Label;
	private JLabel zipCodeLabel;
	private JLabel stateLabel;
	
	private JFormattedTextField phone1Field;
	private JFormattedTextField phone2Field;
	private JFormattedTextField zipCodeField;
	private JComboBox<String> stateCombo;
	
	public DataPanel() {
		setLayout(getGridLayout());
		setBorder(getPanelBorder());
		initialize();
	}

	private void initialize() {
		add(getPhone1Label());
		add(getPhone1Field());
		
		add(getPhone2Label());
		add(getPhone2Field());
		
		add(getZipCodeLabel());
		add(getZipCodeField());
		
		add(getStateLabel());
		add(getStateCombo());
	}

	
	/**
	 * @return the phone1Label
	 */
	private JLabel getPhone1Label() {
		if(phone1Label == null) {
			phone1Label = new JLabel();
			phone1Label.setText("Phone 1");
		}
		return phone1Label;
	}

	/**
	 * @return the phone2Label
	 */
	private JLabel getPhone2Label() {
		if(phone2Label == null) {
			phone2Label = new JLabel();
			phone2Label.setText("Phone 2");
		}
		return phone2Label;
	}

	/**
	 * @return the zipCodeLabel
	 */
	private JLabel getZipCodeLabel() {
		if(zipCodeLabel == null) {
			zipCodeLabel = new JLabel();
			zipCodeLabel.setText("Zip Code");
		}
		return zipCodeLabel;
	}

	/**
	 * @return the stateLabel
	 */
	private JLabel getStateLabel() {
		if(stateLabel == null) {
			stateLabel = new JLabel();
			stateLabel.setText("State");
		}
		return stateLabel;
	}

	/**
	 * @return the phone1
	 */
	private JFormattedTextField getPhone1Field() {
		if(phone1Field == null) {
			phone1Field = new JFormattedTextField(
			  createFormatter(PHONE_MASK)
			);
			phone1Field.setToolTipText("eg: (35)8828-1250");
		}
		return phone1Field;
	}

	/**
	 * @return the phone2
	 */
	private JFormattedTextField getPhone2Field() {
		if(phone2Field == null) {
			phone2Field = new JFormattedTextField(
			  createFormatter(PHONE_MASK)
			);
			phone2Field.setToolTipText("eg: (35)8828-1250");
		}
		return phone2Field;
	}

	/**
	 * @return the zipCode
	 */
	private JFormattedTextField getZipCodeField() {
		if(zipCodeField == null) {
			zipCodeField = new JFormattedTextField(
			  createFormatter(ZIPCODE_MASK)
			);
			zipCodeField.setToolTipText("eg: 37550-000");
		}
		return zipCodeField;
	}

	/**
	 * @return the state
	 */
	private JComboBox<String> getStateCombo() {
		if(stateCombo == null) {
			//TODO extract this code to another method
			String[] states = {
			  "",
			  "MG",
			  "SP",
			  "RJ",
			  "ES"
			};
			stateCombo = new JComboBox<String>(states);
		}
		return stateCombo;
	}
	
	
	private MaskFormatter createFormatter(String mask) {
		MaskFormatter mf = new MaskFormatter();
		try {
			mf.setMask(mask);
			mf.setPlaceholderCharacter('_');
		} 
		catch (Exception e) {
			System.err.println("The mask " + mask + " is bad");
		}
		return mf;
	}

	private Border getPanelBorder() {
		int space = 5;
		
		EmptyBorder outsideBorder = 
			new EmptyBorder(space, space, space, space);
		
		EmptyBorder insideBorder = 
			new EmptyBorder(space, space, space, space);
		
		LineBorder lineBorder = new LineBorder(Color.RED);
		
		TitledBorder titledBorder = 
			new TitledBorder(lineBorder, "Contact Data");
		
		CompoundBorder compoundSmall = 
			new CompoundBorder(outsideBorder, titledBorder);
		
		CompoundBorder compoundAll = 
			new CompoundBorder(compoundSmall, insideBorder);
		
		return compoundAll;
	}

	private LayoutManager getGridLayout() {
		GridLayout gl = new GridLayout();
		gl.setColumns(2);
		gl.setRows(4);
		int gap = 5;
		gl.setHgap(gap);
		gl.setVgap(gap);
		return gl;
	}
	
	public Contact getContact() {
		Contact contact = new Contact();
		contact.setPhone1(getPhone1Field().getText());
		contact.setPhone2(getPhone2Field().getText());
		contact.setZipCode(getZipCodeField().getText());
		contact.setState((String)getStateCombo().getSelectedItem());
		return contact;
	}

}
