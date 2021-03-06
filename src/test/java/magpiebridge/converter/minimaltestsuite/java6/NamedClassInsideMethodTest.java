/** @author: Hasitha Rajapakse */
package magpiebridge.converter.minimaltestsuite.java6;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import magpiebridge.converter.categories.Java8Test;
import magpiebridge.converter.minimaltestsuite.MinimalTestSuiteBase;
import org.junit.experimental.categories.Category;

@Category(Java8Test.class)
public class NamedClassInsideMethodTest extends MinimalTestSuiteBase {
  @Override
  public String getMethodSignature() {
    return identifierFactory.getMethodSignature(
        "namedClassInsideMethod", getDeclaredClassSignature(), "void", Collections.emptyList());
  }

  @Override
  public List<String> expectedBodyStmts() {
    return Stream.of(
            "r0 := @this: NamedClassInsideMethod",
            "$r1 = new NamedClassInsideMethod1$MyMathOperation",
            "specialinvoke $r1.<NamedClassInsideMethod1$MyMathOperation: void <init>()>()",
            "interfaceinvoke $r1.<NamedClassInsideMethod$MathOperation: void addition()>()",
            "return")
        .collect(Collectors.toList());
  }
}
