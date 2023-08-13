package io.upschool.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilTest {

    @Test
    void testCleanCreditCard() {
        // given
        String input = "1234.4567.5432.2345";
        String expected = "1234456754322345";

        // then
        String actual = StringUtil.cleanCreditCard(input);

        // expected
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMaskCreditCard() {
        // given
        String input = "1234456754322345";
        String expected = "123445******2345";

        // then
        String actual = StringUtil.maskCreditCard(input);

        // expected
        Assertions.assertEquals(expected, actual);
    }

}