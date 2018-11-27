/**
* Указываем, в каком пакете находится класс
*/
package forms;
/**
* Импортируем все классы из пакета для создания графического
* интерфейса
*/
import java.awt.*;
/**
* Импортируем оконную библиотеку графического интерфейса, необходимые для функционирования класса.
*/
import java.awt.event.*;
/**
* Импортируем все классы из пакета для работы с графическими
* элементами интерфейса
*/
import javax.swing.*;
/**
 * Импортируем классы проекта, необходимые для функционирования класса
 */
import forms.Accountant_Panel;
import forms.User_Panel;

/**
 * Создаем класс, который наследуется от апплета
 */
public class Authorization_Panel extends JApplet{
	/**
	 * Объявляем переменные, которые доступны только в пределах класса
	 */
	private User_Panel uf;
	private Accountant_Panel af;
	private JPasswordField pass;
	private JTextField JTextField_Login;
	private JPanel panel;
	
	/**
	* Задаем количество меток на панели авторизации
	*/
	public int auth_labels_number = 4;
	/**
	* Объявляем массив меток на панели авторизации, размером 4
	*/
	public JLabel[] auth_labels = new JLabel[auth_labels_number];
	/**
	* Объявляем массив текстов для меток
	*/
	public String auth_labels_text[]={"Авторизация","Логин","Пароль",""};
	/**
	* Объявляем массив размеров для меток, где
	* для каждой метки отведено 4 значения:
	* 1. координата по Х
	* 2. координата по Y
	* 3. ширина метки
	* 4. высота метки
	*/
	public int auth_labels_size[]={170, 39, 230, 42,  111, 113, 55, 24,  111, 151, 55, 24, 111, 240, 223, 24};	
	
	/**
	* Создаем конструктор класса авторизации
	* этот метод будет реализовываться при создании экземпляра класса
	*/
	public Authorization_Panel(){
		/**
		* Обращаемся к панели содержимого апплета и 
		* задаем карточное размещение компонентов на ней 
		*/
		getContentPane().setLayout(new CardLayout());
		/**
		* Создаем экземпляр панели 
		*/
		panel = new JPanel();
		/**
		* Задаем свободное размещение элементов на
		* панели (устанавиваем координаты элементов вручную)
		*/
		panel.setLayout(null);
		/**
		 * Обращаемся к панели содержимого апплета и 
		 * добавляем компонент (панель)
		 */
		getContentPane().add(panel, "Auth");
		/**
		* Добавляем на панель метки
		*/
		auth_labels_add(auth_labels_number, auth_labels_text, auth_labels_size, panel);
		/**
		* Создаем экземпляр текстового поля
		*/
		JTextField_Login = new JTextField();
		/**
		* Устанавливаем размер текстового поля 
		* (10 символов)
		*/
		JTextField_Login.setColumns(10);
		/**
		* Устанавливаем размер текстового поля
		* 4 значения:
		* 1. координата по Х
		* 2. координата по Y
		* 3. ширина текстового поля
		* 4. высота текстового поля
		*/
		JTextField_Login.setBounds(180, 113, 94, 20);
		/**
		* Добавляем текстовое поле на панель
		*/
		panel.add(JTextField_Login);
		/**
		* Создаем экземпляр поля для пароля
		*/
		pass = new JPasswordField();
		/**
		* Устанавливаем размер поля для пароля
		* 4 значения:
		* 1. координата по Х
		* 2. координата по Y
		* 3. ширина поля
		* 4. высота поля
		*/
		pass.setBounds(180, 151, 94, 20);
		/**
		* Добавляем поле для пароля на панель
		*/
		panel.add(pass);

		/**
		* Создаем экземпляр кнопки "Вход"
		*/
		JButton JButton_Enter = new JButton("Вход");
		/**
		* Добавляем слушателя к кнопке 
		*/
		JButton_Enter.addActionListener(new ActionListener() {
			/**
			* Обрабатываем нажатие на кнопку 
			*/
			public void actionPerformed(ActionEvent e) {
				/**
				 * Создаем экземпляр менеджера компоновки
				 * для карточного размещения компонентов
				 */
				CardLayout cl = (CardLayout) getContentPane().getLayout();
				/**
				 * Если логин и пароль для доступа к калькулятору жителя,
				 * (метод возвращает 1),
				 */
				if(auth(JTextField_Login.getText(), pass.getText()) == 1){
					/**
					 * То создаем экземпляр калькулятора для жителя
					 */
					uf = new User_Panel();
					/**
					 * И добавляем на панель содержимого данный экземпляр
					 * как новую карточку
					 */
					getContentPane().add(uf, "User");
					/**
					 * Указываем менеджеру компановки,
					 * что нужно показать карточку калькулятора для жителя
					 */
					cl.show(getContentPane(), "User");
				}
				/**
				 * Если логин и пароль для доступа к калькулятору бухгалтера,
				 * (метод возвращает 2),
				 */
				else if(auth(JTextField_Login.getText(), pass.getText()) == 2){
					/**
					 * То создаем экземпляр калькулятора для бухгалтера
					 */
					af = new Accountant_Panel();
					/**
					 * И добавляем на панель содержимого данный экземпляр
					 * как новую карточку
					 */
					getContentPane().add(af, "Accountant");
					/**
					 * Указываем менеджеру компановки,
					 * что нужно показать карточку калькулятора для бухгалтера
					 */
					cl.show(getContentPane(), "Accountant");
				}
				/**
				 * Если логин и пароль для доступа введены неверно,
				 * (метод возвращает 0),
				 */
				else if(auth(JTextField_Login.getText(), pass.getText()) == 0){
					/**
					 * То присваиваем метке текст "Неверный логин или пароль!"
					 */
					auth_labels[3].setText("Неверный логин или пароль!");
					}
				}
			});
		/**
		 * Устанавливаем шрифт и размер текста на кнопке
		 */
		JButton_Enter.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		/**
		* Задаем размер для кнопки, где
		* 4 значения:
		* 1. координата по Х
		* 2. координата по Y
		* 3. ширина кнопки
		* 4. высота кнопки
		*/
		JButton_Enter.setBounds(180, 198, 94, 31);
		/**
		 * Добавляем кнопку на панель
		 */
		panel.add(JButton_Enter);
		}
	/**
	 * Объявляем переменную, где будет храниться результат 
	 * проверки авторизации
	 */
	private int access;
	/**
	 * Создаем метод для проверки введенных логина и пароля
	 */
	public int auth(String login, String pass){
		/**
		 * Если введены логин и пароль для калькулятора жителя,
		 * то переменной с результатом проверки присваивается 1,
		 */
		if(login.equals("Person") && pass.equals("123")){
			access = 1;
		}
		/**
		 * Если введены логин и пароль для калькулятора бухгалтера,
		 * то переменной с результатом проверки присваивается 2,
		 */
		else if(login.equals("Admin") && pass.equals("123")){
			access = 2;
		}
		/**
		 * Если введены неверные логин и пароль, или ничего
		 * не введено, то переменной с результатом проверки присваивается 0
		 */
		else
		{access = 0;}
		/**
		 * Метод возвращает переменную с результатом проверки
		 */
		return access;
	}
	/**
	* Метод для создания меток 
	* их редактирования и добавления на панель
	*/
	public void auth_labels_add (int auth_labels_number, String auth_labels_text[],int auth_labels_size[],JPanel panel){
		/**
		* Создаем цикл, в котором обрабатываются элементы
		* массива меток 
		*/
		for (int i=0; i<auth_labels_number; i++){
			/**
			* Создаем экземпляр метки
			*/
			auth_labels[i]=new JLabel();
			/**
			* Устанавливаем текст для метки
			*/
			auth_labels[i].setText(auth_labels_text[i]);
			/**
			* Устанавливаем шрифт и размер для 
			* текста метки
			*/
			auth_labels[i].setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
			/**
			* Устанавливаем размеры метки
			*/
			auth_labels[i].setBounds(auth_labels_size[i*4],auth_labels_size[i*4+1],auth_labels_size[i*4+2],auth_labels_size[i*4+3]);
			/**
			* Добавляем метку на панель
			*/
			panel.add(auth_labels[i]);	
		}
	}
	/**
	* Создаем метод для запуска апплета в качестве
	* оконного приложения
	*/
	public static void main(String[] args) {
		/**
		* Создаем экземпляр окна
		*/
	    JFrame frame = new JFrame();
	    /**
		* Создаем экзмепляр апплета 
		* типа класса авторизации
		*/
	    JApplet app = new Authorization_Panel();
	    /**
		* Добавляем апплет на панель содержимого окна
		*/
	    frame.getContentPane().add(app);
	    /**
		* Устанавливаем размер для окна
		*/
	    frame.setSize(400,400);
	    /**
		* Инициализируем апплет
		*/
	    app.init();
	    /**
		* Запускаем апплет
		*/
	    app.start();
	    /**
		* Делаем окно видимым
		*/
	    frame.setVisible(true);
	    /**
		* Указываем, что при закрытии окна (нажатии на крест)
		* происходит выход из программы
		*/
	    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	  }

}
