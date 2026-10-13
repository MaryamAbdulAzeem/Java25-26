public class IPAddress {
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    private static int total = 0;

    public String getPart1() {
        return part1;
    }

    public String getPart2() {
        return part2;
    }

    public String getPart3() {
        return part3;
    }

    public String getPart4() {
        return part4;
    }

    public static int getTotal() {
        return total;
    }

    public void setAll(String part1, String part2, String part3, String part4) {
        String[] parts = {part1, part2, part3, part4};

        for (int i = 0; i < parts.length; i++) {
            boolean valid_part = true;
            boolean valid_digit = true;

            if (parts[i] == null || parts[i].equals("") || parts[i].equals(" ")) { // handles the case of an empty part or space in the IP address.
                valid_digit = false;
            }

            if (valid_digit) {
                for (int j = 0; j < parts[i].length(); j++) { // checks each String part of the IP address - digit validation (ensures that the IP address consists only of digits from 0-9)
                    char p = parts[i].charAt(j);
                    if (p < '0' || p > '9') {
                        valid_digit = false;
                        break;
                    }
                }
            }

            int numericPart = 0;
            if (valid_digit) {
                numericPart = Integer.parseInt(parts[i]);
                if ((numericPart < 0) || (numericPart > 255)) {
                    valid_part = false;
                }
            }

            if (valid_digit && valid_part) {
                parts[i] = "" + numericPart;
            } else {
                parts[i] = "0";
            }
        }

        this.part1 = parts[0];
        this.part2 = parts[1];
        this.part3 = parts[2];
        this.part4 = parts[3];
    }

    // Parameterized constructor
    public IPAddress(String ip) {
        int dotCount = 0;
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) == '.') {
                dotCount++;
            }
        }

        if (dotCount != 3) { // Checks if the IP address has 3 dots, if not it sets all the parts to 0
            this.setAll("0", "0", "0", "0");
            total++;
            return;
        }

        int firstDot = ip.indexOf("."); // finds the position of the first dot (where part1 ends)
        int secondDot = ip.indexOf(".", firstDot + 1); // finds the position of the second dot (where part2 ends)
        int thirdDot = ip.indexOf(".", secondDot + 1); // finds the position of the third dot (where part3 ends and part4 begins)

        String[] parts = new String[4]; // Creates an array in heap memory of size 4 to store each of the 4 parts of the ip address
        parts[0] = ip.substring(0, firstDot); // extracts portion of string from the start till the first dot
        parts[1] = ip.substring(firstDot + 1, secondDot); // extracts portion of string from the first dot till the second dot
        parts[2] = ip.substring(secondDot + 1, thirdDot); // extracts portion of string from the second dot till the third dot
        parts[3] = ip.substring(thirdDot + 1); // extracts portion of string from the third dot till the end

        // checks if inputs are numbers
        for (int i = 0; i < 4; i++) {
            boolean valid = parts[i].length() > 0; // flag to check if each part is a valid number (a digit between 0 and 9)
            for (int j = 0; j < parts[i].length(); j++) {
                char c1 = parts[i].charAt(j);
                if (c1 < '0' || c1 > '9') {
                    valid = false;
                    break;
                }
            }

            if (valid) { // after digit validation,
                // checks if the numbers are in the range of 0-255
                int num = Integer.parseInt(parts[i]); // e.g. converts the string 001 to 1 (handles the cases of leading zeros)
                if (num < 0 || num > 255) {
                    parts[i] = "0";
                } else {
                    parts[i] = "" + num; // removes leading zeros and stores only the numbers
                }
            } else {
                parts[i] = "0";
            }
        }

        this.setAll(parts[0], parts[1], parts[2], parts[3]);
        total++;
    }

    // Default constructor
    public IPAddress() {
        this.part1 = this.part2 = this.part3 = this.part4 = "0";
        total++;
    }

    public void PrintIP() {
        System.out.println(part1 + "." + part2 + "." + part3 + "." + part4);
    }

    @Override
    public boolean equals(Object otherIP) {
        if (this == otherIP) { // checks if both references point to the same object in memory
            return true;
        }
        if (otherIP == null) { // checks if the other object is null
            return false;
        }
        if (!(otherIP instanceof IPAddress)) { // validates the data type - checks if the other IP is actually an IP address
            return false;
        }

        IPAddress that = (IPAddress) otherIP;
        if ((this.part1.equals(that.part1)) && (this.part2.equals(that.part2)) && (this.part3.equals(that.part3)) && (this.part4.equals(that.part4))) {
            return true;
        } else {
            return false;
        }
    }
}
