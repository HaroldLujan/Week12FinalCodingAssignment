import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;


class TestDemoTest {
  
  private  TestDemo testDemo;

  @BeforeEach
  void setUp() {
    testDemo = new TestDemo();
  }
  
  static Stream<Arguments> argumentsForAddPositive() {
    return (Stream.of(arguments(2, 4, 6, true),
                     arguments(0, 4, 4, true),
                     arguments(4, 0, 4, true),
                     arguments(-2, 4, 2,true),
                     arguments(3, 2, 5, true)));
    
  }

  @ParameterizedTest
  @MethodSource("TestDemoTest#argumentsForAddPositive")
 
  void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException){
    
    if(!expectException) {
      assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
     
    }else {
      assertThatThrownBy(() -> 
      testDemo.addPositive(a, b))
          .isInstanceOf(IllegalArgumentException.class);

    }

  }
  
  
  @Test
  void assertThatNumberSquaredIsCorrect () {
    TestDemo mockDemo = spy(testDemo);
    doReturn(5).when(mockDemo).getRandomInt();
    
    int fiveSquared = mockDemo.randomNumberSquared();
    assertEquals(25, fiveSquared);
  }

}
