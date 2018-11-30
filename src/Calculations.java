/**
 * Создаем класс, который будет выполнять расчет
*/
public class Calculations {
	/**определяем тарифы по услугам.
	 *
	 */
	public final static double Tarif_Hot_Water = 141.44;
	public final static double Tarif_Cold_Water = 22.21;
	public final static double Tarif_Heating = 37.47;
	public final static double Tarif_Gas_Flat = 6.50;
	public final static double Tarif_Electricity = 2.74;
	public final static double Tarif_Gas_House = 4994.02;
	public final static double kommunalka = 0;

// метод, возвращающий значение kommunalka для квартиры
            public static double getPrice_Flat (double Flat_Size, double Hot_Water, double Cold_Water, double Gas_Flat,double Electricity) {
            //объявляем kommunalka
            	double kommunalka = 0;

            //формула расчета для квартиры
            	kommunalka =  Flat_Size*Tarif_Heating + Hot_Water*Tarif_Hot_Water + Cold_Water*Tarif_Cold_Water +
            			Gas_Flat*Tarif_Gas_Flat + Electricity*Tarif_Electricity;
            	kommunalka = Math.rint(100.0*kommunalka)/100.0;
            	return (kommunalka);
			}

}
