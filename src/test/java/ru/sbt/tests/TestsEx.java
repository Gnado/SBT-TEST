package ru.sbt.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import junitparams.*;
import org.junit.*;
import org.junit.runner.*;
import java.util.regex.*;


import javax.script.*;

/**
 * Created by user on 27.11.2015.
 */
@RunWith(JUnitParamsRunner.class)
public class TestsEx {
    ScriptEngine eng = new NashornScriptEngineFactory().getScriptEngine();

    @Test
    @FileParameters("src/test/resources/datapool.csv")
    //public void simpleTest(String operand1,String operand2, String operation, String result) throws Exception {
    public void testCalc(String Cond) throws Exception {
        System.out.println(Cond);
        String[] arrSrt = Cond.split(";");
        assertTrue(Cond + "- incorrect data. DataPool temp: operand1;operand2;operation;result", arrSrt.length == 4);
        String operand1 = arrSrt[0].trim();
        String operand2 = arrSrt[1].trim();
        String operation = arrSrt[2].trim();
        String result = arrSrt[3].trim();
        String operationTemp = "/*+-^";

        assertTrue(operand1 + " - incorrect operand1 - NOT integer", isNumber(operand1));
        assertTrue(operand2 + " - incorrect operand2 - NOT integer", isNumber(operand2));
        assertTrue(operation + " - incorrect operation - more then 1 char", 1==(operation.length()));
        assertTrue(operation + " -  incorrect operation - chose one"+operationTemp, (operationTemp.indexOf(operation) != -1));
        assertTrue(result + " - incorrect result - NOT integer", isNumber(result));

        if (operation.equals("/")) {
            assertFalse("Division by zero", 0==Integer.valueOf(operand2));
        }

        Double d2 = new Double (eng.eval(operand1 + operation + operand2).toString());
        Double res = new Double(result.toString());

        assertTrue(result +" -incorrect result - must be " + d2.toString(), Double.compare(d2, res)==0);

    }

    private static boolean isNumber(String sNum){
        try {
            if (Integer.valueOf(sNum) == (Integer.valueOf(sNum))) {
                return true;
            }
            return false;
        }catch(Exception e) {
                return false;
            }

    };

}

