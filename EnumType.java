
class EnumType{
    //Demo1 : Use of enumerated type
    static enum Games {CRICKET, TENNIS, CHESS, FOOTBALL,BANDMINTON, BASKETBALL};

    //Demo2 : Defining an enumerated type with Attributes and Method
    public enum Desc{
    CRICKET("Virat Kohli"),TENNIS("Sania Mirza"),CHESS("Vishwathanand"),FOOTBALL("Christiano Ronaldo");
    private String desc;
    //Contructor : NOTE: enum contructor should be private to prevent it from being invoked directly.
    private Desc(String desc)
    {
        this.desc = desc;
    }
    public String getDesc(){
        System.out.println("Indian Sports star: ");
        return desc;
    }
}

    public static void main(String args[])
    {
        //Demo1
        Games g1 = Games.CHESS;
        Games g2 = Games.FOOTBALL;
        System.out.println("First game is: "+g1.name());// give the name of the assigned values
        System.out.println("Second game is: "+g2.name());
        System.out.println("First game's oridnal or Index is: "+g1.ordinal()); //returns the Ordinal values
        System.out.println("Second game's ordinal or Index is: "+g2.ordinal());
        System.out.println("G1 is equal to G2 returns: "+g1.equals(g2)); //
        System.out.println("G1 string value is: "+g1.toString());
        System.out.println("G1 compare to G2 returns: "+g1.compareTo(g2));
            //Using for loop for accesing values
            Games[] gm = Games.values();
            for(Games str: gm)
            {
                System.out.println("Game Name: "+str);
            }
        System.out.println();
        //Demo 2 
        Desc player = Desc.FOOTBALL;
        Desc player2 = Desc.CRICKET;
        System.out.println(player.getDesc());
        System.out.println(player2.getDesc()+"\n");
        //Use of If condition
        if(player.equals(Desc.FOOTBALL)){
            System.out.print(player.getDesc());
        }
        else{
            System.out.println("Not equal type of Game");
        }
    }
    
}