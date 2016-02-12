import com.consumer.Consumer;
import com.proceduce.Proceducer;



public class Test {
	
	
	public static void main(String[] args) {
		new Proceducer().startProceduce();
		new Thread(new Consumer()).start();
		
	}

}
