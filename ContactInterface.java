import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.EventListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JTable;

public class ContactInterface extends JFrame implements ActionListener {
    private static JTextField txtIdNo, txtLName, txtFName, txtContact, txtLocation, searchIDTxt;
    private static JButton btnAdd, btnSubmit, btnCancel, btnDispAll, btnExit, btnToSearch;
    private static JFrame frame;
    private static JPanel panel, panelAdd, panelSearch, panelDisplay;
    private static JLabel lblTitle, sLName, sFName, sContact, sLocation;
    private static JTable table;
    
    public static void main(String[] args){
        frame=new JFrame();
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel=new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JLabel lblTitle=new JLabel("CONTACT MANAGEMENT SYSTEM");
        lblTitle.setFont(new Font("ARIAL",Font.BOLD,16));
        lblTitle.setBounds(115, 10, 300, 20);
        panel.add(lblTitle);

        JButton btnAdd=new JButton("Add Contact");
        btnAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panelAdd=new JPanel();
                    panelAdd.setLayout(null);
                    frame.add(panelAdd);

                    JLabel lblTitle=new JLabel("CONTACT MANAGEMENT SYSTEM");
                    lblTitle.setFont(new Font("ARIAL",Font.BOLD,16));
                    lblTitle.setBounds(115, 10, 300, 20);
                    panelAdd.add(lblTitle);

                    JLabel lblIdNo=new JLabel("ID No.");
                    lblIdNo.setFont(new Font("ARIAL",Font.PLAIN,14));
                    lblIdNo.setBounds(120, 35, 100, 80);
                    panelAdd.add(lblIdNo);

                    txtIdNo=new JTextField();
                    txtIdNo.setBounds(220, 60, 160, 25);
                    panelAdd.add(txtIdNo);

                    JLabel lblLName=new JLabel("Last Name");
                    lblLName.setFont(new Font("ARIAL",Font.PLAIN,14));
                    lblLName.setBounds(120, 75, 100, 80);
                    panelAdd.add(lblLName);

                    txtLName=new JTextField();
                    txtLName.setBounds(220, 100, 160, 25);
                    panelAdd.add(txtLName);

                    JLabel lblFName=new JLabel("First Name");
                    lblFName.setFont(new Font("ARIAL",Font.PLAIN,14));
                    lblFName.setBounds(120, 115, 100, 80);
                    panelAdd.add(lblFName);

                    txtFName=new JTextField();
                    txtFName.setBounds(220, 140, 160, 25);
                    panelAdd.add(txtFName);

                    JLabel lblContact=new JLabel("Contact No. ");
                    lblContact.setFont(new Font("ARIAL",Font.PLAIN,14));
                    lblContact.setBounds(120, 155, 100, 80);
                    panelAdd.add(lblContact);

                    txtContact=new JTextField();
                    txtContact.setBounds(220, 180, 160, 25);
                    panelAdd.add(txtContact);

                    JLabel lblLocation=new JLabel("Location");
                    lblLocation.setFont(new Font("ARIAL",Font.PLAIN,14));
                    lblLocation.setBounds(120, 190, 100, 80);
                    panelAdd.add(lblLocation);

                    txtLocation=new JTextField();
                    txtLocation.setBounds(220, 220, 160, 25);
                    panelAdd.add(txtLocation);

                    btnSubmit=new JButton("Submit");
                    btnSubmit.setBounds(115, 280, 125, 30);
                    btnSubmit.addActionListener(new ContactInterface());
                    panelAdd.add(btnSubmit);

                    JButton btnCancel=new JButton("Cancel");
                    btnCancel.setBounds(255, 280, 125, 30);
                    btnCancel.addActionListener(new ContactInterface());
                    panelAdd.add(btnCancel);

                    panel.setVisible(false);
                    panelAdd.setVisible(true);

                    btnCancel.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                panel.setVisible(true);
                                panelAdd.setVisible(false);
                            }
                        });
                }
            });

        btnAdd.setBounds(155, 60, 200, 35);
        panel.add(btnAdd);

        JButton btnSearch=new JButton("Search Contact");
        btnSearch.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panelSearch = new JPanel();
                    panelSearch.setLayout(null);
                    frame.add(panelSearch);

                    JLabel lblTitle=new JLabel("CONTACT MANAGEMENT SYSTEM");
                    lblTitle.setFont(new Font("ARIAL",Font.BOLD,16));
                    lblTitle.setBounds(115, 10, 300, 20);
                    panelSearch.add(lblTitle);

                    JLabel idSearch=new JLabel("Search ID:");
                    idSearch.setFont(new Font("ARIAL",Font.BOLD,14));
                    idSearch.setBounds(120, 35, 100, 80);
                    panelSearch.add(idSearch);

                    searchIDTxt = new JTextField("");
                    searchIDTxt.setBounds(220, 60, 160, 25);
                    panelSearch.add(searchIDTxt);

                    // Last name
                    JLabel lstName =new JLabel("Last name:");
                    lstName.setFont(new Font("ARIAL",Font.BOLD,14));
                    lstName.setBounds(120, 70, 100, 80);
                    panelSearch.add(lstName);
                    sLName=new JLabel();
                    sLName.setFont(new Font("ARIAL",Font.PLAIN,14));
                    sLName.setBounds(220, 70, 400, 80);
                    panelSearch.add(sLName);

                    // First name
                    JLabel fstName =new JLabel("First name:");
                    fstName.setFont(new Font("ARIAL",Font.BOLD,14));
                    fstName.setBounds(120, 105, 100, 80);
                    panelSearch.add(fstName);
                    sFName=new JLabel();
                    sFName.setFont(new Font("ARIAL",Font.PLAIN,14));
                    sFName.setBounds(220, 105, 400, 80);
                    panelSearch.add(sFName);

                    // Contact
                    JLabel cntText =new JLabel("Contact:");
                    cntText.setFont(new Font("ARIAL",Font.BOLD,14));
                    cntText.setBounds(120, 140, 100, 80);
                    panelSearch.add(cntText);
                    sContact=new JLabel();
                    sContact.setFont(new Font("ARIAL",Font.PLAIN,14));
                    sContact.setBounds(220, 140, 400, 80);
                    panelSearch.add(sContact);

                    // Location
                    JLabel lctText =new JLabel("Location:");
                    lctText.setFont(new Font("ARIAL",Font.BOLD,14));
                    lctText.setBounds(120, 175, 100, 80);
                    panelSearch.add(lctText);
                    sLocation=new JLabel();
                    sLocation.setFont(new Font("ARIAL",Font.PLAIN,14));
                    sLocation.setBounds(220, 175, 400, 80);
                    panelSearch.add(sLocation);

                    btnToSearch=new JButton("Search");
                    btnToSearch.setBounds(115, 280, 125, 30);
                    btnToSearch.addActionListener(new ContactInterface());
                    panelSearch.add(btnToSearch);

                    JButton btnCancel=new JButton("Cancel");
                    btnCancel.setBounds(255, 280, 125, 30);
                    btnCancel.addActionListener(new ContactInterface());
                    panelSearch.add(btnCancel);

                    panel.setVisible(false);
                    panelSearch.setVisible(true);

                    btnCancel.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                panel.setVisible(true);
                                panelSearch.setVisible(false);
                            }
                        });
                }
            });
        btnSearch.setBounds(155, 105, 200, 35);
        panel.add(btnSearch);
        // JButton btnUpdate=new JButton("Update Contact");
        // btnUpdate.setBounds(155, 150, 200, 35);
        // //btnUpdate.addActionListener(new ContactInterface());
        // panel.add(btnUpdate);

        // JButton btnDelete=new JButton("Delete Contact");
        // btnDelete.setBounds(155, 195, 200, 35);
        // //btnDelete.addActionListener(new ContactInterface());
        // panel.add(btnDelete);

        // Display all
        btnDispAll=new JButton("Diplay All Contact");
        btnDispAll.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
 
                    CMSModules cm = new CMSModules();
                    panelDisplay = new JPanel();
                    panelDisplay.setLayout(null);
                    frame.add(panelDisplay);
        
                    JLabel lblTitle=new JLabel("CONTACT MANAGEMENT SYSTEMS");
                    lblTitle.setFont(new Font("ARIAL",Font.BOLD,16));
                    lblTitle.setBounds(115, 10, 300, 20);
                    panelDisplay.add(lblTitle);
                    
                    String[] columnNames= {"ID Number","First Name","Last Name","Contact Number","Adress"};
                    Object[][] data = cm.displayAll();
                
                    table = new JTable(data, columnNames);
                    frame.add(new JScrollPane(table));

                    panel.setVisible(false);
                    panelDisplay.setVisible(true);
                }
            });
        btnDispAll.setBounds(155, 150, 200, 35);
        btnDispAll.addActionListener(new ContactInterface());
        panel.add(btnDispAll);

        btnExit=new JButton("EXIT");
        btnExit.setBounds(155, 200, 200, 35);
        btnExit.addActionListener(new ContactInterface());
        panel.add(btnExit);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnExit){
            System.exit(0);
        }

        if(e.getSource()==btnToSearch){
            CMSModules cms=new CMSModules();
            if(searchIDTxt.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter an ID No.","Error",JOptionPane.WARNING_MESSAGE);
                searchIDTxt.requestFocus();
            } else cms.searchData(searchIDTxt.getText());
        }

        
        if(e.getSource()==btnSubmit){
            CMSModules cms=new CMSModules();
            String idno, lastname, firstname, contact, location;
            if(txtIdNo.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter ID No.","Error",JOptionPane.WARNING_MESSAGE);
                txtIdNo.requestFocus();
            }
            else if(txtLName.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter Last Name","Error",JOptionPane.WARNING_MESSAGE);
                txtLName.requestFocus();
            }
            else if(txtFName.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter First Name","Error",JOptionPane.WARNING_MESSAGE);
                txtFName.requestFocus();
            }
            else if(txtContact.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter Contact","Error",JOptionPane.WARNING_MESSAGE);
                txtContact.requestFocus();
            }
            else if(txtLocation.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter Location","Error",JOptionPane.WARNING_MESSAGE);
                txtLocation.requestFocus();
            }
            else{

                idno = txtIdNo.getText();
                lastname = txtLName.getText();
                firstname = txtFName.getText();
                contact = txtContact.getText();
                location = txtLocation.getText();
                cms.addData(idno, lastname, firstname, contact, location);

                txtIdNo.setText("");
                txtLName.setText("");
                txtFName.setText("");
                txtContact.setText("");
                txtLocation.setText("");
            }

            if(e.getSource()==btnDispAll){
                //String data = cms.displayAll();
            }
        }

    }
    // Setters
    public void setSLName(String sLName) {this.sLName.setText(sLName);}

    public void setSFName(String sFName){this.sFName.setText(sFName);}

    public void setSContact(String sContact){this.sContact.setText(sContact);}

    public void setSLocation(String sLocation){this.sLocation.setText(sLocation);}

    public void displayError() {
        JOptionPane.showMessageDialog(null,"DATA NOT FOUND!","No Data",JOptionPane.WARNING_MESSAGE);
        this.sLName.setText("");
        this.sFName.setText("");
        this.sContact.setText("");
        this.sLocation.setText("");
    }
}

