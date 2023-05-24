import java.util.Scanner;
public class Main {
    public static int[] cards;
    public static int[] randomDeck(int n){
        int[] deck;
        deck = new int[52];
        for (int i=1;i<=52;i++){
            deck[i-1]=i;
        }
        for (int i=0;i<n;i++) {
            int rand1 = (int) (Math.random() * 52);
            int rand2 = (int) (Math.random() * 52);
            while (rand1 == rand2) {
                rand2 = (int) (Math.random() * 52);
            }
            int temp1 = deck[rand1];
            int temp2 = deck[rand2];
            deck[rand1] = temp2;
            deck[rand2] = temp1;
        }
        return deck;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] cards= new int[52];
        cards = randomDeck(10000);
        int cash = 1000;
        int bet;
        int selection = 0;
        int high = 0;
        Card one = new Card();
        Card two = new Card();
        Card three = new Card();
        Card four = new Card();
        Card five = new Card();
        while (cash>0){
            boolean close1 = false;
            boolean close2 = false;
            boolean close3 = false;
            boolean close4 = false;
            boolean close5 = false;
            int tick = 5;
            System.out.println("Cash: "+cash+"\nPlace a bet");
            bet = scan.nextInt();
            if (cash-bet>=0 && bet>0){
                cards = randomDeck(10000);
                cash = cash-bet;
                one.setCard(cards[0]);
                two.setCard(cards[1]);
                three.setCard(cards[2]);
                four.setCard(cards[3]);
                five.setCard(cards[4]);
                System.out.println(one.display()+" "+two.display()+" "+three.display()+" "+four.display()+" "+five.display());
                System.out.println("Enter the cards (1-5,no spaces) that you want to replace");
                selection = scan.nextInt();
                while (selection>0){
                    if (selection%10==1 && !(close1)){
                        one.setCard(cards[tick]);
                        tick++;
                        close1 = true;
                    } else if (selection%10==2 && !(close2)){
                        two.setCard(cards[tick]);
                        tick++;
                        close2 = true;
                    } else if (selection%10==3 && !(close3)){
                        three.setCard(cards[tick]);
                        tick++;
                        close3 = true;
                    } else if (selection%10==4 && !(close4)){
                        four.setCard(cards[tick]);
                        tick++;
                        close4 = true;
                    } else if (selection%10==5 && !(close5)){
                        five.setCard(cards[tick]);
                        tick++;
                        close5 = true;
                    }
                    selection/=10;
                }
                System.out.println(one.display()+" "+two.display()+" "+three.display()+" "+four.display()+" "+five.display());
                Card.makeData(one,two,three,four,five);
                high = Card.findHand();
                if (high==1){
                    System.out.println("Royal flush");
                    cash+=(bet*250);
                } else if (high==2){
                    System.out.println("Straight flush");
                    cash+=(bet*50);
                } else if (high==3){
                    System.out.println("Four of a kind");
                    cash+=(bet*25);
                } else if (high==4){
                    System.out.println("Full house");
                    cash+=(bet*9);
                } else if (high==5){
                    System.out.println("Flush");
                    cash+=(bet*6);
                } else if (high==6){
                    System.out.println("Straight");
                    cash+=(bet*4);
                } else if (high==7){
                    System.out.println("Three of a kind");
                    cash+=(bet*3);
                } else if (high==8){
                    System.out.println("Two pair");
                    cash+=(bet*2);
                } else if (high==9){
                    System.out.println("One pair");
                    cash+=bet;
                } else {
                    System.out.println("You lose");
                }
            } else {
                System.out.println("Invalid bet");
            }
        }
    }
}