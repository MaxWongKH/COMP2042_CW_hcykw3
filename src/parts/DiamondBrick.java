package parts;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

public class DiamondBrick extends Brick {
    private static final String NAME = "Diamond Brick";
    private static final Color DEF_INNER = new Color(69, 172, 165);
    private static final Color DEF_BORDER = Color.WHITE;
    private static final int DIAMOND_STRENGTH = 5;
    //private static final double DIAMOND_PROBABILITY = 0.3;

    //private Random rnd;
    private Crack crack;
    private Shape brickFace;

    public DiamondBrick(Point point, Dimension size){
        super(NAME,point,size,DEF_BORDER,DEF_INNER,DIAMOND_STRENGTH);
        crack = new Crack(DEF_CRACK_DEPTH,DEF_STEPS);
        brickFace = super.brickFace;
    }


    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }

    public boolean setImpact(Point2D point, int dir) {
        if(super.isBroken())
            return false;
        super.impact();
        if(!super.isBroken()){
            crack.makeCrack(point,dir);
            updateBrick();
            return false;
        }
        return true;
    }

    @Override
    public Shape getBrick() {
        return brickFace;
    }
/*
    public void impact(){
        if(rnd.nextDouble() < DIAMOND_PROBABILITY){
            super.impact();
        }
    }*/
    private void updateBrick(){
    if(!super.isBroken()){
        GeneralPath gp = crack.draw();
        gp.append(super.brickFace,false);
        brickFace = gp;
    }
}

    public void repair(){
        super.repair();
        crack.reset();
        brickFace = super.brickFace;
    }
}
