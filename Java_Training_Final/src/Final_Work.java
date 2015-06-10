
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
/**
 * @author henry1758f , Lilyo .
 *
 */
public class Final_Work  extends JFrame implements ActionListener
{
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
		item.addActionListener(this);
		file.add(item = new JMenuItem("儲存檔案(S)",KeyEvent.VK_S));
		item.addActionListener(this);
		file.add(item = new JMenuItem("另存新檔(A)",KeyEvent.VK_A));
		item.addActionListener(this);
		file.addSeparator();
		file.add(item = new JMenuItem("版面設定(U)",KeyEvent.VK_U));
		item.addActionListener(this);
		file.add(item = new JMenuItem("列印(P)",KeyEvent.VK_P));
		item.addActionListener(this);
		file.addSeparator();
		file.add(item = new JMenuItem("結束(X)",KeyEvent.VK_X));
		item.addActionListener(this);
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Final_Work mainWin = new Final_Work();
		mainWin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		mainWin.setSize(W_width, W_height);
		mainWin.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
