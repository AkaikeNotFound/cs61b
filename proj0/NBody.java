public class NBody{
  public static double readRadius(String file){
    In in = new In(file);
    int firstItemInFile = in.readInt();
    double secondItemInFile = in.readDouble();
    return secondItemInFile;
  }

  public static Planet[] readPlanets(String file){
    In in = new In(file);
    int N = in.readInt();
    double radius = in.readDouble();
    Planet[] allPlanets =new Planet[N];
    for(int i=0;i<N;i+=1){
      double xP = in.readDouble();
      double yP = in.readDouble();
      double xV = in.readDouble();
      double yV = in.readDouble();
      double m = in.readDouble();
      String img = in.readString();
      allPlanets[i] = new Planet(xP, yP, xV, yV, m, img);
    }
    return allPlanets;
  }

  public static void main(String[] args){
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String filename = args[2];
    Planet[] allPlanets = readPlanets(filename);
    double radius = readRadius(filename);
    
    StdDraw.setScale(-radius,radius);
    StdDraw.clear();
    StdDraw.picture(0,0,"images/starfield.jpg");
    for(int i=0;i<allPlanets.length;i+=1){
      allPlanets[i].draw();
    }
    StdDraw.show();
    StdDraw.enableDoubleBuffering();
    for(double time=0;time<=T;time+=dt){
      double[] xForces = new double[allPlanets.length];
      double[] yForces = new double[allPlanets.length];
      for(int i=0;i<allPlanets.length;i+=1){
        xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
        yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
        allPlanets[i].update(dt,xForces[i],yForces[i]);
      }
      StdDraw.clear();
      StdDraw.setScale(-radius,radius);
      StdDraw.picture(0,0,"images/starfield.jpg");
      for(int i=0;i<allPlanets.length;i+=1){
        allPlanets[i].draw();
      }
      StdDraw.show();
      StdDraw.pause(10);
    }
    StdOut.printf("%d\n", allPlanets.length);
    StdOut.printf("%.2e\n", radius);
    for (int i = 0; i < allPlanets.length; i++) {
      StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
      allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
      allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);
    }
  }
}
