public class Planet{

  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;

  public Planet(double xP, double yP, double xV,
      double yV, double m, String img){
    this.xxPos = xP;
    this.yyPos = yP;
    this.xxVel = xV;
    this.yyVel = yV;
    this.mass = m;
    this.imgFileName = img;
  }

  public Planet(Planet p){
    this.xxPos = p.xxPos;
    this.yyPos = p.yyPos;
    this.xxVel = p.xxVel;
    this.yyVel = p.yyVel;
    this.mass = p.mass;
    this.imgFileName = p.imgFileName;
  }

  public double calcDistance(Planet p){
    double xdis = this.xxPos - p.xxPos;
    double ydis = this.yyPos - p.yyPos;
    double distance = xdis*xdis + ydis*ydis;
    return java.lang.Math.sqrt(distance);
  }

  public double calcForceExertedBy(Planet p){
    double G = 6.67e-11;
    double r = this.calcDistance(p);
    double f = (G*this.mass*p.mass)/(r*r);
    return f;
  }

  public double calcForceExertedByX(Planet p){
    double r = this.calcDistance(p);
    double dx = -this.xxPos + p.xxPos;
    return this.calcForceExertedBy(p)*dx/r;
  }

  public double calcForceExertedByY(Planet p){
    double r = this.calcDistance(p);
    double dy = -this.yyPos + p.yyPos;
    return this.calcForceExertedBy(p)*dy/r;
  }

  public double calcNetForceExertedByX(Planet[] allPlanets){
    double xforce = 0;
    for(int i=0;i<allPlanets.length;i=i+1){
      if(this.equals(allPlanets[i])){
        continue;
      }
      xforce = xforce + this.calcForceExertedByX(allPlanets[i]);
    }
      return xforce;
  }

  public double calcNetForceExertedByY(Planet[] allPlanets){
    double yforce = 0;
    for(int i=0;i<allPlanets.length;i=i+1){
      if(this.equals(allPlanets[i])){
        continue;
      }
      yforce = yforce + this.calcForceExertedByY(allPlanets[i]);
    }
    return yforce;
  }

  public void update(double time,double xforce,double yforce){
    double accX = xforce / this.mass;
    double accY = yforce / this.mass;
    this.xxVel = this.xxVel + time * accX;
    this.yyVel = this.yyVel + time * accY;
    this.xxPos = this.xxPos + time*this.xxVel;
    this.yyPos = this.yyPos + time*this.yyVel;
  }

  public  void draw(){
    StdDraw.picture(xxPos,yyPos,imgFileName);
  }
}
