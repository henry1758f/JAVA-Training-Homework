package Final_Work;
import javax.swing.*;

import com.sun.glass.events.WindowEvent;

import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class Final_Work  extends JFrame implements ActionListener
{
	
	private static final String Users = null;
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
		JMenuItem item;
		file.add(item = new JMenuItem("開新檔案(N)",KeyEvent.VK_N));
		item.addActionListener(this);
		file.add(item = new JMenuItem("開啟舊檔(O)",KeyEvent.VK_O));
		item.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseReleased(MouseEvent ev)
            {
                //csopenFile();
                fgopenFile();
            }
		});
		file.add(item = new JMenuItem("儲存檔案(S)",KeyEvent.VK_S));
		item.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseReleased(MouseEvent ev)
            {
				fgsaveFile();
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
		item.addActionListener(this);
		edit.add(item = new JMenuItem("複製(C)",KeyEvent.VK_C));
		item.addActionListener(this);
		edit.add(item = new JMenuItem("貼上(P)",KeyEvent.VK_P));
		item.addActionListener(this);
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
		edit.setMnemonic(KeyEvent.VK_O);
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
		help.setMnemonic(KeyEvent.VK_E);
		help.add(item = new JMenuItem("問題回報(R)",KeyEvent.VK_R));
		item.addActionListener(this);
		help.addSeparator();
		help.add(item = new JMenuItem("關於(A)",KeyEvent.VK_A));
		item.addActionListener(this);
		upon.add(help);
		 /*輸入文字區*/
		JTextArea textArea = new JTextArea(); 
	    textArea.setFont(new Font("細明體", Font.PLAIN, 16)); //設定字體及大小
	    textArea.setForeground(Color.black);//設定文字顏色
	    textArea.setBackground(Color.white);//設定背景顏色
	    textArea.setLineWrap(true);
	      
	
	    JScrollPane panel = new JScrollPane(textArea,      
	    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, //設置垂直滾動條策略以使垂直滾動條需要時顯示。
	    //ScrollPaneConstants. VERTICAL_SCROLLBAR_ALWAYS,  //設置垂直滾動條策略以使垂直滾動條一直顯示。
	    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //設置水平滾動條策略以使水平滾動條不顯示。

	      
	    Container contentPane = getContentPane(); 
	    contentPane.add(panel, BorderLayout.CENTER); 
	      
	    /*狀態列*/
	    JLabel stateBar = new JLabel("未修改"); 
	    stateBar.setHorizontalAlignment(SwingConstants.LEFT); //設定水平方向的對齊
	    stateBar.setBorder( 
	    BorderFactory.createEtchedBorder()); 
	    contentPane.add(stateBar, BorderLayout.SOUTH);

	}


	public static void main(String[] args) {
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
		FileDialog fd = new FileDialog( frame,"開啟檔案", FileDialog.LOAD);   //LOAD=>整數 0 ，設定為開啟檔案的對話視窗
	    fd.setVisible(true); 
	    fd.setDirectory("Usernull");
	    if(fd!=null){   
	        Filename=fd.getDirectory() +fd.getFile();   //getDirectory設定檔案的預設路徑, getFile設定檔案的預設檔名
	        System.out.println("FileDialog---->"+Filename);  //顯示選擇的檔案路徑+名稱
	    }
	}
	/*filedialog方法儲存檔案*/
	private static void fgsaveFile() {
		// TODO Auto-generated method stub
		String Filename;  
		Frame frame = new Frame();
		FileDialog fd = new FileDialog( frame,"儲存檔案", FileDialog.SAVE);   //LOAD=>整數 0 ，設定為開啟檔案的對話視窗
	    fd.setVisible(true); 
	    fd.setDirectory("Usernull");
	    if(fd!=null){   
	        Filename=fd.getDirectory() +fd.getFile();   //getDirectory設定檔案的預設路徑, getFile設定檔案的預設檔名
	        System.out.println("FileDialog---->"+Filename);  //顯示選擇的檔案路徑+名稱
	    }
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	} 

	
}
