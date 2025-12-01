package com.mphasis.ui;

import java.util.Scanner;

import com.mphasis.exception.ValidationException;

public class ConsoleIO {
	private final Scanner scanner = new Scanner(System.in);

    public double readDoublePositive(String prompt) throws ValidationException {
        System.out.print(prompt);
        String s = scanner.nextLine().trim();
        try {
            double v = Double.parseDouble(s);
            if (v <= 0) throw new ValidationException("Value must be > 0.");
            return v;
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid number format.");
        }
    }

    public int readIntPositive(String prompt) throws ValidationException {
        System.out.print(prompt);
        String s = scanner.nextLine().trim();
        try {
            int v = Integer.parseInt(s);
            if (v <= 0) throw new ValidationException("Value must be > 0.");
            return v;
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid integer format.");
        }
    }

    public char readYesNoChar(String prompt) throws ValidationException {
        System.out.print(prompt);
        String s = scanner.nextLine().trim();
        if (s.length() != 1) throw new ValidationException("Enter single char Y or N.");
        char c = Character.toUpperCase(s.charAt(0));
        if (c != 'Y' && c != 'N') throw new ValidationException("Invalid input. Use Y or N.");
        return c;
    }

    public boolean readYesNo(String prompt) throws ValidationException {
        System.out.print(prompt);
        String s = scanner.nextLine().trim();
        if (s.equalsIgnoreCase("Y")) return true;
        if (s.equalsIgnoreCase("N")) return false;
        throw new ValidationException("Invalid input. Enter Y or N.");
    }

    public String readRegistration(String prompt) throws ValidationException {
        System.out.print(prompt);
        String s = scanner.nextLine().trim();
        if (s.length() != 4) throw new ValidationException("Registration must be 4 digits.");
        for (char ch : s.toCharArray()) if (!Character.isDigit(ch)) throw new ValidationException("Registration must be numeric digits.");
        if ("0000".equals(s)) throw new ValidationException("'0000' is invalid.");
        return s;
    }

    public String readNonEmptyString(String prompt) throws ValidationException {
        System.out.print(prompt);
        String s = scanner.nextLine().trim();
        if (s.isEmpty()) throw new ValidationException("Input cannot be empty.");
        return s;
    }

    public double readDoubleInRange(String prompt, double min, double max) throws ValidationException {
        System.out.print(prompt);
        String s = scanner.nextLine().trim();
        try {
            double v = Double.parseDouble(s);
            if (v < min || v > max) throw new ValidationException("Value must be between " + min + " and " + max + ".");
            return v;
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid number.");
        }
    }

    public int readIntInRange(String prompt, int min, int max) throws ValidationException {
        System.out.print(prompt);
        String s = scanner.nextLine().trim();
        try {
            int v = Integer.parseInt(s);
            if (v < min || v > max) throw new ValidationException("Value must be between " + min + " and " + max + ".");
            return v;
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid integer.");
        }
    }
}
