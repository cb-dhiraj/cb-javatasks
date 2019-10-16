public class Audi implements Car{
	int model=0, horsePower=0;
	String colour = "";
	Audi(String colour, int model, int horsePower){
		this.colour = colour;
		this.model = model;
		this.horsePower = horsePower;
	}
	@Override
	public int getDiscount(){
		if(this.horsePower == 200 && this.model == 2019){
			return 1000;
		}
		else{
			return 3000;
		}
	}
}