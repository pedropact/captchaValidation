package captchaValidation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Captcha extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldTypedCode;

	
	// Random number created to be the reference of all the mothodes in the class
	private Integer nbIndex = creerNumeroRandom();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Captcha dialog = new Captcha(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Captcha(JFrame owner) {
		super(owner,true);
		setTitle("VALIDER");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lbImage = new JLabel(new ImageIcon(imageCode()));
		lbImage.setBounds(50, 23, 350, 150);
		contentPanel.add(lbImage);

		JLabel lblNewLabel_1 = new JLabel("Enter the validation code:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(45, 189, 202, 16);
		contentPanel.add(lblNewLabel_1);

		textFieldTypedCode = new JTextField();
		textFieldTypedCode.setBounds(272, 184, 130, 26);
		contentPanel.add(textFieldTypedCode);
		textFieldTypedCode.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						codeValitation(textFieldTypedCode.getText());
						//setVisible(false);

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("CANCEL");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					setVisible(false);

					}
				});
				//cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	//---------------------------------------------------------
	// Create a random number between 1 and 30, the same number of images
	public static Integer creerNumeroRandom(){
		Integer nbRandom = 0;
		nbRandom = ( int ) ( 1 + Math.random() * 30 );			
		return nbRandom;		
	}

	//---------------------------------------------------------
	// Create the path for the image and to display in the window according to the random number
	public String imageCode(){
		String imageLocalisation = "src/images/"+nbIndex+".png";
		System.out.println(imageLocalisation);
		return imageLocalisation;
	}

	//---------------------------------------------------------
	// Create the code corresponding to the image and random number
	public String strCode(){

		List<String> codeList = new ArrayList<String>();
		codeList.add("TpRRs");		//1
		codeList.add("yHHw");		//2
		codeList.add("235295");		//3
		codeList.add("CUXE");		//4
		codeList.add("9UHDD");		//5
		codeList.add("cr8ws");		//6
		codeList.add("jw62k");		//7
		codeList.add("FH2DE");		//8
		codeList.add("ZHvmC");		//9
		codeList.add("S5TB");		//10
		codeList.add("CVBRR");		//11
		codeList.add("EUWF5G");		//12
		codeList.add("tTH1GW");		//13
		codeList.add("DELXE");		//14
		codeList.add("6138B");		//15
		codeList.add("etsans");		//16
		codeList.add("GENERAL");	//17
		codeList.add("8Z8ME");		//18
		codeList.add("CUU5");		//19
		codeList.add("MY5N5");		//20
		codeList.add("BETW");		//21
		codeList.add("16qe9o");		//22
		codeList.add("77ZLN");		//23
		codeList.add("ssMp7T");		//24
		codeList.add("HIU7");		//25
		codeList.add("4803633");	//26
		codeList.add("TEST");		//27
		codeList.add("7jb6v5w");	//28
		codeList.add("VKypL2");		//29
		codeList.add("3406072");	//30

		String strCode = codeList.get(nbIndex-1);
		return strCode;
	}

	//---------------------------------------------------------
	// To validate if the count enters for the user is the same as was created.
	public void codeValitation(String typedCode){

		String strCode = strCode();		

		// If the code is incorrect
		if (!typedCode.equals(strCode)){
			
			System.out.println("Incorrect code");
			JOptionPane.showMessageDialog(null, "The code is incorrect! Retry!");
			setVisible(false);
			resetAll();
			
			//Recharge a new window
			try {
				Captcha dialog = new Captcha(null);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
		}
		// If the code is CORRECT
		else {
			JOptionPane.showMessageDialog(null, "The code is correct! Thanks!");
			System.out.println("CORRECT code");
			setVisible(false);
			
		}		
	}

	// Reset all fields
	private void resetAll(){

		textFieldTypedCode.setText("");
	}

}
