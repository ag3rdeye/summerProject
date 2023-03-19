import java.util.Random;
import java.util.Scanner;
public class RSA{
  private static int p,q,funcN ;
  private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
 
    while(true){
      if(isPrime(getP()) == true){
        break;
      }
      getP();
    }

    while(true){
      if(isPrime(getQ()) == true){
        break;
      }
      getQ();
    }
  
     funcN = ((p-1)*(q-1));
    int e = getE(funcN);
    Encrypt(e, funcN);
    }
   public static boolean isPrime(int num){
    boolean flag = false;
    for(int i=2;i<=num/2;i++){
      if(num%i==0){
        return flag;
      }
    }
    return flag = true;
   } 

   public static int getP(){
    System.out.println("Enter prime number P: ");
     p = in.nextInt();
     return p;
       }

   public static int getQ(){
    System.out.println("Enter prime number Q: ");
      q = in.nextInt();
      return q;
     }


     public static int getE(int funcN){
      int Ce = 2;
      while(Ce < funcN){
        if(gcd(Ce, funcN) == 1){
          break;
        }
        Ce++;
      }
      return Ce;
    }
  
    public static int gcd(int a, int b){
      if(b == 0){
        return a;
      }
      return gcd(b, a%b);
    }

    private static void Encrypt(int e,int funcN){
      double d=0;
      for (int i = 2;i<=funcN;i++){
         d = ((e*i)%funcN) ;
        if(d == 1){
          break;
        }
      }
      System.out.println(d +" "+ funcN + " "+e);
    
      System.out.println("Enter a numeric message to encrypt: ");
      double CT=((Math.pow((in.nextDouble()), (double)e))%funcN);
      System.out.println("Encrypted message: "+ CT);
    
      Decrypt(CT,d);
  }
  public static void Decrypt(double CT,double d){
    double PT = ((Math.pow(CT,d))%funcN);
    System.out.println("Decrypted message: "+PT );
  }
}


