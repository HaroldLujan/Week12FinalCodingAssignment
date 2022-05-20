import java.util.Random;

public class TestDemo {

  public int addPositive(int a, int b) {
    
  if( a > 0 && b > 0) {
    return a + b;
    
  }else {
    throw new IllegalArgumentException("Both parameters must be positive!");
    
  }

  }
  
  public int randomNumberSquared () {
    int randomNumber = getRandomInt();
    return randomNumber * randomNumber;
  }

  public int getRandomInt() {
    Random randomInt = new Random();
    
    return randomInt.nextInt(10) + 1;
  }
  
}
