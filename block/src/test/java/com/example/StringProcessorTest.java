package com.example;

import org.junit.jupiter.api.Test;

import com.example.String.StringProcessor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringProcessorTest {
    //repetitionMethod
    @Test
    public void testRepeatWordNegative() {
        StringProcessor sp = new StringProcessor();
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            sp.repetitionMethod("Hello", -1);
        });
        assertEquals("Число не может быть отриц", e.getMessage());
    }
    @Test
    public void testRepeatWordZero() {
        StringProcessor sp = new StringProcessor();
        String result = sp.repetitionMethod("Hello", 0);
        assertEquals("Нихт не выведено", result);
    }
    @Test
    public void testRepeatWordPositive() {
        StringProcessor sp = new StringProcessor();
        String result = sp.repetitionMethod("Hello", 3);
        assertEquals("Hello Hello Hello ", result);
    }
    //repetitionMethod

    //lineOccursMethod
    @Test
    public void testLineOccurscheck() {
        StringProcessor sp = new StringProcessor();
        int result = sp.lineOccursMethod("привет страна, привет семья, привет друзья", "привет");
        assertEquals(3, result);
    }
    @Test
    public void testLineOccurs() {
        StringProcessor sp = new StringProcessor();
        int result = sp.lineOccursMethod("пивет страна, првет семья, привт друзья", "привет");
        assertEquals(0, result);
    }
    @Test
    public void testLineOccursnullZero() {
        StringProcessor sp = new StringProcessor();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sp.lineOccursMethod("привет страна, привет семья, привет друзья", "");
        });
        assertEquals("Слово должно быть заполнено.", exception.getMessage());
    }
    @Test
    public void testLineOccursnullnull() {
        StringProcessor sp = new StringProcessor();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sp.lineOccursMethod("привет страна, привет семья, привет друзья", null);
        });
        assertEquals("Слово должно быть заполнено.", exception.getMessage());
    }
    //lineOccursMethod

    //replacingNumMethod
    @Test
    public void testReplacingNum() {
        StringProcessor sp = new StringProcessor();
        String result = sp.replacingNumMethod("Привет 1, привет 2, привет 3!");
        assertEquals("Привет один, привет два, привет три!", result);
    }
    @Test
    public void testReplacingNumWithout() {
        StringProcessor sp = new StringProcessor();
        String result = sp.replacingNumMethod("qwerty");
        assertEquals("qwerty", result);
    }
    @Test
    public void testReplacingNumNothing() {
        StringProcessor sp = new StringProcessor();
        String result = sp.replacingNumMethod("");
        assertEquals("", result);
    }
    //replacingNumMethod

    //deleteEveryOtherCharacterMetod
    @Test
    public void testdeleteEveryOtherCharacter() {
        StringProcessor sp = new StringProcessor();
        String result = sp.deleteEveryOtherCharacterMetod("Qwerty");
        assertEquals("Qet", result);
    }
    @Test
    public void testDeleteEveryOtherCharacterNull() {
        StringProcessor sp = new StringProcessor();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        sp.deleteEveryOtherCharacterMetod(null);
      });
      assertEquals("Строка должна быть заполнена", exception.getMessage());
    }
    @Test
    public void testDeleteEveryOtherCharacterZero() {
        StringProcessor sp = new StringProcessor();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        sp.deleteEveryOtherCharacterMetod("");
      });
      assertEquals("Строка должна быть заполнена", exception.getMessage());
    }
    //deleteEveryOtherCharacterMetod

    //reverseWordsmMetod
    @Test
    public void testReverseWordsmMetodNull() {
        StringProcessor sp = new StringProcessor();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        sp.reverseWordsmMetod(null);
        });
        assertEquals("Строка должна быть заполнена", exception.getMessage());
    }
    @Test
    public void testReverseWordsmMetodZero() {
        StringProcessor sp = new StringProcessor();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        sp.reverseWordsmMetod("");
        });
        assertEquals("Строка должна быть заполнена", exception.getMessage());
    }
    @Test
    public void testReverseWordsmMetod() {
        StringProcessor sp = new StringProcessor();
        String result = sp.reverseWordsmMetod("hello frend   000  111");
        assertEquals("111  000   frend hello ", result);
    }
    //reverseWordsmMetod

    //HexToDecConverter
    @Test
    public void testconvertHexToDecMetodNull() {
        StringProcessor sp = new StringProcessor();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        sp.convertHexToDecMetod(null);
        });
        assertEquals("Строка должна быть заполнена", exception.getMessage());
    }
    @Test
    public void testconvertHexToDecMetodZero() {
        StringProcessor sp = new StringProcessor();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        sp.convertHexToDecMetod("");
        });
        assertEquals("Строка должна быть заполнена", exception.getMessage());
    }
    @Test
    public void testconvertHexToDecMetod() {
        StringProcessor sp = new StringProcessor();
        String result = sp.convertHexToDecMetod("vase 0x00000010 let");
        assertEquals("vase 16 let", result);
    }
    //HexToDecConverter
}
