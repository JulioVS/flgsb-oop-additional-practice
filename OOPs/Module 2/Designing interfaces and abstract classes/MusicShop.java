// Step 1: Create an abstract class Instrument
// This should include:
// - private String name
// - protected int year (year of manufacture)
// - constructor that initializes both fields
// - abstract method play() that returns a String
// - concrete method getInstrumentDetails() that returns information about the instrument
abstract class Instrument {

    private String name;
    protected int year;

    public Instrument(String name, int year) {
        this.name = name;
        this.year = year;
    }

    abstract String play();

    public String getInstrumentDetails() {
        return "\nInstruments details - "
                + "\n Name: " + this.name
                + "\n Year: " + this.year;
    }

}

// Step 2: Create an interface Tunable
// This should include:
// - abstract method tune() that returns a String
// - abstract method adjustPitch(boolean up) that returns a String (up means
// increase pitch)
interface Tunable {

    String tune();
    String adjustPitch(boolean up);

}

// Step 3: Create an interface Maintainable
// This should include:
// - abstract method clean() that returns a String
// - abstract method inspect() that returns a String
interface Maintainable {

    String clean();
    String inspect();

}

// Step 4: Create a concrete class StringedInstrument that extends Instrument
// This should include:
// - private int numberOfStrings
// - constructor that initializes name, year, and numberOfStrings
// - implementation of the abstract play() method
// - override getInstrumentDetails() to include number of strings
class StringedInstrument extends Instrument {

    private int numberOfStrings;

    public StringedInstrument(String name, int year, int numberOfStrings) {
        super(name, year);
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public String play() {
        return "Now playing my Stringed Instrument 🎶🎶🎶";
    }

    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails()
                + "\n Strings: " + this.numberOfStrings;
    }

}

// Step 5: Create a concrete class Guitar that extends StringedInstrument
// and implements Tunable and Maintainable
// This should include:
// - private String guitarType (acoustic, electric, etc.)
// - constructor that initializes all fields
// - implementation of all required interface methods
class Guitar extends StringedInstrument implements Tunable, Maintainable {

    private String guitarType;

    public Guitar(String name, int year, int numberOfString, String guitarType) {
        super(name, year, numberOfString);
        this.guitarType = guitarType;
    }

    @Override
    public String tune() {
        return "Now tuning up my Guitar";
    }

    @Override
    public String adjustPitch(boolean up) {
        return "Now adjusting my Guitar pitch " + (up ? "⬆️" : "⬇️");
    }

    @Override
    public String clean() {
        return "Now cleaning my Guitar";
    }

    @Override
    public String inspect() {
        return "Now inspecting my Guitar";
    }

}

// Step 6: Create a concrete class Piano that extends Instrument
// and implements Tunable and Maintainable
// This should include:
// - private boolean isGrand
// - constructor that initializes all fields
// - implementation of the abstract play() method
// - implementation of all required interface methods
class Piano extends Instrument implements Tunable, Maintainable {

    private boolean isGrand;

    public Piano(String name, int year, boolean isGrand) {
        super(name, year);
        this.isGrand = isGrand;
    }

    @Override
    public String play() {
        return "Now playing my "
                + (this.isGrand ? "Grand " : "")
                + "Piano 🎶🎶🎶";
    }

    @Override
    public String tune() {
        return "Now tuning up my "
                + (this.isGrand ? "Grand " : "")
                + "Piano";
    }

    @Override
    public String adjustPitch(boolean up) {
        return "Now adjusting my "
                + (this.isGrand ? "Grand " : "")
                + "Piano pitch "
                + (up ? "⬆️" : "⬇️");
    }

    @Override
    public String clean() {
        return "Now cleaning my "
                + (this.isGrand ? "Grand " : "")
                + "Piano";
    }

    @Override
    public String inspect() {
        return "Now inspecting my "
                + (this.isGrand ? "Grand " : "")
                + "Piano";
    }

}

// Step 7: Create a public class MusicShop to test the classes
// This should include:
// - main method that:
// 1. Creates an array of Instrument objects including Guitar and Piano
// instances
// 2. Iterates through the array calling play() for each instrument
// 3. Demonstrates polymorphism by testing if each instrument is Tunable or
// Maintainable
// and if so, calls the appropriate methods
public class MusicShop {

    public static void main(String[] args) {

        System.out.println("\nMusic Shop open!");

        Instrument[] instruments = new Instrument[3];

        instruments[0] = new Guitar("Fender", 1992, 6, "Electric");
        instruments[1] = new Piano("Steinway", 1955, true);
        instruments[2] = new Piano("Yamaha", 1978, false);

        for (Instrument i : instruments) {

            System.out.println();
            System.out.println(i.play());

            if (i instanceof Tunable) {
                Tunable t = (Tunable) i;

                System.out.println(t.tune());
                System.out.println(t.adjustPitch(true));
            }

            if (i instanceof Maintainable) {
                Maintainable m = (Maintainable) i;

                System.out.println(m.clean());
                System.out.println(m.inspect());
            }

        }

        System.out.println("\nMusic Shop closed!\n");

    }

}
