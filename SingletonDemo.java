class Singleton{
	
	private static Singleton instance = null;

	private Singleton(){
	}

	public static Singleton getInstance(){
		if(instance==null)
		{
			instance = new Singleton();
		}
		return instance;
	}

	public static void showTypeInstance(){
		System.out.println("Singleton Class Instance Called!");
	}
}

public class SingletonDemo{
	public static void main(String[] args){

		Singleton obj= Singleton.getInstance();
		obj.showTypeInstance();
	}
}