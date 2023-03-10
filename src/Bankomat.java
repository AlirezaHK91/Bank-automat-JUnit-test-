public class Bankomat {

    boolean cardInserted = false;
    Card card= new Card();
    int amount;
    int machineBalance = 11000;

    String message= "";

    void insertCard(Card card) {
        cardInserted = true;
        this.card = card;
        if (this.card.pin == ""){
            addMessage ("This is a new card please choose your pin code");
        }else {
            addMessage ("Enter the pin");
        }
    }
    void addMessage(String msg){
        message =msg;
        System.out.println(message);
    }

    public String getMessage(){
        return message;
    }

    boolean createPin(String pin){
        return card.createPin(pin);
    }

    void ejectCard() {
        cardInserted = false;
    }

    boolean enterPin(String pin) {
        if (card.pin == pin) {
            return true;
        } else {
            return false;
        }
    }

    int withdrawMoney(int amount) {
        if (amount%100 != 0){
            return 0;
        }
        if (machineBalance >= amount) {
            machineBalance -= amount;
            return amount;
        } else {
            return 0;
        }
    }


}


