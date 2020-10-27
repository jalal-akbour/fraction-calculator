import fraction.Fraction;
import fraction.exception.InvalidFractionException;
import org.junit.Assert;
import org.junit.Test;

public class FractionDivisionTest {

    @Test(expected = InvalidFractionException.class)
    public void given_validFraction_when_divideByFractionOfZero_then_throwInvalidFractionException() {
        //Given
        Fraction fraction = new Fraction(0, 10);
        Fraction fractionOne = Fraction.of(1);

        //When
        fractionOne.divide(fraction);
    }

    @Test(expected = InvalidFractionException.class)
    public void given_invalidFraction_when_divideByInvalidFraction_then_throwInvalidFractionException() {
        //Given
        Fraction fraction1 = new Fraction(10, 20);
        Fraction fraction2 = new Fraction(10, 0);

        //When
        fraction1.divide(fraction2);
    }

    @Test
    public void given_validFractions_when_divideByFractionOfOne_then_returnSameFraction() {
        //Given
        Fraction fraction = new Fraction(10, 20);
        Fraction fractionOne = Fraction.of(1);

        //When
        Fraction result = fraction.divide(fractionOne);

        //Then
        Assert.assertEquals(fraction, result);
    }

    @Test
    public void given_validFractions_when_applyAntiCommutativePropertyOfDivision_then_returnEqualValues() {
        //Given
        Fraction fraction1 = new Fraction(12, 11);
        Fraction fraction2 = new Fraction(10, 23);
        //When
        Fraction divide1 = fraction1.divide(fraction2);
        Fraction divide2 = fraction2.divide(fraction1);
        //Then
        Assert.assertEquals(divide1, divide2.reciprocal());
    }

    @Test
    public void given_validFractions_when_divideByItself_then_returnFractionOfOne() {
        //Given
        Fraction fraction = new Fraction(12, 11);

        //When
        Fraction result = fraction.divide(fraction);

        //Then
        Assert.assertEquals(Fraction.of(1), result);
    }
}
