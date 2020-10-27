import fraction.Fraction;
import fraction.exception.InvalidFractionException;
import org.junit.Assert;
import org.junit.Test;

public class FractionAdditionTest {

    @Test(expected = InvalidFractionException.class)
    public void given_invalidFraction_when_add_then_throwInvalidFractionException() {
        //Given
        Fraction f1 = new Fraction(1, 0);
        Fraction f2 = new Fraction(10, 1);

        //When
        f1.add(f2);
    }

    @Test
    public void given_validFractionsOfZero_when_add_then_returnFractionOfZero() {
        //Given
        Fraction f1 = Fraction.of(0);
        Fraction f2 = Fraction.of(0);

        //When
        Fraction result = f1.add(f2);

        //Then
        Assert.assertEquals(Fraction.of(0), result);
    }

    @Test
    public void given_validFractions_when_addToFractionOfZero_then_returnTheSameFraction() {
        //Given
        Fraction f1 = new Fraction(10, 1);
        Fraction f2 = Fraction.of(0);

        //When
        Fraction result = f1.add(f2);

        //Then
        Assert.assertEquals(f1, result);
    }

    @Test
    public void given_validFractionWithDenominatorEqualToOne_when_add_then_returnFractionOfSumOfNominators() {
        //Given
        Fraction f1 = new Fraction(10, 1);
        Fraction f2 = new Fraction(20, 1);

        //When
        Fraction result = f1.add(f2);

        //Then
        Assert.assertEquals(new Fraction(10 + 20, 1), result);
    }

    @Test
    public void given_validFractionsHavingEqualDenominators_when_add_then_returnFractionWithNominatorIsTheSumOfNominators() {
        //Given
        Fraction f1 = new Fraction(10, 15);
        Fraction f2 = new Fraction(20, 15);

        //When
        Fraction result = f1.add(f2);

        //Then
        Assert.assertEquals(new Fraction(10 + 20, 15), result);

    }

    @Test
    public void given_validFractions_when_applyCommutativePropertyOfAddition_then_returnEqualValues() {
        //Given
        Fraction f1 = new Fraction(10, 15);
        Fraction f2 = new Fraction(20, 15);

        //When
        Fraction addition1 = f1.add(f2);
        Fraction addition2 = f2.add(f1);

        //Then
        Assert.assertEquals(addition1, addition2);
    }

    @Test
    public void given_validFraction_when_addFractionToItself_then_returnFractionOfNominatorMultipliedByTwo() {
        //Given
        Fraction f = new Fraction(10, 33);

        //When
        Fraction addition = f.add(f);

        //Then
        Fraction expected = new Fraction(20, 33);
        Assert.assertEquals(expected, addition);
    }

    @Test
    public void given_validFractions_when_applyAssociativePropertyOfAddition_then_returnEqualValues() {
        //Given
        Fraction f1 = new Fraction(5, 3);
        Fraction f2 = new Fraction(7, 9);
        Fraction f3 = new Fraction(3, 2);

        //When
        Fraction addition1 = f1.add(f2).add(f3);
        Fraction addition2 = f3.add(f1).add(f2);

        //Then
        Assert.assertEquals(addition1, addition2);
    }

    @Test
    public void given_validFractions_when_add_then_returnGeneralAddition() {
        //Given
        Fraction f1 = new Fraction(5, 3);
        Fraction f2 = new Fraction(7, 9);

        //When
        Fraction addition = f1.add(f2);

        //Then
        Fraction expected = new Fraction(5 * 9 + 7 * 3, 9 * 3);
        Assert.assertEquals(expected, addition);
    }

    @Test
    public void given_validFraction_when_simplify_then_returnSimplifiedValueOfTheFraction() {
        //Given
        Fraction fraction1 = new Fraction(10, 3);
        Fraction fraction2 = new Fraction(5, 3);

        Fraction fraction3 = new Fraction(4, 15);
        Fraction fraction4 = new Fraction(1, 15);

        Fraction fraction5 = new Fraction(10, 15);
        Fraction fraction6 = new Fraction(15, 15);

        //When
        Fraction simplifiedAddition1 = fraction1.add(fraction2).simplify();
        Fraction simplifiedAddition2 = fraction3.add(fraction4).simplify();
        Fraction simplifiedAddition3 = fraction5.add(fraction6).simplify();

        //Then
        Fraction expected = new Fraction(5, 3);

        Assert.assertEquals(Fraction.of(5), simplifiedAddition1);
        Assert.assertEquals(Fraction.of(3).reciprocal(), simplifiedAddition2);
        Assert.assertEquals(expected, simplifiedAddition3);
    }
}
