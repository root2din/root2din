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
* Импортируем все классы из пакета для работы с графическими
* элементами интерфейса
*/
import javax.swing.*;
/**
 * Импортируем классы проекта, необходимые для функционирования класса
 */
import form.panel.Main_Panel;

/**
 * Создаем класс-потомок, который будет выполнять расчет для бухгалтера;
 * он наследуется от класса-родителя (шаблона квартплатного калькулятора)
 */
public class Accountant_Panel extends Main_Panel{

	/**
	 * Создаем конструктор калькулятора бухгалтера
	 */
	public Accountant_Panel(){
		/**
		 * Обращаемся к панели содержимого апплета и 
		 * добавляем компонент (панель)
		 */
		getContentPane().add(panel, "Accountant");
		/**
		 * Добавляем текстовые поля для ввода показателей для расчета итоговой квартплаты;
		 * используем для этого переопределенный в данном классе метод класса-родителя.
		 */
		textfields_add(accountant_textfields_number, accountant_textfields_name, accountant_textfields_size, panel);
		/**
		 * Добавляем метки бухгалтерского калькулятора;
		 * используем для этого метод класса-родителя.
		 */
		labels_add(accountant_labels_number, accountant_labels_text, accountant_labels_size, panel);
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
				 * метод расчета для бухгалтера.
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
	 * расчета квартплаты для бухгалтера
	 */
		public void Calc() 
		{
		/**
		 * Заносим введенные показатели по жилью в соответсвующие переменные.
		 */
		area = Double.valueOf(accountant_textfields[0].getText());
		hot_water = Double.valueOf(accountant_textfields[1].getText());
		cold_water = Double.valueOf(accountant_textfields[2].getText());
		electricity =  Double.valueOf(accountant_textfields[3].getText());
		gas =  Double.valueOf(accountant_textfields[4].getText());
		house_cleaning = Double.valueOf(accountant_textfields[6].getText());
		house_lightning =Double.valueOf(accountant_textfields[7].getText());
		street_cleaning = Double.valueOf(accountant_textfields[8].getText());
		house_repairing = Double.valueOf(accountant_textfields[9].getText());

		/**
		 * Если выбран тип жилья "квартира", то расчет производится по следующей формуле
		 * в соответствии с тарифами 
		 */
		if (radiobuttons[0].isSelected()){
		totals =  area*TARIF_HEATING + hot_water*TARIF_HOT_WATER + cold_water*TARIF_COLD_WATER + 
    			gas*TARIF_GAS_FLAT + electricity*TARIF_ELECTRICITY + house_cleaning + house_lightning +
    			street_cleaning + house_repairing; 
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
    			gas*TARIF_GAS_HOUSE + electricity*TARIF_ELECTRICITY + house_cleaning + house_lightning +
    			street_cleaning + house_repairing; 
		/**
		 * Округляем результат расчета до сотых (до копеек)
		 */
		totals = Math.rint(100.0*totals)/100.0;
		}
		/**
		 * Выводим результат расчета в отдельное текстовое поле
		 */
		accountant_textfields[5].setText(String.valueOf(totals));	
		}
	/**
	 * Аннотация, указывающая на то, что 
	 * мы собираемся переопределить метод класса-родителя
	 */
	@Override
	/**
	* Метод для создания текстовых полей 
	* их редактирования и добавления на панель
	*/
	public void textfields_add (int accountant_textfields_number,String accountant_textfields_name[],int accountant_textfields_size[],JPanel panel){
		/**
		* Создаем цикл, в котором обрабатываются элементы
		* массива текстовых полей
		*/
		for (int i=0; i<accountant_textfields_number; i++){
			/**
			* Создаем экземпляр текстового поля
			*/
			accountant_textfields[i]=new JTextField();
			/**
			* Устанавливаем начальное значение
			* для текстового поля (0)
			*/
			accountant_textfields[i].setText("0");
			/**
			* Устанавливаем имя для текстового поля
			*/
			accountant_textfields[i].setName(accountant_textfields_name[i]);
			/**
			* Устанавливаем размеры текстового поля
			*/
			accountant_textfields[i].setBounds(accountant_textfields_size[i*4],accountant_textfields_size[i*4+1],
			accountant_textfields_size[i*4+2],accountant_textfields_size[i*4+3]);
			/**
			* Добавляем текстовое поле на панель
			*/
			panel.add(accountant_textfields[i]);			
		}
	}
}
	
