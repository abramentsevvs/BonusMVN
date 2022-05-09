import org.junit.jupiter.api.Assertions;

public class Test {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_60;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateUnRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 100_000_60;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateUnRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 2_000_60;
        boolean registered = false;
        long expected = 20;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }
}