public class Autobus implements Vehicule
{
    private int numeroArret;
    private Jauge jauge1;
    private Jauge jauge2;
    /*private Passager[] passagers={};
      int len;*/
    private Passager[] passagers;
    
    //de la forme [min;max[
    //car dans le sujet: elle utilise 2 instances de Jauge.
    public Autobus(int nbPlaceAssise, int nbPlaceDebout)
    {
	jauge2=new Jauge(nbPlaceAssise,0);
	jauge1=new Jauge(nbPlaceDebout,0);
	numeroArret=0;

	passagers=new Passager[nbPlaceAssise+nbPlaceDebout];

	//ASTUCE!!!///////(instanciation tableau d'instances, ca se dit!)
	
	//on y avait penser syntaxiquement même mais c'était la très bonne
	//option.
	
	//len=0;

	//[$1,$2[ telque $1++ si ca s'incremente
	//ca parait logique !
    }
    //dans le code client, lorsqu'on ecrit new Autobus(100,200), on considere
    //qu'il y a 99 assises places et 199 debouts.(comme la boucle for sans le++)

    private void enleverPassager(Passager p)
    {//le passager existe forcément.(et c'est pas le dernier)
	int i=0;
	while(passagers[i]==null || !passagers[i].equals(p))
	    i++;//On connait pas si la compacite(td0) est respecte ou non.
	passagers[i]=null;
    }

    private void ajouterPassager(Passager p)
    {
	int i=0;
	while(passagers[i]!=null)
	    i++;
	passagers[i]=p;
    }

    
    public void allerArretSuivant()
    {
	numeroArret++;
	for(Passager p:passagers)
	    {
		if(p!=null)//il faudrait impérativement si p est null!!
		    p.nouvelArret(this,numeroArret);
	    }
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
	    jauge2.incrementer();
	    p.changerEnAssis();
	    this.ajouterPassager(p);
    }
    public void monteeDemanderDebout(Passager p)
    {
	    jauge1.incrementer();
	    p.changerEnDebout();
	    this.ajouterPassager(p);
    }
    public void arretDemanderDebout(Passager p)
    {
	//p est assis.
	
	jauge2.decrementer();
	jauge1.incrementer();
	p.changerEnDebout();
    }
    public void arretDemanderAssis(Passager p)
    {
	//p est debout.
	jauge2.incrementer();
	jauge1.decrementer();
	p.changerEnAssis();//en dernier après avoir gérer CES attributs(les
	//jauges).
    }
    public void arretDemanderSortie(Passager p)
    {
	if(p.estAssis())
		jauge2.decrementer();
		//ca va diminuer le nombre de places assises.
	else{
	        jauge1.decrementer();
	}
	p.changerEnDehors();
	this.enleverPassager(p);
		//et de meme.
		//pour avoir plus de places entieres dans l'intervalle.
    }
	//on peut factoriser ici tout SIMPLE.

    public String toString()
    {
    String res = "[arret " + numeroArret + "] " + "assis" + jauge2 + " debout" + jauge1;
    return res;
    }
}
