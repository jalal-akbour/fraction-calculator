import fraction.Fraction;
import fraction.exception.InvalidFractionException;
import org.junit.Assert;
import org.junit.Test;

public class FractionValidationTest {

    @Test
    public void given_invalidFractions_when_checkIsValid_then_returnFalse() {
        //Given
        Fraction fraction1 = new Fraction(10, 0);
        Fraction fraction2 = new Fraction(0, 0);

        //When
        boolean isValid1 = fraction1.isValid();
        boolean isValid2 = fraction2.isValid();

        //Then
        Assert.assertFalse(isValid1);
        Assert.assertFalse(isValid2);
    }

    @Test(expected = InvalidFractionException.class)
    public void given_invalidFraction_when_simplify_then_trowInvalidFractionException() {
        //Given
        Fraction f = new Fraction(10, 0);

        //When
        f.simplify();

        //Then InvalidFractionException Exception is expected
    }

    @Test
    public void given_validFraction_when_checkIsValid_then_returnTrue() {
        //Given
        Fraction fraction = new Fraction(10, 5);

        //When
        boolean isValid = fraction.isValid();

        //Then
        Assert.assertTrue(isValid);
    }

    @Test
    public void given_validFractionWithNominatorIsZero_when_simplify_then_returnFractionOfZero() {
        //Given
        Fraction fraction = new Fraction(0, 100);

        //When
        Fraction simplifiedFraction = fraction.simplify();

        //Then
        Assert.assertEquals(Fraction.of(0), simplifiedFraction);
    }

    @Test
    public void given_validFractionWithNominatorEqualToDenominator_when_simplify_then_returnFractionOfOne() {
        //Given
        Fraction fraction = new Fraction(100, 100);

        //When
        Fraction simplifiedFraction = fraction.simplify();
        //Then
        Assert.assertEquals(Fraction.of(1), simplifiedFraction);
    }

    @Test
    public void given_validFraction_when_simplify_then_returnSimplifiedValue() {
        //Given
        Fraction fraction1 = new Fraction(50, 100);
        Fraction fraction2 = new Fraction(100, 50);

        //When
        Fraction simplifiedFraction1 = fraction1.simplify();
        Fraction simplifiedFraction2 = fraction2.simplify();

        //Then
        Assert.assertEquals(new Fraction(1, 2), simplifiedFraction1);
        Assert.assertEquals(Fraction.of(2), simplifiedFraction2);
    }

    @Test
    public void given_validFraction_when_reciprocal_then_returnFractionReciprocal() {
        //Given
        Fraction fraction = new Fraction(15, 7);

        //When
        Fraction reversedFraction = fraction.reciprocal();

        //Then
        Assert.assertEquals(new Fraction(7, 15), reversedFraction);
    }

    @Test
    public void given_validFractions_when_opposite_then_returnCorrectOppositeValue() {
        //Given
        Fraction fraction1 = new Fraction(-15, 7);
        Fraction fraction2 = new Fraction(15, -7);

        //When
        Fraction oppositeFraction1 = fraction1.opposite();
        Fraction oppositeFraction2 = fraction2.opposite();

        //Then
        Fraction expected = new Fraction(15, 7);
        Assert.assertEquals(expected, oppositeFraction1);
        Assert.assertEquals(expected, oppositeFraction2);
    }

    @Test
    public void given_validFractionWithNegativeNominatorAndDenominator_when_createFraction_then_returnSimplifiedFraction() {
        //Given
        Fraction fraction = new Fraction(-15, -7);

        //When

        //Then
        Fraction expected = new Fraction(15, 7);
        Assert.assertEquals(expected, fraction);
    }
}