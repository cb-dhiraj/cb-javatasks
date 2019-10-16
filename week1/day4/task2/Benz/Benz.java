public class Benz implements Car{
	int model=0, horsePower=0;
	String colour = "";
	Benz(String colour, int model, int horsePower){
		this.colour = colour;
		this.model = model;
		this.horsePower = horsePower;
	}
	@Override
	public int getDiscount(){
		return 0;
	}
}