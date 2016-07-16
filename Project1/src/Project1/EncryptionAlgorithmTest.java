package Project1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class EncryptionAlgorithmTest {

	static String filePath;
	static String masterKey;
	
	public static void main(String[] args) {
		
		 Runnable r = new Runnable() {
			public void run() {
				
				final JLabel lblKeyIsIncorrect;
				final JLabel lblKeyIsIncorrect1;
				final JLabel lblFile;
				final JLabel lblFile1;
				final JTextField fileField;
				final JTextField fileField1;
				final JLabel lblKey;
				final JLabel lblKey1;
				final JPasswordField passwordField;
				final JPasswordField passwordField1;
				final JButton btnNewButton;
				final JButton btnEncryptPasswordFile;
				final JButton btnDecryptPassword;
				final JButton button;
				final JButton btnAdd;
				final JButton btnDelete;
				final JButton btnModify;
				final JTable table;
				final DefaultTableModel model;
				
				    
				final JFrame frame = new JFrame("Password Database Management");
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		        final JPanel gui = new JPanel(new BorderLayout(5,5));
		        gui.setBorder( new TitledBorder(" ") );
			    
		        //*********************************************Open an existing password file Panel
		        lblFile = new JLabel("File Location:");
		        lblFile.setFont(new Font("Times New Roman", Font.BOLD, 16));
				lblFile.setBounds(28, 18, 52, 27);
				
				fileField = new JTextField();
				fileField.setBounds(150, 18, 52, 27);
				fileField.setColumns(10);
				
				 button = new JButton("Browse");
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							final JFileChooser fc = new JFileChooser();
				            fc.showOpenDialog(frame);

				            try {
				                // Open an input stream
				                Scanner reader = new Scanner(fc.getSelectedFile());
				                File file = fc.getSelectedFile();
				                fileField.setText(file.toString());
				                
				            }
				            catch (Exception e){
				            	System.out.println(e);
				            }
						
						}
					});
					button.setBounds(443, 120, 104, 23);
				
				
				lblKey = new JLabel("Key:");
				lblKey.setFont(new Font("Times New Roman", Font.BOLD, 16));
				lblKey.setBounds(28, 50, 52, 27);
				
				passwordField = new JPasswordField();
				passwordField.setBounds(150,50,52,27);
				passwordField.setColumns(10);
				
				lblKeyIsIncorrect = new JLabel("Key is incorrect");
				lblKeyIsIncorrect.setBounds(150,120,52,27);
				lblKeyIsIncorrect.setForeground(Color.RED);
				lblKeyIsIncorrect.setVisible(false);
				
				btnDecryptPassword = new JButton("Decrypt Password File");
				btnDecryptPassword.setBounds(150, 100, 52, 27);
				
				JPanel newOpen = new JPanel(new GridLayout(1,2));
				JPanel openComp = new JPanel(new GridLayout(3,1));
                openComp.setBorder(
                    new TitledBorder("Open an existing Password File") );
                openComp.add(lblFile);
                openComp.add(fileField);
                openComp.add(button);
                openComp.add(lblKey);
                openComp.add(passwordField);
                openComp.add(btnDecryptPassword);
                openComp.add(lblKeyIsIncorrect);
                newOpen.add(openComp);
                   
                
                
		        //*********************************************Create a new password file Panel
                lblFile1 = new JLabel("File Location:");
				lblFile1.setBounds(88, 126, 97, 16);
				lblFile1.setFont(new Font("Times New Roman", Font.BOLD, 16));
				
				fileField1 = new JTextField();
				fileField1.setBounds(239, 120, 160, 28);
				fileField1.setColumns(10);
                    
				btnNewButton = new JButton("Browse");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JFileChooser fileChooser = new JFileChooser();
		            	fileChooser.setDialogTitle("Specify the database you want to open");   
						int userSelection = fileChooser.showSaveDialog(frame);
                        filePath = fileChooser.getSelectedFile().getAbsolutePath();
			            try {
			            	if(!fileChooser.getSelectedFile().exists()) {
			            		
				            	 if (userSelection == JFileChooser.APPROVE_OPTION) {
				            	    File fileToSave = fileChooser.getSelectedFile();
				            	    fileField1.setText(fileToSave.getAbsolutePath());
				            	    File db = new File (fileToSave.getAbsolutePath());
				            	    db.createNewFile();
				            	   
				            	}
			            	}
				             else {
				            		 JOptionPane.showMessageDialog(frame, "File already exists! Select a new file", "Error", JOptionPane.ERROR_MESSAGE);
				            	}

			                
			            }
			            catch (Exception e){
			            	System.out.println(e);
			            }
					}
				});
				
				lblKey1 = new JLabel("Master Key:");
				lblKey1.setBounds(91, 190, 61, 16);
				lblKey1.setFont(new Font("Times New Roman", Font.BOLD, 16));
				
				passwordField1 = new JPasswordField();
				passwordField1.setBounds(239, 184, 153, 28);
				passwordField1.setColumns(10);
				
				lblKeyIsIncorrect1 = new JLabel("Key is incorrect");
				lblKeyIsIncorrect1.setBounds(274, 351, 97, 16);
				lblKeyIsIncorrect1.setForeground(Color.RED);
				lblKeyIsIncorrect1.setVisible(false);
				
				btnEncryptPasswordFile = new JButton("Create Password Database");

			
			
				
				JPanel newComp = new JPanel(new GridLayout(3,1));
                newComp.setBorder(
                    new TitledBorder("Create a New Password File") );
                newComp.add(lblFile1);
                newComp.add(fileField1);
                newComp.add(btnNewButton);
                newComp.add(lblKey1);
                newComp.add(passwordField1);
                newComp.add(btnEncryptPasswordFile);
                newComp.add(lblKeyIsIncorrect1);
                newOpen.add(newComp);
			
		        //*********************************************Table
				   //TABLE Header
			       String  title[] = { "Title", "Username","Password","URL","Notes" };
				   Object[][] data = {
				      
				    };
				    
				    model = new DefaultTableModel(data, title );
				     table = new JTable(model);
				    	
				     
				    table.getTableHeader().setBackground(Color.LIGHT_GRAY);
		            table.getColumnModel().getColumn(0).setPreferredWidth(60);
		            table.getColumnModel().getColumn(1).setPreferredWidth(60);
		            table.getColumnModel().getColumn(2).setPreferredWidth(100);
		            table.getColumnModel().getColumn(3).setPreferredWidth(200);
		            table.getColumnModel().getColumn(4).setPreferredWidth(500);
		            
				    table.setGridColor(Color.black);
				    table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
				     JScrollPane tableScroll = new JScrollPane(table);
		                Dimension tablePreferred = tableScroll.getPreferredSize();
		                tableScroll.setPreferredSize(
		                    new Dimension(tablePreferred.width, tablePreferred.height) );
		                
		                JPanel tableComp = new JPanel(
		                        new GridLayout(4,2));
		                    tableComp.setBorder(
		                        new TitledBorder("Password Table") );
		                    tableComp.add(tableScroll);
             
				    JPanel buttons = new JPanel(new FlowLayout());
		            btnAdd = new JButton("Add");
					btnAdd.setBounds(98, 431, 117, 29);
					buttons.add(btnAdd);
					
					btnModify = new JButton("Modify");
					btnModify.setBounds(274, 431, 117, 29);
					buttons.add(btnModify);
					
					btnDelete = new JButton("Delete");
					btnDelete.setBounds(453, 431, 117, 29);
					buttons.add(btnDelete);
					tableComp.add(buttons);
					
					JSplitPane splitPane = new JSplitPane(
		                    JSplitPane.VERTICAL_SPLIT,
		                    newOpen,
		                    tableComp);
					gui.add( splitPane, BorderLayout.CENTER );
					
					
				//************************************************BUTTON ACTIONS
					btnDecryptPassword.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							//make sure the entered key is correct for the specified database
							String line;
							try {
								
								FileInputStream fis = new FileInputStream ("/Users/MeryemMhamdi/Desktop/Keys.txt");
								BufferedReader br = new BufferedReader(new InputStreamReader(fis));
								int flag = 0;
								while ((line = br.readLine()) != null){
								    StringTokenizer st = new StringTokenizer (line,",");
						
								   while (st.hasMoreTokens()){
							       if((st.nextToken()).equals(fileField.getText())){
							    	   flag = 1;
							    	
							    	   if((st.nextToken()).equals(passwordField.getText())){
							    		   lblKeyIsIncorrect.setVisible(false);
							    		   try {
							    			    File f = new File (fileField.getText());
							    			    String path = fileField.getText();
							    			   
												File encryptedFile = new File (fileField.getText());
												 EncryptionAlgorithm.encrypt(passwordField.getText(),f,encryptedFile);
												 StringTokenizer st2 = new StringTokenizer (fileField.getText(),".");
												String file = st2.nextToken();
												File decryptedFile = new File (file+".decrypted");
												
													EncryptionAlgorithm.decrypt(passwordField.getText(),encryptedFile , decryptedFile);
													
												    createTable(file,btnAdd,btnModify,btnDelete,model,table);
													
												} catch (Exception e1) {
													
													System.out.println("Error decrypting"+e1);
												}
							    		   
							    	   }
							    	   else {
											lblKeyIsIncorrect.setText("The entered key is not correct");
											lblKeyIsIncorrect.setVisible(true);
											System.out.println("Key incorrect");
										}
							    	
							    }
								   }
								   
								
							
							} if (flag == 0){
						    	 JOptionPane.showMessageDialog(frame, "Nonvalid file", "Error", JOptionPane.ERROR_MESSAGE);
						    }
								br.close();
							}catch (Exception e){
							     System.out.println(e);
							}
						
						}
					});
					
					//EncryptPasswordFile Button
				
					System.out.println("\r\n");
					
					btnEncryptPasswordFile.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (passwordField1.getText().length()!=16){
								lblKeyIsIncorrect1.setText("Enter a key whose length is 16 characters");
								lblKeyIsIncorrect1.setVisible(true);
							
							} else {
								lblKeyIsIncorrect1.setVisible(false);
								 FileWriter keys;
								try {
									keys = new FileWriter("/Users/MeryemMhamdi/Desktop/Keys.txt",true);
									keys.append(fileField1.getText()+".encrypted"+","+ passwordField1.getText()+"\r\n");
									keys.close();
									
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (UnsupportedEncodingException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								try {
									
									
								    File encryptedFile = new File (filePath+".encrypted");
									File f = new File(filePath);
									EncryptionAlgorithm.encrypt(passwordField1.getText(),f , encryptedFile);
								    createTable(fileField1.getText(),btnAdd, btnModify,btnDelete,model,table);
								    
									
							} catch (Exception ex) {
									ex.printStackTrace();
							}
						
						}
						}
					}
					);
					 
				
					
	///////////////////////////////////////////////////////////////////////
					frame.setContentPane(gui);

		                frame.pack();

		                frame.setLocationRelativeTo(null);
		                try {
		                    // 1.6+
		                    frame.setLocationByPlatform(true);
		                    frame.setMinimumSize(frame.getSize());
		                } catch(Throwable ignoreAndContinue) {
		                }

		                frame.setVisible(true);
				  
			}
		};
		 SwingUtilities.invokeLater(r);
	}
	
	public static void createTable(final String filePath, JButton btnAdd, JButton btnModify, JButton btnDelete,final DefaultTableModel model, final JTable table){
		
		
			String line;
			try {
				FileInputStream fis = new FileInputStream (filePath);
				
				
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		
				while ((line = br.readLine()) != null){
					Vector columns = new Vector ();
				StringTokenizer st = new StringTokenizer (line,",");
		
				   while (st.hasMoreTokens()){
			   
			    	String toke = st.nextToken();
			    	columns.addElement(toke);
			    	System.out.println(toke);	
			    	
			    }
				  
				   model.addRow(columns);
				  
				   
				}
				br.close();
			} catch (Exception e){
			     System.out.println(e);
			}
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				model.insertRow(model.getRowCount(), new Object [] {" ", " ", " "," "});
			  
				 try
	                {
	                    String filename= filePath;
	                    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
	                    int nRow = model.getRowCount(), nCol = model.getColumnCount();
	                    
	                    for (int i = 0 ; i < nRow ; i++){
	                        for (int j = 0 ; j < nCol ; j++) {
	                     	   fw.write((String) model.getValueAt(i,j)+",");//appends the string to the file
	                        }
	                        fw.write("\r\n");
	                    }
	                    fw.close();
	                }
	                catch(IOException ioe)
	                {
	                    System.err.println("IOException: " + ioe.getMessage());
	                }
			}
		});
		
	   btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try
	                {
	                    String filename= filePath;
	                  
	                    FileWriter fw = new FileWriter(filename,false); //the true will append the new data
	                    int nRow = model.getRowCount(), nCol = model.getColumnCount();
	                    
	                    for (int i = 0 ; i < nRow ; i++){
	                        for (int j = 0 ; j < nCol ; j++) {
	                         
	                     	   fw.write((String) model.getValueAt(i,j)+",");//appends the string to the file
	                        }
	                        fw.write("\r\n");
	                    }
	                    fw.close();
	                }
	                catch(IOException ioe)
	                {
	                    System.err.println("IOException: " + ioe.getMessage());
	                }
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 // check for selected row first
		        if (table.getSelectedRow() != -1) {
		            // remove selected row from the model
		            model.removeRow(table.getSelectedRow());
		        }
		        try
                {
                    String filename= filePath;
                    FileWriter fw = new FileWriter(filename,false); //the true will append the new data
                    int nRow = model.getRowCount(), nCol = model.getColumnCount();
                    
                    for (int i = 0 ; i < nRow ; i++){
                        for (int j = 0 ; j < nCol ; j++) {
                         
                     	   fw.write((String) model.getValueAt(i,j)+",");//appends the string to the file
                        }
                        fw.write("\r\n");
                    }
                    fw.close();
                }
                catch(IOException ioe)
                {
                    System.err.println("IOException: " + ioe.getMessage());
                }
			}
		});
		
		model.addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.INSERT) {
                  // model.fireTableRowsInserted(e.getFirstRow(),e.getLastRow() );
                   
                }
                if (e.getType()== TableModelEvent.UPDATE){
                	//model.fireTableRowsUpdated(e.getFirstRow(), e.getLastRow());
                }
                if(e.getType()==TableModelEvent.DELETE){
                	//model.fireTableRowsDeleted(e.getFirstRow(), e.getLastRow());
                }
                try
                {
                    String filename= filePath;
                    FileWriter fw = new FileWriter(filename,false); //the true will append the new data
                    int nRow = model.getRowCount(), nCol = model.getColumnCount();
                    
                    for (int i = 1 ; i < nRow ; i++){
                        for (int j = 0 ; j < nCol ; j++) {
                           
                     	   fw.write((String) model.getValueAt(i,j)+",");//appends the string to the file
                        }
                        fw.write("\r\n");
                    }
                    fw.close();
                }
                catch(IOException ioe)
                {
                    System.err.println("IOException: " + ioe.getMessage());
                }
            }
			
        });	
		
		 try {
             table.setAutoCreateRowSorter(true);
         } catch(Exception continuewithNoSort) {
         }
	}
}
