package algorithms.leetcode.string;

public class FourhuandardAndSixtyEight {
    public static void main(String[] args) {
        String s = "2001:db8:85a3:0::8a2E:0370:7334";
        FourhuandardAndSixtyEight fourhuandardAndSixtyEight = new FourhuandardAndSixtyEight();
        fourhuandardAndSixtyEight.validIPAddress(s);
    }

    public String validIPAddress(String queryIP) {
        if (queryIP.length() == 0) {
            return "Neither";
        }
        if(queryIP.charAt(0) == '.' || queryIP.charAt(queryIP.length()-1) == '.' || queryIP.charAt(0) == ':' || queryIP.charAt(queryIP.length()-1) == ':') {
            return "Neither";
        }
        if(queryIP.contains("..") || queryIP.contains("::")){
            return "Neither";
        }


        String[] splitRes = queryIP.split("\\.");
        if(splitRes.length ==4 ) {
            return judgeIP4(splitRes);
        }
        splitRes = queryIP.split(":");
        if(splitRes.length ==8) {
            return judgeIP6(splitRes);
        }

        return "Neither";

    }

    public String judgeIP4(String[] parts) {
        for(int i=0; i<4; i++) {
            try {
                int num = Integer.parseInt(parts[i]);
                if(num <0|| num>255) {
                    return "Neither";
                }

                if(parts[i].length() != 1 && parts[i].charAt(0) == '0') {
                    return "Neither";
                }

            } catch ( NumberFormatException e) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String judgeIP6(String[] parts) {
        for(int i=0; i<8; i++) {
            if(parts[i].length()>4) {
                return "Neither";
            }
            for(int j=0; j<parts[i].length(); j++) {
                char c = parts[i].charAt(j);
                if (!((c -'0'>=0 && c-'0'<=9) || (c -'a'>=0 && c-'a'<6) || (c -'A'>=0 && c-'A'<6))) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }


}
