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
        assertTrue(Cond + "- не верные входные данные. Пераметры должны быть вида: operand1;operand2;operation;result", arrSrt.length == 4);
        String operand1 = arrSrt[0].trim();
        String operand2 = arrSrt[1].trim();
        String operation = arrSrt[2].trim();
        String result = arrSrt[3].trim();
        String operationTemp = "/*+-^";

        assertTrue(operand1 + "- не является целым числом (operand1)", isNumber(operand1));
        assertTrue(operand2 + "- не является целым числом (operand2)", isNumber(operand2));
        assertTrue(operation + "- не верный оператор (operation)! Больше одного символа", 1==(operation.length()));
        assertTrue(operation + "- не верный оператор (operation)! Выберете один из следующих символов"+operationTemp, (operationTemp.indexOf(operation) != -1));
        assertTrue(result + "- не является целым числом (result)", isNumber(result));

        if (operation.equals("/")) {
            assertFalse("Деление на ноль невозможно", 0==Integer.valueOf(operand2));
        }

        Object resultEx = eng.eval(operand1+operation+operand2);
//        String strRes = resultEx.toString();
//        System.out.println(strRes);
        //assertEquals("Резутьтат не верный!",result, resultEx.toString());
        assertTrue("Резутьтат не верный!", Integer.parseInt(result) == Integer.parseInt(resultEx.toString()));

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

