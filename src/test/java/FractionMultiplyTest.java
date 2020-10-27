import fraction.Fraction;
import fraction.exception.InvalidFractionException;
import org.junit.Assert;
import org.junit.Test;

public class FractionMultiplyTest {

    @Test
    public void given_validFraction_when_multiplyByFractionOfZero_then_returnFractionOfZero() {
        //Given
        Fraction fraction = new Fraction(10, 15);
        Fraction fractionZero = Fraction.of(0);

        //When
        Fraction result1 = fraction.multiply(fractionZero);
        Fraction result2 = fractionZero.multiply(fraction);

        //Then
        Assert.assertEquals(Fraction.of(0), result1);
        Assert.assertEquals(Fraction.of(0), result2);
    }

    @Test
    public void given_validFraction_when_multiplyByFractionOfOne_then_returnTheSameFraction() {
        //Given
        Fraction fraction = new Fraction(10, 15);
        Fraction fractionOne = Fraction.of(1);

        //When
        Fraction result1 = fraction.multiply(fractionOne);
        Fraction result2 = fractionOne.multiply(fraction);

        //Then
        Assert.assertEquals(fraction, result1);
        Assert.assertEquals(fraction, result2);
    }

    @Test(expected = InvalidFractionException.class)
    public void given_invalidFraction_when_multiply_then_throwInvalidFractionException() {
        //Given
        Fraction fraction = new Fraction(10, 0);
        Fraction fractionOne = Fraction.of(1);

        //When
        fraction.multiply(fractionOne);
    }

    @Test
    public void given_validFractions_when_applyAssociativePropertyOfMultiply_then_returnEqualValues() {
        //Given
        Fraction fraction1 = new Fraction(12, 11);
        Fraction fraction2 = new Fraction(10, 23);
        Fraction fraction3 = new Fraction(7, 3);

        //When
        Fraction multiply1 = fraction1.multiply(fraction2).multiply(fraction3);
        Fraction multiply2 = fraction3.multiply(fraction2).multiply(fraction1);

        //Then
        Assert.assertEquals(multiply1, multiply2);
    }

    @Test
    public void given_validFractions_when_applyCommutativePropertyOfMultiply_then_returnEqualValues() {
        //Given
        Fraction fraction1 = new Fraction(12, 11);
        Fraction fraction2 = new Fraction(10, 23);

        //When
        Fraction multiply1 = fraction1.multiply(fraction2);
        Fraction multiply2 = fraction2.multiply(fraction1);

        //Then
        Assert.assertNotNull(multiply1);
        Assert.assertNotNull(multiply2);
        Assert.assertEquals(multiply1, multiply2);
    }

    @Test
    public void given_validFractions_when_multiply_then_simplifyNumbersPresentInNominatorsAndDenominators() {
        //Given
        Fraction fraction1 = new Fraction(10, 15);
        Fraction fraction2 = new Fraction(6, 10);

        Fraction fraction3 = new Fraction(10, 15);
        Fraction fraction4 = new Fraction(15, 7);

        //When
        Fraction result1 = fraction1.multiply(fraction2);
        Fraction result2 = fraction3.multiply(fraction4);

        //Then
        Assert.assertEquals(new Fraction(6, 15), result1);
        Assert.assertEquals(new Fraction(10, 7), result2);
    }

    @Test
    public void given_validFractions_when_multiplyByReverse_then_returnFractionOfOne() {
        //Given
        Fraction fraction1 = new Fraction(7, 15);
        Fraction fraction2 = new Fraction(15, 7);

        //When
        Fraction result = fraction1.multiply(fraction2);

        //Then
        Assert.assertEquals(Fraction.of(1), result);
    }
}
