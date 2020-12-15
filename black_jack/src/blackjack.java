     |        import java.util.Scanner;

public class blackjack {
    public static void main(String[] args) {

        //intro
        System.out.println("      __________________________________________________");
        System.out.println("     |                                                  |");
        System.out.println("     |                                                  |");
        System.out.println("     |    #####    #         ####     #####   #   #     |");
        System.out.println("     |    #    #   #        #    #   #        #  #      |");
        System.out.println("     |    #####    #        ######   #        # #       |");
        System.out.println("     |    #     #  #        #    #   #        #   #     |");
        System.out.println("     |    #     #  #######  #    #    #####   #     #   |");
        System.out.println("     |    ######                                        |");
        System.out.println("     |             #    ####    #####  #   #            |");
        System.out.println("     |             #   #    #  #       #  #             |");
        System.out.println("     |             #   ######  #       # #              |");
        System.out.println("     |             #   #    #  #       #   #            |");
        System.out.println("     |            #    #    #   #####  #     #          |");
        System.out.println("     |      # # #                                       |");
        System.out.println("     |                                                  |");
        System.out.println("      -------------------------------------------------");

        Deck cardDeck = new Deck();
        cardDeck.makeDeck();
        cardDeck.shuffle();


        Deck playerDeck = new Deck();   //player deck
        Deck dealerDeck = new Deck();   //dealer deck

        double chips = 25;
        Scanner input = new Scanner(System.in);

            //game

            while (chips > 0) {
                double bet = -1;

                    do {

                        System.out.println("      You have " + chips + " chips, how much do you want to bet?");
                        bet = input.nextDouble();

                        if (bet > chips) {
                            System.out.println("Looks like you don't have enough chips to bet that much.");
                        } else if (bet < 0) {
                            System.out.println("Ummm I don't think that's a valid amount...");
                        }
                    }
                    while (bet < 1 || bet > chips);
                    boolean roundOver = false;


                    System.out.println("Dealing...");
                    playerDeck.draw(cardDeck);
                    playerDeck.draw(cardDeck);
                    dealerDeck.draw(cardDeck);
                    dealerDeck.draw(cardDeck);

                    while (true) {
                        System.out.println("Your Hand:" + playerDeck.toString());
                        System.out.println("\n" + "Your hand's value: " + playerDeck.valueofCards());

                        System.out.println("Dealer hand: " + dealerDeck.getCard(0).toString() + " and another hidden card");
                        int answer = -1;
                        do {
                            System.out.println("Are you gonna hit (1) or stand (2) ? Enter (3) to exit the game.");
                            answer = input.nextInt();
                        } while (answer < 1 && answer > 3);

                        if (answer == 1) {
                            playerDeck.draw(cardDeck);
                            System.out.println(" You drew a " + playerDeck.getCard(playerDeck.size() - 1).toString());
                            //Bust
                            if (playerDeck.valueofCards() > 21) {
                                System.out.println("Bust! Your hand value is " + playerDeck.valueofCards());
                                chips -= bet;
                                roundOver = true;
                                break;
                            }
                        }
                        if (answer == 2) {
                            break;
                        }

                        if(answer == 3) {
                            System.out.println("Good game! you ended with "+ " chips.");
                            System.exit(1);
                        }
                    }
                    System.out.println("Dealer's hand" + dealerDeck.toString());
                    if ((dealerDeck.valueofCards() > playerDeck.valueofCards()) && roundOver == false) {
                        System.out.println("Looks like the dealer wins this round!");
                        chips -= bet;
                        roundOver = true;
                    }
                    while ((dealerDeck.valueofCards() < 17) && roundOver == false) {
                        dealerDeck.draw(cardDeck);
                        System.out.println("The dealer drew: " + dealerDeck.getCard(dealerDeck.size() - 1).toString());
                    }
                    System.out.println("The dealer's deck value: " + dealerDeck.valueofCards());
                    if ((dealerDeck.valueofCards() > 21) && roundOver == false) {
                        System.out.println("Looks like the dealer busted! You win this round.");
                        chips += bet;
                        roundOver = true;
                    }
                    if ((playerDeck.valueofCards() == dealerDeck.valueofCards()) && roundOver == false) {
                        System.out.println("Tie!");
                        roundOver = true;
                    }
                    if ((playerDeck.valueofCards() > dealerDeck.valueofCards() && roundOver == false)) {

                        System.out.println("You win this round!");
                        chips += bet;
                        roundOver = true;
                    } else if (roundOver == false) //dealer wins
                    {
                        System.out.println("The dealer wins this round!");
                        chips -= bet;
                    }
                    playerDeck.moveCards(cardDeck);
                    dealerDeck.moveCards(cardDeck);
                    System.out.println("You reached the end of your hand!");
                }

                System.out.println("Yikes! You're out of money. Game over.");


            }
        }







                                          |
     |                                                  |

