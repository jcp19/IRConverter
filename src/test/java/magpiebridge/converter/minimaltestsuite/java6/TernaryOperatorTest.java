package magpiebridge.converter.minimaltestsuite.java6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import magpiebridge.converter.minimaltestsuite.MinimalTestSuiteBase;

/** @author Kaustubh Kelkar */
public class TernaryOperatorTest extends MinimalTestSuiteBase {
  @Override
  public String getMethodSignature() {
    return identifierFactory.getMethodSignature(
        "ternaryOperatorMethod", getDeclaredClassSignature(), "boolean", Collections.emptyList());
  }

  @Override
  public List<String> expectedBodyStmts() {
    return Stream.of(
            "r0 := @this: TernaryOperator",
            "$i0 = r0.<TernaryOperator: int num>",
            "$z0 = $i0 < 0",
            "if $z0 == 0 goto label1",
            "$z1 = 0",
            "goto label2",
            "label1:",
            "$z1 = 1",
            "label2:",
            "return $z1")
        .collect(Collectors.toCollection(ArrayList::new));
  }
}
