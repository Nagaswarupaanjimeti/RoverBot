package src.main.constants;

import java.util.ArrayList;
import java.util.HashMap;

public final class RoverBotConstants {
    public final static String N = "N";
    public final static String E = "E";
    public final static String W = "W";
    public final static String S = "S";
    public final static HashMap<String, ArrayList<String>> ROTATE = new HashMap<String, ArrayList<String>>() {{
            put("L", new ArrayList<String>(){{
                add(N);
                add(W);
                add(S);
                add(E);
            }});
        put("R", new ArrayList<String>(){{
            add(N);
            add(E);
            add(S);
            add(W);
        }});
    }};
    public final static int NINTY= 90;
    public final static int ONEEIGTHY = 180;
    public final static int TWOSEVENTY = 270;
    public final static int THREESIXTY = 360;
    public final static int ZERO = 0;
    public final static HashMap<Integer,Integer> ROTATE_COUNT = new HashMap<Integer, Integer>(){{
        put(NINTY, 1);
        put(ONEEIGTHY, 2);
        put(TWOSEVENTY, 3);
    }};
}
