public class test
{
    public static void main(String args[])
    {/*
		String s1="Kalti";
	String s2="Kalti";
	System.out.println(s1==s2);//true
	System.out.println(s1=="Kalti");//true
	System.out.println(s1.equals(s2));//true
     */

	
	/* char valeur[] = {'K', 'a', 'l', 'k', 'i'};
    String s1 = new String(valeur);
    String s2 = new String(valeur);

    System.out.println(s1 == s2);//false
    System.out.println(s1 == "Kalki");//false*/

	String s1=new String("ab");
	String s2=new String("ab");
	/*s1="HEllo";
	  s2="HEllo";*/
	System.out.println(s1==s2);//true=>false(pas la même référence).
	System.out.println(s1.equals(s2));//true(moins faible).
	


    }
}
