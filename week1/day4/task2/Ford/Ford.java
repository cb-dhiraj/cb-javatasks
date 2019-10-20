public class Ford implements Car{
	int model=0, horsePower=0;
	String colour = "";
	Ford(String colour, int model, int horsePower){
		this.colour = colour;
		this.model = model;
		this.horsePower = horsePower;
	}
	@Override
	public int getDiscount(){
		if(this.colour == "Black" && this.horsePower == 100){
			return 500;
		}
		else{
			return 2000;
		}
	}
}