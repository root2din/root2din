/**
* Импортируем все классы из пакета для работы с графическими
* элементами интерфейса
*/
import javax.swing.*;
/** Импортируем интерфейсы и классы для того, чтобы иметь дело с различными типами событий,
* запущенных компонентами AWT.
*/
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 *  Создаем класс, в котором будут содержаться формы для ввода, кнопки, окно вывода.
*/
public class frame1 extends JApplet {
	  /**
     * Объявляем форму
     */
	public JFrame frame;
	 /**
     * Объявляем массив кнопок
     */
	public final ButtonGroup buttonGroup = new ButtonGroup();
	  /**
     * Объявляем поля ввода данных
     */
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	  /**
     * Объявляем rdbtnNewRadioButton для выбора типа собственности.
     */
    public JRadioButton rdbtnNewRadioButton;
	  /**
     * Объявляем поле вывода
     */
	public JTextField textField_8;
	public String saved;
	public JLabel lblNewLabel_12;
	  /**
     * Объявляем кнопку, нажатие на которую передает вводные данные в Calculations.java
     */
	public JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/**
					 *Создаем экземпляр нашего приложения.
					 */
					frame1 window = new frame1();
					/**
					 * С этого момента приложение запущено
					 */
					window.frame.setVisible(true);
				}  /**
				 * печатает трассировку стека Exception
				 */
				catch (Exception e) {
					/**
					 *   до System.err.
					 */
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public frame1() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		/**
	     *  frame
	     *  * для каждой метки отведено 4 значения:
	     * 1. координата по Х
	     * 2. координата по Y
	     * 3. ширина метки
	     * 4. высота метки
	     */
		frame.setBounds(100, 100, 500, 400);
		   /**
         * Указываем, что при закрытии окна (нажатии на крест)
         * происходит выход из программы
         */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().setLayout(null);
		  /**
	     * чек-бокс квартира.  В дальнейшем определяет функцию расчета
	     *  * для каждой метки отведено 4 значения:
	     * 1. координата по Х
	     * 2. координата по Y
	     * 3. ширина метки
	     * 4. высота метки
	     */
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Квартира");
		/**
		 * добавляем чекбокс в buttonGroup
		 */
		buttonGroup.add(rdbtnNewRadioButton);
		/**
		 * положение по умолчанию
		 */
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(31, 51, 149, 23);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(rdbtnNewRadioButton);
		  /**
	     * чек-бокс Частный дом. В дальнейшем определяет функцию расчета
	     * для каждой метки отведено 4 значения:
	     * 1. координата по Х
	     * 2. координата по Y
	     * 3. ширина метки
	     * 4. высота метки
	     */
		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Частный дом");
		/**
		 * добавляем чекбокс в buttonGroup
		 */
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(31, 79, 149, 23);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(rdbtnNewRadioButton_1);

		/**
	     * в зависимости от значения, неоходимо скрывать поля ввода.
	     */
		  /**
         * Добавляем слушателя к чекбоксу
         */
		rdbtnNewRadioButton.addActionListener(new ActionListener(){
			/**
			* Метод обработки положения чекбокса
             */
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected()) {
					/**поле газа для частного дома невидимо, площадь и показание газа для квартиры видимы.
					 *
					 */
					textField.setVisible(true);
					textField_5.setVisible(false);
					textField_2.setVisible(true);
					textField_4.setVisible(true);
				}
			}
		});

		/**
	     * в зависимости от значения, неоходимо скрывать поля ввода.
	     */
		   /**
         * Добавляем слушателя к чекбоксу
         */
		rdbtnNewRadioButton_1.addActionListener(new ActionListener(){
			/**
			* Метод обработки положения чекбокса
             */
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton_1.isSelected()) {
					/**поле газа для частного дома видимо, площадь и показание газа для квартиры не видимы.
					 *
					 */
					textField.setVisible(false);
					textField_5.setVisible(true);
					textField_2.setVisible(false);
					textField_4.setVisible(false);
				}
			}
		});
		 /**
         * Создаем экземпляр кнопки "Рассчитать"
         */
		JButton btnNewButton = new JButton("Рассчитать");
		   /**
         * Добавляем слушателя к кнопке
         */
		btnNewButton.addMouseListener(new MouseAdapter() {
			 /**
             * Метод обработки нажатия на кнопку
             */
			public void mouseClicked(MouseEvent arg0) {
				/**
		        * Объявляем переменные, которым возвращаются значения функции.
		        */
				double Price_Flat = 0;
				double Price_House = 0;
				/**
				 * Забираем переменные из полей ввода
				 */
			    /**
			        * В зависимости от положение чекбокса вызываем функцию.
			        */
			  if  ( rdbtnNewRadioButton.isSelected() == true) {
				  /**
					 * Забираем переменные из полей ввода
					 */
				  if((textField_1.getText().length() > 0) & (textField.getText().length() > 0) & (textField_2.getText().length() > 0)
						  & (textField_3.getText().length() > 0)& (textField_4.getText().length() > 0)
						  )
					{
					  double Cold_Water = Double.parseDouble(textField_1.getText());
					    double Electricity = Double.parseDouble(textField_3.getText());
				double Hot_Water = Double.parseDouble(textField.getText());
			 	double Flat_Size = Double.parseDouble(textField_4.getText());
				double Gas_Flat = Double.parseDouble(textField_2.getText());
				/**
				 * функция расчета для квартиры
				 */
				Price_Flat = Calculations.getPrice_Flat(Flat_Size, Hot_Water, Cold_Water, Gas_Flat, Electricity);
			   	textField_8.setText(Double.toString(Price_Flat));
			   	JOptionPane.showMessageDialog(null, "Расчет для квартиры выполнен");
			   	saved = textField_8.getText();
					} else JOptionPane.showMessageDialog(null, "Введите все данные");
			  }
			  if (rdbtnNewRadioButton_1.isSelected() == true)  {
			    	{
			    		if((textField_1.getText().length() > 0) & (textField_3.getText().length() > 0) & (textField_5.getText().length() > 0)
							)
			    		{
/**
 * Функция расчета для Частного дома.
 */
			    		double Cold_Water = Double.parseDouble(textField_1.getText());
					    double Electricity = Double.parseDouble(textField_3.getText());
			    		double Gas_House = Double.parseDouble(textField_5.getText());
			   			Price_House = Calculations.getPrice_House(Cold_Water, Gas_House, Electricity);
			   			textField_8.setText(Double.toString(Price_House));
				    	JOptionPane.showMessageDialog(null , "Расчет для частного дома выполнен");
				}  else JOptionPane.showMessageDialog(null, "Введите все данные");
			    		}
			}}
		});
		 /**
         * Добавляем слушателя к кнопке
         */
		btnNewButton.addActionListener(new ActionListener() {
			 /**
             * Метод обработки нажатия на кнопку
             */
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(319, 261, 117, 25);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(btnNewButton);
	     /** Объявляем JLabel, для вывода подписи Выберите тип собственности
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		JLabel lblNewLabel = new JLabel("Выберите тип собственности");
		lblNewLabel.setBounds(30, 28, 366, 15);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(lblNewLabel);

	    /** Объявляем JLabel, для вывода подписи Горячая вода
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		JLabel lblNewLabel_1 = new JLabel("Горячая вода");
		lblNewLabel_1.setBounds(31, 110, 117, 15);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(lblNewLabel_1);
		/** Объявляем JLabel, для вывода подписи Холодная вода
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		JLabel lblNewLabel_2 = new JLabel("Холодная вода");
		lblNewLabel_2.setBounds(31, 137, 120, 15);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(lblNewLabel_2);
		 /** Объявляем JLabel, для вывода подписи куб. м.
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		JLabel lblNewLabel_3 = new JLabel("куб.м");
		lblNewLabel_3.setBounds(237, 110, 70, 15);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(lblNewLabel_3);
		/** Объявляем JLabel, для вывода подписи куб .м
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		JLabel lblNewLabel_4 = new JLabel("куб.м");
		lblNewLabel_4.setBounds(237, 137, 70, 15);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(lblNewLabel_4);

		/** Объявляем JLabel, для вывода подписи Газ
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		JLabel lblNewLabel_5 = new JLabel("Газ");
		lblNewLabel_5.setBounds(31, 163, 70, 15);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(lblNewLabel_5);
		/** Объявляем JLabel, для вывода подписи Электричество
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		JLabel lblNewLabel_6 = new JLabel("Электричество");
		lblNewLabel_6.setBounds(31, 190, 117, 15);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(lblNewLabel_6);
		 /** Объявляем JLabel, для вывода подписи квт*час
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		JLabel lblNewLabel_7 = new JLabel("квт*час");
		lblNewLabel_7.setBounds(237, 190, 70, 15);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(lblNewLabel_7);
		 /** Объявляем JLabel, для вывода подписи  куб. м.
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		JLabel lblNewLabel_8 = new JLabel("куб.м");
		lblNewLabel_8.setBounds(237, 163, 70, 15);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(lblNewLabel_8);
		 /** Объявляем JLabel, для вывода подписи Площадь
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		JLabel lblNewLabel_9 = new JLabel("Площадь");
		lblNewLabel_9.setBounds(214, 55, 70, 15);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(lblNewLabel_9);
		/** Объявляем JLabel, для вывода подписи кв .м
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		JLabel lblNewLabel_10 = new JLabel("кв.м");
		lblNewLabel_10.setBounds(355, 55, 70, 15);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(lblNewLabel_10);
		/** Объявляем JLabel, для вывода подписи тыс. куб. м.
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		JLabel lblNewLabel_11 = new JLabel("тыс.куб.м");
		lblNewLabel_11.setBounds(355, 163, 83, 15);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(lblNewLabel_11);
		 /** Объявляем TextField, для ввода  данных показаний горячей воды
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		textField = new JTextField();
		textField.setBounds(156, 110, 63, 19);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				        // TODO add your handling code here:
				        char c=evt.getKeyChar();
				         // if(Character.isLetter(c)&&!evt.isAltDown())
				        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
				        {
				            evt.consume();
				        }
				    }
			});
		/**
		  *
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		/** Объявляем TextField, для ввода  данных показаний Холодной воды
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
		        // TODO add your handling code here:
		        char c=evt.getKeyChar();
		        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
		        {
		            evt.consume();
		        }
		    }
		});
		textField_1.setBounds(156, 135, 63, 19);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		/** Объявляем TextField, для ввода  данных показаний Газа
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
		        // TODO add your handling code here:
		        char c=evt.getKeyChar();
		      if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
		        {
		            evt.consume();
		        }
		    }
		});
		textField_2.setBounds(156, 161, 63, 19);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		/** Объявляем TextField, для ввода  данных показаний Газа
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
		        // TODO add your handling code here:
		        char c=evt.getKeyChar();
		        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
		        {
		            evt.consume();
		        }
		    }
		});
		textField_3.setBounds(156, 188, 63, 19);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		/** Объявляем TextField, для ввода  значения площади
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
		        // TODO add your handling code here:
		        char c=evt.getKeyChar();
		        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
		        {
		            evt.consume();
		        }
		    }
		});
		textField_4.setBounds(292, 53, 45, 19);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		/** Объявляем TextField, для ввода  данных показаний Газа в частном доме тыс.куб.
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
		        // TODO add your handling code here:
		        char c=evt.getKeyChar();
		        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
		        {
		            evt.consume();
		        }
		    }
		});
		textField_5.setBounds(292, 161, 51, 19);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		/** Объявляем TextField, для вывода  расчетов Итого
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		textField_8 = new JTextField();
		textField_8.setBounds(118, 229, 114, 19);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		/** Объявляем Jlabel, для подписи Итого рядом с поле вывода данных.
	      * для каждой метки отведено 4 значения:
	         * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
	         */
		JLabel lblNewLabel_12 = new JLabel("Итого");
		lblNewLabel_12.setBounds(31, 231, 70, 15);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(lblNewLabel_12);
		/**
             * Создаем экземпляр кнопки "Вход"
       		 * обрабатываем нажатие на кнопку выхода;
       		 * для каждой метки отведено 4 значения:
		 	 * 1. координата по Х
	         * 2. координата по Y
	         * 3. ширина метки
	         * 4. высота метки
		 */
		JButton btnNewButton_1 = new JButton("Выход");
		/**
         * Добавляем слушателя к кнопке
         */
		btnNewButton_1.addActionListener(new ActionListener() {
			 /**
             * Метод обработки нажатия на кнопку
             */
			public void actionPerformed(ActionEvent e) {
		        System.exit(0);
			}
		});
		btnNewButton_1.setBounds(31, 261, 117, 25);
		 /**
         * Добавляем компонент на панель содержимого окна
         */
		frame.getContentPane().add(btnNewButton_1);

			}
	}