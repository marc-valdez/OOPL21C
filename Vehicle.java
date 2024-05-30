class Runner {
	public static void main(String[] args) {
	    Truck t1 = new Truck();
		System.out.println(t1.fuelEfficiency());
		System.out.println(t1.distanceTraveled());
		System.out.println(t1.topSpeed());
		
		Car c1 = new Car();
		System.out.println(c1.fuelEfficiency());
		System.out.println(c1.distanceTraveled());
		System.out.println(c1.topSpeed());
		
		Motorbike m1 = new Motorbike();
		System.out.println(m1.fuelEfficiency());
		System.out.println(m1.distanceTraveled());
		System.out.println(m1.topSpeed());
    }
}

abstract class Vehicle {
	protected String make, model, year, fuelType;
	
	public abstract String fuelEfficiency();
	public abstract String distanceTraveled();
	public abstract String topSpeed();
}

class Truck extends Vehicle {
	Truck() {}
	
	public String fuelEfficiency() {
		return "Truck - Fuel Efficiency";
	}
	
	public String distanceTraveled() {
		return "Truck - Distance Traveled";
	}
	
	public String topSpeed() {
		return "Truck - Top Speed";
	}
}

class Car extends Vehicle {
	Car() {}
	
	public String fuelEfficiency() {
		return "Car - Fuel Efficiency";
	}
	
	public String distanceTraveled() {
		return "Car - Distance Traveled";
	}
	
	public String topSpeed() {
		return "Car - Top Speed";
	}
}

class Motorbike extends Vehicle {
	Motorbike() {}
	
	public String fuelEfficiency() {
		return "Motorbike - Fuel Efficiency";
	}
	
	public String distanceTraveled() {
		return "Motorbike - Distance Traveled";
	}
	
	public String topSpeed() {
		return "Motorbike - Top Speed";
	}
}