/*文件編碼請選擇UTF-8*/
package Final_Work;
import javax.swing.*;

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


public class Final_Work  extends JFrame implements ActionListener
{
	
	private static AsString Output [];
	public static String str= new String();
	public static char opench;
	public static JTextArea textArea;
	public static String Filename;
	public static int W_width = 700;	//視窗寬
	public static int W_height = 700;	//視窗高
	public Final_Work() 
	{
		super ("記事本");

		/*上方下拉式選單JMenuBar*/
		JMenuBar upon = new JMenuBar();
		setJMenuBar(upon);
		//檔案
		JMenu file = new JMenu("檔案(F) ");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem open;
		file.add(open= new JMenuItem("開新檔案(N)"));
		open.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_N,InputEvent.CTRL_MASK));//Ctrl快捷鍵
		open.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseReleased(MouseEvent ev)
            {
                textArea.setText("");  //清除
            }
			 
		});
		JMenuItem open1;
		file.add(open1 = new JMenuItem("開啟舊檔(O)"));
		open1.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_O,InputEvent.CTRL_MASK));//Ctrl快捷鍵
		open1.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseReleased(MouseEvent ev)
            {
                fgopenFile();
            }
		});
		JMenuItem item;
		file.add(item = new JMenuItem("儲存檔案(S)",KeyEvent.VK_S));
		item.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseReleased(MouseEvent ev)
            {
				try {
					fgsaveFile();
					} 
				catch (IOException e) {e.printStackTrace();
			}
            }
		});
		file.add(item = new JMenuItem("另存新檔(A)",KeyEvent.VK_A));
		item.addActionListener(this);
		file.addSeparator();
		file.add(item = new JMenuItem("版面設定(U)",KeyEvent.VK_U));
		item.addActionListener(this);
		file.add(item = new JMenuItem("列印(P)",KeyEvent.VK_P));
		item.addActionListener(this);
		file.addSeparator();
		file.add(item = new JMenuItem("結束(X)",KeyEvent.VK_X));
		item.addActionListener(new ActionListener() {              //右上角關閉事件
					public void actionPerformed(ActionEvent e) { 
					closeFile(); 	
					}});
		upon.add(file);
		//編輯
		JMenu edit = new JMenu("編輯(E) ");
		edit.setMnemonic(KeyEvent.VK_E);
		edit.add(item = new JMenuItem("復原(Z)",KeyEvent.VK_Z));
		item.addActionListener(this);
		edit.addSeparator();
		edit.add(item = new JMenuItem("剪下(T)",KeyEvent.VK_T));
		item.addActionListener(new ActionListener(
				) {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	cut();
			}
		});
		edit.add(item = new JMenuItem("複製(C)",KeyEvent.VK_C));
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	copy();
			}
		});
		edit.add(item = new JMenuItem("貼上(P)",KeyEvent.VK_P));
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	paste();
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
		statusBar = new JCheckBoxMenuItem("狀態欄");
		statusBar.addActionListener(this);
		view.add(statusBar);
		upon.add(view);
		//說明
		JMenu help = new JMenu("說明(H) ");
		help.setMnemonic(KeyEvent.VK_H);
		help.add(item = new JMenuItem("問題回報(R)",KeyEvent.VK_R));
		item.addActionListener(this);
		help.addSeparator();
		help.add(item = new JMenuItem("關於(A)",KeyEvent.VK_A));
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showOptionDialog(null, 
						"程式名稱: 簡易型筆記本 \n" + 
						"程式設計者: 吳侑峰  黃宣錡  羅永暉  \n" + 
						"簡介: 簡單的文字編輯器\n" , 
						"關於簡易型筆記本",              //title
						JOptionPane.DEFAULT_OPTION,     
						JOptionPane.INFORMATION_MESSAGE,  //警示圖示
						null, null, null); 
				
			}
		});
		upon.add(help);
		 /*輸入文字區*/
		textArea = new JTextArea(); 
	    textArea.setFont(new Font("細明體", Font.PLAIN, 16)); //設定字體及大小
	    textArea.setForeground(Color.black);//設定文字顏色
	    textArea.setBackground(Color.white);//設定背景顏色
	    textArea.setLineWrap(true);//設定自動換行 
		textArea.setEditable(true);//將textArea設為可編輯(預設)
	    JScrollPane panel = new JScrollPane(textArea,      
	    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, //設置垂直滾動條策略以使垂直滾動條需要時顯示。
	    //ScrollPaneConstants. VERTICAL_SCROLLBAR_ALWAYS,  //設置垂直滾動條策略以使垂直滾動條一直顯示。
	    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //設置水平滾動條策略以使水平滾動條不顯示。
	     
	    	
	    
/*
	    textArea.addMouseListener( 
	    		new MouseAdapter() { 
	    		public void mouseReleased(MouseEvent e) { 
				JPopupMenu popUpMenu = editMenu.getPopupMenu();
	    		if(e.getButton() == MouseEvent.BUTTON3) //表示滑鼠右鍵
	    		{popUpMenu.show(editMenu, e.getX(), e.getY());}
	    		} 
	    		
	    		public void mouseClicked(MouseEvent e) { 
				if(e.getButton() == MouseEvent.BUTTON1) //表示滑鼠左鍵
				{popUpMenu.setVisible(false); }
	    		} }
	    		);*/
	    		
	    Container contentPane = getContentPane(); 
	    contentPane.add(panel, BorderLayout.CENTER); 
	      
	    /*狀態列*/
	    JLabel stateBar = new JLabel("未修改"); 
	    stateBar.setHorizontalAlignment(SwingConstants.LEFT); //設定水平方向的對齊
	    stateBar.setBorder( 
	    BorderFactory.createEtchedBorder()); 
	    contentPane.add(stateBar, BorderLayout.SOUTH);

	}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Final_Work mainWin = new Final_Work();
		//mainWin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		mainWin.addWindowListener(                           //右上角關閉事件
				new WindowAdapter() { 
				public void windowClosing(WindowEvent e) { 
				closeFile(); 
				}}); 	
		
		mainWin.setSize(W_width, W_height);
		mainWin.setVisible(true);
		
		
	}

	/*關閉檔案*/
	private static void closeFile() {
		// TODO Auto-generated method stub
		 System.exit(0);
	}

	/*chooser方法開檔*/
	private static void csopenFile() {
		// TODO Auto-generated method stub
		JFileChooser chooser = new JFileChooser();
		int confirm = chooser.showOpenDialog(null);
		if (confirm == chooser.APPROVE_OPTION){
    	//JOptionPane.showMessageDialog(null, "Your file: " + chooser.getSelectedFile() + "\n,in " + chooser.getCurrentDirectory() + ".", "Message", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	/*filedialog方法開檔*/
	private static void fgopenFile() {
		// TODO Auto-generated method stub
		String Filename;  
		Frame frame = new Frame();
		FileDialog fd = new FileDialog( frame,"開啟舊檔", FileDialog.LOAD);   //LOAD=>整數 0 ，設定為開啟檔案的對話視窗
	    fd.setVisible(true); 
	    if(fd!=null){   
	        Filename=fd.getDirectory() +fd.getFile();   //getDirectory設定檔案的預設路徑, getFile設定檔案的預設檔名
	        System.out.println("FileDialog---->"+Filename);  //顯示選擇的檔案路徑+名稱
	        
	        try {
	            FileReader fr=new FileReader(Filename); 
	            BufferedReader bread=new BufferedReader(fr); //串流緩衝
	            int ch;
	            int a = 0;
	            while ((ch=bread.read()) != -1) {          //BufferedReader 繼承自 Reader 類別的 read() 方法來讀取, 但此方法是一次讀取一個字元, 讀到檔尾時會傳回 -1
	              opench=(char)ch;                     //opench=將ch強制轉成字元
	              System.out.print(opench);   
	              a++;
	             if(a==1){continue;}
	               str=str+String.valueOf(opench);   //字串=字串+強制轉字串後的opench
	              }
	             textArea.setText("");  //清除
	             textArea.setText(str);           //最後顯示於TextArea 
	             bread.close();
	            }
	        
	          catch (IOException e) {System.out.println(e);  //捕捉異常並顯示"e"
	    	
	    }}
	}



	/*filedialog方法儲存檔案*/
	private static void fgsaveFile() throws IOException  {
		// TODO Auto-generated method stub
		String stringfile; 
		Frame frame = new Frame();
		FileDialog fd = new FileDialog( frame,"儲存檔案", FileDialog.SAVE);   //LOAD=>整數 0 ，設定為開啟檔案的對話視窗
	    fd.setVisible(true); 
	    if(fd!=null){   
	    	 String string1 = textArea.getText();    //檔案內容字串
	         stringfile = fd.getDirectory()+fd.getFile()+".txt";       //當按路徑+檔案名稱字串   
	        try {  
	            BufferedWriter bwrite = new BufferedWriter(new FileWriter(stringfile));  //串流緩衝區
	            bwrite.write(string1);   //寫入內容
	            bwrite.close();   //關閉串流
	            textArea.setText(textArea.getText()); //在對話框後扔保持文字顯示
	        } catch (Exception e) {  
	            // TODO Auto-generated catch block  
	            System.out.println("保存失敗");  
	        }   
	        
	       }
	          }
	    
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	} 

	
}
