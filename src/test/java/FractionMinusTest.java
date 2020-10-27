import fraction.Fraction;
import fraction.exception.InvalidFractionException;
import org.junit.Assert;
import org.junit.Test;

public class FractionMinusTest {

    @Test
    public void given_validFraction_when_minusZero_then_returnTheSameFraction() {
        //Given
        Fraction fraction = new Fraction(10, 11);
        Fraction fractionZero = Fraction.of(0);

        //When
        Fraction sub1 = fraction.minus(fractionZero);
        Fraction sub2 = fractionZero.minus(fraction);

        //Then
        Assert.assertEquals(fraction, sub1);
        Assert.assertEquals(fraction.opposite(), sub2);
    }

    @Test
    public void given_validFraction_when_minusItself_then_returnFractionOfZero() {
        //Given
        Fraction fraction = new Fraction(10, 11);

        //When
        Fraction sub = fraction.minus(fraction);

        //Then
        Assert.assertEquals(Fraction.of(0), sub);
    }

    @Test(expected = InvalidFractionException.class)
    public void given_invalidFraction_when_minusInvalidFraction_then_throwInvalidFractionException() {
        //Given
        Fraction fraction = new Fraction(10, 11);
        Fraction fractionZero = new Fraction(0, 0);
        //When
        fraction.minus(fractionZero);
    }

    @Test
    public void given_validFractions_when_minusFractionsHavingTheSameDenominator_then_returnSimplifiedFraction() {
        //Given
        Fraction fraction1 = new Fraction(15, 10);
        Fraction fraction2 = new Fraction(7, 10);
        //When
        Fraction sub = fraction1.minus(fraction2);

        //Then
        Assert.assertEquals(new Fraction(15 - 7, 10), sub);
    }

    @Test
    public void given_validFractions_when_applyAntiCommutativePropertyOfSubtraction_then_returnEqualFractions() {
        //Given
        Fraction fraction1 = new Fraction(10, 11);
        Fraction fraction2 = new Fraction(7, 6);

        //When
        Fraction sub1 = fraction1.minus(fraction2);
        Fraction sub2 = fraction2.minus(fraction1);

        //Then
        Assert.assertEquals(sub1.opposite(), sub2);
    }
}
