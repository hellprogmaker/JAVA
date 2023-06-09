public class Car extends Transport implements ILights {

	private boolean isOn; // включение света;
	public Engine engine = new Engine(); // рабочий двигатель, car проехал 100 км.

	public Car(double speed, double weight, String color) {

		super(speed, weight, color); // вызов конструктора родительского класса;
	}

	// super - это обращение напрямую к родительскому классу;
	// то же, что this, но для родительского класса;

	public Car() {

		super();
	}

	public void Show() {

		super.Show();
	}

	// нужно реализовывать все абстрактные методы абстрактного класса. Поэтому:
	@Override
	public void ShowSpeed(double speed) {

		System.out.println("Object speed: " + speed);
	}

	@Override
	public void SetLight(boolean set) {

		isOn = set;
	}

	@Override
	public void BlinkLight() {

		System.out.println("Light turned on.");
	}
}
