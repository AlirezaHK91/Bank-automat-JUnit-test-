import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankomatTest {
    Bankomat bankomat;
    Card card;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.bankomat= new Bankomat();
        this.card =new Card();
    }

    @Test
    void insertCard() {
        bankomat.insertCard(card);
        Assertions.assertEquals(true, bankomat.cardInserted);
    }

    @Test
    void ejectCard() {
        bankomat.insertCard(card);
        bankomat.ejectCard();
        Assertions.assertEquals(false, bankomat.cardInserted);
    }

    @Test
    void enterPin() {
        bankomat.insertCard(card);
        boolean pin = bankomat.enterPin("");
        Assertions.assertTrue(pin);
    }

    @Test
    void withdrawMoney() {

        bankomat.insertCard(card);
        bankomat.enterPin("1111");
        bankomat.withdrawMoney(1000);
        Assertions.assertEquals(10000, bankomat.machineBalance);
    }

    @Test
    void createPin(){
        bankomat.insertCard(card);
        String msg = bankomat.getMessage();
        assertEquals("This is a new card please choose your pin code", msg);
        boolean result = bankomat.createPin("1111");
        assertTrue(result);
    }

    @Test
    void updatePin() {
        card.createPin("1111");

        card.updatePin("1111","2222");

        assertEquals(card.pin, "2222");
    }

}