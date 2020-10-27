package fraction;

import fraction.exception.InvalidFractionException;

import java.math.BigInteger;
import java.util.Objects;

public class Fraction {
    private final int nominator;
    private final int denominator;

    public Fraction(int nominator, int denominator) {
        int sign = 1;
        if (denominator < 0) {
            sign = -1;
        }
        this.nominator = sign * nominator;
        this.denominator = Math.abs(denominator);
    }

    public static Fraction of(int number) {
        return new Fraction(number, 1);
    }

    public Fraction add(Fraction fraction) {
        if (!isValid() || !fraction.isValid()) {
            throw new InvalidFractionException();
        } else {
            if (equals(Fraction.of(0))) {
                return fraction;
            } else if (fraction.equals(Fraction.of(0))) {
                return this;
            } else if (equals(fraction)) {
                return new Fraction(2 * nominator, denominator);
            } else if (equals(fraction.opposite())) {
                return Fraction.of(0);
            } else if (denominator == fraction.denominator) {
                return new Fraction(nominator + fraction.nominator, denominator);
            } else {
                return new Fraction(nominator * fraction.denominator + fraction.nominator * denominator, denominator * fraction.denominator);
            }
        }
    }

    public Fraction minus(Fraction fraction) {
        Fraction opposite = fraction.opposite();
        return add(opposite);
    }

    public Fraction multiply(Fraction fraction) {
        if (!isValid() || !fraction.isValid()) {
            throw new InvalidFractionException();
        } else {
            if (nominator == 0 || fraction.nominator == 0) {
                return Fraction.of(0);
            } else if (equals(Fraction.of(1))) {
                return fraction;
            } else if (fraction.equals(Fraction.of(1))) {
                return this;
            } else if (reciprocal().equals(fraction)) {
                return Fraction.of(1);
            } else if (nominator == fraction.denominator) {
                return new Fraction(fraction.nominator, denominator);

            } else if (denominator == fraction.nominator) {
                return new Fraction(nominator, fraction.denominator);

            } else {
                return new Fraction(nominator * fraction.nominator, denominator * fraction.denominator);
            }
        }
    }

    public Fraction divide(Fraction fraction) {
        if (!isValid() || !fraction.isValid()) {
            throw new InvalidFractionException();
        }

        Fraction reversed = fraction.reciprocal();
        return multiply(reversed);
    }

    public Fraction reciprocal() {
        return new Fraction(denominator, nominator);
    }

    public Fraction opposite() {
        return new Fraction(-1 * nominator, denominator);
    }

    public Fraction simplify() {
        if (!isValid()) {
            throw new InvalidFractionException();
        } else {
            if (nominator == 0) {
                return Fraction.of(0);
            } else if (nominator == denominator) {
                return Fraction.of(1);
            } else if (nominator % denominator == 0) {
                return Fraction.of(nominator / denominator);
            } else if (denominator % nominator == 0) {
                return Fraction.of(denominator / nominator).reciprocal();
            } else {
                BigInteger b1 = BigInteger.valueOf(nominator);
                BigInteger b2 = BigInteger.valueOf(denominator);
                int divider = b1.gcd(b2).intValue();
                return new Fraction(nominator / divider, denominator / divider);
            }
        }
    }

    public boolean isValid() {
        return denominator != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return nominator == fraction.nominator &&
                denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nominator, denominator);
    }
}