public class Types{
	String type;
	int length;
	Types(String type, int length){
		this.type = type;
		this.length = length;
	}

	public int getDiscount(){
		if(this.type == "Sedan" && this.length == 15){
			return 1000;
		}
		else{
			return 2000;
		}
	}
}