package controllers;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import models.Model;
import views.View;

public class Controller {
	
	private Model model;
	private View view;
	
	public Controller(Model m, View v) {
		model = m;
		view = v;
		
		model.setId(model.getIds().get(0));
		initView();
	}
	
	public void initView() {
		view.getPersonId().setModel(new DefaultComboBoxModel(model.getIds().toArray()));
		view.getFirstNameTextField().setText(model.getFirstName());
		view.getLastNameTextField().setText(model.getLastName());
	}
	
	public void initController() {
		view.getPersonId().addActionListener(e -> saveId());
		view.getFirstNameSaveButton().addActionListener(e -> saveFirstName());
		view.getLastNameSaveButton().addActionListener(e -> saveLastName());
		view.getHello().addActionListener(e -> sayHello());
		view.getBye().addActionListener(e -> sayBye());
	}
	
	public void saveId() {
		model.setId(Integer.parseInt(view.getPersonId().getSelectedItem().toString()));
		view.getFirstNameTextField().setText(model.getFirstName());
		view.getLastNameTextField().setText(model.getLastName());
	}
	
	public void saveFirstName() {
		model.setFirstName(view.getFirstNameTextField().getText());
		JOptionPane.showMessageDialog(null, "First name saved: " + model.getFirstName());
	}
	
	public void saveLastName() {
		model.setLastName(view.getLastNameTextField().getText());
		JOptionPane.showMessageDialog(null, "Last name saved: " + model.getLastName());
	}

	public void sayHello() {
		JOptionPane.showMessageDialog(null, "Hello, " + model.getFirstName() + " " + model.getLastName());
	}
	
	public void sayBye() {
		System.exit(0);
	}
	
}
