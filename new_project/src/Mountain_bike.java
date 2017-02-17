
public class Mountain_bike extends Bicycle {
	int chain_ring;
	double gear_ratio;
	void change_chain(int new_value){
		chain_ring = new_value;
	}
	void gear_ratio(int new_value){
		gear_ratio = new_value;
	}
	void printStates() {
        System.out.println("cadence:" +
            cadence + " speed:" + 
            speed + " gear:" + gear + "chain" + chain_ring);
   }
}
