

//define a functional interface
@FunctionalInterface
interface WorkerInterface {

	public void doSomeWork();

}


public class WorkerInterfaceTest {

	public static void execute(WorkerInterface worker) {
		worker.doSomeWork();
	}

	public static void main(String [] args) {

		// Testing the old looping:
		String[] names = {"Kamonyo", "Mugabo", "Richard", "Herve"};
		names.forEach(n -> System.out.println(n));

		//invoke doSomeWork using Annonymous class
		execute(new WorkerInterface() {
			@Override
			public void doSomeWork() {
				System.out.println("\tWorker invoked using Anonymous class");
			}
		});
	
		//invoke doSomeWork using Lambda expression	
		execute( () -> System.out.println("\tWorker invoked using Lambda expression") );
	}

}