
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
	public static int W_width = 700;
	public static int W_height = 700;
	public Final_Work() 
	{
		super ("�O�ƥ�");
		/*�W��U�Ԧ����JMenuBar*/
		JMenuBar upon = new JMenuBar();
		setJMenuBar(upon);
		//�ɮ�
		JMenu file = new JMenu("�ɮ�(F) ");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem item;
		file.add(item = new JMenuItem("�}�s�ɮ�(N)",KeyEvent.VK_N));
		item.addActionListener(this);
		file.add(item = new JMenuItem("�}������(O)",KeyEvent.VK_O));
		item.addActionListener(this);
		file.add(item = new JMenuItem("�x�s�ɮ�(S)",KeyEvent.VK_S));
		item.addActionListener(this);
		file.add(item = new JMenuItem("�t�s�s��(A)",KeyEvent.VK_A));
		item.addActionListener(this);
		file.addSeparator();
		file.add(item = new JMenuItem("�����]�w(U)",KeyEvent.VK_U));
		item.addActionListener(this);
		file.add(item = new JMenuItem("�C�L(P)",KeyEvent.VK_P));
		item.addActionListener(this);
		file.addSeparator();
		file.add(item = new JMenuItem("����(X)",KeyEvent.VK_X));
		item.addActionListener(this);
		upon.add(file);
		//�s��
		JMenu edit = new JMenu("�s��(E) ");
		edit.setMnemonic(KeyEvent.VK_E);
		edit.add(item = new JMenuItem("�_��(Z)",KeyEvent.VK_Z));
		item.addActionListener(this);
		edit.addSeparator();
		edit.add(item = new JMenuItem("�ŤU(T)",KeyEvent.VK_T));
		item.addActionListener(this);
		edit.add(item = new JMenuItem("�ƻs(C)",KeyEvent.VK_C));
		item.addActionListener(this);
		edit.add(item = new JMenuItem("�K�W(P)",KeyEvent.VK_P));
		item.addActionListener(this);
		edit.add(item = new JMenuItem("�R��(L)",KeyEvent.VK_L));
		item.addActionListener(this);
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
		edit.setMnemonic(KeyEvent.VK_O);
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
		statusBar.addActionListener(this);
		view.add(statusBar);
		upon.add(view);
		//����
		JMenu help = new JMenu("����(H) ");
		help.setMnemonic(KeyEvent.VK_E);
		help.add(item = new JMenuItem("���D�^��(R)",KeyEvent.VK_R));
		item.addActionListener(this);
		help.addSeparator();
		help.add(item = new JMenuItem("����(A)",KeyEvent.VK_A));
		item.addActionListener(this);
		upon.add(help);

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
