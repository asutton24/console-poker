public class Card {
    private int suit;
    private int value;

    private static int[] sVal = new int[4];

    private static int[] vVal = new int[13];
    public Card(){
        suit = 0;
        value = 0;
    }

    public void setCard(int n){
        n--;
        suit = n/13;
        value = n%13;
    }

    public int getSuit(){
        return suit;
    }

    public int getValue(){
        return value;
    }

    public String display(){
        String s = "";
        if (value<9){
            s+=(value+2);
        } else if (value==9){
            s+="J";
        } else if (value==10){
            s+="Q";
        } else if (value==11){
            s+="K";
        } else if (value==12){
            s+="A";
        }
        if (suit==0){
            s+="♠";
        } else if (suit==1){
            s+="♥";
        } else if (suit==2){
            s+="♦";
        } else if (suit==3){
            s+="♣";
        }
        return s;
    }

    public static void makeData(Card a,Card b,Card c,Card d, Card e){
        for (int i=0;i<4;i++){
            sVal[i]=0;
        }
        for (int i=0;i<13;i++){
            vVal[i]=0;
        }
        sVal[a.getSuit()]++;
        sVal[b.getSuit()]++;
        sVal[c.getSuit()]++;
        sVal[d.getSuit()]++;
        sVal[e.getSuit()]++;
        vVal[a.getValue()]++;
        vVal[b.getValue()]++;
        vVal[c.getValue()]++;
        vVal[d.getValue()]++;
        vVal[e.getValue()]++;
        /*
        for (int i=0;i<4;i++){
            System.out.print(sVal[i]+" ");
        }
        System.out.println();
        for (int i=0;i<13;i++){
            System.out.print(vVal[i]+" ");
        }
        System.out.println();

         */
    }
    public static int findHand(){
        if (vVal[8]==1 && vVal[9]==1 && vVal[10]==1 && vVal[11]==1 && vVal[12]==1 && (sVal[0]==5 || sVal[1]==5 || sVal[2]==5 || sVal[3]==5)){
           return 1;
        }
        if (sVal[0]==5 || sVal[1]==5 || sVal[2]==5 || sVal[3]==5){
            for (int i=0;i<9;i++){
                if (vVal[i]==1 && vVal[i+1]==1 && vVal[i+2]==1 && vVal[i+3]==1 && vVal[i+4]==1){
                    return 2;
                }
            }
            return 5;
        }
        for (int i=0;i<13;i++){
            if (vVal[i]==4){
                return 3;
            }
        }
        for (int i=0;i<13;i++){
            if (vVal[i]==3){
                for (int j=0;j<13;j++){
                    if (vVal[j]==2){
                        return 4;
                    }
                }
            }
        }
        for (int i=0;i<9;i++){
            if (vVal[i]==1 && vVal[i+1]==1 && vVal[i+2]==1 && vVal[i+3]==1 && vVal[i+4]==1){
                return 6;
            }
        }
        if (vVal[0]==1 && vVal[1]==1 && vVal[2]==1 && vVal[3]==1 && vVal[12]==1){
            if (sVal[0]==5 || sVal[1]==5 || sVal[2]==5 || sVal[3]==5){
                return 2;
            } else {
                return 6;
            }
        }
        for (int i=0;i<13;i++){
            if (vVal[i]==3){
                return 7;
            }
        }
        for (int i=0;i<13;i++){
            if (vVal[i]==2){
                for (int j=0;j<13;j++){
                   if (i!=j && vVal[j]==2){
                       return 8;
                   }
                }
            }
        }
        if (vVal[12]==2 || vVal[11]==2 || vVal[10]==2 || vVal[9]==2){
            return 9;
        }
        return 10;
    }
}
