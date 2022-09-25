public class TestPosition
{
    public static void main(String[] args)
    {
	TestPosition tst=new TestPosition();
	tst.testAssis();
	tst.testDebout();
	tst.testDehors();
    }

    public void testAssis()
    {
	Position pos=new Position();//over-loading de constructors.
	pos=pos.assis();//meilleure utilisation.
	System.out.println(pos.toString());
	assert pos.estAssis()==true;
	assert pos.estDebout()==false;
	assert pos.estInterieur()==true;
	assert pos.estDehors()==false;
    }
    public void testDebout()
    {
	Position pos=new Position();
	pos=pos.debout();//over-loading de constructors.
	System.out.println(pos.toString());
	assert pos.estAssis()==false;
	assert pos.estDebout()==true;
        assert pos.estInterieur()==true;
	assert pos.estDehors()==false;
    }
    public void testDehors()
    {
	Position pos=new Position();//over-loading de constructors.
	assert pos.estAssis()==false;
	assert pos.estDebout()==false;
	assert pos.estInterieur()==false;
	assert pos.estDehors()==true;
    }
}
