/**
 * Xia Lin
 * 110732381
 * xia.lin@stonybrook.edu
 * Assignment 7
 * CSE214-01
 * Charles Chen
 * Shilpi Bhattacharyya
 */
package homwork7;

import big.data.DataInstantiationException;
import big.data.DataSourceException;
import java.util.List;
import java.util.Scanner;

public class ASMDB {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MovieManager mm = new MovieManager();
        System.out.println("Welcome to A Smiley Movie Data Base, the happiest way to manage your DVDs.");
        System.out.println("Main Menu:");
        System.out.println("\tI) Import a Movie");
        System.out.println("\tD) Delete a Movie");
        System.out.println("\tA) Sort Actors");
        System.out.println("\tM) Sort Movies");
        System.out.println("\tQ) Quit");
        System.out.print("Please select an option:");
        String fInput = input.nextLine();
        while (!fInput.equalsIgnoreCase("Q")) {
            if (fInput.equalsIgnoreCase("I")) {
                System.out.print("Please enter a movie title:");
                String title = input.nextLine();
                String prefix = "http://www.omdbapi.com/?t=";
                String postfix = "&y=&plot=short&r=xml";
                try {
                    System.out.println("Movie added: \"" + mm.setAndReturnMovies(new Movie(prefix + title.replace(' ', '+') + postfix)).getTitle() + "\"");
                } catch (DataSourceException e) {
                    System.out.println("Movie not found.");
                } catch (DataInstantiationException ex) {
                    System.out.println("Movie not found.");
                }

            } else if (fInput.equalsIgnoreCase("D")) {
                System.out.print("Please enter the movie title to be deleted:");
                String deleteTitle = input.nextLine();
                for (int i = 0; i < mm.getMovies().size(); i++) {
                    if (deleteTitle.equalsIgnoreCase(mm.getMovies().get(i).getTitle())) {
                        for (int j = 0; j < mm.getMovies().get(i).getActors().size(); j++) {
                            for (int z = 0; z < mm.getActors().size(); z++) {
                                if (mm.getMovies().get(i).getActors().get(j).equals(mm.getActors().get(z))) {
                                    if (mm.getActors().get(z).getCount() > 1) {
                                        mm.getActors().get(z).setCount(-1);
                                    } else {
                                        mm.getActors().remove(mm.getActors().get(z));
                                    }
                                }
                            }
                        }
                        System.out.println("\"" + mm.getMovies().remove(i).getTitle() + "\" deleted.");
                        break;
                    } else if (i == mm.getMovies().size() - 1) {
                        System.out.println("The movie is not in the list.");
                    }
                }
            } else if (fInput.equalsIgnoreCase("A")) {
                System.out.println("Actor Sorting Options:");
                System.out.println("\tAA) Alphabetically Ascending");
                System.out.println("\tAD) Alphabetically Descending");
                System.out.println("\tNA) By Number of Movies They Are In Ascending");
                System.out.println("\tND) By Number of Movies They Are In Descending");
                System.out.print("Please Select A Sort Method:");
                String aInput = input.nextLine();
                if (aInput.equalsIgnoreCase("AA")) {
                    System.out.println(" Actor                                  Number of Movies");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    List<Actor> temp = mm.getSortedActors(new NameComparator());
                    for (int i = 0; i < temp.size(); i++) {
                        System.out.println(temp.get(i).toString());
                    }
                } else if (aInput.equalsIgnoreCase("AD")) {
                    System.out.println(" Actor                                  Number of Movies");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    List<Actor> temp = mm.getSortedActors(new NameComparator());
                    for (int i = temp.size() - 1; i >= 0; i--) {
                        System.out.println(temp.get(i).toString());
                    }
                } else if (aInput.equalsIgnoreCase("NA")) {
                    System.out.println(" Actor                                  Number of Movies");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    List<Actor> temp = mm.getSortedActors(new CountComparator());
                    for (int i = 0; i < temp.size(); i++) {
                        System.out.println(temp.get(i).toString());
                    }
                } else if (aInput.equalsIgnoreCase("ND")) {
                    System.out.println(" Actor                                  Number of Movies");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    List<Actor> temp = mm.getSortedActors(new CountComparator());
                    for (int i = temp.size() - 1; i >= 0; i--) {
                        System.out.println(temp.get(i).toString());
                    }
                }
            } else if (fInput.equalsIgnoreCase("M")) {
                System.out.println("Movie Sorting Options:");
                System.out.println("\tTA) Title Ascending (A-Z)");
                System.out.println("\tTD) Title Descending (Z-A)");
                System.out.println("\tYA) Year Ascending");
                System.out.println("\tYD) Year Descending");
                System.out.print("Please Select A Sort Method:");
                String mInput = input.nextLine();
                if (mInput.equalsIgnoreCase("TA")) {
                    System.out.println("Title                                             Year Actors");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    List<Movie> temp = mm.getSortedMovies(new TitleComparator());
                    for (int i = 0; i < temp.size(); i++) {
                        System.out.println(temp.get(i).toString());
                    }
                } else if (mInput.equalsIgnoreCase("TD")) {
                    System.out.println("Title                                             Year Actors");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    List<Movie> temp = mm.getSortedMovies(new TitleComparator());
                    for (int i = temp.size() - 1; i >= 0; i--) {
                        System.out.println(temp.get(i).toString());
                    }
                } else if (mInput.equalsIgnoreCase("YA")) {
                    System.out.println("Title                                             Year Actors");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    List<Movie> temp = mm.getSortedMovies(new YearComparator());
                    for (int i = 0; i < temp.size(); i++) {
                        System.out.println(temp.get(i).toString());
                    }
                } else if (mInput.equalsIgnoreCase("YD")) {
                    System.out.println("Title                                             Year Actors");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    List<Movie> temp = mm.getSortedMovies(new YearComparator());
                    for (int i = temp.size() - 1; i >= 0; i--) {
                        System.out.println(temp.get(i).toString());
                    }
                }
            }
            System.out.print("Please select an option:");
            fInput = input.nextLine();
        }
        System.out.println("That's All Folks!");

    }
}
