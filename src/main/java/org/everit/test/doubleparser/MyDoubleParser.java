package org.everit.test.doubleparser;

public class MyDoubleParser implements DoubleParser {

  private double appendToFirst(final double base, final int toAdd) {
    return (base * 10) + toAdd;
  }

  private double appendToLast(final double base, final int toAdd) {
    return (base * 10) + toAdd;
  }

  private int charToNumber(final char ch) {
    switch (ch) {
      case '0':
        return 0;
      case '1':
        return 1;
      case '2':
        return 2;
      case '3':
        return 3;
      case '4':
        return 4;
      case '5':
        return 5;
      case '6':
        return 6;
      case '7':
        return 7;
      case '8':
        return 8;
      case '9':
        return 9;

      default:
        throw new UnsupportedOperationException("Unsupported character");
    }
  }

  private boolean isDot(final char ch) {
    if (ch == '.') {
      return true;
    } else {
      return false;
    }
  }

  private boolean isNum(final char ch) {
    try {
      charToNumber(ch);
      return true;
    } catch (UnsupportedOperationException e) {
      return false;
    }
  }

  @Override
  public double strtod(final char[] str) {
    double rval = 0;
    double firstPart = 0;
    double lastPart;
    boolean positive = true;
    int i = 0;
    for (; i < str.length; i++) {
      if (Character.isWhitespace(str[i])) {
        continue;
      }
      else if (str[i] == '+') {
        positive = true;
        i++;
        break;
      }
      else if (str[i] == '-') {
        positive = false;
        i++;
        break;
      }
      else if (isNum(str[i])) {
        break;
      }
    }
    // TODO has number or more elements return
    for (; i < str.length; i++) {
      if (isDot(str[i])) {
        i++;
        break;
      }
      else if (firstPart != 0) {
        appendToFirst(firstPart, charToNumber(str[i]));
      }
      else {
        firstPart = charToNumber(str[i]);
      }
    }
    // TODO has nextPart

    if (positive == false) {
      return -1 * firstPart;
    } else {
      return firstPart;
    }

  }
}
