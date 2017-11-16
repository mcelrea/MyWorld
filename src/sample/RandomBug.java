package sample;

public class RandomBug extends Bug{

    private int numOfForwardMoves;
    private int currentStep=0;
    private int chanceToClone=1;//1%

    public RandomBug(double x, double y, String imagePath) {
        super(x,y, imagePath);
        numOfForwardMoves = (int)(1 + Math.random() * 10);
    }

    @Override
    public void act() {
        super.act();
        currentStep++;
        if(currentStep >= numOfForwardMoves){
            setMyDir((getMyDir()+2)%8);//turn me 90 degrees
            numOfForwardMoves = (int)(1 + Math.random() * 10);
            currentStep=0;
        }

        //do I clone???
        int diceThrow = (int)(1 + Math.random()*100);
        if(diceThrow <= chanceToClone) {
            //I need the WORLD!!!!!
            Main.world.addActor(new RandomBug(getMyLoc().getX()-25,
                    getMyLoc().getY(),
                    "images/bug.png"));
        }
    }
}
