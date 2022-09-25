public class TestJauge
{
    public static void main(String[] args)
    {
	int nbr_tests=4;
	int a=0;
	Jauge jauge=new Jauge(100,200);//depart > max
	assert jauge.estRouge()==true;
	assert jauge.estVert()==false;//(probleme d'implementation)
	System.out.println(".");
	a++;
	//1er cas de test.
	jauge=new Jauge(100,100);//depart=max
	assert jauge.estRouge()==true;
	assert jauge.estVert()==false;//(de meme)
	System.out.println(".");
	a++;
	jauge=new Jauge(100,-5);//-5 est incompréhensible.[contexte]
	assert jauge.estRouge()==false;
	assert jauge.estVert()==true;
	System.out.println(".");
	a++;
	jauge=new Jauge(100,0);
	assert jauge.estRouge()==false;
	assert jauge.estVert()==true;
	System.out.println(".OK");
	assert a==3;
	jauge=new Jauge(100,98);
	System.out.println(jauge.toString());
	jauge.incrementer();
	jauge.incrementer();
	System.out.println(jauge.toString());
	assert jauge.estVert()==false;
	assert jauge.estRouge()==true;//(probleme aussi ici)
	jauge.decrementer();
	jauge.decrementer();
	System.out.println(jauge.toString());
	assert jauge.estVert()==true;//(probleme dans la methode decrementer)
    }
}
