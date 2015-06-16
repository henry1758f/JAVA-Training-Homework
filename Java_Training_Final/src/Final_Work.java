/*文件編碼請選擇UTF-8*/
package Final_Work;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenMBeanConstructorInfoSupport;
import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.html.HTMLEditorKit.LinkController;

import com.sun.glass.events.WindowEvent;
import com.sun.javafx.binding.SelectBinding.AsString;

import java.awt.*;
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
import java.net.URL;
import java.net.URLConnection;



public class Final_Work  extends JFrame implements ActionListener
{
	boolean oldfile = false;
	Frame frame = new Frame();
	private static AsString Output [];
	public static String str= new String();
	public static char opench;
	public static JTextArea textArea;
	public static String Filename;
	public static int W_width = 600;	//視窗寬
	public static int W_height = 600;	//視窗高
	public static String First_load;
	public static Timer change_Timer;
	private Timer title_Timer;
	public JLabel status;
	public static String file_name;
	
	public class Connect extends JFrame	implements ActionListener	//聯絡我們的畫面
	{
		public Connect()
		{
			super("聯絡作者");
			Container c =  getContentPane();		//顯示視窗
			c.setBackground(Color.GRAY);			//設定背景色
			c.setLayout(new FlowLayout(FlowLayout.LEFT));	//排版靠左
			JLabel githubURL = new JLabel("開放資源          ");
			JButton githubIN = new JButton(" GitHub ");
			JLabel githubURL1 = new JLabel("                                                                                            ");
			JLabel Programmer = new JLabel("聯絡作者                                                                           ");
			JLabel ProgrammerA = new JLabel("henry1758f    ");
			JButton ProgrammerAm = new JButton(" E-mail ");
			JLabel ProgrammerB = new JLabel("Lilyo                 ");
			JButton ProgrammerBm = new JButton(" E-mail ");
			JLabel ProgrammerC = new JLabel("oven of KUAS");
			JButton ProgrammerCm = new JButton(" E-mail ");
			Font inConnect = new Font("微軟正黑體", Font.BOLD, 20);	//字體設定
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
						Runtime.getRuntime().exec("cmd /c start " + "mailto:1102104112@gm.kuas.edu.tw");
					} 
					catch (IOException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			/*加進介面中*/
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
		
	/*主要視窗*/
	public Final_Work() 
	{
		//super ("記事本");
		/*上方下拉式選單JMenuBar*/
		JMenuBar upon = new JMenuBar();
		status = new JLabel("未修改"); 
		setJMenuBar(upon);
		//檔案
		JMenu file = new JMenu("檔案(F) ");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem open;
		file.add(open= new JMenuItem("開新檔案(N)"));
		open.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_N,InputEvent.CTRL_MASK));//Ctrl快捷鍵
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				change_Timer.start();
				textArea.setText("");  //清除
			}
		});
		open.addMouseListener(new MouseAdapter() 
		{
			@Override
            public void mouseReleased(MouseEvent ev)
            {
				//滑鼠事件已包含 ctrl快捷鍵的事件
            } 
		});
		JMenuItem open1;
		file.add(open1 = new JMenuItem("開啟舊檔(O)"));
		open1.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_O,InputEvent.CTRL_MASK));//Ctrl快捷鍵
		
		open1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent eo) {
				// TODO Auto-generated method stub
				fgopenFile();
			}
		});
		open1.addMouseListener(new MouseAdapter() 
		{
			@Override
            public void mouseReleased(MouseEvent ev)
            {
				//滑鼠事件已包含 ctrl快捷鍵的事件
            }
		});
		JMenuItem save;
		file.add(save = new JMenuItem("儲存檔案(S)"));
		save.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_S,InputEvent.CTRL_MASK));//Ctrl快捷鍵
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
						//TODO 直接存檔功能
					}
					change_Timer.start();
				} 
				catch (IOException es) 
				{
					JOptionPane.showConfirmDialog(frame, "注意!檔案未儲存!\n存檔時發生錯誤，請再試一次!", "錯誤", JOptionPane.ERROR_MESSAGE ,0);
					es.printStackTrace();
				}
			}
		});
		save.addMouseListener(new MouseAdapter() 
		{
			//滑鼠事件已包含 ctrl快捷鍵的事件
		});
		
		JMenuItem item;
		file.add(item = new JMenuItem("另存新檔(A)"));
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
					JOptionPane.showConfirmDialog(frame, "注意!檔案未儲存!\n存檔時發生錯誤，請再試一次!", "錯誤", JOptionPane.ERROR_MESSAGE ,0);
					e.printStackTrace();
				}
            }
		});
		file.addSeparator();
		file.add(item = new JMenuItem("版面設定(U)",KeyEvent.VK_U));
		item.addActionListener(this);
		file.add(item = new JMenuItem("列印(P)",KeyEvent.VK_P));
		item.addActionListener(this);
		file.addSeparator();
		file.add(item = new JMenuItem("結束(X)",KeyEvent.VK_X));
		item.addActionListener(new ActionListener() 
		{              //右上角關閉事件
			public void actionPerformed(ActionEvent e) 
			{ 
				if(First_load.equals(textArea.getText()))
				{
					change_Timer.stop();
					closeFile(); 
				}
				else
				{
				    System.out.println(First_load + " & " + textArea.getText());  
				}
								
			}
		});
		upon.add(file);
		//編輯
		JMenu edit = new JMenu("編輯(E) ");
		edit.setMnemonic(KeyEvent.VK_E);
		edit.add(item = new JMenuItem("復原(Z)",KeyEvent.VK_Z));
		item.addActionListener(this);
		edit.addSeparator();
		edit.add(item = new JMenuItem("剪下(T)",KeyEvent.VK_T));
		item.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		edit.add(item = new JMenuItem("複製(C)",KeyEvent.VK_C));
		item.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
			}
		});
		edit.add(item = new JMenuItem("貼上(P)",KeyEvent.VK_P));
		item.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
			}
		});
		edit.add(item = new JMenuItem("刪除(L)",KeyEvent.VK_L));
		item.addActionListener(this);
		edit.addSeparator();
		edit.add(item = new JMenuItem("尋找(F)",KeyEvent.VK_F));
		item.addActionListener(this);
		edit.add(item = new JMenuItem("找下一個(N)",KeyEvent.VK_N));
		item.addActionListener(this);
		edit.add(item = new JMenuItem("取代(R)",KeyEvent.VK_R));
		item.addActionListener(this);
		edit.addSeparator();
		edit.add(item = new JMenuItem("全選(A)",KeyEvent.VK_A));
		item.addActionListener(this);
		edit.add(item = new JMenuItem("時間/日期(D)",KeyEvent.VK_D));
		item.addActionListener(this);
		upon.add(edit);
		//格式
		JMenu form = new JMenu("格式(O) ");
		form.setMnemonic(KeyEvent.VK_O);
		JCheckBoxMenuItem autowrap;
		autowrap = new JCheckBoxMenuItem("自動換行");
		autowrap.addActionListener(this);
		form.add(autowrap);
		form.add(item = new JMenuItem("字型(F)",KeyEvent.VK_F));
		item.addActionListener(this);
		upon.add(form);
		//檢視
		JMenu view  = new JMenu("檢視(V) ");
		view.setMnemonic(KeyEvent.VK_V);
		JCheckBoxMenuItem statusBar;
		view.add(statusBar = new JCheckBoxMenuItem("狀態欄"));
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
		//說明
		JMenu help = new JMenu("說明(H) ");
		help.setMnemonic(KeyEvent.VK_H);
		help.add(item = new JMenuItem("問題回報(R)",KeyEvent.VK_R));
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
		help.add(item = new JMenuItem("關於(A)",KeyEvent.VK_A));
		item.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showOptionDialog(null, 
											"程式名稱: 簡易型筆記本 \n" + 
											"程式設計者: 吳侑峰  黃宣錡  羅永暉  \n" + 
											"簡介: 簡單的文字編輯器\n" , 
											"關於簡易型筆記本",              //title
											JOptionPane.DEFAULT_OPTION,     
											JOptionPane.INFORMATION_MESSAGE,  //警示圖示
											null, 
											null, 
											null); 
			}
		});
		upon.add(help);
		 /*輸入文字區*/
		textArea = new JTextArea(); 
	    textArea.setFont(new Font("新細明體", Font.PLAIN, 16));
	    textArea.setForeground(Color.black);//設定文字顏色
	    textArea.setBackground(Color.white);//設定背景顏色
	    textArea.setLineWrap(true);//設定自動換行 
		textArea.setEditable(true);//將textArea設為可編輯(預設)
	
		
		
		/*視窗設定*/
	    JScrollPane panel = new JScrollPane(textArea,      
	    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, //設置垂直滾動條策略以使垂直滾動條需要時顯示。
	    //ScrollPaneConstants. VERTICAL_SCROLLBAR_ALWAYS,  //設置垂直滾動條策略以使垂直滾動條一直顯示。
	    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //設置水平滾動條策略以使水平滾動條不顯示。
	    		
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
			else{setTitle("記事本");}
			}
		});
	    
	    
	    
	    /*狀態列*/
	    status.setHorizontalAlignment(SwingConstants.LEFT); //設定水平方向的對齊
	    status.setVisible(true); 
	    status.setBorder( 
	    BorderFactory.createEtchedBorder()); 
	    contentPane.add(status, BorderLayout.SOUTH);
	    
	    change_Timer = new Timer(100, this);
	    change_Timer.addActionListener(new ActionListener() 
	    {	
	    	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				if(First_load.equals(textArea.getText()))
				{
					status.setText("已儲存");
				}
				else
				{
					status.setText("未儲存");
				}
				change_Timer.start();
			}
		});

	}


	public static void main(String[] args) throws IOException 
	{
		Final_Work mainWin = new Final_Work();
		//mainWin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		mainWin.addWindowListener(                           //右上角關閉事件
				new WindowAdapter() 
				{ 
					public void windowClosing(WindowEvent e) 
					{ 
						closeFile(); 
					}
				}); 	
		mainWin.setLocation(200,50);  //視窗大小
		mainWin.setSize(W_width, W_height);
		mainWin.setVisible(true);
		
	}

	/*關閉檔案*/
	private static void closeFile() {
		 System.exit(0);
	}

	/*filedialog方法開檔*/
	private static void fgopenFile() 
	{
		String Filename;  
		Frame frame = new Frame();
		
		FileDialog fd = new FileDialog( frame,"開啟舊檔", FileDialog.LOAD);   //LOAD=>整數 0 ，設定為開啟檔案的對話視窗 
	    fd.setVisible(true); 
	    if(fd!=null)
	    {   
	     if(fd.getDirectory()==null){ return;}           //最後顯示於TextArea 
	     else{	
	        Filename=fd.getDirectory() +fd.getFile();   //getDirectory設定檔案的預設路徑, getFile設定檔案的預設檔名
	        System.out.println("FileDialog---->"+Filename);  //顯示選擇的檔案路徑+名稱
	        try 
	        {
	            FileReader fr=new FileReader(Filename); 
	            BufferedReader bread=new BufferedReader(fr); //串流緩衝
	            int ch;
	            boolean a = true;
	            while ((ch=bread.read()) != -1) //BufferedReader 繼承自 Reader 類別的 read() 方法來讀取, 但此方法是一次讀取一個字元, 讀到檔尾時會傳回 -1
	            {          
	            	opench=(char)ch;                     //opench=將ch強制轉成字元
	            	System.out.print(opench);   
	            	if(a==true){a=false;continue;}
		               str=str+String.valueOf(opench);   //字串=字串+強制轉字串後的opench
		              }
	            textArea.setText("");  //清除
	            textArea.setText(str); //最後顯示於TextArea
	            file_name=fd.getFile();
	            First_load = textArea.getText();	//複製原先內容
				change_Timer.start();
	             bread.close();
	             str="";
	        }
	        
	        catch (IOException e) 
	        {
	        	JOptionPane.showConfirmDialog(frame, "注意!\n開啟檔案時發生錯誤，請再試一次!", "錯誤", JOptionPane.OK_OPTION ,0);
	        	System.out.println("error_openfile");  //捕捉異常並顯示"e"
	    	
	        }
	     }
	    }
	}


	/*filedialog方法儲存檔案*/
	private static void fgsaveFile() throws IOException  
	{
		boolean s = false;
		String stringfile; 
		Frame frame = new Frame();
		FileDialog fd = new FileDialog( frame,"儲存檔案", FileDialog.SAVE);   //LOAD=>整數 0 ，設定為開啟檔案的對話視窗
	    fd.setVisible(true); 
	    if(fd!=null)
	    {   
	    	 String string1 = textArea.getText();    //檔案內容字串
	         stringfile = fd.getDirectory()+fd.getFile();//當按路徑+檔案名稱字串
	         if(fd.getDirectory()==null){s=true;}           //最後顯示於TextArea 
	         else  if(!(stringfile.contains(".txt") || stringfile.contains(".TXT")))
	         {
	        	 int n= JOptionPane.showConfirmDialog(frame, "檔案副檔名似乎不是文字文件.txt類型，是否設為此類型?", "副檔名問題", JOptionPane.YES_NO_CANCEL_OPTION ,1);
	        	 if(n==1)
	        	 {
	 	            System.out.println("n=1");  
	        	 }
	        	 else if(n==2)
	        	 {
		        	 JOptionPane.showConfirmDialog(frame, "注意!\n檔案未儲存!", "副檔名問題", JOptionPane.OK_OPTION ,2);
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
	        		BufferedWriter bwrite = new BufferedWriter(new FileWriter(stringfile));  //串流緩衝區
	        		bwrite.write(string1);   //寫入內容
	        		bwrite.close();   //關閉串流
	        		textArea.setText(textArea.getText()); //在對話框後扔保持文字顯示
	        		file_name=fd.getFile();
	        		First_load = textArea.getText();	//更新修改前的檔案
	        	}
	            
	        } 
	        catch (Exception e) 
	        {  
	            // TODO Auto-generated catch block 
	        	JOptionPane.showConfirmDialog(frame, "注意!\n檔案儲存時發生錯誤，請再試一次!", "錯誤", JOptionPane.OK_OPTION ,0);
	            System.out.println("保存失敗");  
	        }   
	    }
	}



    /*開啟新檔事件*/
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	} 

	
}
