package practice.lamdas;

public class Lamdas_Runnable_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Legacy Way:
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("inside Runnable 1");
			}
		};
		
		new Thread(runnable).start();
		
		
		//Lambda Way:
		Runnable runnable2 = () -> {
			System.out.println("Inside Runnable 2");
		};
		
		new Thread(runnable2).start();
		
		
		//Lambda Way
		Runnable runnable3 = () -> System.out.println("Inside Runnable 3");
		new Thread(runnable3).start();
		
		//Lambda Way
		new Thread(() -> System.out.println("Inside Runnable 4")).start();
		
		
	}

}
