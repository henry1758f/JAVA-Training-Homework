package qwe;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ewq extends JFrame implements ActionListener
{
	 private JRadioButtonMenuItem red, green, blue;
	 private Container c;
	
	 public  ewq()
	{
		 super ("JMenuBar元件範例");
	      c = getContentPane();
	      c.setBackground(Color.white);
	      
	      JMenuBar jmb = new JMenuBar();
	      setJMenuBar(jmb);  // 新增下拉式功能表
	      
	      
	      /*第一個選單*/
	      JMenu file = new JMenu("檔案(F)");
	      file.setMnemonic(KeyEvent.VK_F);
	      
	      JMenuItem item;
	      file.add(item = new JMenuItem("開啟檔案(N)    Alt+N",KeyEvent.VK_N));
	      item.addActionListener(this);
	      
	      file.add(item = new JMenuItem("開啟舊檔(O)    Alt+O",KeyEvent.VK_O));
	      item.addActionListener(this);
	      
	      file.add(item = new JMenuItem("儲存檔案(S)    Alt+S",KeyEvent.VK_S));
	      item.addActionListener(this);
	      
	      file.add(item = new JMenuItem("另存新檔(A)    Alt+A",KeyEvent.VK_A));
	      item.addActionListener(this);
	      
	      file.addSeparator();  // 分隔線
	      
	      file.add(item = new JMenuItem("版面設定(U)    Alt+U",KeyEvent.VK_U));
	      item.addActionListener(this);

	      /*
	      JMenu setting = new JMenu("參數設定"); // 子選單
	      setting.add(item = new JMenuItem("編碼"));
	      item.addActionListener(this);
	      setting.add(item = new JMenuItem("字型"));
	      item.addActionListener(this);
	      file.add(setting);    // 新增子選單*/
	      
	      file.addSeparator();  // 分隔線
	      file.add(item = new JMenuItem("結束(X)             Alt+X",KeyEvent.VK_X));
	      item.addActionListener(this);
	
	      jmb.add(file); // 新增file選單
	      
	      
	      /*第二個選單*/
	      JMenu edit = new JMenu("編輯(E)");
	      edit.setMnemonic(KeyEvent.VK_E);
	      
	      edit.add(item = new JMenuItem("復原(Z)      Alt+Z",KeyEvent.VK_Z));
	      item.addActionListener(this);
	      
	      edit.addSeparator();  // 分隔線
	      
	      edit.add(item = new JMenuItem("剪下(T)      Alt+T",KeyEvent.VK_T));
	      item.addActionListener(this);
	      
	      edit.add(item = new JMenuItem("複製(C)      Alt+C",KeyEvent.VK_C));
	      item.addActionListener(this);
	      
	      edit.add(item = new JMenuItem("貼上(P)      Alt+P",KeyEvent.VK_P));
	      item.addActionListener(this);
	      
	      edit.add(item = new JMenuItem("刪除(L)      Alt+L",KeyEvent.VK_L));
	      item.addActionListener(this);
	      
	      edit.addSeparator();  // 分隔線
	      
	      edit.add(item = new JMenuItem("全選(A)      Alt+A",KeyEvent.VK_A));
	      item.addActionListener(this);
	      
	      jmb.add(edit); // 新增file選單
	      
	      /*第三個選單*/
	      JMenu  form= new JMenu("格式(O)");
	      form.setMnemonic(KeyEvent.VK_O);
	      
	      
	      JCheckBoxMenuItem autowrap;
	      autowrap = new JCheckBoxMenuItem("自動換行");
	      autowrap.addActionListener(this);
	      form.add(autowrap);
	      
	      JCheckBoxMenuItem font;
	      font = new JCheckBoxMenuItem("字型");
	      font.addActionListener(this);
	      form.add(font);
	      jmb.add(form);
	      
	      /* 第四個選單*/
	      JMenu  explain= new JMenu("說明(H)");
	      explain.setMnemonic(KeyEvent.VK_H);
	      
	      explain.add(item = new JMenuItem("關於"));
	      item.addActionListener(this);
	      
	      jmb.add(explain); // 新增file選單
	      
	     
	      
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ewq app =new ewq();
		app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//打X按鈕
		app.setSize(300,150);//視窗大小
		app.setVisible(true);//顯示視窗
	}
	public void actionPerformed(ActionEvent evt) {
	     
	   }
}
