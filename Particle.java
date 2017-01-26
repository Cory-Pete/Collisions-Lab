/**
 * Created by Sarah on 1/21/2017.
 */
public class Particle {
    double X;
    double Y;
    double vX;
    double vY;
    double radius;
    double Yi;
    double Xi;
    public Particle(double X, double Y, double vX, double vY, double radius){ //position and velocity
        this.X=X;
        this.Xi=X;
        this.Y=Y;
        this.Yi=Y; //X and Y initial
        this.vX=vX;
        this.vY=vY;
        this.radius=radius;
    }

    public double getX(){
       return X;
    }
    public double getY(){
        return Y;
    }
    public double getvX(){
        return vX;
    }
    public double getvY(){
        return vY;
    }
    public double getXi() {
        return Xi;
    }
    public double getYi(){
        return Yi;
    }
    public void changeX(double a){
        X=a;
    }
    public void changeY(double b){
        Y=b;
    }
    public void changeXi(double x){
        Xi = x;
    }
    public void changeYi(double y){
        Yi = y;
    }
    public void changevX(double c){
        vX=c;
    }
    public void changevY(double d){
        vY=d;
    }

    public double collidesX(double t){//returns when particle collides with a wall vertically
        double currentT=t;
        double dt=-1;
        /*
        if (vX==0) return -1;
        else {
            *//*
            have to make it solve for time not if the coordinates are equal. otherwise cant sort for time. also the program
            already goes through a time loop, so adding another isnt needed.
            *//*

            //x+v(t+change in t)= border vertical
           //((border vertical-x)/v))-t=change in t //does actual t matter? perhaps in solving for border coor

            for(double time=0; time<=.5; time+=0.0001){//cycling through 1 second at 0.01 time. will i miss some?
               if(vX>1) {
                   if ((((1 - X) / vX)) - currentT == time) {
                       return time;
                   }
               }
               if(vX<1){
                   if ((((0 - X) / vX)) - currentT == time) {
                       return time;
                   }
               }
            }
        }
        return -1; //made it out of loop without finding anything*/

        if (vX==0) return -1;
        else if(vX>0) {
           dt= ((1-radius-X)/vX)-currentT;
        }
        else if(vX<0){
            dt=(radius-X)/vX-currentT;
        }
        return dt;
    }

    public double collidesY(double t){//returns when particle collides with a wall vertically
        double currentT=t;
        double dt=-1;
        if (vY==0) return -1;
       else if(vY>0) {
            dt= ((1-radius-Y)/vY)-currentT;
        }
       else if(vY<0){
            dt=(radius-Y)/vY-currentT;
        }
        return dt;
    }
}
