/*���s�X�п��UTF-8*/
package Final_Work;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenMBeanConstructorInfoSupport;
import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.html.HTMLEditorKit.LinkController;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;



public class Final_Work  extends JFrame implements ActionListener
{
	boolean oldfile = false;
	Frame frame = new Frame();
	private static char Output [];
	public static String str= new String();
	public static char opench;
	public static JTextArea textArea=new JTextArea();
	public static String Filename;
	public static int W_width = 600;	//�����e
	public static int W_height = 600;	//������
	public static String First_load="";
	private static Timer change_Timer;
	private Timer title_Timer;
	public JLabel status;
	public static String file_name;
	public static JPopupMenu popup;
	public static JMenuItem cut,paste,copy,del;
	static java.awt.datatransfer.Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard(); //�ŶK�O
	public static StringSelection StringSelec;
	public class Connect extends JFrame	implements ActionListener	//�p���ڭ̪��e��
	{
		public Connect()
		{
			super("�p���@��");
			Container c =  getContentPane();		//��ܵ���
			c.setBackground(Color.GRAY);			//�]�w�I����
			c.setLayout(new FlowLayout(FlowLayout.CENTER));	//�ƪ��a��
			JLabel githubURL = new JLabel("�}��귽          ");
			JButton githubIN = new JButton(" GitHub ");
			JLabel githubURL1 = new JLabel("                                                                                            ");
			JLabel Programmer = new JLabel("�p���@��                                                                           ");
			JLabel ProgrammerA = new JLabel("henry1758f    ");
			JButton ProgrammerAm = new JButton(" E-mail ");
			JLabel ProgrammerB = new JLabel("Lilyo                 ");
			JButton ProgrammerBm = new JButton(" E-mail ");
			JLabel ProgrammerC = new JLabel("syndrlo            ");
			JButton ProgrammerCm = new JButton(" E-mail ");
			Font inConnect = new Font("�L�n������", Font.BOLD, 20);	//�r��]�w
			githubURL.setFont(inConnect);
			githubURL.setForeground(Color.WHITE);
			Programmer.setFont(inConnect);
			Programmer.setForeground(Color.WHITE);
			ProgrammerA.setFont(inConnect);
			ProgrammerA.setForeground(Color.WHITE);
			ProgrammerB.setFont(inConnect);
			ProgrammerB.setForeground(Color.WHITE);
			ProgrammerC.setFont(inConnect);
			ProgrammerC.setForeground(Color.WHITE);
			
			githubIN.addActionListener(new ActionListener() 
			{	
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					try 
					{
						Runtime.getRuntime().exec("cmd /c start " + "https://github.com/henry1758f/JAVA-Training-Homework");
					} 
					catch (IOException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
			ProgrammerAm.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					// TODO Auto-generated method stub
					try 
					{
						Runtime.getRuntime().exec("cmd /c start " + "mailto:1102104112@gm.kuas.edu.tw");
					} 
					catch (IOException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			ProgrammerBm.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					// TODO Auto-generated method stub
					try 
					{
						Runtime.getRuntime().exec("cmd /c start " + "mailto:1102104116@gm.kuas.edu.tw");
					} 
					catch (IOException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			ProgrammerCm.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					// TODO Auto-generated method stub
					try 
					{
						Runtime.getRuntime().exec("cmd /c start " + "mailto:1102104143@gm.kuas.edu.tw");
					} 
					catch (IOException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			/*�[�i������*/
			c.add(githubURL);
			c.add(githubIN);
			c.add(githubURL1);
			c.add(Programmer);
			c.add(ProgrammerA);
			c.add(ProgrammerAm);
			c.add(ProgrammerB);
			c.add(ProgrammerBm);
			c.add(ProgrammerC);
			c.add(ProgrammerCm);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
		
	/*�D�n����*/
	public Final_Work() 
	{
		//super ("�O�ƥ�");
		change_Timer = new Timer(100, this);

		status = new JLabel("���ק�");/*�W��U�Ԧ����JMenuBar*/
		status.setVisible(true); 
		JMenuBar upon = new JMenuBar();
		 
		setJMenuBar(upon);
		//�ɮ�
		JMenu file = new JMenu("�ɮ�(F) ");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem open;
		file.add(open= new JMenuItem("�}�s�ɮ�(N)"));
		open.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_N,InputEvent.CTRL_MASK));//Ctrl�ֱ���
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				change_Timer.start();
				textArea.setText("");  //�M��
			}
		});
		open.addMouseListener(new MouseAdapter() 
		{
			@Override
            public void mouseReleased(MouseEvent ev)
            {
				//�ƹ��ƥ�w�]�t ctrl�ֱ��䪺�ƥ�
            } 
		});
		JMenuItem open1;
		file.add(open1 = new JMenuItem("�}������(O)"));
		open1.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_O,InputEvent.CTRL_MASK));//Ctrl�ֱ���
		
		open1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent eo) {
				// TODO Auto-generated method stub
				try {
					fgopenFile();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		open1.addMouseListener(new MouseAdapter() 
		{
			@Override
            public void mouseReleased(MouseEvent ev)
            {
				//�ƹ��ƥ�w�]�t ctrl�ֱ��䪺�ƥ�
            }
		});
		JMenuItem save;
		file.add(save = new JMenuItem("�x�s�ɮ�(S)"));
		save.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_S,InputEvent.CTRL_MASK));//Ctrl�ֱ���
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try 
				{
					if(oldfile == false)
					{
						fgsaveFile();
					}
					else
					{
						//TODO �����s�ɥ\��
					}
					change_Timer.start();
				} 
				catch (IOException es) 
				{
					JOptionPane.showConfirmDialog(frame, "�`�N!�ɮץ��x�s!\n�s�ɮɵo�Ϳ��~�A�ЦA�դ@��!", "���~", JOptionPane.ERROR_MESSAGE ,0);
					es.printStackTrace();
				}
			}
		});
		save.addMouseListener(new MouseAdapter() 
		{
			//�ƹ��ƥ�w�]�t ctrl�ֱ��䪺�ƥ�
		});
		
		JMenuItem item;
		file.add(item = new JMenuItem("�t�s�s��(A)"));
		item.addMouseListener(new MouseAdapter() 
		{
			@Override
            public void mouseReleased(MouseEvent ev)
            {
				try 
				{
					fgsaveFile();
					change_Timer.start();
				} 
				catch (IOException e) 
				{
					JOptionPane.showConfirmDialog(frame, "�`�N!�ɮץ��x�s!\n�s�ɮɵo�Ϳ��~�A�ЦA�դ@��!", "���~", JOptionPane.ERROR_MESSAGE ,0);
					e.printStackTrace();
				}
            }
		});
		file.addSeparator();
		file.add(item = new JMenuItem("�����]�w(U)",KeyEvent.VK_U));
		item.addActionListener(this);
		file.add(item = new JMenuItem("�C�L(P)",KeyEvent.VK_P));
		item.addActionListener(this);
		file.addSeparator();
		file.add(item = new JMenuItem("����(X)",KeyEvent.VK_X));
		item.addActionListener(new ActionListener() 
		{              //�k�W�������ƥ�
			public void actionPerformed(ActionEvent e) 
			{ 
				if(First_load.equals(textArea.getText()))
				{
					change_Timer.stop();
					closeFile(); 
				}
				else
				{
					int n= JOptionPane.showConfirmDialog(frame, "�ɮ׸g�ק��|���x�s�A�O�_�������}?", "�ɮץ��sĵ�i", JOptionPane.YES_NO_CANCEL_OPTION ,1);
		        	 if(n==1)
		        	 {
		        		 try 
		 				{
		 					if(oldfile == false)
		 					{
		 						fgsaveFile();
		 					}
		 					else
		 					{
		 						//TODO �����s�ɥ\��
		 					}
		 					change_Timer.start();
		 				} 
		 				catch (IOException es) 
		 				{
		 					JOptionPane.showConfirmDialog(frame, "�`�N!�ɮץ��x�s!\n�s�ɮɵo�Ϳ��~�A�ЦA�դ@��!", "���~", JOptionPane.ERROR_MESSAGE ,0);
		 					es.printStackTrace();
		 				} 
		        		
		        	 }
		        	 else if(n==2)
		        	 {
			        	 
		        		 System.out.println("n=3");
		        	 }
		        	 else
		        	 {
		        		 change_Timer.stop();
		        		 closeFile();   
		        	 } 
				}
								
			}
		});
		upon.add(file);
		//�s��
		JMenu edit = new JMenu("�s��(E) ");
		edit.setMnemonic(KeyEvent.VK_E);
		edit.add(item = new JMenuItem("�_��(Z)",KeyEvent.VK_Z));
		item.addActionListener(this);
		edit.addSeparator();
		edit.add(item = new JMenuItem("�ŤU(T)",KeyEvent.VK_T));
		item.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cut();
			}
		});
		edit.add(item = new JMenuItem("�ƻs(C)",KeyEvent.VK_C));
		item.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				copy();
			}
		});
		edit.add(item = new JMenuItem("�K�W(P)",KeyEvent.VK_P));
		item.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				paste();
			}
		});
		edit.add(item = new JMenuItem("�R��(L)",KeyEvent.VK_L));
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				del();
			}
		});
		edit.addSeparator();
		edit.add(item = new JMenuItem("�M��(F)",KeyEvent.VK_F));
		item.addActionListener(this);
		edit.add(item = new JMenuItem("��U�@��(N)",KeyEvent.VK_N));
		item.addActionListener(this);
		edit.add(item = new JMenuItem("���N(R)",KeyEvent.VK_R));
		item.addActionListener(this);
		edit.addSeparator();
		edit.add(item = new JMenuItem("����(A)",KeyEvent.VK_A));
		item.addActionListener(this);
		edit.add(item = new JMenuItem("�ɶ�/���(D)",KeyEvent.VK_D));
		item.addActionListener(this);
		upon.add(edit);
		//�榡
		JMenu form = new JMenu("�榡(O) ");
		form.setMnemonic(KeyEvent.VK_O);
		JCheckBoxMenuItem autowrap;
		autowrap = new JCheckBoxMenuItem("�۰ʴ���");
		autowrap.addActionListener(this);
		form.add(autowrap);
		form.add(item = new JMenuItem("�r��(F)",KeyEvent.VK_F));
		item.addActionListener(this);
		upon.add(form);
		//�˵�
		JMenu view  = new JMenu("�˵�(V) ");
		view.setMnemonic(KeyEvent.VK_V);
		JCheckBoxMenuItem statusBar;
		statusBar = new JCheckBoxMenuItem("���A��");
		statusBar.setSelected(true);
		statusBar.addActionListener(new ActionListener() 
		{
					
				@Override
				public void actionPerformed(ActionEvent arg0) 
				{
					if(statusBar.isSelected())
					{
						status.setVisible(true);
					}
					else
					{
						status.setVisible(false);
		
					}
		
				}
					
		});
		view.add(statusBar);
		upon.add(view);
		//����
		JMenu help = new JMenu("����(H) ");
		help.setMnemonic(KeyEvent.VK_H);
		help.add(item = new JMenuItem("���D�^��(R)",KeyEvent.VK_R));
		item.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Connect cframe = new Connect();
				cframe.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				cframe.setSize(252, 250);
				cframe.setVisible(true);
				cframe.setResizable(false);
			}
		});
		help.addSeparator();
		help.add(item = new JMenuItem("����(A)",KeyEvent.VK_A));
		item.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showOptionDialog(null, 
											"�{���W��: ²�������O�� \n" + 
											"�{���]�p��: �d�ݮp  �����B  ù�÷u  \n" + 
											"²��: ²�檺��r�s�边\n" , 
											"����²�������O��",              //title
											JOptionPane.DEFAULT_OPTION,     
											JOptionPane.INFORMATION_MESSAGE,  //ĵ�ܹϥ�
											null, 
											null, 
											null); 
			}
		});
		upon.add(help);
		 /*��J��r��*/
		textArea = new JTextArea(); 
	    textArea.setFont(new Font("�s�ө���", Font.PLAIN, 16));
	    textArea.setForeground(Color.black);//�]�w��r�C��
	    textArea.setBackground(Color.white);//�]�w�I���C��
	    textArea.setLineWrap(true);//�]�w�۰ʴ��� 
		textArea.setEditable(true);//�NtextArea�]���i�s��(�w�])
	
		
		
		/*�����]�w*/
	    JScrollPane panel = new JScrollPane(textArea,      
	    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, //�]�m�����u�ʱ������H�ϫ����u�ʱ��ݭn����ܡC
	    //ScrollPaneConstants. VERTICAL_SCROLLBAR_ALWAYS,  //�]�m�����u�ʱ������H�ϫ����u�ʱ��@����ܡC
	    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //�]�m�����u�ʱ������H�Ϥ����u�ʱ�����ܡC
	    		
	    Container contentPane = getContentPane(); 
	    contentPane.add(panel, BorderLayout.CENTER); 
	    /**/
	    title_Timer = new Timer(100, this);
	    title_Timer.start();
	    title_Timer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			if(file_name!=null){setTitle(file_name);}
			else{setTitle("�O�ƥ�");}
			}
		});
	    
	    
	    
	    /*���A�C*/
	    status.setHorizontalAlignment(SwingConstants.LEFT); //�]�w������V�����
	    status.setBorder( 
	    BorderFactory.createEtchedBorder()); 
	    contentPane.add(status, BorderLayout.SOUTH);
	    change_Timer.addActionListener(new ActionListener() 
	    {	
	    	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				if(First_load.equals(textArea.getText()))
				{
					status.setText("�w�x�s");
				}
				else
				{
					status.setText("���x�s");
				}
				change_Timer.start();
			}
		});
	    popup =new JPopupMenu();
	    popup.add(cut=new JMenuItem("�ŤU"));
	    cut.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_T,InputEvent.CTRL_MASK));//Ctrl�ֱ���
	    cut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cut();
			}
		});
	    popup.add(copy=new JMenuItem("�ƻs"));
	    copy.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_C,InputEvent.CTRL_MASK));//Ctrl�ֱ���
	    copy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				copy();
			}
		});
	    popup.add(paste=new JMenuItem("�K�W"));
	    paste.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_V,InputEvent.CTRL_MASK));//Ctrl�ֱ���
	    paste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				paste();
			}
		});
	    popup.addSeparator();
	    popup.add(del=new JMenuItem("�R��"));
	    del.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_D,InputEvent.CTRL_MASK));//Ctrl�ֱ���
	    del.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				del();
			}
		});
	    
	    textArea.addMouseListener(new MouseAdapter() {
	    	public void mousePressed(MouseEvent evt){
	    		if(evt.isPopupTrigger()){
	    			popup.show(evt.getComponent(), evt.getX(), evt.getY());
	    		}
	    	}
	    	public void mouseReleased(MouseEvent evt){
	    		if(evt.isPopupTrigger()){
	    			popup.show(evt.getComponent(), evt.getX(), evt.getY());
	    		}
	    	}
	    	
		});
	    
	}
     

	public static void main(String[] args) throws IOException 
	{
		Final_Work mainWin = new Final_Work();
		//mainWin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		mainWin.addWindowListener(                           //�k�W�������ƥ�
				new WindowAdapter() 
				{ 
					public void windowClosing(WindowEvent e) 
					{ 
						closeFile(); 
					}
				}); 	
		mainWin.setLocation(200,50);  //�����j�p
		mainWin.setSize(W_width, W_height);
		mainWin.setVisible(true);
		
	}

	/*�����ɮ�*/
	private static void closeFile() {
		 System.exit(0);
	}

	/*filedialog��k�}��*/
	private static void fgopenFile() throws UnsupportedEncodingException 
	{
		String Filename=new String(str.getBytes("UTF-8"), "GB2312"); //UTF-8�ഫANSI�s�X   
		Frame frame = new Frame();
		
		FileDialog fd = new FileDialog( frame,"�}������", FileDialog.LOAD);   //LOAD=>��� 0 �A�]�w���}���ɮת���ܵ��� 
	    fd.setVisible(true); 
	    if(fd!=null)
	    {   
	     if(fd.getDirectory()==null){ return;}           //�̫���ܩ�TextArea 
	     else{	
	        Filename=fd.getDirectory() +fd.getFile();   //getDirectory�]�w�ɮת��w�]���|, getFile�]�w�ɮת��w�]�ɦW
	        System.out.println("FileDialog---->"+Filename);  //��ܿ�ܪ��ɮ׸��|+�W��
	        try 
	        {
	            FileReader fr=new FileReader(Filename); 
	            BufferedReader bread=new BufferedReader(fr); //��y�w��
	            int ch;
	            boolean a = true;
	            while ((ch=bread.read()) != -1) //BufferedReader �~�Ӧ� Reader ���O�� read() ��k��Ū��, ������k�O�@��Ū���@�Ӧr��, Ū���ɧ��ɷ|�Ǧ^ -1
	            {          
	            	opench=(char)ch;                     //opench=�Nch�j���ন�r��
	            	System.out.print(opench);   
	            	//if(a==true){a=false;continue;}
		               str=str+String.valueOf(opench);   //�r��=�r��+�j����r��᪺opench
		              }
	            textArea.setText("");  //�M��
	            textArea.setText(str); //�̫���ܩ�TextArea
	            file_name=fd.getFile();
	            First_load = textArea.getText();	//�ƻs������e
	             bread.close();
	             str="";
	             change_Timer.start();
	        }
	        
	        catch (IOException e) 
	        {
	        	JOptionPane.showConfirmDialog(frame, "�`�N!\n�}���ɮ׮ɵo�Ϳ��~�A�ЦA�դ@��!", "���~", JOptionPane.OK_OPTION ,0);
	        	System.out.println("error_openfile");  //�������`�����"e"
	    	
	        }
	     }
	    }
	}


	/*filedialog��k�x�s�ɮ�*/
	private static void fgsaveFile() throws IOException  
	{
		boolean s = false;
		String stringfile; 
		Frame frame = new Frame();
		FileDialog fd = new FileDialog( frame,"�x�s�ɮ�", FileDialog.SAVE);   //LOAD=>��� 0 �A�]�w���}���ɮת���ܵ���
	    fd.setVisible(true); 
	    if(fd!=null)
	    {   
	    	 String string1 = textArea.getText();    //�ɮפ��e�r��
	         stringfile = fd.getDirectory()+fd.getFile();//������|+�ɮצW�٦r��
	         if(fd.getDirectory()==null){s=true;}           //�̫���ܩ�TextArea 
	         else  if(!(stringfile.contains(".txt") || stringfile.contains(".TXT")))
	         {
	        	 int n= JOptionPane.showConfirmDialog(frame, "�ɮװ��ɦW���G���O��r���.txt�����A�O�_�]��������?", "���ɦW���D", JOptionPane.YES_NO_CANCEL_OPTION ,1);
	        	 if(n==1)
	        	 {
	 	            System.out.println("n=1");  
	        	 }
	        	 else if(n==2)
	        	 {
		        	 JOptionPane.showConfirmDialog(frame, "�`�N!\n�ɮץ��x�s!", "���ɦW���D", JOptionPane.OK_OPTION ,2);
	        		 System.out.println("n=3");
	        		 s = true;
	        	 }
	        	 else
	        	 {
	 	            System.out.println("n=0");  
	 	            stringfile = stringfile + ".txt";
	        	 }
	        	 
	         }
	        try 
	        {  
	        	if(s ==false)
	        	{
	        		BufferedWriter bwrite = new BufferedWriter(new FileWriter(stringfile));  //��y�w�İ�
	        		bwrite.write(string1);   //�g�J���e
	        		bwrite.close();   //������y
	        		textArea.setText(textArea.getText()); //�b��ܮث᥵�O����r���
	        		file_name=fd.getFile();
	        		First_load = textArea.getText();	//��s�ק�e���ɮ�
	        	}
	            
	        } 
	        catch (Exception e) 
	        {  
	            // TODO Auto-generated catch block 
	        	JOptionPane.showConfirmDialog(frame, "�`�N!\n�ɮ��x�s�ɵo�Ϳ��~�A�ЦA�դ@��!", "���~", JOptionPane.OK_OPTION ,0);
	            System.out.println("�O�s����");  
	        }   
	    }
	}

	private static void cut(){
		
	}
	private static void copy(){
		 String copy_string = textArea.getSelectedText();  //���otextArea��������r��
         StringSelec = new StringSelection(copy_string);   //�N���e�ᵹStringSelec
         cb.setContents(StringSelec,null);//�⤺�e���t�ΰŶK�O
	}
	private static void paste(){
		try {
			String paste_string = null; 
			Transferable tr = cb.getContents( StringSelec ); //�q�t�ΰŶK�O�o��@��Transferable��H
			if  (tr != null ){
			
			paste_string =(String) tr.getTransferData(DataFlavor.stringFlavor); //�qTransferable�ﹳ���o��ƻs����r
			}
			if  (paste_string!= null ){
				textArea.insert((String) paste_string, textArea.getCaretPosition()); //�N��r�K�btextArea.getCaretPosition()�o�Ӧ�m

			}
			} catch (Exception err){
			 err.printStackTrace();
			}
	}
	private static void del(){
		
	}
    /*�}�ҷs�ɨƥ�*/
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	} 

	
}