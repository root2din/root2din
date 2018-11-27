/**
* Указываем, в каком пакете находится класс
*/
package forms;
/**
* Импортируем оконную библиотеку графического интерфейса, необходимые для функционирования класса.
*/
import java.awt.*;
/**
* Импортируем интерфейсы и классы для того, чтобы иметь дело с различными типами событий, 
* запущенных компонентами AWT.
*/
import java.awt.event.*;
/**
 * Импортируем классы проекта, необходимые для функционирования класса
 */
import form.panel.Main_Panel;
import forms.Authorization_Panel;

/**
 * Создаем класс-потомок, который будет выполнять расчет для жителя;
 * он наследуется от класса-родителя (шаблона квартплатного калькулятора)
 */
public class User_Panel extends Main_Panel{

	/**
	 * Создаем конструктор калькулятора жителя
	 */
	public User_Panel() {
		/**
		 * Обращаемся к панели содержимого апплета и 
		 * добавляем компонент (панель)
		 */
		getContentPane().add(panel, "User");
		/**
		 * Добавляем текстовые поля для ввода показателей счетчиков коммунальных услуг;
		 * используем для этого метод класса-родителя.
		 */
		textfields_add(user_textfields_number,user_textfields_name, user_textfields_size, panel);
		/**
		 * Обрабатываем нажатие на кнопку расчета;
		 * обращаемся к кнопке по индексу и переопределяем метод обработки нажатия на данную кнопку;
		 */
		buttons[1].addActionListener(new ActionListener() {
			/**
			 * Аннотация, указывающая на то, что 
			 * мы собираемся переопределить метод обработки класса-родителя
			 */
			@Override
			/**
			 * Метод обработки нажатия на кнопку 
			 */
			public void actionPerformed(ActionEvent e) {
				/**
				 * Вызываем переопределенный в данном классе
				 * метод расчета для жителя.
				 */
				Calc();	
			}
		});
		/**
		 * Обрабатываем нажатие на кнопку выхода;
		 * обращаемся к кнопке по индексу и переопределяем метод обработки нажатия на данную кнопку;
		 * открываем стартовую панель авторизации.
		 */
		buttons[0].addActionListener(new ActionListener() {
			/**
			 * Аннотация, указывающая на то, что 
			 * мы собираемся переопределить метод класса-родителя
			 */
			@Override
			/**
			 * Метод обработки нажатия на кнопку 
			 */
			public void actionPerformed(ActionEvent e) {
				/**
				 * Создаем экземпляр менеджера компоновки
				 * для карточного размещения компонентов
				 */
				CardLayout cl = (CardLayout) getContentPane().getLayout();
				/**
				 * Создаем экземпляр класса авторизации
				 */
				Authorization_Panel af = new Authorization_Panel();
				/**
				 * Добавляем экземпляр класса авторизации
				 * как новую карточку, устанавливаем имя карточки
				 */
				getContentPane().add(af, "Auth");
				/**
				 * Указываем менеджеру компановки,
				 * что нужно показать карточку авторизации
				 */
				cl.show(getContentPane(), "Auth");
			}
		});
	}
	
	/**
	 * Аннотация, указывающая на то, что 
	 * мы собираемся переопределить метод класса-родителя
	 */
	@Override
	/**
	 * Переопределяем абстрактный метод класса-родителя, то есть создаем конкретный метод
	 * расчета квартплаты для жителя дома
	 */
	public void Calc() {
		/**
		 * Заносим введенные показатели по жилью в соответсвующие переменные.
		 */
		area = Double.valueOf(user_textfields[0].getText());
		hot_water = Double.valueOf(user_textfields[1].getText());
		cold_water = Double.valueOf(user_textfields[2].getText());
		electricity =  Double.valueOf(user_textfields[3].getText());
		gas =  Double.valueOf(user_textfields[4].getText());
		
		/**
		 * Если выбран тип жилья "квартира", то расчет производится по следующей формуле
		 * в соответствии с тарифами 
		 */
		if (radiobuttons[0].isSelected()){
			totals =  area*TARIF_HEATING + hot_water*TARIF_HOT_WATER + cold_water*TARIF_COLD_WATER + 
        			gas*TARIF_GAS_FLAT + electricity*TARIF_ELECTRICITY; 
			/**
			 * Округляем результат расчета до сотых (до копеек)
			 */
			totals = Math.rint(100.0*totals)/100.0;
		}
		/**
		 * Если выбран тип жилья "частный дом", то расчет производится 
		 * по следующей формуле в соответствии с тарифами 
		 */
		else if (radiobuttons[1].isSelected()){
			totals = hot_water*TARIF_HOT_WATER + cold_water*TARIF_COLD_WATER + 
        			gas*TARIF_GAS_HOUSE + electricity*TARIF_ELECTRICITY; 
			/**
			 * Округляем результат расчета до сотых (до копеек)
			 */
			totals = Math.rint(100.0*totals)/100.0;
		}
		/**
		 * Выводим результат расчета в отдельное текстовое поле
		 */
		user_textfields[5].setText(String.valueOf(totals));
		
	}
	
}
