public class Autobus implements Vehicule
{
    private int numeroArret;
    private Jauge jauge1;
    private Jauge jauge2;
    /*private Passager[] passagers={};
      int len;*/

    
    //de la forme [min;max[
    //car dans le sujet: elle utilise 2 instances de Jauge.
    public Autobus(int nbPlaceAssise, int nbPlaceDebout)
    {
	jauge2=new Jauge(nbPlaceAssise,0);
	jauge1=new Jauge(nbPlaceDebout,0);
	numeroArret=0;

	//len=0;

	//[$1,$2[ telque $1++ si ca s'incremente
	//ca parait logique !
    }
    //dans le code client, lorsqu'on ecrit new Autobus(100,200), on considere
    //qu'il y a 99 assises places et 199 debouts.(comme la boucle for sans le++)
    public void allerArretSuivant()
    {
	numeroArret++;
    }
    public boolean aPlaceAssise()
    {
	return jauge2.estVert();
    }
    public boolean aPlaceDebout()
    {
	
	return jauge1.estVert();
    }
    public void monteeDemanderAssis(Passager p)
    {
	if(aPlaceAssise())
	    {
	    p.changerEnAssis();
	    jauge2.incrementer();
	    }
	numeroArret++;
    }
    public void monteeDemanderDebout(Passager p)
    {
	if(aPlaceDebout())
	    {	
	    p.changerEnDebout();
	    jauge1.incrementer();
	    }
	numeroArret++;
    }
    public void arretDemanderDebout(Passager p)
    {
	//p est assis.
	p.changerEnDebout();
	jauge2.decrementer();
	jauge1.incrementer();
	numeroArret++;
    }
    public void arretDemanderAssis(Passager p)
    {
	//p est debout.
	p.changerEnAssis();
	jauge2.incrementer();
	jauge1.decrementer();
	numeroArret++;
    }
    public void arretDemanderSortie(Passager p)
    {
	if(p.estAssis())
	    {
		p.changerEnDehors();
		jauge2.decrementer();
		//ca va diminuer le nombre de places assises.
	    }
	else if(p.estDebout())
	    {
		p.changerEnDehors();
	        jauge1.decrementer();
		//et de meme.
		//pour avoir plus de places entieres dans l'intervalle.
	    }
	//on peut factoriser ici tout SIMPLE.
	
	numeroArret++;
    }
}
