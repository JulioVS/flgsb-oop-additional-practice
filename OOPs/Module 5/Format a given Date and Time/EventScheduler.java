// EventScheduler.java
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class EventScheduler {
    private List<Event> events;
    private Scanner scanner;

    public EventScheduler() {
        // Step 7: Initialize the events list and scanner
        this.events = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {

        boolean running = true;

        while (running) {

            // Step 8: Display menu options
            System.out.println("\n=== Event Scheduler ===");
            System.out.println("1. Add Event");
            System.out.println("2. Display All Events");
            System.out.println("3. Show Time Until Event");
            System.out.println("4. Convert Event Time to Different Timezone");
            System.out.println("5. Find Upcoming Events");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            // Step 9: Implement menu choices using switch-case
            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    displayAllEvents();
                    break;
                case 3:
                    showTimeUntilEvent();
                    break;
                case 4:
                    convertEventTime();
                    break;
                case 5:
                    findUpcomingEvents();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the Event Scheduler. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addEvent() {

        // Step 10: Implement method to get event details from user and create a new
        // Event
        // Hint: Get name, date, time, duration, and timezone from user
        // Parse the date and time strings into LocalDateTime
        // Get a ZoneId from the timezone string
        // Create a ZonedDateTime from LocalDateTime and ZoneId
        // Create a Duration object from hours and minutes
        // Create a new Event object and add it to the events list

        try {

            System.out.print("Enter event name: ");
            String name = scanner.nextLine();

            System.out.print("Enter event date (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();

            System.out.print("Enter event time (HH:mm): ");
            String timeStr = scanner.nextLine();

            System.out.print("Enter event duration in hours: ");
            int hours = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter event duration in minutes: ");
            int minutes = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter event timezone (e.g., America/New_York): ");
            String timezoneStr = scanner.nextLine();

            LocalDateTime localDateTime = LocalDateTime.parse(dateStr + "T" + timeStr);
            ZoneId zoneId = ZoneId.of(timezoneStr);
            ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
            Duration duration = Duration.ofHours(hours).plusMinutes(minutes);

            Event event = new Event(name, zonedDateTime, duration);
            events.add(event);

            System.out.println("Event added successfully!");

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date or time format. Please try again.");

        } catch (Exception e) {
            System.out.println("An error occurred while adding the event. Please try again.");
        }

    }

    private void displayAllEvents() {
        // Step 11: Implement method to display all events
        // Hint: Get format pattern from user
        // Loop through events list and display each event with the specified format
        if (events.isEmpty()) {
            System.out.println("No events scheduled.");
            return;
        }

        System.out.print("Enter date format pattern (e.g., yyyy-MM-dd HH:mm): ");
        String pattern = scanner.nextLine();

        for (Event event : events) {
            System.out.println(event.getName() + " - " +
                    event.formatDateTime(pattern) + " (Duration: " +
                    event.getDuration().toHours() + "h " +
                    event.getDuration().toMinutesPart() + "m)");
        }
    }

    private void showTimeUntilEvent() {
        // Step 12: Implement method to calculate and display time until a specific
        // event
        // Hint: Show list of events with numbers
        // Get event selection from user
        // Calculate and display time until the selected event
        if (events.isEmpty()) {
            System.out.println("No events scheduled.");
            return;
        }

        System.out.println("Select an event to see time until it starts:");
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i).getName());
        }

        int selection = Integer.parseInt(scanner.nextLine()) - 1;

        if (selection < 0 || selection >= events.size()) {
            System.out.println("Invalid selection. Please try again.");
            return;
        }

        Event selectedEvent = events.get(selection);
        Duration timeUntil = selectedEvent.timeUntilEvent();

        if (timeUntil.isNegative()) {
            System.out.println("The event has already started.");
        } else {
            System.out.println("Time until " + selectedEvent.getName() + ": " +
                    timeUntil.toDaysPart() + " days, " +
                    timeUntil.toHoursPart() + " hours, " +
                    timeUntil.toMinutesPart() + " minutes, " +
                    timeUntil.toSecondsPart() + " seconds.");
        }

    }

    private void convertEventTime() {

        // Step 13: Implement method to convert event time to a different timezone
        // Hint: Show list of events with numbers
        // Get event selection from user
        // Get target timezone from user
        // Convert and display event time in the target timezone

        if (events.isEmpty()) {
            System.out.println("No events scheduled.");
            return;
        }

        System.out.println("Select an event to convert its time:");
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i).getName());
        }

        int selection = Integer.parseInt(scanner.nextLine()) - 1;

        if (selection < 0 || selection >= events.size()) {
            System.out.println("Invalid selection. Please try again.");
            return;
        }

        Event selectedEvent = events.get(selection);

        System.out.print("Enter target timezone (e.g., Europe/London): ");
        String targetTimezone = scanner.nextLine();

        ZonedDateTime convertedTime = selectedEvent.convertToTimezone(targetTimezone);

        System.out.println("Event time in " + targetTimezone + ": " +
                convertedTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z")));

    }

    private void findUpcomingEvents() {

        // Step 14: Implement method to find events within a specific number of days
        // Hint: Get number of days from user
        // Loop through events and display those within the specified days
        
        if (events.isEmpty()) {
            System.out.println("No events scheduled.");
            return;
        }

        System.out.print("Enter number of days to find upcoming events: ");
        int days = Integer.parseInt(scanner.nextLine());

        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime cutoff = now.plusDays(days);

        boolean found = false;

        for (Event event : events) {
            if (event.getDateTime().isAfter(now) && event.getDateTime().isBefore(cutoff)) {
                System.out.println(event.getName() + " - " + event.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z")));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No upcoming events within the specified number of days.");
        }

    }

    public static void main(String[] args) {
        // Step 15: Create an EventScheduler object and call its run method
        EventScheduler scheduler = new EventScheduler();
        scheduler.run();
    }
}
