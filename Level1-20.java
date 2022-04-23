import java.util.ArrayList;

public class Level1 {
    static String string = "";
    static ArrayList<String> memory = new ArrayList<>();
    static int rollback = 0;
    static int undoPosition = 0;
    public static String BastShoe(String command) {
        if (memory.isEmpty()) memory.add("");
        int commandNumber;
        try {
            Integer.parseInt(String.valueOf(command.charAt(0)));
        } catch (Exception exception) {
            return string;
        }
        commandNumber = Integer.parseInt(String.valueOf(command.charAt(0)));
        if (command.length() > 1 && command.charAt(1) != ' ') {
            commandNumber = -1;
        }

        //Command 1
        if (commandNumber == 1 && command.length() > 2) {
            if (rollback == 1) {
                memory.clear();
                memory.add(string);
                rollback = 0;
            }
            StringBuilder bld = new StringBuilder();
            for (int i = 2; i < command.length(); i++) {
                bld.append(command.charAt(i));
            }
            string += bld.toString();

            memory.add(string);
            undoPosition = memory.size() - 1;
        }

        //Command 2
        if (commandNumber == 2 && command.length() > 2) {
            if (rollback == 1) {
                memory.clear();
                memory.add(string);
                rollback = 0;
            }
            String[] str = command.split(" ");
            try {
                Integer.parseInt(str[1]);
            } catch (Exception exception) {
                return string;
            }
            int delete = Integer.parseInt(str[1]);
            if (delete >= string.length()) {
                string = "";
                return string;
            }
            StringBuilder bld = new StringBuilder();
            for (int i = 0; i < string.length() - delete; i++) {
                bld.append(string.charAt(i));
            }
            string = bld.toString();

            memory.add(string);
            undoPosition = memory.size() - 1;
        }

        //Command 3
        if (commandNumber == 3 && command.length() > 2) {
            String[] str = command.split(" ");
            try {
                Integer.parseInt(str[1]);
            } catch (Exception exception) {
                return string;
            }
            int position = Integer.parseInt(str[1]);
            if (position > string.length() || position < 0) {
                return "";
            }
            return String.valueOf(string.charAt(position));
        }

        //Command 4
        if (commandNumber == 4 && command.length() == 1) {
            rollback = 1;
            if (!memory.isEmpty() && undoPosition > 0) {
                undoPosition--;
                string = memory.get(undoPosition);
            }
        }

        //Command 5
        if ((commandNumber == 5 && command.length() == 1) && (undoPosition < memory.size() - 1)){
                undoPosition++;
                string = memory.get(undoPosition);
        }

        return string;
    }
}
