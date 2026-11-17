import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    // Salon Service Class
    static class Service {
        String name;
        int price;
        String duration;
        String icon;
        String description;

        Service(String name, int price, String duration, String icon, String description) {
            this.name = name;
            this.price = price;
            this.duration = duration;
            this.icon = icon;
            this.description = description;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> bookings = new ArrayList<>();

        // Our Salon Services
        Service[] services = {
            new Service("Box Braids", 450, "3-4 hours", "🧶", "Protective braids, neatly sectioned and styled."),
            new Service("Gel Nails", 250, "1 hour", "💅", "A glossy gel finish for a polished look."),
            new Service("Full Face Makeup", 350, "1.5 hours", "💄", "A complete makeup look for your special occasion."),
            new Service("Wig Install + Styling", 300, "2 hours", "✨", "A secure install finished with a custom style.")
        };

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║       ✨ GLOW BEAUTY SALON - JOBURG ✨       ║");
        System.out.println("║          Hair  •  Nails  •  Makeup          ║");
        System.out.println("╚════════════════════════════════════════════╝");

        while (true) {
            System.out.println("\n┌────────────── BEAUTY MENU ──────────────┐");
            System.out.println("│  1. Browse Services & Prices            │");
            System.out.println("│  2. Book an Appointment                 │");
            System.out.println("│  3. View My Bookings                    │");
            System.out.println("│  4. Exit                                │");
            System.out.println("└────────────────────────────────────────┘");
            System.out.print("Choose an option (1-4): ");

            int choice = input.nextInt();
            input.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.println("\n═══════ ✨ THE BEAUTY MENU ✨ ═══════");
                for (int i = 0; i < services.length; i++) {
                    Service service = services[i];
                    System.out.println("\n" + service.icon + " " + (i + 1) + ". " + service.name);
                    System.out.println("   " + service.description);
                    System.out.println("   Price: R" + service.price + "  |  Time: " + service.duration);
                }
                System.out.println("\n════════════════════════════════════");

            } else if (choice == 2) {
                System.out.print("\nEnter your name: ");
                String name = input.nextLine();

                System.out.println("\nChoose your beauty service:");
                for (int i = 0; i < services.length; i++) {
                    System.out.println((i + 1) + ". " + services[i].icon + " " + services[i].name + " - R" + services[i].price);
                }
                System.out.print("Enter number: ");
                int serviceChoice = input.nextInt();
                input.nextLine();

                System.out.print("Enter date (e.g. 20 Nov 2026): ");
                String date = input.nextLine();

                if (serviceChoice >= 1 && serviceChoice <= 4) {
                    Service selected = services[serviceChoice - 1];
                    String booking = name + " booked " + selected.name + " for R" + selected.price + " on " + date;
                    bookings.add(booking);
                    System.out.println("\n✅ BOOKING SAVED!");
                    System.out.println("   " + booking);
                    System.out.println("Please contact the salon directly to confirm. This program does not send WhatsApp messages.");
                } else {
                    System.out.println("Invalid service. Try again.");
                }

            } else if (choice == 3) {
                System.out.println("\n--- YOUR BOOKINGS ---");
                if (bookings.isEmpty()) {
                    System.out.println("No bookings yet.");
                } else {
                    for (String b : bookings) {
                        System.out.println("- " + b);
                    }
                }

            } else if (choice == 4) {
                System.out.println("\nThank you for visiting Glow Beauty Salon!");
                break;
            } else {
                System.out.println("Please choose 1-4 only.");
            }
        }
        input.close();
    }
}