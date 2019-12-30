package magpiebridge.converter.minimaltestsuite.java6;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import magpiebridge.converter.minimaltestsuite.MinimalTestSuiteBase;
import org.junit.Test;
import soot.SootClass;

/** @author Kaustubh Kelkar */
public class InterfaceImplClassTest extends MinimalTestSuiteBase {
  public String getMethodSignature() {
    return identifierFactory.getMethodSignature(
        "interfaceMethod", getDeclaredClassSignature(), "void", Collections.emptyList());
  }

  @Test
  @Override
  public void defaultTest() {
    super.defaultTest();
    SootClass clazz = loadClass(getDeclaredClassSignature());
    assertTrue(
        clazz.getInterfaces().stream()
            .anyMatch(
                javaClassType -> {
                  return javaClassType.getName().equalsIgnoreCase("InterfaceImpl");
                }));
  }

  @Override
  public List<String> expectedBodyStmts() {
    return Stream.of(
            "r0 := @this: InterfaceImplClass",
            "$r1 = <java.lang.System: java.io.PrintStream out>",
            "virtualinvoke $r1.<java.io.PrintStream: void print(java.lang.String)>(\"Method from InterfaceImpl is implemented\")",
            "$r2 = <java.lang.System: java.io.PrintStream out>",
            "$r3 = \"Variable from InterfaceImpl is \" + 10",
            "virtualinvoke $r2.<java.io.PrintStream: void println(java.lang.String)>($r3)",
            "return")
        .collect(Collectors.toCollection(ArrayList::new));
  }
}