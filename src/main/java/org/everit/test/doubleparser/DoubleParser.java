package org.everit.test.doubleparser;

/**
 * A parser that converts a string to double without using any in-built Java functionality such as
 * {@link Double#valueOf(String)}, {@link String#contains(CharSequence)}, java.math package, etc.
 * Only the Java functionalities mentioned in the {@link #strtod(char[])} method are permitted.
 */
public interface DoubleParser {

  /**
   * The strtod (“string-to-double”) function converts the initial part of string to a
   * floating-point number, which is returned as a value of type double.
   * <p>
   * This function attempts to decompose string as follows:
   * </p>
   *
   * <ul>
   * <li>
   * A (possibly empty) sequence of whitespace characters. Which characters are whitespace is
   * determined by the {@link java.lang.Character#isWhitespace(char)} function. These are discarded.
   * </li>
   * <li>An optional plus or minus sign (‘+’ or ‘-’).</li>
   * <li>A floating point number in decimal format. The decimal format is:</li>
   * <ul>
   * <li>A nonempty sequence of digits optionally containing a decimal-point character ‘.’.</li>
   * <li><i>LEVEL 2</i> - An optional exponent part, consisting of a character ‘e’ or ‘E’, an
   * optional sign, and a sequence of digits.</li>
   * </ul>
   * <li>Any remaining characters in the string are ignored.</li></ul>
   * <p>
   * If the string is empty, contains only whitespace, or does not contain an initial substring that
   * has the expected syntax for a floating-point number, no conversion is performed. In this case,
   * strtod returns a value of zero.
   * </p>
   * <p>
   * <i>LEVEL 4</i> - If the string has valid syntax for a floating-point number but the value is
   * outside the range of a double, strtod will signal "overflow" or "underflow" with a
   * {@link NumberFormatException}.
   * </p>
   * <p>
   * <i>LEVEL 3</i> - strtod recognizes four special input strings. The strings "inf" and "infinity"
   * are converted to the infinity values described in {@link java.lang.Double}. You can prepend a
   * "+" or "-" to specify the sign. Case is ignored when scanning these strings.
   * </p>
   * <p>
   * <i>LEVEL 3</i> - The strings "nan" and "nan(chars…)" are converted to NaN described in
   * {@link java.lang.Double}. Again, case is ignored. If chars… are provided, they are discarded.
   * </p>
   *
   * <p>
   * <b>Remark</b>: Functionalities marked with <i>LEVEL 2</i>, <i>LEVEL 3</i> and <i>LEVEL 4</i>
   * can be implemented if the basics are implemented and validated!
   * </p>
   *
   * @param str
   *          the input to parse
   * @return the parsed double value of the input
   */
  double strtod(char[] str);

}
