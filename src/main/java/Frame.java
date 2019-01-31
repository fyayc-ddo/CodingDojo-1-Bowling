public class Frame {

    private int roll1;
    private int roll2;
    private boolean spare;
    private boolean strike;

    public Frame(int roll1, int roll2) {
        this.roll1 = roll1;
        this.roll2 = roll2;
    }

    public Frame(int roll1, String roll2) {
        this.roll1 = roll1;
        if (roll2.equals("/")) {
            this.spare = true;
            this.roll2 = 10 - this.roll1;
        }
    }

    public Frame(String s) {
        String[] rolls = s.split(",");
        if (rolls[0].equals("X")) {
            this.strike = true;
            this.roll1 = 10;
            this.roll2 = 0;
        } else {
            this.roll1 = Integer.parseInt(rolls[0]);
        }

        if (rolls.length > 1) {
            if (rolls[1].equals("/")) {
                this.spare = true;
                this.roll2 = 10 - this.roll1;
            }  else {
                this.roll2 = Integer.parseInt(rolls[1]);
            }
        }

        if(rolls.length > 2){
            if(this.spare){
                this.roll2 = 10 + Integer.parseInt(rolls[2]);
            } else if (this.strike) {
                this.roll1 = 10 + Integer.parseInt(rolls[2]);
            }
        }
    }

    public boolean isSpare() {
        return spare;
    }

    public boolean isStrike() {
        return strike;
    }

    public int getRoll1() {
        return roll1;
    }

    public void setRoll1(int roll1) {
        this.roll1 = roll1;
    }

    public int getRoll2() {
        return roll2;
    }

    public void setRoll2(int roll2) {
        this.roll2 = roll2;
    }
}
