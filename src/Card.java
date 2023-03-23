public class Card {


    String pin ="";

    boolean createPin(String pin){
        this.pin= pin;
        return true;
    }

    boolean updatePin(String oldPin, String newPin) {
        if (oldPin.equals(this.pin)) {
            this.pin = newPin;
            return true;
        } else {
            return false;
        }
    }

}
