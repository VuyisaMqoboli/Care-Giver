/* CareGiverGUI.java
 * This is the caregiver gui section
 * Author: Vuyisa Lutho Mqoboli (219191018)
 * 8 August 2022
*/
package com.mycompany.caregivers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;


public class CareGiverGUI extends JFrame implements ActionListener{
    
    private JPanel panelTop,panelCentre,panelBottom;
    private ImageIcon icon;
    private JLabel lblImage;
    private JLabel lblImageHeader;
    
    private JLabel lblCaregiverCode;
    private JTextField txtCaregiverCode;
    
    private JLabel lblFirstName;
    private JTextField txtFirstName;
    
    private JLabel lblLastName;
    private JTextField txtLastName;
    
    private JLabel lblHasResources;
    private JPanel panelHasResources;
    private JRadioButton radNo;
    private JRadioButton radYes;
    private ButtonGroup hasResourcesButtonGroup;
    
    
    private JButton btnSave;
    private JButton btnReset;
    private JButton btnExit;
    
    private ArrayList<String> caregiverTypeNameList = new ArrayList<>();
    private JLabel lblCaregiverType;
    private JComboBox cmboCaregiverTypeName;
    private Font ft1,ft2;
    
    final String imageUrl = "utensils.jpg";
    
    public CareGiverGUI(){
    super("Caregivers Registration App Version 1.0");
    
    
    ft1 = new Font("Arial", Font.BOLD, 18);
    ft2 = new Font("Arial", Font.PLAIN, 12);
    panelTop = new JPanel();
    panelCentre = new JPanel();
    panelBottom = new JPanel();
    
    icon = new ImageIcon(imageUrl);
    lblImage = new JLabel(icon);
    lblImageHeader = new JLabel("Caregivers Registration System");
    lblImageHeader.setFont(ft1);
    lblImageHeader.setForeground(Color.DARK_GRAY);
    
    
    lblCaregiverCode = new JLabel("Caregiver Code: ");
    txtCaregiverCode = new JTextField(15); 
    lblCaregiverCode.setHorizontalAlignment(JLabel.RIGHT);
    lblCaregiverCode.setFont(ft2);
    lblCaregiverCode.setForeground(Color.yellow);
    
    lblFirstName = new JLabel("First Name: ");
    txtFirstName = new JTextField(15);
    lblFirstName.setHorizontalAlignment(JLabel.RIGHT);
    lblFirstName.setFont(ft2);
    lblFirstName.setForeground(Color.yellow);
    
    lblLastName = new JLabel("Last Name: ");
    txtLastName = new JTextField(15);
    lblLastName.setHorizontalAlignment(JLabel.RIGHT);
    lblLastName.setFont(ft2);
    lblLastName.setForeground(Color.yellow);
    
    lblCaregiverType = new JLabel("Caregiver Type: ");
    cmboCaregiverTypeName = new JComboBox();
    lblCaregiverType.setHorizontalAlignment(JLabel.RIGHT);
    lblCaregiverType.setFont(ft2);
    lblCaregiverType.setForeground(Color.yellow);
    CareGiverDAO.populateComboBox(cmboCaregiverTypeName);
    cmboCaregiverTypeName.setSelectedIndex(1);
    
    lblHasResources = new JLabel("Do you have caregiver equipment: ");
    panelHasResources = new JPanel();
    lblHasResources.setHorizontalAlignment(JLabel.RIGHT);
    lblHasResources.setFont(ft2);
    lblHasResources.setForeground(Color.yellow);
    lblHasResources.setAlignmentY(RIGHT_ALIGNMENT);
    
    radYes = new JRadioButton("Yes");
    radNo = new JRadioButton("No");
    radYes.setFont(ft2);
    radYes.setForeground(Color.yellow);
    radNo.setFont(ft2);
    radNo.setForeground(Color.yellow);
    radYes.setBackground(Color.GRAY);
    radNo.setBackground(Color.GRAY);
    hasResourcesButtonGroup = new ButtonGroup();
    hasResourcesButtonGroup.add(radYes);
    hasResourcesButtonGroup.add(radNo);
    panelHasResources.setLayout(new GridLayout(1, 2));
    radYes.setSelected(true);
    panelHasResources.add(radYes);
    panelHasResources.add(radNo);
    
    btnSave = new JButton("Save");
    btnReset = new JButton("Reset");
    btnExit = new JButton("Exit");
}   
    
    public void setGUI(){
        panelTop.setLayout(new GridLayout(1, 2));
        panelCentre.setLayout(new GridLayout(5, 2));
        panelBottom.setLayout(new GridLayout(1, 3));
        
        panelTop.add(lblImage);
        panelTop.add(lblImageHeader);
        
        panelCentre.add(lblCaregiverCode);
        panelCentre.add(txtCaregiverCode);
                
        panelCentre.add(lblFirstName);
        panelCentre.add(txtFirstName);
        
        panelCentre.add(lblLastName);
        panelCentre.add(txtLastName);
        
        panelCentre.add(lblCaregiverType);
        panelCentre.add(cmboCaregiverTypeName);
        
        panelCentre.add(lblHasResources);
        panelCentre.add(panelHasResources);

        
        panelBottom.add(btnSave);
        panelBottom.add(btnReset);
        panelBottom.add(btnExit);
        
        btnSave.addActionListener(this);
        btnReset.addActionListener(this);
        btnExit.addActionListener(this);
        
        this.panelTop.setBackground(Color.WHITE);
        this.panelCentre.setBackground(Color.GRAY);
        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelCentre, BorderLayout.CENTER);
        this.add(panelBottom, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600, 400));
        panelTop.setPreferredSize(new Dimension(300, 100));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);     
    }
    
    public void resetForm(){
        radYes.setSelected(true);
        txtCaregiverCode.setText(null);
        txtFirstName.setText(null);
        txtLastName.setText(null);
        cmboCaregiverTypeName.setSelectedIndex(1);             
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnSave){
       
                CareGiver caregiver = new CareGiver(txtCaregiverCode.getText(),
                                            txtFirstName.getText(),
                                            txtLastName.getText(),
                                            cmboCaregiverTypeName.getSelectedItem().toString(),
                                            radYes.isSelected()?true:false);
                if(CareGiverDAO.isCaregiverCodeUnique(caregiver)){
                    CareGiverDAO.saveToDataBase(caregiver);
                    resetForm(); 
                }else{
                    JOptionPane.showMessageDialog(this,"This caregiver code exist. Use another code.");
                    resetForm();
                    txtCaregiverCode.requestFocus();
                }
               
            
        }else if(e.getSource() == btnReset){
            resetForm();
        }else if(e.getSource() == btnExit){
            System.exit(0);
            }
    
    }

}
